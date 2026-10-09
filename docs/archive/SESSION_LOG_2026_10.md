# Session log: October 2026

Archived verbatim from `docs/HANDOFF.md` when its live session log exceeded ten entries.

### Session 10: 2026-10-07: P2-07 Dagger Discovery Reactions & Inventory Hand-off

**Contributor:** Codex

**Goal:** Make the museum cast recognize the recovered Dagger of Amon Ra and transfer physical custody to O'Reilly.

**Done:**
- Audited archived message modules 1882..1892 and identified eight accessible verb-22 reactions, most of which incorrectly described the recovered dagger as a gift-shop replica.
- Added loose overrides for modules 1884, 1885, 1887, and 1889..1892, and updated the existing 1888 override without disturbing its P2-05 introduction edits.
- Added character-specific recognition dialogue for Countess, Yvette, Steve, O'Reilly, Heimlich, Ziggy, Rameses, and Olympia.
- Updated both O'Reilly actor contexts in Scripts 90 and 93 to dispatch the ordinary dagger dialogue and then remove inventory item 11 with `(gEgo sel_351: 11)`.
- Compiled Scripts 90 and 93, recorded D-015, synchronized the manual, and smoke-tested the loose patch set under DOSBox-X.

**Changed:** `LB2/src/MuseumRgn.sc`, `LB2/src/RotundaRgn.sc`, `LB2/90.SCR`, `LB2/93.SCR`, `LB2/1884.MSG`, `LB2/1885.MSG`, `LB2/1887.MSG`, `LB2/1888.MSG`, `LB2/1889.MSG`, `LB2/1890.MSG`, `LB2/1891.MSG`, `LB2/1892.MSG`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-015 (Treat the recovered dagger as physical evidence).

**Verified:** SCI Companion compilation of Scripts 90 and 93; exact-string audit of all eight message overrides; static ownership-path review; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the hand-off remains a manual regression test.

**Next session should start with:** Phase 2 deterministic-save branch testing, then P3-01 (Dead Man Walking Prevention for Act 5 critical items).

### Session 9: 2026-10-07: P2-06 Steve & Laura Character Consistency

**Contributor:** Codex

**Goal:** Make Steve and Laura's museum romance conditional on the player establishing a personal connection in Act 1.

**Done:**
- Audited the Act 1 Steve conversation and the museum arrival/reunion sequences, then reserved previously unused relationship flag 122.
- Set flag 122 from both `sTalkSteve` and `sAskSteve` in Script 240.
- Gated the automatic kiss, embrace, and reunion paths in Scripts 330, 335, and 350 behind that flag while preserving ordinary room initialization when it is unset.
- Removed an invalid decompiler-only `name` property from `local_Steve`, compiled all four affected scripts, and normalized the loose patches to uppercase.
- Recorded D-014, synchronized the manual, and kept all documentation under `docs/` after removing the project-local 3x symlink.

