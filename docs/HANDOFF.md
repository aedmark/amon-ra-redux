# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](../ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-07, session 2: Architectural decisions D-007 (voice policy) and D-008 (diegetic Act 2 pacing) integrated._

**Where things stand, in one paragraph:** The project baseline has been established using the DOS floppy release
v1.000 (D-001) in `LB2/`. Maintainer feedback has resolved both open questions: D-007 omits insensitive CD voice
tracks in favor of text message tables (`.MSG`) with extensible hooks for future custom re-recordings; D-008 replaces
the 14-eavesdropping requirement with a diegetic knowledge acquisition threshold supplemented by contextual museum
puzzles. All 24 roadmap items (P1-01 through P4-06) across four phases are fully specified, and both verification
suites pass cleanly.

**Verified** (2026-10-07, Linux workspace)

| Suite | Result |
| --- | --- |
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 3x-documentation-scheme/scripts/manual.py check 3x-documentation-scheme/scheme/amon-ra.manual.json` | **Pass: 5 sections, 29 entries, 0 errors** |
| `python3 3x-documentation-scheme/scripts/manual.py build ... --output manual.html` | **Pass: compiled manual.html (102 KB)** |
| `scummvm --detect --path=LB2` | **Pass: recognized sci:laurabow2** |
| Wine execution of SCI Companion | **Pass: binary launches cleanly under Wine 11.19** |

**What works**

- **Documentation Architecture:** Both the Manifold project-memory system (`ROADMAP.md`, `docs/`) and the 3x
  Documentation Scheme (`manual.html`, `amon-ra.manual.json`) are synchronized and pass automated verification.
- **Maintainer Decisions Incorporated:** D-007 (text-first with extensible voice hooks) and D-008 (diegetic knowledge
  gating for Act 2) are formally accepted in `docs/DECISIONS.md` and integrated into the roadmap.
- **Tooling Readiness:** SCI Companion executes under Wine and ScummVM detects and runs the base floppy game files.

**Not verified**

- Individual script decompilations into `.sc` source files have not yet been bulk-extracted via SCI Companion GUI.
- Direct gameplay test saves across all acts have not yet been populated into a test fixtures directory.

**Gotchas for the next session**

- Loose patch files in `LB2/` take precedence over `RESOURCE.000`; keep a clean backup of `LB2/` before compiling.
- In SCI Companion under Wine, file paths inside dialogs map to Wine drive letters (e.g. `Z:\home\gordonk\...`).
- When editing `.MSG` files, message tuples (case, sequence, talker) must match the caller IDs in `.SCR` exactly.

## Next steps (in order)

1. Launch SCI Companion under Wine and decompile target scripts (`0.SCR`, `13.SCR`, `20.SCR`, `440.SCR`, `500.SCR`, `700.SCR`).
2. Begin Phase 1 implementation starting with P1-04 (Act 2 About screen memory check) and P1-03 (hitbox enlargement in room 440).
3. Implement P1-01 (interrogation UI streamlining) in `13.SCR` and test interaction flow with ScummVM.
4. Draft contextual investigation puzzles and minimum knowledge state flags for P3-03 in Act 2 (`Script 0`, `Script 230`).

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007 and D-008.

## Session log

### Session 2: 2026-10-07: Voiceover Policy and Diegetic Act 2 Pacing Integration

**Contributor:** Antigravity

**Goal:** Incorporate maintainer feedback regarding voiceover omission (D-007) and diegetic knowledge progression (D-008).

**Done:** Recorded D-007 (omitting insensitive CD audio tracks, text-first with future voiceover hooks) and D-008
(diegetic knowledge threshold and contextual museum puzzles); updated P2-03 and P3-03 in `ROADMAP.md`,
`docs/ARCHITECTURE.md`, `3x-documentation-scheme/scheme/amon-ra.manual.json`, and rebuilt `manual.html`.

**Changed:** `docs/DECISIONS.md`, `ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/HANDOFF.md`, `manual.html`.

**Decisions:** D-007 (Text-first, omit CD voices, future voice hooks), D-008 (Diegetic knowledge gating for Act 2).

**Verified:** `tools/check_docs.py` passes (0 errors, 0 warnings); `manual.py check` passes (0 errors, 0 warnings).

**Not verified:** In-engine script compilation.

**Problems / surprises:** None.

**Corrections:** None.

**Left undone:** P1-01 through P4-06 implementation.

**Next session should start with:** Decompiling target scripts in SCI Companion and executing P1-04 and P1-03 fixes.

### Session 1: 2026-10-07: Dev Plan & Modernization Roadmap Creation

**Contributor:** Antigravity

**Goal:** Establish development plan, architecture, and roadmap for modernizing The Dagger of Amon Ra using the floppy
release and SCI Companion.

**Done:** Created root `ROADMAP.md` covering all 24 items (P1-01 through P4-06); authored `docs/ARCHITECTURE.md`,
`docs/DECISIONS.md` (D-001 through D-006, Q-001, Q-002), `docs/TESTING.md`, `docs/SECURITY.md`, `docs/CHANGELOG.md`,
`docs/CONTRIBUTING.md`, `docs/README.md`, `AGENTS.md`, and `CLAUDE.md`; authored and compiled 3x manual `manual.html`.

**Changed:** Initialized project memory and documentation toolchain.

**Decisions:** D-001 (Floppy base v1.000), D-002 (Loose patch overrides), D-003 (Interrogation streamlining),
D-004 (Unrestricted save/load), D-005 (Softlock prevention), D-006 (Inquest scoring standardization).

**Verified:** `tools/check_docs.py` passes; `manual.py check` passes; ScummVM detects game; Wine executes SCI Companion.

**Not verified:** Script decompilation output and in-engine regression saves.

**Problems / surprises:** None.

**Corrections:** None.

**Left undone:** P1-01 through P4-06 implementation.

**Next session should start with:** Decompiling target scripts in SCI Companion and executing P1-04 and P1-03 fixes.
