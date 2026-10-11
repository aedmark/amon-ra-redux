#!/usr/bin/env python3
"""Build the room-335 benefit podium as a loose SCI1.1 VGA view patch."""

from __future__ import annotations

import argparse
import struct
from pathlib import Path


WIDTH = 24
HEIGHT = 48
TRANSPARENT = 255


def _canvas() -> list[list[int]]:
    return [[TRANSPARENT for _ in range(WIDTH)] for _ in range(HEIGHT)]


def _span(pixels: list[list[int]], y: int, left: int, right: int, color: int) -> None:
    pixels[y][left : right + 1] = [color] * (right - left + 1)


def draw_podium() -> list[list[int]]:
    """Draw a compact dark-wood lectern with a red leather register."""
    pixels = _canvas()

    black = 0
    red = 4
    wood = 6
    paper = 7
    shadow = 8
    gold = 14

    # Leather-bound register, resting at a slight angle on the lectern.
    _span(pixels, 0, 7, 18, black)
    _span(pixels, 1, 5, 20, black)
    _span(pixels, 2, 5, 19, red)
    _span(pixels, 2, 20, 20, gold)
    _span(pixels, 3, 4, 20, red)
    _span(pixels, 3, 21, 21, black)
    _span(pixels, 4, 4, 20, paper)
    _span(pixels, 4, 21, 21, black)
    _span(pixels, 5, 3, 21, black)

    # Sloped reading surface and carved lip.
    _span(pixels, 6, 2, 21, black)
    _span(pixels, 7, 2, 20, wood)
    _span(pixels, 7, 21, 22, black)
    _span(pixels, 8, 3, 20, wood)
    _span(pixels, 8, 21, 21, shadow)
    _span(pixels, 9, 4, 19, gold)
    _span(pixels, 9, 20, 20, black)
    _span(pixels, 10, 4, 20, black)
    _span(pixels, 11, 6, 18, black)

    # Narrow wooden pedestal with a highlighted left edge and deep right shadow.
    for y in range(12, 38):
        left = 8 if y < 29 else 9
        right = 16 if y < 29 else 15
        _span(pixels, y, left, right, black)
        _span(pixels, y, left + 1, right - 1, wood)
        pixels[y][left + 1] = gold if y % 4 else paper
        pixels[y][right - 1] = shadow

    # Broad stepped base so the silhouette reads clearly against the wall.
    _span(pixels, 38, 7, 17, black)
    _span(pixels, 39, 6, 18, black)
    _span(pixels, 40, 6, 18, wood)
    _span(pixels, 40, 7, 8, gold)
    _span(pixels, 40, 17, 18, shadow)
    _span(pixels, 41, 5, 19, black)
    _span(pixels, 42, 4, 20, black)
    for y in range(43, 46):
        _span(pixels, y, 3, 21, black)
        _span(pixels, y, 4, 20, wood)
        _span(pixels, y, 4, 6, gold)
        _span(pixels, y, 18, 20, shadow)
    _span(pixels, 46, 2, 22, black)
    _span(pixels, 47, 1, 23, black)

    return pixels


def encode_view(pixels: list[list[int]]) -> bytes:
    """Encode one loop/one cel using the SCI1.1 split-RLE view layout."""
    # One literal command per scanline. SCI stores cel rows bottom-up.
    rle = bytes([WIDTH] * HEIGHT)
    literals = bytes(pixel for row in reversed(pixels) for pixel in row)

    view_header_size = 18
    loop_header_size = 16
    cel_header_size = 36
    cel_header_offset = view_header_size + loop_header_size
    rle_offset = cel_header_offset + cel_header_size
    literal_offset = rle_offset + len(rle)

    view_header = struct.pack(
        "<HBBBBHIBBHH",
        view_header_size - 2,
        1,  # loop count
        0,  # scalable
        1,
        0,  # 320x200 native resolution
        1,  # total non-mirrored cels
        0,  # no embedded palette; use the room palette
        loop_header_size,
        cel_header_size,
        0,
        0,
    )
    loop_header = struct.pack(
        "<BBBBIII",
        0xFF,
        0,
        1,
        0xFF,
        0x03FFFFFF,
        0,
        cel_header_offset,
    )
    cel_header = struct.pack(
        "<HHhhBBBBIIIIII",
        WIDTH,
        HEIGHT,
        0,
        0,
        TRANSPARENT,
        0x0A,
        0,
        0,
        len(rle) + len(literals),
        len(rle),
        0,
        rle_offset,
        literal_offset,
        0,
    )

    # SCI Companion loose VGA-view patch header.
    patch_header = bytes((0x80, 0x80)) + bytes(24)
    return patch_header + view_header + loop_header + cel_header + rle + literals


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--output",
        type=Path,
        default=Path("LB2/335.V56"),
        help="loose view patch to create (default: LB2/335.V56)",
    )
    args = parser.parse_args()
    args.output.write_bytes(encode_view(draw_podium()))
    print(f"built {args.output} ({args.output.stat().st_size} bytes, {WIDTH}x{HEIGHT})")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
