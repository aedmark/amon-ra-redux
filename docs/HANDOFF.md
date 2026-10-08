# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](../ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-07, session 6: P2-03 (Unused Dialogue & Murder Reaction Restoration) implemented, compiled, and verified._

**Where things stand, in one paragraph:** Phase 1 (P1-01 through P1-06) and Phase 2 items P2-01, P2-02, and P2-03 are fully
implemented, verified, and compiled. P2-03 resolves systematic flag disconnects between homicide discovery cutscenes and NPC
interrogation dispatchers: sets narrative homicide flags (`171` & `134` in `rm630.sc`, `143` in `rm435.sc`, `158` in `rm420.sc`,
`161` in `rm500.sc`, `165` in `rm525.sc`, and `155` in `rm620.sc`) upon body/clue discovery; establishes dual-tier fallback checks
in interrogation switches across `MuseumRgn.sc`, `RotundaRgn.sc`, `aHeimlich.sc`, and `aRameses.sc`; wires missing topic 269 in
O'Riley (`MuseumRgn.sc`) to activate authored 8-line Countess murder sequence 70; and restores Ziggy's severed head exhibit in
`rm490.sc` via dual-tier flag 143/72 check. All 11 modified scripts are compiled to loose overrides (`32.SCR`, `36.SCR`, `90.SCR`,
`93.SCR`, `420.SCR`, `435.SCR`, `490.SCR`, `500.SCR`, `525.SCR`, `620.SCR`, `630.SCR`). Base game archives match bit-for-bit,
ADR D-011 recorded, and 3x manuals pass validation.

**Verified** (2026-10-07, Linux workspace)

| Suite | Result |
| --- | --- |
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 3x-documentation-scheme/scripts/manual.py check ...` | **Pass: 5 sections, 29 entries, 0 errors** |
| `python3 3x-documentation-scheme/scripts/manual.py build ...` | **Pass: compiled manual.html (105 KB)** |
| Base Game Archive MD5 Integrity | **Pass: RESOURCE.000 and RESOURCE.MAP match vanilla bit-for-bit** |
| SCI Companion Script Compilation | **Pass: 32, 36, 90, 93, 420, 435, 490, 500, 525, 620, 630 compiled cleanly** |

**What works**

- **Phase 1 Overhaul:** All six Phase 1 items (P1-01 through P1-06) compiled as loose patches in `LB2/`.
- **P2-01 Suspect Fallbacks:** Dual-tier guest register check-in and encounter-based suspect registration operational.
- **P2-02 Pocket Watch Confrontation:** Armor Room lockout removed, meeting scheduling sequence corrected, and watch confrontation dialogue fully accessible.
- **P2-03 Murder Reaction Restoration:** Discovered homicide dialogue trees restored across all suspects; O'Riley Countess reaction connected; Ziggy head exhibit restored; Dagger inquiry connected.
- **Tooling Automation:** `tools/compile.py` compiles single scripts (including extension-agnostic target lookup in SysListView32); `tools/compile_all.exe` executes multi-pass builds.
- **Documentation Architecture:** `ROADMAP.md`, `DECISIONS.md` (D-009, D-010, D-011), `3x-documentation-scheme/`, and `manual.html` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.

**Gotchas for the next session**

- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`).
- In `RotundaRgn.sc` (Script 93), `Actor` instances must not define extraneous property `name` (already covered by `sel_20`).

## Next steps (in order)

1. Implement P2-04 (Narrative Anachronism Corrections across MSG resources).
2. Implement P2-05 (Contextual Dialogue Logic & Acquaintance Checks).
3. Implement P2-06 (Steve & Laura Character Consistency).
4. Run gameplay test verification in DOSBox-X using `./tools/run_dosbox.sh`.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007 and D-008.

## Session log

### Session 6: 2026-10-07: P2-03 Unused Dialogue & Murder Reaction Restoration

**Contributor:** Antigravity

**Goal:** Implement P2-03 (Unused Dialogue & Murder Reaction Restoration) to restore authored NPC murder reactions, reconnect missing interrogation branches, restore Ziggy's severed head display in room 490, and enable O'Riley's Countess murder confrontation.

**Done:**
- Audited message resources across suspect talkers (1883..1892) using custom DCL decompression tooling (`/tmp/dump_msg`). Discovered Sierra authors wrote complete, dramatic reactions for all discovered murders (Carrington, Ziggy, Ernie, Yvette, Carter, Countess, and Dagger of Amon Ra) across modules.
- Diagnosed root causes for inaccessible murder reactions:
  1. Carrington (clue 259, sequence 69): Room 630 set physical discovery flag 12 upon opening trunk, but interrogation switches checked flag 171 (only set in room 560 when finding Watney Little).
  2. Ziggy (clue 264, sequence 74): Room 435 set corpse discovery flag 72, but interrogation switches checked flag 143, and Ziggy's severed head in room 490 was gated behind `(if (proc0_2 143))`, preventing the exhibit from ever initializing.
  3. Ernie (clue 267, sequence 71): Room 420 set corpse discovery flag 67, but interrogation switches checked flag 158.
  4. Yvette (clue 266, sequence 73): Room 500 set corpse discovery flag 68 upon discovering Yvette, but interrogation switches checked flag 161 (only set after `sSmashPlaster`).
  5. Countess (clue 269, sequence 70): Sierra authored a full 8-line sequence in module 1888 for questioning O'Riley about Countess's murder, but case 269 was entirely omitted from `aORiley` in `MuseumRgn.sc`.
  6. Dagger (clue 780, sequence 75): O'Riley's reaction to finding the Dagger in the alcohol vat checked score flag 155 rather than physical item possession.
