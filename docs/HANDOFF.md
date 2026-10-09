# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-08, session 19: P4-03 (Hint Book Contradictions & Best Ending Alignment) completed and verified._

**Where things stand, in one paragraph:** Phase 1 through Phase 3 are complete; P4-01 and P4-02 are committed and pushed
through `3fc64b6`, and P4-03 is complete but uncommitted. Script 750 now tests Sierra's full 13-item evidence list for the
best outcome instead of vanilla's five-condition subset. Dagger acquisition bit 155 and carbon-paper read bit 170 preserve
credit after those items leave inventory; Room 560 records police-file inspection in non-scoring bit 183 so Look and Take
both qualify. Correct murder and theft answers and `global126` meanings remain unchanged for P4-04/P4-06. D-024 records
the decision and cites the owner-supplied OneShortEye analysis plus Sierra's official hint book. Act 2's passive-pacing
concern remains scheduled as post-bugfix milestone P5-01.

**Verified** (2026-10-08, Linux workspace)

| Suite | Result |
| --- | --- |
| P4-03 Script compilation | **Pass: 560.SCR and 750.SCR emitted by SCI Companion** |
| P4-03 checklist/state audit | **Pass: all 13 official items present; bits 155/170/183 cover surrender, consumption, and inspection; bit 183 unique to the intended paths** |
| P4-02 Script compilation | **Pass: 454.SCR/454.HEP and 750.SCR/750.HEP emitted by SCI Companion** |
| P4-02 evidence-state audit | **Pass: unique bits 179..182; items 20/21/30 map to Ankh/notepad/shoe; carbon paper item 29 is not treated as a schedule** |
| P4-01 Script compilation | **Pass: 560.SCR/560.HEP emitted by SCI Companion** |
| P4-01 evidence-path audit | **Pass: 36x38 special-volume target, full-bookcase Look/Hand/Magnifier fallback, and inspection/Take registration of clues 793 and 272** |
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
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 tools/manual.py check ...` | **Pass: 6 sections, 30 entries, 0 errors** |
| `python3 tools/manual.py build ...` | **Pass: compiled docs/manual/manual.html** |
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
- **P4-01 Watney Evidence Access:** Room 560's bookcase exposes the existing police-file inset through a broad fallback target; inspecting or taking the file registers its contents and Watney's notebook identity.
- **P4-02 Planted-Evidence Credit:** Room 454 persists footprint inspection; Script 750 recognizes the Ankh, Pippin's appointment notepad, and the footprint/Yvette-shoe comparison as evidence chains and awards one-time insight credit.
- **P4-03 Hint-Book Alignment:** Script 750's best-evidence gate requires Sierra's complete 13-item checklist and accepts durable discovery state for the surrendered dagger, consumed carbon paper, and inspected police file.
- **Tooling Automation:** `tools/compile.py` compiles single scripts (including extension-agnostic target lookup in SysListView32); `tools/compile_all.exe` executes multi-pass builds.
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-009 through D-024), `docs/manual/`, and `docs/manual/manual.html` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game confirmation of the P4-03 maximum outcome and one-at-a-time failure cases from the Act 6 save.
- Direct in-game traversal of the P4-02 footprint inspection and all three Script 750 evidence-review branches from the Act 6 save.
- Direct Room 560 observation of the enlarged book/bookcase discovery path and pre-Take notebook updates for P4-01.
- Direct in-game traversal of the P2-04 historical dialogue, P2-05 first-contact branches, both P2-06 Steve relationship branches, the P2-07 dagger hand-off, P3-01 entry with deliberately missing supplies, P3-02 bottle depletion/refill transitions, both P3-04 stairwell paths, P3-05's early dirty-taxi/claim-ticket route, and P3-06 moving-NPC conversations plus O'Reilly's post-10:15 Act 3–4 availability; the automated DOSBox-X check is a startup smoke, not an input-driven playthrough.

**Gotchas for the next session**

- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`, `.MSG`).
- The dialogue chronology is late 1926; the design outline's “Spring 1926” wording is contradicted by multiple in-game date anchors (D-012).
- In `RotundaRgn.sc` (Script 93), `Actor` instances must not define extraneous property `name` (already covered by `sel_20`).
- Script 15's decompiled inventory instances likewise carried invalid `name` pseudo-properties; these were removed because `sel_20` already supplies their labels.
- If a mapped source is absent from SCI Companion's resource list, a temporary numbered loose resource makes it selectable; compile the real source, then retain only the compiler-emitted patch. Scripts 15, 90, 240, and 250 required this bootstrap.

