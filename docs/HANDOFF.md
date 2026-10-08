# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-08, session 13: P3-03 (Pacing and Progression Audit) completed and verified._

**Where things stand, in one paragraph:** Phase 1, Phase 2, and P3-01 through P3-03 are complete. P3-03 audited the
outline's claimed 14-eavesdrop Act 2 gate and found that it does not exist: authored sequences call Script 26 directly,
while `global111` is a later scene scheduler that is not read by the act-break controller. D-017 preserves those save and
story semantics rather than introducing a conflicting knowledge counter. The underlying passive-pacing concern remains
scheduled as post-bugfix milestone P5-01, which will add player-driven museum investigations around Act 2's essential
conversations. P3-02's Snake Oil patches remain compiled and uncommitted alongside these documentation changes. All
project documentation lives under `docs/`, with the manual builder retained under `tools/`.

**Verified** (2026-10-08, Linux workspace)

| Suite | Result |
| --- | --- |
| P3-03 progression reference audit | **Pass: all `global111` reads/writes and all Script 26 callers traced; no Act 2 knowledge-count gate exists** |
| P3-02 Script compilation | **Pass: 15.SCR/15.HEP and 610.SCR/610.HEP emitted by SCI Companion** |
| P3-02 View 61 structure | **Pass: cursor loop retains one cel; inventory and toolbar loops each expose full cel 0 and empty cel 1** |
| P3-02 refill audit | **Pass: full/empty guards precede a one-action refill and one-step jar depletion** |
| P3-01 Script 0 compilation | **Pass: 0.SCR and 0.HEP emitted by SCI Companion** |
| P3-01 state audit | **Pass: items 10/14/16 repaired once at Act 5; empty global150 restored; guard flag 123 unused elsewhere** |
| P2-07 script compilation | **Pass: 90.SCR and 93.SCR emitted by SCI Companion** |
| P2-07 MSG/ownership audit | **Pass: eight intended dagger reactions present; both O'Reilly verb-22 paths remove item 11** |
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 tools/manual.py check ...` | **Pass: 6 sections, 30 entries, 0 errors** |
| `python3 tools/manual.py build ...` | **Pass: compiled docs/manual/manual.html** |
| P2-06 script compilation | **Pass: 240.SCR, 330.SCR, 335.SCR, and 350.SCR emitted by SCI Companion** |
| P2-06 flag-use audit | **Pass: relationship flag 122 is set only by Act 1 Steve Talk/Ask and tested only by the three intended museum paths** |
| P2-05 script compilation | **Pass: 35.SCR, 36.SCR, and 90.SCR emitted by SCI Companion** |
| P2-05 MSG structure audit | **Pass: modules 1882, 1883, and 1888 parse with only six intended text records changed** |
| DOSBox-X headless startup | **Pass: original interpreter environment initialized with loose patches mounted** |
| Base Game Archive MD5 Integrity | **Pass: RESOURCE.000 and RESOURCE.MAP match vanilla bit-for-bit** |

**What works**

- **Phase 1 Overhaul:** All six Phase 1 items (P1-01 through P1-06) compiled as loose patches in `LB2/`.
- **P2-01 Suspect Fallbacks:** Dual-tier guest register check-in and encounter-based suspect registration operational.
- **P2-02 Pocket Watch Confrontation:** Armor Room lockout removed, meeting scheduling sequence corrected, and watch confrontation dialogue fully accessible.
- **P2-03 Murder Reaction Restoration:** Discovered homicide dialogue trees restored across all suspects; O'Riley Countess reaction connected; Ziggy head exhibit restored; Dagger inquiry connected.
- **P2-04 Historical Dialogue:** Three loose message overrides correct or clarify the identified late-1926 references while preserving message tuples and talkers.
- **P2-05 Acquaintance Routing:** Six museum characters now honor existing introduction state; Pippin, Smith, and O'Riley introduce themselves in neutral first-contact dialogue.
- **P2-06 Steve Continuity:** Museum romance sequences require Laura to have spoken with Steve in Act 1; otherwise their relationship remains professional.
- **P2-07 Dagger Reactions and Custody:** Accessible suspects recognize the authentic recovered dagger; handing it to O'Reilly removes it from inventory in either museum actor context.
- **P3-01 Act 5 Supply Safety:** A one-time central audit repairs missing cutters, oil, and cheese for new or existing Act 5 saves without recreating consumed items.
- **P3-02 Snake Oil Feedback:** Empty bottles visibly switch to a red-X cel; the Room 610 jar provides three guarded one-action refills through a larger hotspot.
- **P3-03 Progression Audit:** Authored act transitions and the later `global111` scene scheduler are preserved; Act 2's genuine passive-pacing problem is retained as post-bugfix content milestone P5-01.
- **Tooling Automation:** `tools/compile.py` compiles single scripts (including extension-agnostic target lookup in SysListView32); `tools/compile_all.exe` executes multi-pass builds.
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-009 through D-018), `docs/manual/`, and `docs/manual/manual.html` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game traversal of the P2-04 historical dialogue, P2-05 first-contact branches, both P2-06 Steve relationship branches, the P2-07 dagger hand-off, P3-01 entry with deliberately missing supplies, and P3-02 bottle depletion/refill transitions; the automated DOSBox-X check is a startup smoke, not an input-driven playthrough.

**Gotchas for the next session**

- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`, `.MSG`).
- The dialogue chronology is late 1926; the design outline's “Spring 1926” wording is contradicted by multiple in-game date anchors (D-012).
- In `RotundaRgn.sc` (Script 93), `Actor` instances must not define extraneous property `name` (already covered by `sel_20`).
- Script 15's decompiled inventory instances likewise carried invalid `name` pseudo-properties; these were removed because `sel_20` already supplies their labels.
- If a mapped source is absent from SCI Companion's resource list, a temporary numbered loose resource makes it selectable; compile the real source, then retain only the compiler-emitted patch. Scripts 15 and 240 required this bootstrap.

