#!/usr/bin/env python3
"""Normalize vocab.997 for the compiler-facing Sluicebox source baseline.

Sluicebox uses contextual selector aliases that cannot all coexist in SCI's
single global selector vocabulary.  Redux sources therefore use stable
``sel_N`` names, except for four reserved object metadata selectors whose
compiler spellings must be preserved.
"""

from __future__ import annotations

import argparse
from pathlib import Path
import struct


RESERVED = {
    4098: "-propDict-",
    4100: "-classScript-",
    4102: "-super-",
    4103: "-info-",
}


def read_vocab(path: Path) -> tuple[list[str], bytes]:
    data = path.read_bytes()
    prefix = b"\x86\x00" if data[:2] == b"\x86\x00" else b""
    base = len(prefix)
    if len(data) < base + 2:
        raise ValueError(f"invalid selector vocabulary: {path}")
    count = struct.unpack_from("<H", data, base)[0] + 1
    table_end = base + 2 + count * 2
    if table_end > len(data):
        raise ValueError(f"truncated selector table: {path}")
    names: list[str] = []
    for index in range(count):
        offset = struct.unpack_from("<H", data, base + 2 + index * 2)[0]
        string_at = base + offset
        if string_at + 2 > len(data):
            raise ValueError(f"invalid selector offset {offset}: {path}")
        length = struct.unpack_from("<H", data, string_at)[0]
        start = string_at + 2
        end = start + length
        if end > len(data):
            raise ValueError(f"truncated selector string {index}: {path}")
        names.append(data[start:end].decode("latin-1"))
    return names, prefix


def write_vocab(path: Path, names: list[str], prefix: bytes) -> None:
    table_end = 2 + len(names) * 2
    offsets: list[int] = []
    strings = bytearray()
    for name in names:
        encoded = name.encode("latin-1")
        offset = table_end + len(strings)
        if offset > 0xFFFF:
            raise ValueError("selector vocabulary exceeds 16-bit offset range")
        offsets.append(offset)
        strings += struct.pack("<H", len(encoded)) + encoded
    payload = bytearray(struct.pack("<H", len(names) - 1))
    payload += b"".join(struct.pack("<H", offset) for offset in offsets)
    payload += strings
    path.write_bytes(prefix + payload)


def main() -> int:
    parser = argparse.ArgumentParser()
    parser.add_argument("input", type=Path)
    parser.add_argument("output", type=Path)
    args = parser.parse_args()

    names, prefix = read_vocab(args.input)
    required_count = max(max(RESERVED) + 1, len(names))
    normalized = [f"sel_{index}" for index in range(required_count)]
    for selector, name in RESERVED.items():
        normalized[selector] = name
    write_vocab(args.output, normalized, prefix)
    print(
        f"wrote {args.output}: {len(normalized)} selectors; "
        f"reserved metadata IDs {', '.join(map(str, RESERVED))}"
    )
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