## Next steps (in order)

1. Exercise the P4-01 bookcase, exposed-file Look, and Take paths from a deterministic Room 560 save in DOSBox-X.
2. Exercise the P4-02 footprint inspection and evidence-review branches from deterministic Room 454 and Room 750 saves in DOSBox-X.
3. Begin P4-04 (Quiz / Dagger Possession Logic Decoupling).

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

### Session 19: 2026-10-08: P4-03 Hint Book Contradictions & Best Ending Alignment

**Contributor:** Codex

**Goal:** Make the best-ending evidence gate match Sierra's published investigation requirements instead of vanilla's accidental subset.

**Done:**
- Audited the owner-supplied OneShortEye issue analysis, Sierra's official hint book, and all Script 750 outcome branches.
- Confirmed that vanilla's “all evidence” check included only dagger, grapes, wire cutters, bifocals, and red hair, while the hint book names 13 objects.
- Added a shared Script 750 predicate for all 13 objects and used it consistently in both local result and `global126` outcome selection.
- Preserved evidence credit after dagger surrender and carbon-paper consumption through existing bits 155 and 170.
- Added non-scoring Room 560 discovery bit 183 so inspecting or taking Watney's police file satisfies the published requirement.
- Compiled Scripts 560 and 750, recorded D-024, added the research-source index, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm560.sc`, `LB2/src/rm750.sc`, `LB2/560.SCR`, `LB2/750.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/reference/README.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-024 (Use Sierra's complete evidence checklist for the best ending).

**Verified:** SCI Companion compilation of Scripts 560 and 750; static 13-item checklist and durable-state audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the full positive and negative ending matrix remains a manual regression test.

**Next session should start with:** P4-04 (Quiz / Dagger Possession Logic Decoupling).

### Session 18: 2026-10-08: P4-02 Evidence Validity, Red Herrings & Inquest Credit

**Contributor:** Codex

**Goal:** Make the inquest recognize planted physical evidence and reward careful investigation using the game's canonical resources.

**Done:**
- Traced the complete questionnaire and final evaluation to Script 750, correcting the outline's proposed Scripts 700/720.
- Identified Pippin's notepad (item 21/clue 790) as the appointment schedule; confirmed that carbon paper item 29/clue 798 instead contains an unrelated fencing message.
- Made opening Room 454's authored bloody high-heel footprint inset persist discovery through unused point bit 179.
- Added a post-question Script 750 review that independently recognizes the Ankh, Pippin's appointment notepad, and the footprint paired with Yvette's shoe, explains their evidentiary limits, and awards one-time point bits 180..182.
- Preserved questionnaire correctness and ending-tier logic for P4-03 through P4-06, then compiled both scripts and synchronized the roadmap, architecture, decision log, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm454.sc`, `LB2/src/rm750.sc`, `LB2/454.SCR`, `LB2/454.HEP`, `LB2/750.SCR`, `LB2/750.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-023 (Reconcile canonical planted evidence in Script 750).

**Verified:** SCI Companion compilation of Scripts 454 and 750; static evidence-identity, ownership, and unique point-bit audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the footprint and evidence-review branches remains a manual regression test.

**Next session should start with:** P4-03 (Hint Book Contradictions & Best Ending Alignment).

### Session 17: 2026-10-08: P4-01 Watney Little Evidence Discovery

**Contributor:** Codex

**Goal:** Make Watney Little's narratively essential police file and notebook evidence discoverable without a pixel hunt.

**Done:**
- Audited the roadmap premise and traced the real file path to the special book and insets in Room 560; Room 420 and Script 13 are unrelated.
- Confirmed that inventory item 24's original Take path already adds file-content clue 793 and Watney People clue 272.
- Expanded the special volume hotspot from 11x15 to 36x38 pixels and routed Look, Hand, or Magnifier on the full bookcase to the same inset until the file is acquired.
- Added idempotent clue 793 and 272 registration when the exposed file is inspected, while retaining the original Take, point, and inventory behavior.
- Compiled Script 560 and synchronized the architecture, roadmap, decision log, changelog, testing matrix, handoff, and manual.

**Changed:** `LB2/src/rm560.sc`, `LB2/560.SCR`, `LB2/560.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-022 (Expose Watney's existing police-file path).

**Verified:** SCI Companion compilation of Script 560; static ownership, hotspot, clue-ID, inventory, and score-path audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct Room 560 observation remains a manual save-based regression test.

**Next session should start with:** P4-02 (Evidence Validity, Red Herrings & Inquest Credit).

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
