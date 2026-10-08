# Contributing

Guidelines for contributing to *The Dagger of Amon Ra: Redux*.

## Development setup

1. Ensure Wine 11+ is installed for running SCI Companion: `wine --version`.
2. Ensure DOSBox-X is installed for original-interpreter runtime verification: `dosbox-x --version`.
3. Base floppy files are located in `LB2/`. Never overwrite `RESOURCE.000` or `RESOURCE.MAP`.
4. Run `python3 tools/check_docs.py` to confirm documentation consistency.

## Workflow

1. Select an open task from `docs/ROADMAP.md` (e.g. `P1-01`).
2. Decompile the relevant script using SCI Companion (`wine /home/gordonk/PycharmProjects/SCICompanion/Release/SCICompanion.exe LB2/RESOURCE.MAP`).
3. Make and compile the code change into loose `.SCR` and `.HEP` files in `LB2/`.
4. Test the fix in DOSBox-X: `./tools/run_dosbox.sh`.
5. Update `docs/ROADMAP.md`, `docs/HANDOFF.md`, and 3x manual entries.
6. Verify documentation: `python3 tools/check_docs.py`.
