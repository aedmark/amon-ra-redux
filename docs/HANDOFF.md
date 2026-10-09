# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-09, session 23: pre–Phase 5 full-game playtest checklist established._

**Where things stand, in one paragraph:** Phase 1 through Phase 3 and P4-01 through P4-05 are committed and pushed
through `4c79bcf`; P4-06 is complete but uncommitted. Script 750 now announces questions 1–11 as required case findings
and runs optional art-theft and High Priest questions 12–16 in a separately announced `sBonusQuestions` state machine.
The audit confirms that only questions 1–9 can change murder correctness and only questions 10–11 can change theft-answer
correctness; the bonus state cannot alter either verdict flag. D-027 records the boundary. All planned bug-fix phases are
complete. The maintainer is now running the game to completion in DOSBox-X; `docs/PLAYTEST_CHECKLIST.md` is the Phase 5
entry gate and currently tracks observations PLAY-001 through PLAY-008 from the run through the start of Act 2.

**Verified** (2026-10-09, Linux workspace)

| Suite | Result |
| --- | --- |
| P4-06 Script compilation | **Pass: 750.SCR/750.HEP emitted by SCI Companion** |
| P4-06 verdict isolation audit | **Pass: Q1–9 own murder writes, Q10–11 own theft writes, Q12–16 bonus state owns neither** |
| P4-05 Script compilation | **Pass: 26.SCR/26.HEP emitted by SCI Companion** |
| P4-05 score audit | **Pass: attainable cumulative maxima 5/13/38/48/51; final raw maximum 54; Act 0 excluded from grade-band counters** |
| P4-04 Script compilation | **Pass: 750.SCR emitted by SCI Companion** |
| P4-04 outcome audit | **Pass: four murder/recovery combinations map to states 1/2/3/4; item 11 or acquisition bit 155 supplies recovery** |
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
- **P4-05 Accurate Act Grades:** Script 26 uses attainable cumulative point maxima and leaves the introduction ungraded, preserving the first authored response in every grade band.
- **P4-06 Clear Inquest Scope:** Script 750 labels questions 1–11 as required findings and questions 12–16 as bonus museum inquiries, with optional answers structurally isolated from verdict state.
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-009 through D-028), `docs/manual/`, `docs/manual/manual.html`, and the full-game playtest checklist synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game traversal of both P4-06 section notices and confirmation that varied bonus answers leave the final result unchanged.
- Direct in-game P4-05 verification at every act maximum and percentage-band boundary.
- Direct in-game traversal of P4-04's four murder/recovery outcomes, including the surrendered-dagger path.
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

1. Continue the clean DOSBox-X run through the checklist, marking checkpoints and adding stable `PLAY-nnn` findings with deterministic saves.
2. After the ending, audit and consolidate PLAY-001 through the final finding into permanent roadmap work; resolve or schedule regressions before Phase 5.
3. Begin P5-01's Act 2 schedule, room, clue, score, and message-resource design inventory only after the playtest gate closes.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

### Session 24: 2026-10-09: Compile-All Recovery and Hybrid Version Diagnosis

**Contributor:** Claude and maintainer

**Goal:** Diagnose hundreds of Compile All errors (undeclared `msgGET`/`palSET_INTENSITY`/`fi*`/`snd*` constants, script numbers above 999) and confirm no patch work was lost.

**Done:**
- Traced the errors to SCI Companion's map-format setting: format 1.0 drops the `SCI_1_1` defines and caps script numbers at 999. Identified the floppy as a hybrid (SCI1.1 scripts, SCI1-style 6-byte `RESOURCE.MAP`).
- Found that a resource rebuild under format 1.1 had replaced the base archive with a volume containing only loose-file resources (451 entries against 1,075), losing `0.FON` and all views, pics, and sounds. The maintainer restored the original archive and `MESSAGE.MAP`.
- Got Compile All to finish by editing 13 decompiled sources (commit `7d48893`), then found its output does not boot: the game stalls on a black screen. Tested copies: the `4c79bcf` patch set boots; the Compile All set does not, with or without the nine newly loose scripts or recompiled 450/720/973/998.
- Reverted all patches to the `4c79bcf` set and removed the nine new overrides (310, 640, 770, 928, 999, 1888, 1895, 1904, 1906). Reverted the 13 compile-fix sources; only `rm750.sc` (P4-06) differs from `4c79bcf`. Kept the Compile All build of `750.SCR`/`750.HEP`; a copy with that pair and the `4c79bcf` patches boots.
- Added `tools/uppercase_patches.py`, `.gitattributes` (LF for `.sc`, binary for patches), and D-028.

**Changed:** `LB2/*.SCR`/`*.HEP` (reverted to `4c79bcf` except 750), `LB2/src/rm750.sc`, `tools/uppercase_patches.py`, `.gitattributes`, `docs/DECISIONS.md`, `docs/ARCHITECTURE.md`, `docs/TESTING.md`, `docs/HANDOFF.md`.

**Decisions:** D-028.

**Verified:** The patch set committed here boots in DOSBox-X (maintainer). A fresh single-script compile of `rm750` under Wine (`tools/compile.py`) reproduces the committed `750.SCR`/`750.HEP` byte for byte. Not verified: P4-06 in the inquest itself.

**Gotchas:** `tools/compile.py` deletes the existing `N.SCR`/`N.HEP` before compiling and does not restore them if the helper fails, so back them up first. SCI Companion (started with `wine SCICompanion/Release/SCICompanion.exe 'Z:\...\LB2\game.ini'`) drops a script from its list when its patch files vanish and does not re-add it; restart it after restoring files. Stop it with `wineserver -k` when finished.

