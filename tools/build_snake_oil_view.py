#!/usr/bin/env python3
"""Add an empty-bottle cel to the inventory and toolbar loops of View 61.

The input is View 61 exported from the unmodified floppy resources by SCI
Companion.  The output is a loose SCI 1.1 view patch.  Keeping this mechanical
step here makes the small pixel-art change reproducible without modifying the
base archives.
"""

from __future__ import annotations

import argparse
import struct
from pathlib import Path


PATCH_PREFIX_SIZE = 26
HEADER_SIZE = 18
LOOP_SIZE = 16
CEL_SIZE = 36
EMPTY_MARK_COLOR = 12


def read_u16(data: bytes, offset: int) -> int:
    return struct.unpack_from("<H", data, offset)[0]


def read_u32(data: bytes, offset: int) -> int:
    return struct.unpack_from("<I", data, offset)[0]


def decode_cel(data: bytes, header_offset: int) -> tuple[bytearray, int, int, int]:
    width = read_u16(data, header_offset)
    height = read_u16(data, header_offset + 2)
    clear = data[header_offset + 8]
    rle_pos = PATCH_PREFIX_SIZE + read_u32(data, header_offset + 24)
    literal_pos = PATCH_PREFIX_SIZE + read_u32(data, header_offset + 28)
    pixels = bytearray([clear] * (width * height))
    pixel = 0

    while pixel < len(pixels):
        command = data[rle_pos]
        rle_pos += 1
        run = command & 0x3F
        mode = command & 0xC0
        if mode == 0x40:
            run += 64
        copy_length = min(run, len(pixels) - pixel)
        if mode in (0x00, 0x40):
            pixels[pixel : pixel + copy_length] = data[literal_pos : literal_pos + copy_length]
            literal_pos += run
        elif mode == 0x80:
            pixels[pixel : pixel + copy_length] = bytes([data[literal_pos]]) * copy_length
            literal_pos += 1
        pixel += run

    return pixels, width, height, clear


def encode_cel(pixels: bytearray) -> tuple[bytes, bytes]:
    commands = bytearray()
    literals = bytearray()
    for offset in range(0, len(pixels), 63):
        chunk = pixels[offset : offset + 63]
        commands.append(len(chunk))
        literals.extend(chunk)
    return bytes(commands), bytes(literals)


def mark_empty(pixels: bytearray, width: int, height: int, clear: int) -> bytearray:
    result = bytearray(pixels)
    top = max(3, height // 3)
    bottom = height - max(3, height // 6) - 1
    left = max(2, width // 5)
    right = width - left - 1
    span = max(1, bottom - top)

    for y in range(top, bottom + 1):
        progress = y - top
        x1 = left + ((right - left) * progress // span)
        x2 = right - ((right - left) * progress // span)
        for x in (x1, x2):
            index = y * width + x
            if result[index] != clear:
                result[index] = EMPTY_MARK_COLOR
    return result


def build(source: bytes) -> bytes:
    if source[:2] != b"\x80\x80" or source[PATCH_PREFIX_SIZE : PATCH_PREFIX_SIZE + 2] != b"\x10\x00":
        raise ValueError("input is not the expected exported SCI 1.1 View 61")

    logical = source[PATCH_PREFIX_SIZE:]
    loop_count = logical[2]
    if loop_count != 3:
        raise ValueError(f"expected three View 61 loops, found {loop_count}")

    loop_headers = [bytearray(logical[HEADER_SIZE + i * LOOP_SIZE : HEADER_SIZE + (i + 1) * LOOP_SIZE]) for i in range(3)]
    original_headers: list[bytearray] = []
    decoded: list[tuple[bytearray, int, int, int]] = []
    for loop_header in loop_headers:
        if loop_header[2] != 1:
            raise ValueError("expected one cel in each original View 61 loop")
        cel_offset = read_u32(loop_header, 12)
        raw_offset = PATCH_PREFIX_SIZE + cel_offset
        original_headers.append(bytearray(source[raw_offset : raw_offset + CEL_SIZE]))
        decoded.append(decode_cel(source, raw_offset))

    cel_sets = [
        [decoded[0]],
        [decoded[1], (mark_empty(*decoded[1]), decoded[1][1], decoded[1][2], decoded[1][3])],
        [decoded[2], (mark_empty(*decoded[2]), decoded[2][1], decoded[2][2], decoded[2][3])],
    ]

    header = bytearray(logical[:HEADER_SIZE])
    struct.pack_into("<H", header, 6, 5)
    cel_table_offset = HEADER_SIZE + LOOP_SIZE * loop_count
    cel_headers: list[list[bytearray]] = []
    for loop_index, cels in enumerate(cel_sets):
        loop_headers[loop_index][2] = len(cels)
        struct.pack_into("<I", loop_headers[loop_index], 12, cel_table_offset)
        cel_headers.append([bytearray(original_headers[loop_index]) for _ in cels])
        cel_table_offset += CEL_SIZE * len(cels)

    old_palette_offset = read_u32(logical, 8)
    palette = logical[old_palette_offset : old_palette_offset + 37 + (3 * 64)]
    palette_offset = cel_table_offset
    struct.pack_into("<I", header, 8, palette_offset)
    data_offset = palette_offset + len(palette)
    streams = bytearray()

    for loop_index, cels in enumerate(cel_sets):
        for cel_index, (pixels, _width, _height, _clear) in enumerate(cels):
            commands, literals = encode_cel(pixels)
            cel_header = cel_headers[loop_index][cel_index]
            struct.pack_into("<I", cel_header, 12, len(commands) + len(literals))
            struct.pack_into("<I", cel_header, 16, len(commands))
            struct.pack_into("<I", cel_header, 24, data_offset + len(streams))
            streams.extend(commands)
            struct.pack_into("<I", cel_header, 28, data_offset + len(streams))
            streams.extend(literals)

    output = bytearray(source[:PATCH_PREFIX_SIZE])
    output.extend(header)
    for loop_header in loop_headers:
        output.extend(loop_header)
    for loop_cels in cel_headers:
        for cel_header in loop_cels:
            output.extend(cel_header)
    output.extend(palette)
    output.extend(streams)
    return bytes(output)


def main() -> None:
    parser = argparse.ArgumentParser()
    parser.add_argument("source", type=Path, help="SCI Companion export of the unmodified 61.v56")
    parser.add_argument("output", type=Path, help="destination loose view patch")
    args = parser.parse_args()
    args.output.write_bytes(build(args.source.read_bytes()))
    print(f"wrote {args.output} ({args.output.stat().st_size} bytes)")


if __name__ == "__main__":
    main()
