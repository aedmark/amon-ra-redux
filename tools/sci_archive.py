#!/usr/bin/env python3
"""Read resources from LB2's archive, letting loose patches in LB2/ override them.

LB2 is a hybrid build (D-028): its RESOURCE.MAP uses SCI1-style 6-byte entries (16-bit number, 32-bit offset), and
compressed resources use PKWARE DCL "implode" (methods 18-20). The archive is read from LB2_vanilla/, the untouched
retail reference (D-047).

    from sci_archive import get, script_numbers
    scr = get(SCRIPT, 90)   # loose LB2/90.SCR if present, else the archive copy; patch header stripped
"""

import os
import struct

ROOT = os.path.dirname(os.path.dirname(os.path.abspath(__file__)))
VANILLA = os.path.join(ROOT, "LB2_vanilla")
GAME = os.path.join(ROOT, "LB2")
VIEW, PIC, SCRIPT, PALETTE, MESSAGE, HEAP = 0x80, 0x81, 0x82, 0x8B, 0x8F, 0x91
EXTENSIONS = {VIEW: "V56", PIC: "P56", SCRIPT: "SCR", PALETTE: "PAL", MESSAGE: "MSG", HEAP: "HEP"}

_index = None
_volume = None


def _load():
    global _index, _volume
    if _index is not None:
        return
    with open(os.path.join(VANILLA, "RESOURCE.MAP"), "rb") as f:
        data = f.read()
    with open(os.path.join(VANILLA, "RESOURCE.000"), "rb") as f:
        _volume = f.read()
    types, i = [], 0
    while data[i] != 0xFF:
        types.append((data[i], struct.unpack_from("<H", data, i + 1)[0]))
        i += 3
    types.append((0xFF, struct.unpack_from("<H", data, i + 1)[0]))
    _index = {}
    for (kind, start), (_, end) in zip(types, types[1:]):
        for j in range(start, end, 6):
            number, offset = struct.unpack_from("<HI", data, j)
            _index[(kind, number)] = offset & 0x0FFFFFFF


def get(kind, number, loose=True):
    """Return a resource's bytes: the loose patch if present (header stripped), else the archive copy."""
    if loose:
        path = os.path.join(GAME, f"{number}.{EXTENSIONS.get(kind, 'X')}")
        if os.path.exists(path):
            with open(path, "rb") as f:
                return f.read()[2:]
    _load()
    offset = _index[(kind, number)]
    _, _, packed, unpacked, method = struct.unpack_from("<BHHHH", _volume, offset)
    data = _volume[offset + 9 : offset + 9 + packed]
    if method in (18, 19, 20):
        data = blast(data)
    elif method:
        raise ValueError(f"resource {kind:#x}/{number}: unsupported compression method {method}")
    if len(data) != unpacked:
        raise ValueError(f"resource {kind:#x}/{number}: unpacked {len(data)} bytes, expected {unpacked}")
    return data


def script_numbers():
    """Every script the game can load: archive scripts plus loose-only patches."""
    _load()
    numbers = {number for kind, number in _index if kind == SCRIPT}
    for name in os.listdir(GAME):
        stem, _, ext = name.partition(".")
        if ext.upper() == "SCR" and stem.isdigit():
            numbers.add(int(stem))
    return sorted(numbers)


# PKWARE DCL "implode" decompressor: a Python port of Mark Adler's blast.c (zlib license).
_LITLEN = [11, 124, 8, 7, 28, 7, 188, 13, 76, 4, 10, 8, 12, 10, 12, 10, 8, 23, 8, 9, 7, 6, 7, 8, 7, 6, 55, 8, 23,
           24, 12, 11, 7, 9, 11, 12, 6, 7, 22, 5, 7, 24, 6, 11, 9, 6, 7, 22, 7, 11, 38, 7, 9, 8, 25, 11, 8, 11, 9,
           12, 8, 12, 5, 38, 5, 38, 5, 11, 7, 5, 6, 21, 6, 10, 53, 8, 7, 24, 10, 27, 44, 253, 253, 253, 252, 252,
           252, 13, 12, 45, 12, 45, 12, 61, 12, 45, 44, 173]
_LENLEN = [2, 35, 36, 53, 38, 23]
_DISTLEN = [2, 20, 53, 230, 247, 151, 248]
_BASE = [3, 2, 4, 5, 6, 7, 8, 9, 10, 12, 16, 24, 40, 72, 136, 264]
_EXTRA = [0, 0, 0, 0, 0, 0, 0, 0, 1, 2, 3, 4, 5, 6, 7, 8]
_MAXBITS = 13


def _construct(rep):
    lengths = []
    for b in rep:
        lengths += [b & 15] * ((b >> 4) + 1)
    count = [0] * (_MAXBITS + 1)
    for length in lengths:
        count[length] += 1
    offs = [0] * (_MAXBITS + 1)
    for length in range(1, _MAXBITS):
        offs[length + 1] = offs[length] + count[length]
    symbols = [0] * len(lengths)
    for symbol, length in enumerate(lengths):
        if length:
            symbols[offs[length]] = symbol
            offs[length] += 1
    return count, symbols


class _Bits:
    def __init__(self, data):
        self.data, self.pos, self.buf, self.cnt = data, 0, 0, 0

    def bits(self, n):
        value = self.buf
        while self.cnt < n:
            value |= self.data[self.pos] << self.cnt
            self.pos += 1
            self.cnt += 8
        self.buf = value >> n
        self.cnt -= n
        return value & ((1 << n) - 1)

    def decode(self, table):
        count, symbols = table
        code = first = index = 0
        for length in range(1, _MAXBITS + 1):
            code |= self.bits(1) ^ 1
            c = count[length]
            if code < first + c:
                return symbols[index + (code - first)]
            index += c
            first = (first + c) << 1
            code <<= 1
        raise ValueError("bad DCL code")


_LIT, _LEN, _DIST = _construct(_LITLEN), _construct(_LENLEN), _construct(_DISTLEN)


def blast(data):
    reader = _Bits(data)
    coded, dictionary = reader.bits(8), reader.bits(8)
    if coded not in (0, 1) or dictionary not in (4, 5, 6):
        raise ValueError("not a DCL stream")
    out = bytearray()
    while True:
        if reader.bits(1):
            symbol = reader.decode(_LEN)
            length = _BASE[symbol] + reader.bits(_EXTRA[symbol])
            if length == 519:
                break
            shift = 2 if length == 2 else dictionary
            distance = (reader.decode(_DIST) << shift) + reader.bits(shift) + 1
            for _ in range(length):
                out.append(out[-distance])
        else:
            out.append(reader.decode(_LIT) if coded else reader.bits(8))
    return bytes(out)