- Implemented fixes in accordance with ADR D-011:
  1. Set narrative homicide flags directly in discovery cutscenes and detail insets: `(proc0_3 171)` and `(proc0_3 134)` in `LB2/src/rm630.sc`, `(proc0_3 143)` in `LB2/src/rm435.sc`, `(proc0_3 158)` in `LB2/src/rm420.sc`, `(proc0_3 161)` in `LB2/src/rm500.sc`, `(proc0_3 165)` in `LB2/src/rm525.sc`, and `(proc0_3 155)` in `LB2/src/rm620.sc`.
  2. Implemented dual-tier fallback checks across interrogation switches in `LB2/src/MuseumRgn.sc` (Script 90), `LB2/src/RotundaRgn.sc` (Script 93), `LB2/src/aHeimlich.sc` (Script 32), and `LB2/src/aRameses.sc` (Script 36) for clues 259, 264, 266, 267, and 780.
  3. Added missing case 269 in `aORiley` in `MuseumRgn.sc` to trigger sequence 70 upon Countess's death.
  4. Restored Ziggy's severed head exhibit in `LB2/src/rm490.sc` by checking `(if (or (proc0_2 143) (proc0_2 72)))`.
- Compiled all 11 modified scripts: `32.SCR`, `36.SCR`, `90.SCR`, `93.SCR`, `420.SCR`, `435.SCR`, `490.SCR`, `500.SCR`, `525.SCR`, `620.SCR`, `630.SCR`.
- Recorded architectural decision D-011 in `docs/DECISIONS.md`.
- Updated `ROADMAP.md` (P2-03 marked done), `3x-documentation-scheme/scheme/amon-ra.manual.json`, and rebuilt `manual.html` (105 KB).
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm630.sc`, `LB2/src/rm435.sc`, `LB2/src/rm490.sc`, `LB2/src/rm420.sc`, `LB2/src/rm500.sc`, `LB2/src/rm525.sc`, `LB2/src/rm620.sc`, `LB2/src/MuseumRgn.sc`, `LB2/src/RotundaRgn.sc`, `LB2/src/aHeimlich.sc`, `LB2/src/aRameses.sc`, `LB2/32.SCR`, `LB2/36.SCR`, `LB2/90.SCR`, `LB2/93.SCR`, `LB2/420.SCR`, `LB2/435.SCR`, `LB2/490.SCR`, `LB2/500.SCR`, `LB2/525.SCR`, `LB2/620.SCR`, `LB2/630.SCR`, `docs/DECISIONS.md`, `ROADMAP.md`, `3x-documentation-scheme/scheme/amon-ra.manual.json`, `manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-011 (Unused dialogue & murder reaction restoration).

**Verified:** `python3 tools/compile.py` for all 11 scripts, `tools/check_docs.py` (0 errors), `manual.py check` (0 errors), `manual.py build` (105 KB), MD5 verification of base archives.

**Next session should start with:** P2-04 (Narrative Anachronism Corrections across MSG resources).

### Session 5: 2026-10-07: P2-02 Pocket Watch Confrontation Timing & Armor Room Lockout Implementation

**Contributor:** Antigravity

**Goal:** Implement P2-02 (Pocket Watch Confrontation Timing & Armor Room Lockout Adjustment) to guarantee Laura can retrieve Carrington's pocket watch from room 630 and present it to Countess Waldorf-Carlton in the Armor Room (room 440).

**Done:**
- Reverse-engineered bytecode and scripts for Carrington's office (`rm630.sc`), Armor Room (`rm440.sc`), Countess meeting controller (`sCountessMeeting.sc`), and the game clock engine (`triggerAndClock.sc`).
- Diagnosed compounding vanilla lockouts:
  1. Retrieving the watch in `rm630.sc` (`inWatchOpen sel_111:`) advances clock to 1:45 by setting bit 16 (`4880`) in `global124`.
  2. In `rm440.sc` `sOutTapestry` state 2, `(not (proc0_10 4880))` locked out the confrontation dialogue whenever Laura possessed the watch.
  3. In `rm440.sc` `sel_403`, `(proc0_10 8224 1)` tested whether lower bits summed to 31 (`0x1f`); possessing the watch set bit 16, prematurely triggering `sMeetingNo2` (Ziggy/Little) at 1:45 and completely skipping the Countess meeting.
  4. In `triggerAndClock.sc`, clock tick 1:45 (`145`) unconditionally relocated Countess to room 520.
