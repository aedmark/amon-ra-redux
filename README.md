# The Dagger of Amon Ra: Redux

Definitive modernization patch project for Laura Bow II: *The Dagger of Amon Ra* (Sierra On-Line, 1992).

Using the DOS Floppy v1.000 release as our pristine base (D-001) and SCI Companion in Wine, this project addresses
all game-breaking bugs, softlocks, narrative inconsistencies, interface friction, and mystery grading errors outlined
in the modernization design specification.

## Documentation and roadmap

- **Interactive 3x Manual:** Open [manual.html](manual.html) in any browser for complete What/How/Why specifications for every fix.
- **Modernization Roadmap:** See [ROADMAP.md](ROADMAP.md) for phased development tracking with permanent item IDs.
- **Engine Architecture:** See [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) for SCI 1.1 patch architecture and subsystem design.
- **Architectural Decisions:** See [docs/DECISIONS.md](docs/DECISIONS.md) for ADRs (`D-001` through `D-006`) and open questions.
- **Testing & ScummVM Recipes:** See [docs/TESTING.md](docs/TESTING.md) for verification procedures and debug console recipes.
- **Session Handoff:** See [docs/HANDOFF.md](docs/HANDOFF.md) for current state, next steps, and session logs.

## Quick verification

```bash
# Verify repository documentation integrity
python3 tools/check_docs.py

# Verify 3x documentation scheme specification
python3 3x-documentation-scheme/scripts/manual.py check 3x-documentation-scheme/scheme/amon-ra.manual.json

# Rebuild standalone 3x manual HTML
python3 3x-documentation-scheme/scripts/manual.py build 3x-documentation-scheme/scheme/amon-ra.manual.json --output manual.html

# Run game in ScummVM with debug logging
scummvm -d 1 --auto-detect --path=LB2 sci:laurabow2
```
