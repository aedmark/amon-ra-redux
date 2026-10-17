#!/usr/bin/env python3
"""Rename lowercase files at the top of LB2/ to uppercase (D-048).

SCI Companion writes every patch it compiles or saves under a lowercase name, even when it replaces an existing
uppercase file. Run this after saving in SCI Companion; tools/compile.py already renames the patches it builds.

    python3 tools/uppercase_names.py          # rename
    python3 tools/uppercase_names.py --check  # list only; exit 1 if any are lowercase
"""

import sys
from pathlib import Path

GAME = Path(__file__).resolve().parent.parent / "LB2"


def main():
    check = "--check" in sys.argv[1:]
    # Release zips (LB2-Redux-vX.YY.zip) keep their own names.
    lower = sorted(p for p in GAME.iterdir()
                   if p.is_file() and p.name != p.name.upper() and p.suffix.lower() != ".zip")
    for path in lower:
        target = path.with_name(path.name.upper())
        if check:
            print(path.name)
            continue
        # Two steps, since a case-only rename can be a no-op on a case-insensitive filesystem.
        temp = path.with_name(target.name + ".casetmp")
        path.rename(temp)
        temp.rename(target)
        print(f"{path.name} -> {target.name}")
    if check and lower:
        sys.exit(1)


if __name__ == "__main__":
    main()