**Next session should start with:** Play to the inquest to verify P4-06 (Script 750). Use `python3 tools/compile.py <script>` for any further change and boot the game before committing. Never use Compile All.

### Session 23: 2026-10-09: Pre–Phase 5 Full-Game Playtest Checklist

**Contributor:** Codex and maintainer

**Goal:** Capture a clean end-to-end DOSBox-X run and triage all observed bugs, quirks, continuity problems, and content opportunities before beginning Phase 5.

**Done:**
- Added an act-by-act checklist covering saves, state restoration, score, inventory, music, notebook acquisition, topic completion, proximity dialogue, all shipped fixes, inquest outcomes, and the ending.
- Recorded the maintainer's first eight observations as stable PLAY-001 through PLAY-008 findings without prematurely choosing implementations.
- Preserved the guiding constraint that new diegetic introductions and interjections must expose or explain existing content rather than isolate it behind new prerequisites.
- Made completion and triage of the full-game run an explicit Phase 5 entry gate and linked the checklist from the documentation and testing indexes.

**Changed:** `docs/PLAYTEST_CHECKLIST.md`, `docs/README.md`, `docs/ROADMAP.md`, `docs/TESTING.md`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** No architectural decision; findings remain observations until post-playthrough source and resource audits.

**Verified:** Documentation validation. Gameplay findings remain intentionally open pending reproduction and triage from the maintainer's DOSBox-X saves.

**Next session should start with:** Continue the full-game run and append new `PLAY-nnn` findings; do not begin P5-01 implementation until the gate closes.

### Session 22: 2026-10-09: P4-06 Non-Essential Quiz Questions Delineation

**Contributor:** Codex

**Goal:** Make the inquest distinguish required case findings from optional museum lore and guarantee that bonus answers cannot reduce the ending result.

**Done:**
- Audited all sixteen Script 750 questions and corrected the outline's provisional Script 700/720 ownership.
- Confirmed questions 1–9 alone control murder correctness, questions 10–11 alone control theft-answer correctness, and questions 12–16 already supply feedback without score or verdict writes.
- Added a required-case notice before question 1 explaining that questions 1–11 determine the coroner's conclusions.
- Moved the unchanged art-theft, High Priest, and museum-accomplice flow into `sBonusQuestions`, preceded by an explicit notice that questions 12–16 are optional and do not affect Laura's final case result.
- Preserved all authored answer menus, feedback messages, and conditional skips while structurally excluding both verdict flags from the bonus state.
- Compiled Script 750, recorded D-027, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm750.sc`, `LB2/750.SCR`, `LB2/750.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-027 (Isolate bonus museum questions from inquest verdict state).

**Verified:** SCI Companion compilation of Script 750; static all-question, verdict-write, score-write, and transition audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of both section notices and bonus-answer variants remains a manual regression test.

**Next session should start with:** P5-01 Act 2 interactive-content design inventory.

### Session 21: 2026-10-09: P4-05 Grading and Scoring System Standardization

**Contributor:** Codex

**Goal:** Grade Laura against points actually attainable at each act break and stop the introduction from consuming an F response.

**Done:**
- Traced all grading math and message-band selection to Script 26, correcting the outline's provisional Scripts 0/780 ownership.
- Cross-checked every score flag against the point audit linked by the owner-supplied OneShortEye video.
- Established vanilla cumulative maxima `5/12/37/47/50` and Redux maxima `5/13/38/48/51` after P4-02's Act 2 footprint point.
- Replaced Script 26's inflated `5/12/43/58/61` divisors with the attainable Redux values while preserving the authored percentage bands.
- Skipped grade-band selection at `global123 == 0`, preventing the ungraded introduction from advancing the first F-message counter.
- Kept P4-02's three coroner-review awards post-grade and documented the complete raw maximum of 54.
- Compiled Script 26, recorded D-026, indexed the published point audit, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/actBreak.sc`, `LB2/26.SCR`, `LB2/26.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/reference/README.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-026 (Grade against attainable cumulative points).

**Verified:** SCI Companion compilation of Script 26; static point-event, divisor, grade-band, and startup-counter audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of all act and band boundaries remains a manual regression test.

**Next session should start with:** P4-06 (Non-Essential Quiz Questions Delineation).

### Session 20: 2026-10-08: P4-04 Quiz / Dagger Possession Logic Decoupling

**Contributor:** Codex

**Goal:** Stop theft-quiz answers from retroactively changing whether Laura recovered the Dagger of Amon Ra.

**Done:**
- Traced the actual ending controller to Script 750 rather than the outline's proposed Script 720.
- Confirmed that `global126` combines murder-case success with theft-answer correctness and that downstream epilogue content misuses the latter as physical dagger state.
- Added a shared recovery predicate accepting inventory item 11 or durable acquisition bit 155, covering both retained and surrendered custody.
- Preserved the original quiz result through the coroner's feedback, then normalized the four-way outcome at the epilogue boundary from murder success plus physical recovery.
- Routed the newspaper art, intermediate ending scenes, and all 19 Script 785 character cards through the normalized state without changing message resources.
- Compiled Script 750, recorded D-025, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm750.sc`, `LB2/750.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-025 (Normalize physical dagger state at the epilogue boundary).

**Verified:** SCI Companion compilation of Script 750; static four-state outcome, recovery-bit, and downstream route audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the four outcome combinations remains a manual regression test.

**Next session should start with:** P4-05 (Grading and Scoring System Standardization).

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
