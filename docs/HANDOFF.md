# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-08, session 16: P3-06 (NPC Wander Mechanic Stabilization) completed and verified._

**Where things stand, in one paragraph:** Phase 1, Phase 2, and Phase 3 are complete. Script 90 now pauses only the
selected museum actor's existing `TravelToRoom` state while dialogue is open and resumes that exact state on dismissal;
Script 22 preserves O'Reilly after 10:15 in Acts 3 and 4. D-021 records the route-preservation design. P3-04 through
P3-06 remain compiled and uncommitted together with their documentation changes. Act 2's passive-pacing concern remains
scheduled as post-bugfix milestone P5-01. All project documentation lives under `docs/`, with the manual builder
retained under `tools/`.

**Verified** (2026-10-08, Linux workspace)

| Suite | Result |
| --- | --- |
| P3-06 Script compilation | **Pass: 90.SCR/90.HEP and 22.SCR/22.HEP emitted by SCI Companion with 0 errors and 0 warnings** |
| P3-06 movement/schedule audit | **Pass: all 112 museum-actor message paths use the dialogue lock; TravelToRoom holds its state; O'Reilly's 10:15 removal excludes only Acts 3 and 4** |
| P3-05 Script compilation | **Pass: 250.SCR/250.HEP emitted by SCI Companion with 0 errors and 0 warnings** |
| P3-05 state-path audit | **Pass: all three dirty-taxi checks use press-pass bit 1; docks/baseball/Ziggy bits remain independent and available** |
| P3-04 Script compilation | **Pass: 530.SCR/530.HEP emitted by SCI Companion with 0 errors and 0 warnings** |
| P3-04 warning audit | **Pass: dark boundary redirects to sWarnDarkStairs, moves Laura to y=165, and reuses message tuple 11/1/2** |
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
- **P3-04 Fair-Play Stairwell:** Crossing the eastern-tower stairwell threshold in darkness now stops Laura safely and repeats the existing warning; replacing the bulb retains the original traversal.
- **P3-05 Flexible Act 1:** The press pass now exposes the dirty taxi and claim ticket; docks, baseball, and Ziggy remain optional, independently completable paths.
- **P3-06 Stable Museum Conversations:** The selected wandering NPC holds position for dialogue and resumes its prior route afterward; O'Reilly stays available past 10:15 in Acts 3 and 4.
- **Tooling Automation:** `tools/compile.py` compiles single scripts (including extension-agnostic target lookup in SysListView32); `tools/compile_all.exe` executes multi-pass builds.
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-009 through D-021), `docs/manual/`, and `docs/manual/manual.html` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game traversal of the P2-04 historical dialogue, P2-05 first-contact branches, both P2-06 Steve relationship branches, the P2-07 dagger hand-off, P3-01 entry with deliberately missing supplies, P3-02 bottle depletion/refill transitions, both P3-04 stairwell paths, P3-05's early dirty-taxi/claim-ticket route, and P3-06 moving-NPC conversations plus O'Reilly's post-10:15 Act 3–4 availability; the automated DOSBox-X check is a startup smoke, not an input-driven playthrough.

**Gotchas for the next session**

- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`, `.MSG`).
- The dialogue chronology is late 1926; the design outline's “Spring 1926” wording is contradicted by multiple in-game date anchors (D-012).
- In `RotundaRgn.sc` (Script 93), `Actor` instances must not define extraneous property `name` (already covered by `sel_20`).
- Script 15's decompiled inventory instances likewise carried invalid `name` pseudo-properties; these were removed because `sel_20` already supplies their labels.
- If a mapped source is absent from SCI Companion's resource list, a temporary numbered loose resource makes it selectable; compile the real source, then retain only the compiler-emitted patch. Scripts 15, 90, 240, and 250 required this bootstrap.

## Next steps (in order)

1. Exercise P2-04 through P2-07 and P3-01 through P3-06 branches from deterministic saves in DOSBox-X using `./tools/run_dosbox.sh`.
2. Begin P4-01 (Mystery Accessibility & Wattney Little Evidence Discovery).

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

### Session 16: 2026-10-08: P3-06 NPC Wander Mechanic Stabilization

**Contributor:** Codex

**Goal:** Prevent museum NPCs from leaving during dialogue and keep O'Reilly available for later-act questioning without destroying authored schedules.

**Done:**
- Traced Script 90's shared `MuseumActor` and `TravelToRoom` controller and confirmed that actor message calls had no dismissal callback while movement scripts continued to cycle.
- Routed all 112 museum-actor message dispatches through `sel_668`, which locks only the selected actor and stops its mover before opening the message.
- Added `museumDialogueResume` and a `TravelToRoom.sel_145` guard so dismissal clears the lock and re-enters the same travel state, preserving fixed destinations and random routes.
- Gated Script 22's 10:15 O'Reilly removal outside Acts 3 and 4, leaving the authored behavior unchanged in other acts.
- Compiled Scripts 90 and 22 and synchronized the architecture, roadmap, decision log, changelog, testing matrix, handoff, and manual.

**Changed:** `LB2/src/MuseumRgn.sc`, `LB2/src/triggerAndClock.sc`, `LB2/90.SCR`, `LB2/90.HEP`, `LB2/22.SCR`, `LB2/22.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-021 (Preserve museum travel state across dialogue).

