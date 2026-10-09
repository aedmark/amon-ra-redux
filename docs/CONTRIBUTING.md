# Contributing

Guidelines for contributing to *The Dagger of Amon Ra: Redux*.

## Development setup

1. Ensure Wine 11+ is installed for running SCI Companion: `wine --version`.
2. Ensure DOSBox-X is installed for original-interpreter runtime verification: `dosbox-x --version`.
3. Base floppy files are located in `LB2/`. Never overwrite `RESOURCE.000`, `RESOURCE.MAP`, `RESOURCE.MSG`, or `MESSAGE.MAP`; pristine copies live in `LB2_vanilla/`. Never run Compile All or any resource rebuild in SCI Companion (D-028).
4. Run `python3 tools/check_docs.py` to confirm documentation consistency.

## Workflow

1. Select an open task from `docs/ROADMAP.md` (e.g. `P1-01`).
2. Open the game in SCI Companion: `wine SCICompanion/Release/SCICompanion.exe 'Z:\home\gordonk\PycharmProjects\amon-ra-redux\LB2\game.ini'`.
3. Edit the script source in `LB2/src/` and compile that one script into loose `.SCR` and `.HEP` files with `python3 tools/compile.py <script>`; follow the steps in [TESTING.md](TESTING.md#compile-and-boot-workflow).
4. Boot the game in DOSBox-X before committing: `./tools/run_dosbox.sh` (D-029).
5. Update `docs/ROADMAP.md`, `docs/HANDOFF.md`, and 3x manual entries.
6. Verify documentation: `python3 tools/check_docs.py`.
