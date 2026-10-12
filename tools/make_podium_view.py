#!/usr/bin/env python3
"""Build the room-335 benefit podium as a loose SCI1.1 VGA view patch."""

from __future__ import annotations

import argparse
import base64
import struct
from pathlib import Path


WIDTH = 16
HEIGHT = 26
TRANSPARENT = 255

# Composite 256-color palette for room 335:
# - Base colors 0..63 from Palette 999
# - Room 335 picture colors 64..254 from Pic 335
# - Index 255 transparent (0, 0, 0)
# Formatted as standard 37-byte SCI1.1 short-form PaletteHeader + 256*3 RGB bytes.
PALETTE_B64 = (
    "DgAAAAAAAAAAAAEAABYDOTk5AAAAAAAAAAAAAAAAAQEBAAAAAAAAABsbHzc3P09TX2tvf4eLn6On"
    "v7/H39vj/3MTE5cbG7sjI9snJ9tLa+OHd++3n1MzC2dDF3tXJ49rN6eDT7uba8+zh+fPq7OrH7O/"
    "O8PPP9ffJ/PzN8tvQ9eDS+OXUw9XDydnH0N3M0uLS3+zV3/DY4PXd4frhwtTUxNzcxuTkyO7uyfb"
    "27uL16tX15sn2wsLUxMTcxsbkyMjuyMj20ND22Nj44OD63MTc4cfh5szm69Hr8Nfw9d71+uX6/+7"
    "/ysbGzMjI0MjGzsrKzMrM0MrIzMzQ1MrI0MzKzszMzM7S1szI2MzK1M7K0s7M0s7Q0M7O1M7UztD"
    "W0NDU2s7K2M7M1tDM1NDO1NDS2NDO1tDQ0NLY1tDU1NLQ2tDM2NLM0NTa1tLO1tLS2tLO2NLQ2tL"
    "S1tLW2NLU0Nbe2NTO2tTQ2NTS3NTO2tTU2tTY2NbU49LO0tjj3NbS4dbO3tbQ3NbW5dTQ1Nrl3tj"
    "U3NjY49jQ4djS4djW3trS3Nje3tja59bS5djS1Nzn49jU4drU3trW3Nra59jU49rS4drY1N7r59r"
    "S5drW49zU4dzW3tzc5dzS49zY69zS1uHt6dzU6dzY59zW5d7W4d7e597U6d7W597Y5d7a597c697"
    "U2OPt5eHY6eHU5+HW6eHY5+Ha5+He4+Hh6+HW6+Ha6ePW6eHc6+PU7ePW6+PY6ePa6ePe5ePj7eP"
    "c7+XU7+XY7eXa6+Xc6+Xh5+Xl8eXW7+fW8eXa7+Xc7eXe6efl5+fn9eXU8efY7+fa7efc7+fe7+X"
    "h7efh9efY8+fc6enn9+fW8+na8enc8enh8efj7+nj9+na9ene6+vp9evc8+ve8evj8evn9+ve8+v"
    "l7e3r9+vj9e3h8+3j8+3n8e3r7e/t+e3c+e3h9+3l7+/r+e/e9+/j9e/n9e/r7/Ht++/j+e/l+e/"
    "p8fHv+/Hc+/Hh+fHj9/Hn9/Hr+/Hl+/Hp+fPn9/Hv+/Pj+fPr9/Pt+fPv9/Px/fPn+/Xp+/Xx+fX"
    "z/ffz////w=="
)


