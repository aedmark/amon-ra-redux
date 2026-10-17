# The Dagger of Amon Ra: Redux

Definitive modernization patch project for Laura Bow II: *The Dagger of Amon Ra* (Sierra On-Line, 1992).

Built on the DOS floppy v1.000 release (D-001) with SCI Companion under Wine, Redux fixes bugs, softlocks, narrative
inconsistencies, interface friction, and grading errors. It ships as loose patch files that players extract over their
own retail floppy copy; no Sierra files are distributed (D-047).

## Documentation and roadmap

- **Alpha playtesting:** [docs/ALPHA_PLAYTESTING.md](docs/ALPHA_PLAYTESTING.md) (install, checklists, report template)
  and the self-contained [playtest page](docs/alpha-playtest.html).
- **3x manual:** [docs/manual/manual.html](docs/manual/manual.html), What/How/Why for every fix.
- **Roadmap:** [docs/ROADMAP.md](docs/ROADMAP.md). **Architecture:** [docs/ARCHITECTURE.md](docs/ARCHITECTURE.md).
  **Decisions:** [docs/DECISIONS.md](docs/DECISIONS.md). **Testing:** [docs/TESTING.md](docs/TESTING.md).
- **Current state and next steps:** [docs/HANDOFF.md](docs/HANDOFF.md).

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

# Build the patch-only release zip
python3 tools/package_patch.py <version>
```
