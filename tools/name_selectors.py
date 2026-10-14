#!/usr/bin/env python3
"""Give LB2's selectors readable names (D-039).

The floppy release ships without vocab 997, so the source baseline used ``sel_N`` placeholders (D-032).
``tools/selector_names.json`` maps each selector ID used by the source to one name, derived from the pinned
Sluicebox ``ra-dos-1.000`` publication by token alignment and resolved by hand where its contextual aliases
disagreed. Selector IDs never change, so compiled scripts must stay byte-identical.

Usage: python3 tools/name_selectors.py <game_dir> [--vocab-only | --source-only]
Rewrites <game_dir>/997.voc and every <game_dir>/src/*.sc in place.
"""

from __future__ import annotations

import json
import re
import sys
from pathlib import Path

sys.path.insert(0, str(Path(__file__).resolve().parent))
from normalize_selector_vocab import RESERVED, read_vocab, write_vocab  # noqa: E402

NAMES = Path(__file__).resolve().parent / "selector_names.json"


def main(argv: list[str]) -> int:
    if not argv or argv[0].startswith("-"):
        print(__doc__)
        return 2
    game = Path(argv[0])
    table = {int(k): v for k, v in json.loads(NAMES.read_text(encoding="utf-8")).items()}
    if len(set(table.values())) != len(table):
        raise SystemExit("selector_names.json maps one name to several IDs")

    if "--source-only" not in argv:
        names, prefix = read_vocab(game / "997.voc")
        for selector, name in table.items():
            if selector in RESERVED and name != RESERVED[selector]:
                raise SystemExit(f"selector {selector} must stay {RESERVED[selector]}")
            names[selector] = name
        write_vocab(game / "997.voc", names, prefix)
        print(f"named {len(table)} selectors in {game / '997.voc'}")

    if "--vocab-only" not in argv:
        pattern = re.compile(r"\bsel_(\d+)\b")
        missing: set[int] = set()

        def rename(match: re.Match[str]) -> str:
            selector = int(match.group(1))
            if selector not in table:
                missing.add(selector)
                return match.group(0)
            return table[selector]

        changed = 0
        for path in sorted((game / "src").glob("*.sc")):
            text = path.read_bytes().decode("latin-1")  # keep line endings exactly
            new = pattern.sub(rename, text)
            if new != text:
                path.write_bytes(new.encode("latin-1"))
                changed += 1
        print(f"renamed selectors in {changed} source files")
        if missing:
            raise SystemExit(f"unnamed selectors left in source: {sorted(missing)}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main(sys.argv[1:]))