def draw_podium() -> list[list[int]]:
    """Draw a 16x26 Art Deco mahogany lectern with an embossed leather guest register."""
    black = 0
    deep_crevice = 64
    wood_shadow = 66
    wood_mid = 84
    wood_light = 122
    wood_highlight = 158
    gold_mid = 191
    gold_bright = 227
    paper_light = 247
    red_dark = 9
    red_mid = 11
    t = TRANSPARENT

    return [
        # Row 0: Slanted wooden reading desk top edge
        [t, t, wood_shadow, wood_light, wood_light, wood_light, wood_mid, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, deep_crevice, t, t, t],
        # Row 1: Upper wooden shelf surface, top edge of red leather register
        [t, wood_shadow, wood_light, red_dark, red_mid, red_mid, red_mid, red_mid, red_mid, red_mid, red_dark, wood_mid, wood_shadow, deep_crevice, t, t],
        # Row 2: Front cover upper surface
        [t, wood_mid, wood_light, red_dark, red_mid, red_mid, red_mid, red_mid, red_mid, red_mid, red_dark, wood_mid, wood_shadow, deep_crevice, t, t],
        # Row 3: Horizontal embossed gold title across register cover ('GUEST REGISTER')
        [t, wood_mid, wood_light, red_dark, gold_bright, gold_bright, gold_bright, gold_bright, gold_bright, gold_bright, red_dark, wood_mid, wood_shadow, deep_crevice, t, t],
        # Row 4: Front cover lower surface
        [t, wood_shadow, wood_mid, red_dark, red_mid, red_mid, red_mid, red_mid, red_mid, red_mid, red_dark, wood_shadow, wood_shadow, deep_crevice, t, t],
        # Row 5: Lower book edge with parchment page stack edge
        [t, wood_shadow, red_dark, paper_light, paper_light, paper_light, paper_light, paper_light, paper_light, paper_light, red_dark, wood_shadow, wood_shadow, deep_crevice, t, t],
        # Row 6: Brass retention rail across lectern front
        [gold_bright, gold_mid, gold_bright, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, deep_crevice, deep_crevice, t],
        # Row 7: Under-shelf bevel and shadow
        [deep_crevice, wood_highlight, wood_light, wood_mid, wood_mid, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, wood_shadow, deep_crevice, deep_crevice, deep_crevice, t, t],
        # Row 8: Tapered support bracket under desk
        [t, t, deep_crevice, wood_highlight, wood_light, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        # Row 9: Art Deco brass collar / capital moulding
        [t, t, t, gold_bright, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, deep_crevice, deep_crevice, t, t, t, t, t],
        # Rows 10-17: Fluted Art Deco column (cols 4..11)
        [t, t, t, t, wood_highlight, wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_light,     wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_highlight, wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_light,     wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_highlight, wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_light,     wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_highlight, wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        [t, t, t, t, wood_light,     wood_mid, wood_light, wood_light, wood_mid, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        # Row 18: Lower column base collar moulding
        [t, t, t, gold_bright, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, deep_crevice, deep_crevice, deep_crevice, t, t, t, t],
        # Row 19: Top tier of stepped pedestal base
        [t, t, wood_highlight, wood_light, wood_light, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, deep_crevice, deep_crevice, t, t, t, t],
        # Row 20: Upper tier face
        [t, t, deep_crevice, wood_light, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, deep_crevice, deep_crevice, deep_crevice, t, t, t, t],
        # Row 21: Middle tier step
        [t, wood_highlight, wood_light, wood_light, wood_mid, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, wood_shadow, deep_crevice, deep_crevice, t, t, t],
        # Row 22: Brass decorative trim line on base step
        [t, gold_bright, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, gold_mid, deep_crevice, deep_crevice, deep_crevice, t, t, t],
        # Row 23: Lower heavy plinth top bevel
        [wood_highlight, wood_light, wood_light, wood_mid, wood_mid, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, wood_shadow, deep_crevice, deep_crevice, deep_crevice, t, t],
        # Row 24: Lower plinth front face
        [deep_crevice, wood_light, wood_mid, wood_mid, wood_mid, wood_mid, wood_mid, wood_mid, wood_shadow, wood_shadow, deep_crevice, deep_crevice, deep_crevice, deep_crevice, t, t],
        # Row 25: Base plinth bottom bevel & floor shadow
        [t, deep_crevice, black, black, black, black, black, black, black, black, black, deep_crevice, deep_crevice, deep_crevice, t, t],
    ]


def encode_view(pixels: list[list[int]]) -> bytes:
    """Encode one loop/one cel using the SCI1.1 split-RLE view layout with embedded palette."""
    # One literal command per scanline. SCI stores cel rows bottom-up.
    rle = bytes([WIDTH] * HEIGHT)
    literals = bytes(pixel for row in reversed(pixels) for pixel in row)
    palette = base64.b64decode(PALETTE_B64)

    view_header_size = 18
    loop_header_size = 16
    cel_header_size = 36
    cel_header_offset = view_header_size + loop_header_size
    palette_offset = cel_header_offset + cel_header_size
    rle_offset = palette_offset + len(palette)
    literal_offset = rle_offset + len(rle)

    view_header = struct.pack(
        "<HBBBBHIBBHH",
        view_header_size - 2,
        1,  # loop count
        0,  # scalable
        1,
        0,  # 320x200 native resolution
        1,  # total non-mirrored cels
        palette_offset,  # embedded palette offset (prevents SCI Companion null-palette crash)
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
    return patch_header + view_header + loop_header + cel_header + palette + rle + literals


def main() -> int:
    parser = argparse.ArgumentParser(description=__doc__)
    parser.add_argument(
        "--output",
        type=Path,
        default=Path("LB2/335.V56"),
        help="loose view patch to create (default: LB2/335.V56)",
    )
    args = parser.parse_args()
    data = encode_view(draw_podium())
    args.output.write_bytes(data)
    # Also keep lowercase in sync if it exists or is tracked
    lower_path = args.output.parent / (args.output.stem + ".v56")
    lower_path.write_bytes(data)
    print(f"built {args.output} and {lower_path} ({len(data)} bytes, {WIDTH}x{HEIGHT})")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
