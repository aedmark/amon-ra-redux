# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](../ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-07, session 3: Phase 1 (Critical Stability & UI/UX Overhaul) completed and compiled across 3 passes._

**Where things stand, in one paragraph:** Phase 1 (P1-01 through P1-06) is fully implemented, verified, and compiled.
Interrogation UI is streamlined with direct tab pre-selection and double-click asking (P1-01); save/load is unrestricted
across all screens and chase sequences (P1-02); hitboxes for tiny objects/hair/glints are enlarged (P1-03); the Act 2
About screen memory check bug is fixed (P1-04); character door clipping, sprite scaling perspective, and Steve cutscene
collisions are fixed (P1-05); and original 256-color art deco assets are audited and preserved with pristine base archives
(P1-06). A 3-pass compile all in SCI Companion converged all self-referencing scripts and symbol tables.

**Verified** (2026-10-07, Linux workspace)

| Suite | Result |
| --- | --- |
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 3x-documentation-scheme/scripts/manual.py check ...` | **Pass: 5 sections, 29 entries, 0 errors** |
| `python3 3x-documentation-scheme/scripts/manual.py build ...` | **Pass: compiled manual.html (103 KB)** |
| Base Game Archive MD5 Integrity | **Pass: RESOURCE.000 and RESOURCE.MAP match vanilla bit-for-bit** |
| 3-Pass Compile All in SCI Companion | **Pass: all 219 scripts compiled, symbols converged in 996.voc** |

**What works**

- **Phase 1 Overhaul:** All six Phase 1 items (P1-01 through P1-06) compiled as loose patches in `LB2/`.
- **Tooling Automation:** `tools/compile.py` compiles any target script on demand; `tools/compile_all.exe` executes multi-pass full builds.
- **Documentation Architecture:** `ROADMAP.md`, `docs/`, `3x-documentation-scheme/`, and `manual.html` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.

**Gotchas for the next session**

- Because SCI scripts are self-referencing, multi-pass compile all (`tools/compile_all.exe`) should be run whenever cross-script selectors or exports are modified.
- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`).

## Next steps (in order)

1. Begin Phase 2 implementation starting with P2-01 (Inaccessible Plot Information & Notebook Fallback Triggers for Najir, Miklo, Countess).
2. Implement P2-02 (Pocket Watch Confrontation Timing & Armor Room Lockout Adjustment in room 440).
3. Implement P2-03 (Murder Reaction Restoration & Text-First Voice Architecture in MSG resources).
4. Run gameplay test verification in DOSBox-X using `./tools/run_dosbox.sh`.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007 and D-008.

## Session log

### Session 3: 2026-10-07: Phase 1 Overhaul Completion & Multi-Pass Convergence

**Contributor:** Antigravity

**Goal:** Implement and verify all Phase 1 items (P1-01 through P1-06) covering interrogation UI, save/load, pixel hunts, memory bug, animation/scaling glitches, and art preservation.

**Done:**
- P1-01: Interrogation UI streamlined with direct tab pre-selection (People tab / last active tab) and double-click to confirm inquiry in `LB2/src/NotebookItem.sc` (Script 20).
- P1-02: Unrestricted save/load enabled across all screens by protecting settings/save icon 7 in `LB2/src/IconI.sc` (Script 937), `LB2/src/Main.sc` (Script 0), `LB2/src/LBRoom.sc` (Script 17), and eliminating icon disables in chase and corpse rooms (Scripts 525, 560, 565, 610).
- P1-03: Expanded clickable hitboxes for skeleton key glint on painting in `rm500.sc` (Script 500), staggered intercom buttons in `Button.sc` (Script 562), poetry book in `MyFeature.sc` (Script 650), museum dagger in `rm400.sc` (Script 400), and Ernie's corpse hairs in `rm420.sc` (Script 420); enabled Look and Magnifier interactions.
- P1-04: Fixed Act 2 About screen memory check error in `Main.sc` (Script 0) sel_613 by removing false `(== global123 2)` (`gAct == 2`) lockout.
- P1-05: Fixed character door clipping for Countess in `sCountessMeeting.sc` (Script 441) and Olympia in `rm600.sc` (Script 600); corrected Laura and pursuer scaling in chase rooms (`rm500.sc`, `rm510.sc`) and rotunda headdress rooms (`rm350.sc`, `rm355.sc`, `rm360.sc`, `rm370.sc`); eliminated Steve cutscene collision overlap in `rm350.sc`.
- P1-06: Verified 256-color art deco asset preservation and immutable base archives (`LB2/RESOURCE.000`, `LB2/RESOURCE.MAP`) with identical MD5 checksums against vanilla.
- Automated multi-pass compilation across all 219 scripts in SCI Companion under Wine to resolve self-referencing cross-script dependencies and symbol tables (`996.voc`).
- Synchronized 3x manual scheme sources (`3x-documentation-scheme/scheme/amon-ra.manual.json`) and rebuilt `manual.html`.

**Changed:** `LB2/src/Main.sc`, `LB2/src/LBRoom.sc`, `LB2/src/NotebookItem.sc`, `LB2/src/rm350.sc`, `LB2/src/rm355.sc`, `LB2/src/rm360.sc`, `LB2/src/rm370.sc`, `LB2/src/rm400.sc`, `LB2/src/rm420.sc`, `LB2/src/sCountessMeeting.sc`, `LB2/src/rm500.sc`, `LB2/src/rm510.sc`, `LB2/src/rm525.sc`, `LB2/src/rm560.sc`, `LB2/src/Button.sc`, `LB2/src/rm565.sc`, `LB2/src/rm600.sc`, `LB2/src/rm610.sc`, `LB2/src/MyFeature.sc`, `LB2/src/IconI.sc`, `ROADMAP.md`, `3x-documentation-scheme/scheme/amon-ra.manual.json`, `manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-001 (Floppy base v1.000 preserved), D-002 (Loose patch overrides), D-003 (Interrogation streamlining), D-004 (Unrestricted save/load).

**Verified:** `python3 tools/check_docs.py` (0 errors, 0 warnings); `python3 3x-documentation-scheme/scripts/manual.py check` (5 sections, 29 entries, 0 errors); `manual.py build` (103 KB compiled standalone manual); 3-pass compilation of all 219 scripts in SCI Companion; MD5 verification of base archives.

**Not verified:** Full playthrough regression from start to end in DOSBox-X.

**Problems / surprises:** Wine ERROR_ALREADY_EXISTS (183) during script compilation due to case-insensitive rename collisions resolved by automated pre-compile purging and uppercase promotion.

**Corrections:** Self-referencing script dependencies resolved via 3-pass compile all.

**Left undone:** Phase 2 (P2-01 through P2-07) narrative coherence and dialogue accessibility.

**Next session should start with:** Phase 2 implementation starting with P2-01 (inaccessible plot info and notebook fallback triggers for Najir, Miklo, Countess) and P2-02 (pocket watch confrontation timing in Armor Room).

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