- Implemented fixes in accordance with ADR D-010:
  1. Removed `(not (proc0_10 4880))` from `sOutTapestry` state 2 in `LB2/src/rm440.sc`.
  2. Modified `sel_403` in `rm440.sc` so `sMeetingNo2` only takes precedence if `(or (proc0_2 120) (proc0_10 8224))` is satisfied, ensuring Meeting 1 always precedes Meeting 2.
  3. Updated `sCountessNoMeet` state 3 in `LB2/src/sCountessMeeting.sc` so entering the room with the watch immediately triggers `sTalkWithCountess`.
  4. Updated `askQuestions of Actions` in `sCountessMeeting.sc` so presenting the watch from behind the tapestry triggers `sOutTapestry`, returning 1.
  5. In `LB2/src/triggerAndClock.sc`, preserved Countess destination at room 440 at 1:45 until `(proc0_2 120)` is set, relocating her to 520 at 2:00 (`200`).
- Compiled `LB2/440.SCR`, `LB2/441.SCR`, and `LB2/22.SCR`.
- Recorded architectural decision D-010 in `docs/DECISIONS.md`.
- Updated `ROADMAP.md` (P2-02 marked done), `3x-documentation-scheme/scheme/amon-ra.manual.json`, and rebuilt `manual.html`.
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm440.sc`, `LB2/src/sCountessMeeting.sc`, `LB2/src/triggerAndClock.sc`, `LB2/440.SCR`, `LB2/441.SCR`, `LB2/22.SCR`, `docs/DECISIONS.md`, `ROADMAP.md`, `3x-documentation-scheme/scheme/amon-ra.manual.json`, `manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-010 (Pocket watch confrontation timing and Armor Room lockout adjustment).

**Verified:** `python3 tools/compile.py rm440`, `python3 tools/compile.py sCountessMeeting`, `python3 tools/compile.py triggerAndClock`, `python3 tools/check_docs.py` (0 errors), `python3 3x-documentation-scheme/scripts/manual.py check` (0 errors), `manual.py build` (104 KB).

**Next session should start with:** P2-03 (Unused Dialogue & Murder Reaction Restoration in MSG resources).

### Session 4: 2026-10-07: P2-01 Notebook Fallback Triggers Implementation

**Contributor:** Antigravity

**Goal:** Implement P2-01 (Inaccessible Plot Information & Notebook Fallback Triggers) to guarantee all Act 2 suspects and museum staff (Najir, Miklo, Countess, etc.) are registered in Laura's notebook regardless of Act 1 inquiry choices.

**Done:**
- Reverse-engineered SCI 1.1 `RESOURCE.MSG` decompression and identified Category 1 suspect clues 257–274.
- Discovered vanilla bug: clues 263–272 (Steve, Ziggy, Heimlich, Yvette, Ernie, Rameses, Countess, Olympia, Tut, Watney) were strictly gated behind optional Act 1 dialogues, locking players out of Act 2 interrogations.
- Implemented dual-tier fallback in accordance with ADR D-009:
  1. Diegetic guest register check in `LB2/src/rm335.sc` (Script 335) registering clues 263..272 in `sGiveInvite` state 5 and `sExitNorth` state 3.
  2. Direct Look/Talk encounter triggers in `LB2/src/RotundaRgn.sc` (Script 93) across all 11 rotunda characters (Countess, Heimlich, Olympia, O'Riley, Pippin, Rameses, Steve, Tut, Watney, Yvette, Ziggy).
- Fixed syntax error in `RotundaRgn.sc` (`name "O'Riley"` instance property conflict with `sel_20`).
- Updated `tools/compile_any.c` to support case-insensitive, extension-agnostic target lookup in SCI Companion's SysListView32.
- Successfully compiled `LB2/335.SCR`, `LB2/335.HEP`, `LB2/93.SCR`, and `LB2/93.HEP`.
- Documented architectural decision D-009 in `docs/DECISIONS.md`.
- Updated `ROADMAP.md` (P2-01 marked done), updated `3x-documentation-scheme/scheme/amon-ra.manual.json`, and built `manual.html`.
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm335.sc`, `LB2/src/RotundaRgn.sc`, `LB2/335.SCR`, `LB2/335.HEP`, `LB2/93.SCR`, `LB2/93.HEP`, `tools/compile_any.c`, `tools/compile_any.exe`, `docs/DECISIONS.md`, `ROADMAP.md`, `3x-documentation-scheme/scheme/amon-ra.manual.json`, `manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-009 (Dual-tier notebook fallback triggers for Act 2 suspects).

**Verified:** `python3 tools/compile.py rm335`, `python3 tools/compile.py RotundaRgn`, `python3 tools/check_docs.py` (0 errors), `python3 3x-documentation-scheme/scripts/manual.py check` (0 errors), `manual.py build` (104 KB).

**Next session should start with:** P2-02 (Pocket Watch Confrontation Timing & Armor Room Lockout Adjustment in room 440).

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