**Verified:** SCI Companion compilation of Scripts 90 and 22 with 0 errors and 0 warnings; static audit of all museum-actor message paths, pause/resume state handling, and the Act 3–4 clock guard; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based observation of a moving speaker and O'Reilly after 10:15 remains a manual regression test.

**Next session should start with:** P4-01 (Mystery Accessibility & Wattney Little Evidence Discovery).

### Session 15: 2026-10-08: P3-05 Act 1 Progression Trigger Simplification

**Contributor:** Codex

**Goal:** Remove arbitrary Act 1 prerequisites from the dirty-taxi and evening-gown route while preserving essential credentials and authored side content.

**Done:**
- Traced Script 22's `global124` bits and confirmed the press pass, docks visit, baseball trade, and Ziggy conversation are independent events rather than an ordered chain.
- Identified Script 250's `(proc0_10 16 1)` complete-low-nibble test as the actual bottleneck: it withheld the dirty taxi and its gown claim ticket until all four errands were complete.
- Changed the three coordinated taxi-state checks to persistent press-pass bit 1, retaining the dirty-taxi scene, claim ticket, Lo Fat gown exchange, and dressed Act 1 transition.
- Preserved the docks, baseball, and Ziggy paths as optional content with their original clues, character context, clock progression, and rewards.
- Compiled Script 250 and synchronized the architecture, roadmap, decision log, changelog, handoff, and manual.

**Changed:** `LB2/src/Trash.sc`, `LB2/250.SCR`, `LB2/250.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-020 (Make the press pass the Act 1 taxi milestone).

**Verified:** SCI Companion compilation of Script 250 with 0 errors and 0 warnings; static global124, taxi-state, inventory-route, and optional-content audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based traversal from press-pass acquisition through the early dirty taxi and gown remains a manual regression test.

**Next session should start with:** P3-06 (NPC Wander Mechanic Stabilization).

### Session 14: 2026-10-08: P3-04 Unfair Death Warnings

**Contributor:** Codex

**Goal:** Replace the outline's unannounced secret-passage death with a source-backed, diegetic warning while preserving the intended puzzle solution.

**Done:**
- Traced the actual hazard to Script 530's eastern-tower stairwell rather than the outline's proposed Rooms 420/450.
- Confirmed that flag 32 represents the blown-out stairwell bulb, item 23 is its replacement, and the Act 5 lantern intentionally switches off below room 730.
- Redirected the unsafe dark boundary from `sFallStairs` to `sWarnDarkStairs`, which freezes input, moves Laura back to y=165, reuses the existing dark-passage Look tuple 11/1/2, and restores control.
- Preserved the original lit traversal and retained the now-unreachable fall sequence as legacy code.
- Synchronized the architecture, roadmap, decision log, changelog, handoff, and compiled manual.

**Changed:** `LB2/src/ScrewInBulb.sc`, `LB2/530.SCR`, `LB2/530.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-019 (Reuse the stairwell's existing darkness state and warning text).

**Verified:** SCI Companion compilation of Script 530 with 0 errors and 0 warnings; static boundary, message-tuple, and solution-state audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based traversal of the dark and repaired-bulb paths remains a manual regression test.

**Next session should start with:** P3-05 (Act 1 Progression Trigger Simplification).

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
