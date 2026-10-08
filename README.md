# The Dagger of Amon Ra: Redux

Definitive modernization patch project for Laura Bow II: *The Dagger of Amon Ra* (Sierra On-Line, 1992).

Using the DOS Floppy v1.000 release as our pristine base (D-001) and SCI Companion in Wine, this project addresses
all game-breaking bugs, softlocks, narrative inconsistencies, interface friction, and mystery grading errors outlined
in the modernization design specification.

## Documentation and roadmap

- **Interactive 3x Manual:** Open [docs/manual/manual.html](docs/manual/manual.html) in any browser for complete What/How/Why specifications for every fix.
- **Modernization Roadmap:** See [docs/ROADMAP.md](docs/ROADMAP.md) for phased development tracking with permanent item IDs.
- **Engine Architecture:** See [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md) for SCI 1.1 patch architecture and subsystem design.
- **Architectural Decisions:** See [docs/DECISIONS.md](docs/DECISIONS.md) for ADRs (`D-001` through `D-006`) and open questions.
- **Testing & DOSBox-X Recipes:** See [docs/TESTING.md](docs/TESTING.md) for original-interpreter verification procedures.
- **Session Handoff:** See [docs/HANDOFF.md](docs/HANDOFF.md) for current state, next steps, and session logs.

## Quick verification

```bash
# Verify repository documentation integrity
python3 tools/check_docs.py

# Verify 3x documentation scheme specification
python3 tools/manual.py check docs/manual/amon-ra.manual.json

# Rebuild standalone 3x manual HTML
python3 tools/manual.py build docs/manual/amon-ra.manual.json --output docs/manual/manual.html

# Run game through Sierra's original interpreter in DOSBox-X
./tools/run_dosbox.sh
```