**Changed:** `LB2/src/rm240.sc`, `LB2/src/rm330.sc`, `LB2/src/rm335.sc`, `LB2/src/rm350.sc`, `LB2/240.SCR`, `LB2/240.HEP`, `LB2/330.SCR`, `LB2/335.SCR`, `LB2/350.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-014 (Gate Steve romance sequences on Act 1 conversation).

**Verified:** SCI Companion compilation with zero errors or warnings; static flag-use audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct traversal of both relationship branches remains a manual save-based regression test.

**Next session should start with:** P2-07 (Dagger Discovery Reactions & Inventory Hand-off).

### Session 8: 2026-10-07: P2-05 Contextual Dialogue Logic & Acquaintance Checks

**Contributor:** Codex

**Goal:** Prevent Laura from addressing museum characters by name before a formal introduction and use DOSBox-X for runtime testing.

**Done:**
- Audited the rotunda introductions and found six existing acquaintance flags: Pippin 110, Dr. Smith 111, Countess 112, Yvette 113, O'Riley 114, and Rameses 115.
- Added first-contact Talk routing to `aPippin.sc`, `aRameses.sc`, and the Countess, O'Riley, Dr. Smith, and Yvette actors in `MuseumRgn.sc`. An unset acquaintance flag now selects condition 80; existing dialogue remains unchanged once the flag is set.
- Added loose `1882.MSG`, `1883.MSG`, and `1888.MSG` overrides. Only the first two condition-80 text records in each module change: Laura opens neutrally, then Pippin, Smith, or O'Riley identifies himself.
- Recompiled Scripts 35, 36, and 90 with SCI Companion and normalized the loose patch names to uppercase.
- Replaced the active regression-testing documentation with the checked-in DOSBox-X workflow and recorded D-013.
- Synchronized the 3x manual and rebuilt `docs/manual/manual.html`.

**Changed:** `LB2/src/aPippin.sc`, `LB2/src/aRameses.sc`, `LB2/src/MuseumRgn.sc`, `LB2/35.SCR`, `LB2/36.SCR`, `LB2/90.SCR`, `LB2/1882.MSG`, `LB2/1883.MSG`, `LB2/1888.MSG`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-013 (Reuse museum acquaintance flags for formal introductions).

**Verified:** SCI Companion compilation of Scripts 35, 36, and 90; structural parsing of all three message overrides; headless DOSBox-X startup; documentation/manual validation; unchanged base archive hashes.

**Next session should start with:** P2-06 (Steve & Laura Character Consistency).

### Session 7: 2026-10-07: P2-04 Narrative Anachronism Corrections

**Contributor:** Codex

**Goal:** Implement P2-04 by auditing the complete SCI message corpus and correcting or clarifying dialogue that conflicts with the game's 1926 setting.

**Done:**
- Parsed all 103 archived message modules and located the four obsolete target strings in modules 250, 270, and 310.
- Established from in-game evidence that the story occurs late in 1926: Rocco's license was renewed September 5, characters call the year almost over, and Lindbergh's flight is advertised for the following spring.
- Added `LB2/250.MSG`, clarifying the historically real 1926 New York-London exchange as an experimental two-way radiotelephone conversation rather than the 1927 commercial service.
- Added `LB2/270.MSG`, replacing the 1945 Pippi Longstocking misunderstanding and its follow-up with period-valid references to Pip from Dickens' *Great Expectations*.
- Added `LB2/310.MSG`, identifying *The Sun Also Rises* as Hemingway's newly published novel while retaining Ziggy's claim that he saw it before publication.
- Recorded D-012, marked P2-04 complete, synchronized the 3x manual source, and rebuilt `docs/manual/manual.html`.
- Audited the effective resource layer (archived messages plus loose overrides): 103 modules, 5,888 records, zero obsolete target strings.

**Changed:** `LB2/250.MSG`, `LB2/270.MSG`, `LB2/310.MSG`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-012 (Late-1926 historical dialogue corrections).

**Verified:** Message structure and effective-string audit (103 modules / 5,888 records / 0 obsolete strings), ScummVM detection, docs validation, 3x manual validation/build, and unchanged base archive hashes. Headless ScummVM startup produces the same pre-existing invalid-selector fault with and without the three new message patches.

**Next session should start with:** P2-05 (Contextual Dialogue Logic & Acquaintance Checks).

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
- Updated `docs/ROADMAP.md` (P2-03 marked done), `docs/manual/amon-ra.manual.json`, and rebuilt `docs/manual/manual.html` (105 KB).
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm630.sc`, `LB2/src/rm435.sc`, `LB2/src/rm490.sc`, `LB2/src/rm420.sc`, `LB2/src/rm500.sc`, `LB2/src/rm525.sc`, `LB2/src/rm620.sc`, `LB2/src/MuseumRgn.sc`, `LB2/src/RotundaRgn.sc`, `LB2/src/aHeimlich.sc`, `LB2/src/aRameses.sc`, `LB2/32.SCR`, `LB2/36.SCR`, `LB2/90.SCR`, `LB2/93.SCR`, `LB2/420.SCR`, `LB2/435.SCR`, `LB2/490.SCR`, `LB2/500.SCR`, `LB2/525.SCR`, `LB2/620.SCR`, `LB2/630.SCR`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

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
- Updated `docs/ROADMAP.md` (P2-02 marked done), `docs/manual/amon-ra.manual.json`, and rebuilt `docs/manual/manual.html`.
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm440.sc`, `LB2/src/sCountessMeeting.sc`, `LB2/src/triggerAndClock.sc`, `LB2/440.SCR`, `LB2/441.SCR`, `LB2/22.SCR`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-010 (Pocket watch confrontation timing and Armor Room lockout adjustment).

**Verified:** `python3 tools/compile.py rm440`, `python3 tools/compile.py sCountessMeeting`, `python3 tools/compile.py triggerAndClock`, `python3 tools/check_docs.py` (0 errors), `python3 tools/manual.py check` (0 errors), `manual.py build` (104 KB).

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
- Updated `docs/ROADMAP.md` (P2-01 marked done), updated `docs/manual/amon-ra.manual.json`, and built `docs/manual/manual.html`.
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm335.sc`, `LB2/src/RotundaRgn.sc`, `LB2/335.SCR`, `LB2/335.HEP`, `LB2/93.SCR`, `LB2/93.HEP`, `tools/compile_any.c`, `tools/compile_any.exe`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-009 (Dual-tier notebook fallback triggers for Act 2 suspects).

