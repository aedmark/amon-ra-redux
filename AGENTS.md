# The Dagger of Amon Ra: Redux

Modernization and definitive patch project for Laura Bow II (*The Dagger of Amon Ra*), built upon the Sierra SCI 1.1
DOS floppy v1.000 release using modular loose script overrides and SCI Companion.

This is the canonical instruction file for coding agents. `CLAUDE.md` imports it. Project facts belong in the documents
linked below, not in an agent's private memory.

## Start here

1. Read `docs/HANDOFF.md` for current state, active tasks, and gotchas.
2. Read the relevant roadmap item in `docs/ROADMAP.md` and parts of `docs/ARCHITECTURE.md` and `docs/TESTING.md`.
3. Verify claims using DOSBox-X and SCI Companion.
4. Scope changes strictly to the task at hand.

## While working

- Reference roadmap item IDs (`P<phase>-<nn>`) and decision IDs (`D-<nnn>`).
- Preserve immutable base game archives (`LB2/RESOURCE.000`, `LB2/RESOURCE.MAP`).
- Apply fixes as loose `.SCR`, `.HEP`, and `.MSG` files in `LB2/`.
- Record architectural choices in `docs/DECISIONS.md`.
- Keep 3x manual sources (`docs/manual/amon-ra.manual.json`) in sync with code fixes.

## Finishing a change

1. Run checks: `python3 tools/check_docs.py` and `python3 tools/manual.py check docs/manual/amon-ra.manual.json`.
2. Build updated manual: `python3 tools/manual.py build docs/manual/amon-ra.manual.json --output docs/manual/manual.html`.
3. Update `docs/HANDOFF.md` session log.

## Layout

| Path | Purpose |
| --- | --- |
| `LB2` | Floppy v1.000 game files and loose patch override directory |
| `SCICompanion` | SCI Companion source, documentation, and tools |
| `docs/manual` | Project-owned 3x manual source, schema, and license |
| `tools/manual.py` | Standalone 3x manual validator and HTML builder |
| `docs/ROADMAP.md` | Modernization roadmap with permanent item IDs |
| `docs/manual/manual.html` | Standalone compiled 3x project manual |
| `docs/ARCHITECTURE.md` | Engine architecture and subsystem design |
| `docs/DECISIONS.md` | Architectural decision records (ADRs) |
| `docs/TESTING.md` | DOSBox-X testing strategy and commands |
| `docs/HANDOFF.md` | Session handoff notes and log |
| `docs/README.md` | Documentation directory map |
| `docs/SECURITY.md` | Security and asset integrity policies |
| `docs/CHANGELOG.md` | Player-facing release notes |
| `docs/CONTRIBUTING.md` | Contribution guidelines |
| `tools/check_docs.py` | Documentation validation script |
