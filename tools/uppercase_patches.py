#!/usr/bin/env python3
"""
tools/uppercase_patches.py - Rename SCI Companion's lowercase loose patch output
(e.g. 750.scr, 750.hep) to the uppercase names tracked in git (750.SCR, 750.HEP).

Run after "Compile All" or any other SCI Companion save. Never overwrites: if the
uppercase target already exists, the lowercase file is left in place and reported.

Usage: python3 tools/uppercase_patches.py [--dry-run] [game_dir]
"""

import os
import re
import sys

PATCH = re.compile(r"^(\d+)\.(scr|hep|msg)$")  # only what Compile All emits; 996.voc etc. keep their names


def main(argv):
    dry = "--dry-run" in argv
    args = [a for a in argv if not a.startswith("--")]
    game_dir = args[0] if args else os.path.join(os.path.dirname(os.path.abspath(__file__)), "..", "LB2")
    renamed = skipped = 0
    for name in sorted(os.listdir(game_dir)):
        m = PATCH.match(name)
        if not m:
            continue
        target = f"{m.group(1)}.{m.group(2).upper()}"
        if os.path.exists(os.path.join(game_dir, target)):
            print(f"[!] {name} -> {target} skipped: target exists")
            skipped += 1
            continue
        if not dry:
            os.rename(os.path.join(game_dir, name), os.path.join(game_dir, target))
        renamed += 1
    print(f"{'Would rename' if dry else 'Renamed'} {renamed}, skipped {skipped}")
    return 1 if skipped else 0


if __name__ == "__main__":
    sys.exit(main(sys.argv[1:]))
