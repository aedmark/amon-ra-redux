#!/usr/bin/env python3
"""Check object property layouts across every script the game loads.

Each instance must have exactly its class's number of properties, and each class's property selectors must begin
with its superclass's. A script compiled against an older version of a class fails this check; D-049 found Scripts
31 to 37 one property short of MuseumActor, so TravelToRoom read past their actors. Run after changing a class.

    python3 tools/check_layout.py   # exit 1 on any mismatch
"""

import os
import struct
import sys

sys.path.insert(0, os.path.dirname(os.path.abspath(__file__)))
from sci_archive import HEAP, SCRIPT, get, script_numbers  # noqa: E402

MAGIC = 0x1234
NO_CLASS = 0xFFFF


def word(data, offset):
    return struct.unpack_from("<H", data, offset)[0]


def objects(number):
    """Yield (name, size, species, superclass, is_class, selectors) for each object in a script's heap."""
    scr, hep = get(SCRIPT, number), get(HEAP, number)
    offset = 4 + 2 * word(hep, 2)
    while offset + 2 <= len(hep) and word(hep, offset) == MAGIC:
        size, prop_dict = word(hep, offset + 2), word(hep, offset + 4)
        name_at = word(hep, offset + 16)
        try:
            name = hep[name_at : hep.index(b"\0", name_at)].decode("latin-1")
        except ValueError:
            name = "?"
        species, superclass, info = word(hep, offset + 10), word(hep, offset + 12), word(hep, offset + 14)
        is_class = bool(info & 0x8000)
        selectors = [word(scr, prop_dict + 2 * i) for i in range(size)] if is_class else None
        yield name, size, species, superclass, is_class, selectors
        offset += 2 * size


def main():
    found, classes = [], {}
    numbers = script_numbers()
    for number in numbers:
        try:
            for record in objects(number):
                found.append((number,) + record)
                if record[4]:
                    classes[record[2]] = (number,) + record
        except KeyError:
            continue  # listed in the map but no heap: not a loadable script
    problems = 0
    for number, name, size, _, superclass, is_class, selectors in found:
        if superclass == NO_CLASS:
            continue
        parent = classes.get(superclass)
        if parent is None:
            problems += 1
            print(f"{name} (script {number}): unknown superclass {superclass}")
            continue
        p_number, p_name, p_size, *_rest, p_selectors = parent
        if is_class and selectors[:p_size] != p_selectors:
            problems += 1
            print(f"class {name} (script {number}, {size}) does not extend {p_name} (script {p_number}, {p_size})")
        elif not is_class and size != p_size:
            problems += 1
            print(f"instance {name} (script {number}) has {size} words; class {p_name} (script {p_number}) has {p_size}")
    print(f"{len(numbers)} scripts, {len(found)} objects, {len(classes)} classes, {problems} mismatch(es)")
    sys.exit(1 if problems else 0)


if __name__ == "__main__":
    main()