**Verified:** `python3 tools/compile.py rm335`, `python3 tools/compile.py RotundaRgn`, `python3 tools/check_docs.py` (0 errors), `python3 tools/manual.py check` (0 errors), `manual.py build` (104 KB).

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
- Synchronized 3x manual scheme sources (`docs/manual/amon-ra.manual.json`) and rebuilt `docs/manual/manual.html`.

**Changed:** `LB2/src/Main.sc`, `LB2/src/LBRoom.sc`, `LB2/src/NotebookItem.sc`, `LB2/src/rm350.sc`, `LB2/src/rm355.sc`, `LB2/src/rm360.sc`, `LB2/src/rm370.sc`, `LB2/src/rm400.sc`, `LB2/src/rm420.sc`, `LB2/src/sCountessMeeting.sc`, `LB2/src/rm500.sc`, `LB2/src/rm510.sc`, `LB2/src/rm525.sc`, `LB2/src/rm560.sc`, `LB2/src/Button.sc`, `LB2/src/rm565.sc`, `LB2/src/rm600.sc`, `LB2/src/rm610.sc`, `LB2/src/MyFeature.sc`, `LB2/src/IconI.sc`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-001 (Floppy base v1.000 preserved), D-002 (Loose patch overrides), D-003 (Interrogation streamlining), D-004 (Unrestricted save/load).

**Verified:** `python3 tools/check_docs.py` (0 errors, 0 warnings); `python3 tools/manual.py check` (5 sections, 29 entries, 0 errors); `manual.py build` (103 KB compiled standalone manual); 3-pass compilation of all 219 scripts in SCI Companion; MD5 verification of base archives.

**Not verified:** Full playthrough regression from start to end in DOSBox-X.

**Problems / surprises:** Wine ERROR_ALREADY_EXISTS (183) during script compilation due to case-insensitive rename collisions resolved by automated pre-compile purging and uppercase promotion.

**Corrections:** Self-referencing script dependencies resolved via 3-pass compile all.

**Left undone:** Phase 2 (P2-01 through P2-07) narrative coherence and dialogue accessibility.

**Next session should start with:** Phase 2 implementation starting with P2-01 (inaccessible plot info and notebook fallback triggers for Najir, Miklo, Countess) and P2-02 (pocket watch confrontation timing in Armor Room).

### Session 2: 2026-10-07: Voiceover Policy and Diegetic Act 2 Pacing Integration

**Contributor:** Antigravity

**Goal:** Incorporate maintainer feedback regarding voiceover omission (D-007) and diegetic knowledge progression (D-008).

**Done:** Recorded D-007 (omitting insensitive CD audio tracks, text-first with future voiceover hooks) and D-008
(diegetic knowledge threshold and contextual museum puzzles); updated P2-03 and P3-03 in `docs/ROADMAP.md`,
`docs/ARCHITECTURE.md`, `docs/manual/amon-ra.manual.json`, and rebuilt `docs/manual/manual.html`.

**Changed:** `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/HANDOFF.md`, `docs/manual/manual.html`.

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

**Done:** Created `docs/ROADMAP.md` covering all 24 items (P1-01 through P4-06); authored `docs/ARCHITECTURE.md`,
`docs/DECISIONS.md` (D-001 through D-006, Q-001, Q-002), `docs/TESTING.md`, `docs/SECURITY.md`, `docs/CHANGELOG.md`,
`docs/CONTRIBUTING.md`, `docs/README.md`, `AGENTS.md`, and `CLAUDE.md`; authored and compiled 3x manual `docs/manual/manual.html`.

**Changed:** Initialized project memory and documentation toolchain.

**Decisions:** D-001 (Floppy base v1.000), D-002 (Loose patch overrides), D-003 (Interrogation streamlining),
D-004 (Unrestricted save/load), D-005 (Softlock prevention), D-006 (Inquest scoring standardization).

**Verified:** `tools/check_docs.py` passes; `manual.py check` passes; ScummVM detects game; Wine executes SCI Companion.

**Not verified:** Script decompilation output and in-engine regression saves.

**Problems / surprises:** None.

**Corrections:** None.

**Left undone:** P1-01 through P4-06 implementation.

**Next session should start with:** Decompiling target scripts in SCI Companion and executing P1-04 and P1-03 fixes.
