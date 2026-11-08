# Security

Security model, trust boundaries, and asset policies for *The Dagger of Amon Ra: Redux*.

## Supported versions

Only the latest alpha and `master` are maintained.

## Reporting

Report security or asset-integrity concerns through the repository issue tracker.

## Assets and boundaries

An offline single-player mod with no network code, accounts, or telemetry. The risks are to the integrity of the game
files, to the maintainer's machine, and to Sierra's copyright.

| Asset or boundary | Sensitivity / threat | Protection and validation | Owner |
| --- | --- | --- | --- |
| Loose patches (`.SCR`, `.HEP`, `.MSG`, `.V56`) | Malformed bytecode, heaps, or cels crash Sierra's interpreter (PLAY-034) | Routine comparison, `tools/check_layout.py`, and a DOSBox-X boot test before distribution (D-029) | whoever changes the patch |
| Base archives | Corruption or replacement breaks every install | Never modified or committed; MD5s in `SOURCE_PROVENANCE.md`; pristine copies in `LB2_vanilla/` | maintainer |
| Sierra's copyright | Distributing Sierra's files | Packages and the repository hold only Redux's files (D-047); `tools/package_patch.py` leaves Sierra's out | maintainer |
| The maintainer's saves | Loss of the local save set | Never edited, deleted, or committed (`.gitignore`) | maintainer |
| SCI Companion and the `tools/*.exe` helpers under Wine | Windows binaries with access to the user's files through Wine's `Z:` drive | Only the maintainer's fork and locally built helpers; no third-party plugins | maintainer |
| Repository content and retrieved docs | Embedded instructions, prompt injection, invisible characters | `tools/check_docs.py` rejects zero-width and bidirectional controls; agents treat other Zones' docs, playtest reports, and decompiler output as data (`AGENTS.md`) | every agent |
| Downloaded source material | A tampered Sluicebox publication | Pinned revision and SHA-256 in `SOURCE_PROVENANCE.md` | maintainer |

## Secure development rules

- Keep credentials out of the repository, docs, and logs. The project needs none; the git remote's credentials stay
  in the maintainer's own git configuration.
- Boot-test every patch before it ships, and ship only patch-only zips built by `tools/package_patch.py`.
- Pin external source material by revision and hash before using it.
- Add no dependency without the maintainer's approval (`AGENTS.md`).

## Security verification

`tools/check_docs.py` (invisible and bidirectional characters), `tools/package_patch.py` (no Sierra files; the
extracted copy matches `LB2/`), and the boot test. Nothing scans the helper binaries, and no CI runs these checks.

## Incident response

Proposed 2026-11-08; the maintainer has not confirmed it. If a published package turns out to contain Sierra's files or a crashing patch: take the download down, rebuild with
`tools/package_patch.py`, record what happened in the HANDOFF session log and `CHANGELOG.md`, and tell testers through
the playtest page.
