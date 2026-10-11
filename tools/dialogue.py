#!/usr/bin/env python3
"""Apply tuple-addressed dialogue replacements to SCI message patches."""

from __future__ import annotations

import argparse
import json
import struct
from pathlib import Path


PATCH_PREFIX = b"\x8f\x00"


def load_records(payload: bytes) -> tuple[int, int, list[tuple[int, int, int, int, int, int]]]:
    version = struct.unpack_from("<H", payload, 0)[0]
    record_length = 10 if version <= 0x0D53 else 11
    count = struct.unpack_from("<H", payload, 6)[0]
    records = []
    for index in range(count):
        position = 8 + index * record_length
        noun, verb, condition, sequence, talker = payload[position : position + 5]
        text_offset = struct.unpack_from("<H", payload, position + 5)[0]
        records.append((noun, verb, condition, sequence, talker, text_offset))
    return record_length, count, records


def add_record(
    payload: bytes,
    key: tuple[int, int, int, int, int],
    text: str,
    reference: tuple[int, int, int],
) -> bytes:
    record_length, count, records = load_records(payload)
    if record_length != 10:
        raise ValueError("adding records is only supported for SCI 1.1 message resources")
    if len(key) != 5 or len(reference) != 3:
        raise ValueError("message tuple must have five fields and reference must have three")

    table_end = 8 + count * record_length
    text_bytes = text.encode("cp437") + b"\0"
    new_text_offset = len(payload) + record_length
    if new_text_offset > 0xFFFF:
        raise ValueError("message text offset exceeds SCI 1.1 limit")

    mutable = bytearray(payload)
    for index in range(count):
        offset_position = 8 + index * record_length + 5
        old_offset = struct.unpack_from("<H", mutable, offset_position)[0]
        struct.pack_into("<H", mutable, offset_position, old_offset + record_length)

    record = bytes(key) + struct.pack("<H", new_text_offset) + bytes(reference)
    mutable[table_end:table_end] = record
    mutable.extend(text_bytes)
    struct.pack_into("<H", mutable, 4, len(mutable) - 6)
    struct.pack_into("<H", mutable, 6, count + 1)
    return bytes(mutable)


def apply_manifest(message_path: Path, manifest_path: Path) -> tuple[int, int]:
    manifest = json.loads(manifest_path.read_text(encoding="utf-8"))
    if message_path.stem.isdigit() and int(message_path.stem) != manifest["module"]:
        raise ValueError(
            f"manifest module {manifest['module']} does not match {message_path.name}"
        )
    raw = message_path.read_bytes()
    if not raw.startswith(PATCH_PREFIX):
        raise ValueError(f"{message_path} is not a loose SCI message patch")

    payload = raw[len(PATCH_PREFIX) :]
    changed = 0
    for entry in manifest["entries"]:
        key = tuple(entry["tuple"])
        record_length, count, records = load_records(payload)
        replacement_talker = entry.get("set_talker")
        replacement_key = key[:-1] + (replacement_talker,) if replacement_talker is not None else key
        matches = [
            (index, record)
            for index, record in enumerate(records)
            if record[:5] == key or (replacement_talker is not None and record[:5] == replacement_key)
        ]
        if not matches and entry.get("add"):
            reference = tuple(entry.get("reference", [0x7F, 0x20, 0x7F]))
            payload = add_record(payload, replacement_key, entry["text"], reference)
            changed += 1
            continue
        if len(matches) != 1:
            raise ValueError(f"expected one record for tuple {key}, found {len(matches)}")

        record_index, record = matches[0]
        text_offset = record[5]
        text_end = payload.index(b"\0", text_offset)
        old_bytes = payload[text_offset:text_end]
        new_bytes = entry["text"].encode("cp437")
        talker_current = record[4]
        if old_bytes == new_bytes and (replacement_talker is None or talker_current == replacement_talker):
            continue

        delta = len(new_bytes) - len(old_bytes)
        payload = payload[:text_offset] + new_bytes + payload[text_end:]
        mutable = bytearray(payload)
        if replacement_talker is not None:
            mutable[8 + record_index * record_length + 4] = replacement_talker
        for index in range(count):
            offset_position = 8 + index * record_length + 5
            other_offset = struct.unpack_from("<H", mutable, offset_position)[0]
            if other_offset > text_offset:
                struct.pack_into("<H", mutable, offset_position, other_offset + delta)
        struct.pack_into("<H", mutable, 4, len(mutable) - 6)
        payload = bytes(mutable)
        changed += 1

    message_path.write_bytes(PATCH_PREFIX + payload)
    return changed, len(manifest["entries"])


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("message", type=Path)
    parser.add_argument("manifest", type=Path)
    args = parser.parse_args()
    changed, total = apply_manifest(args.message, args.manifest)
    print(f"{args.message}: {changed} changed, {total - changed} already current")


if __name__ == "__main__":
    main()