## Next steps (in order)

1. Exercise P2-04 through P2-07 and P3-01/P3-02 branches from deterministic saves in DOSBox-X using `./tools/run_dosbox.sh`.
2. Implement P3-04 (Unfair Death Warnings & Secret Passage Look Mechanic).

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

### Session 13: 2026-10-08: P3-03 Pacing & Progression Audit

**Contributor:** Codex

**Goal:** Verify the claimed 14-eavesdrop Act 2 gate and replace it only if the source supported that progression model.

**Done:**
- Traced every `global111` reference and every direct Script 26 act-break call in the source tree.
- Confirmed that Act transitions are launched by authored story sequences and that the Act 2-to-3 transition follows the Pippin discovery/report sequence in Room 454.
- Confirmed that `global111` schedules later door-listening and character scenes across Rooms 510, 560, and 630; Script 22 and Room 610 can set it directly to 15, and Script 26 never reads it.
- Rejected the proposed synthetic knowledge bitmask because it would create a second progression model, skip authored scenes, and reinterpret existing saves.
- Superseded D-008 with D-017, marked P3-03 complete as a source-backed scope correction, and synchronized the architecture, roadmap, changelog, and manual.
- Following maintainer clarification, preserved the actual design goal as P5-01: a post-bugfix Act 2 content milestone adding compact museum puzzles and more natural routing through the essential dialogue/eavesdropping flow (D-018).

**Changed:** `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-017 (Preserve authored act transitions and scene-scheduler semantics; supersedes D-008) and D-018 (Stage Act 2 interactive content after core bug fixes).

**Verified:** Complete static progression-reference audit; documentation/manual validation; DOSBox-X original-interpreter startup smoke. No game binary changed for P3-03.

**Next session should start with:** P3-04 (Unfair Death Warnings & Secret Passage Look Mechanic).

### Session 12: 2026-10-08: P3-02 Snake Oil Refill & Inventory Feedback

**Contributor:** Codex

**Goal:** Make snake oil charge state visible and make the laboratory refill interaction direct, guarded, and easy to target.

**Done:**
- Corrected the outline's resource assumptions: Snake Oil is owned by Script 15, and its refill jar is in Room 610 rather than Room 510.
- Added a reproducible loose View 61 patch with a red-X empty cel for the inventory and toolbar loops, driven directly by `global150`.
- Replaced the jar's four-application refill bug with one-action logic that rejects a full bottle or empty jar and consumes exactly one of three jar portions.
- Enlarged the jar interaction rectangle and confirmed the original handler already had no grape prerequisite.
- Removed 23 invalid decompiler-only `name` properties exposed by the first Script 15 rebuild, then compiled Scripts 15 and 610.
- Recorded D-016, synchronized the manual, and smoke-tested the loose patch set under DOSBox-X.

**Changed:** `LB2/src/LBIconItem.sc`, `LB2/src/rm610.sc`, `LB2/15.SCR`, `LB2/15.HEP`, `LB2/61.V56`, `LB2/610.SCR`, `tools/build_snake_oil_view.py`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-016 (Use charge state as the Snake Oil UI source of truth).

**Verified:** SCI Companion compilation of Scripts 15 and 610; structural decode of all five View 61 cels; static guard/depletion audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based refill traversal remains a manual regression test.

**Next session should start with:** P3-03 (Pacing, Act Length & Diegetic Knowledge Rebalance).

### Session 11: 2026-10-07: P3-01 Dead Man Walking Prevention

**Contributor:** Codex

**Goal:** Prevent Act 5 from becoming unwinnable when Wire Cutters, Snake Oil, or Cheese were missed or exhausted earlier.

**Done:**
- Traced all three items through their inventory indices, acquisition paths, charge state, finale consumption, and the `actBreak` transition into `global123 == 5`.
- Corrected the original architectural assumption that Room 510 was a basement cache; it is a museum gallery and is not a reliable recovery boundary.
- Added a one-time supply audit to Main's central room-transition handler. Missing inventory items 10, 14, and 16 are granted, empty `global150` is restored to four charges, and unused flag 123 records completion.
- Kept the audit idempotent so existing Act 5 saves are repaired while snake oil and cheese remain consumed after their finale puzzles.
- Compiled Script 0, synchronized D-005 and the manual, and smoke-tested the loose patch set under DOSBox-X.

**Changed:** `LB2/src/Main.sc`, `LB2/0.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-005 (Softlock prevention through a guarded Act 5 supply audit).

**Verified:** SCI Companion compilation of Script 0; static inventory-index, charge-counter, and flag-use audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based entry with deliberately missing items remains a manual regression test.

**Next session should start with:** P3-02 (Snake Oil Refill Mechanic & Inventory Feedback Overhaul).

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
