# Roadmap

Item IDs are permanent: `P<phase>-<nn>`. Never renumber; append new items at the end of their phase.
`[ ]` open · `[~]` in progress (who holds it, since when, and what is left) · `[x]` done · `[-]` dropped (say why,
and the decision). An item held `[~]` by someone else is theirs until they or a maintainer release it.

A finished item says what was done, the decision if any, the evidence (the test, or the measurement), and the date.
A new item says where it came from (a test run, a real user, a maintainer) and the date. Keep an item's history in it:
"tried X, measured Y, then did Z" is how the next session avoids trying X again. Bugs are items too, filed under
the phase they belong to.

## Phase 1: Critical Stability and UI/UX Overhaul

Goal: Eliminate game-breaking bugs, crash/memory errors, pixel-hunt bottlenecks, and the 5-click interrogation UX penalty.

- [x] P1-01 UI Efficiency & Interrogation Streamlining: Implemented direct tab pre-selection (opening directly to the People tab/last active tab in inNotebook sel_110) and double-click to confirm inquiry in NotebookItem sel_300 (D-003, from PDF outline, 2026-10-07). Verified by compilation of Script 20 (LB2/20.SCR, LB2/20.HEP).
- [x] P1-02 Unrestricted Save/Load Functionality: Re-enabled save/load across all screens by protecting Icon 7 in IconBar disable: (Script 937), handsOn (Script 0), LBRoom setInset: (Script 17), and removing icon lockouts across chase/corpse rooms (Scripts 525, 560, 565, 610) (D-004, from PDF outline, 2026-10-07). Verified by compilation of 0.SCR, 17.SCR, 525.SCR, 560.SCR, 565.SCR, 610.SCR, 937.SCR.
- [x] P1-03 Invisible Hotspot & Pixel Hunt Elimination: Expanded hitboxes for skeleton key glint in rm500 (Script 500), intercom buttons in Button (Script 562), poetry book in MyFeature (Script 650), dagger in rm400 (Script 400), and Ernie's corpse hairs in rm420 (Script 420); enabled Look and Magnifier verbs (from PDF outline, 2026-10-07). Verified by compilation of 400.SCR, 420.SCR, 500.SCR, 562.SCR, 650.SCR.
- [x] P1-04 Memory Check Error Repair on Act 2 About Screen: Repaired code governing "About" screen dialogue in Main.sc (Script 0) sel_613 by eliminating false (== gAct 2) memory warning lockout (from PDF outline, 2026-10-07). Verified by compilation of 0.SCR and 0.HEP.
- [x] P1-05 Graphical and Animation Glitch Corrections: Corrected Countess door clipping in rm440 (Script 441) and Olympia eastDoor entry in rm600 (Script 600); fixed Laura and pursuer scaling in chase rooms (Scripts 500, 510) and rotunda headdress rooms (Scripts 350, 355, 360, 370); and resolved Steve cutscene collision in rm350 (Script 350) (from PDF outline, 2026-10-07). Verified by compilation of 350.SCR, 355.SCR, 360.SCR, 370.SCR, 441.SCR, 500.SCR, 510.SCR, 600.SCR.
- [x] P1-06 Visual Fidelity & Floppy Art Deco Asset Preservation: Audited and preserved DOS floppy v1.000 uncompressed 256-color hand-painted brushstroke artwork and palettes (D-001, from PDF outline, 2026-10-07). Verified by pristine MD5 checksum matches for LB2/RESOURCE.000 and LB2/RESOURCE.MAP.

## Phase 2: Narrative Coherence and Dialogue Accessibility

Goal: Remove dialogue dead-ends, rectify historical anachronisms, fix contextual awareness bugs, and restore unused murder conversations.

- [x] P2-01 Inaccessible Plot Information & Notebook Fallback Triggers: Implemented two-tier fallback mechanism registering all Act 2 suspects (clues 263..272) upon museum check-in via guest register in rm335 (Script 335) and upon Look/Talk encounters with all rotunda characters in RotundaRgn (Script 93) (D-009, from PDF outline, 2026-10-07). Verified by compilation of LB2/335.SCR, LB2/335.HEP, LB2/93.SCR, and LB2/93.HEP.
- [ ] P2-02 Pocket Watch Confrontation Timing & Armor Room Lockout: Adjust item acquisition lockouts so the pocket watch can be retrieved and shown to the Countess during her secret Armor Room meeting with Little/Ziggy (from PDF outline). Verified when presenting watch in room 440 triggers unique confrontation dialogue.
- [ ] P2-03 Unused Dialogue & Murder Reaction Restoration: Activate text dialogue branches in MSG resources where characters react to discovered murders (O'Reilly discussing Ziggy's or Carrington's death) and death messages, omitting insensitive CD voice tracks while keeping audio sync hooks extensible for future voice recordings (D-007, from PDF outline). Verified when questioning suspects after murders triggers homicide-specific text dialogue.
- [ ] P2-04 Narrative Anachronism Corrections: Review and adjust dialogue referencing post-1926 items (Pippi Longstocking, Transatlantic Telephone Call) and clarify The Sun Also Rises to maintain Spring 1926 historical fidelity (from PDF outline). Verified by string audit across all MSG lumps.
- [ ] P2-05 Contextual Dialogue Logic & Acquaintance Checks: Correct dialogue logic where the game assumes Laura knows characters' names (e.g. Dr. Smith) or has met them before formal introduction (from PDF outline). Verified when unintroduced dialogue uses neutral polite titles.
- [ ] P2-06 Steve & Laura Character Consistency: Gate Laura's jealousy and Steve's romantic banter behind actually speaking to Steve in Act 1 (from PDF outline). Verified when ignoring Steve in Act 1 produces professional coworker banter at the museum.
- [ ] P2-07 Dagger Discovery Reactions & Inventory Hand-off: Provide meaningful suspect reactions when shown the Dagger of Amon Ra, and ensure giving the dagger to O'Reilly removes it from inventory (D-006, from PDF outline). Verified when giving dagger executes (ego put: iDagger) and removes item from UI.

## Phase 3: Gameplay, Puzzles, and Progression Logic Refinement

Goal: Eliminate "Dead Man Walking" softlocks, fix unfair sudden deaths, revamp the snake oil mechanic, and smooth pacing.

- [ ] P3-01 Dead Man Walking Prevention for Act 5 Critical Items: Guarantee critical survival items (Wire Cutters, Snake Oil Refill, Cheese) cannot be permanently lost or are available in backup locations within Act 5 (D-005, from PDF outline). Verified when entering Act 5 without items either provides accessible backups in room 510 or prevents premature lockouts.
- [ ] P3-02 Snake Oil Refill Mechanic & Inventory Feedback Overhaul: Add visible inventory icon feedback for empty vs full bottle, prevent refilling a full bottle, and make basement refill container conspicuous and independent of grapes (from PDF outline). Verified when bottle cel toggles on refill and basement oil drum is easily clickable.
- [ ] P3-03 Pacing, Act Length & Diegetic Knowledge Rebalance: Expand Act 4 narrative flow and replace Act 2's rigid 14 mandatory eavesdropping requirement with a diegetic knowledge acquisition threshold (discovering core suspect motives and alibis) supported by contextual museum activities and puzzles (D-008, from PDF outline). Verified when Act 2 advances once the required case context is diegetically established.
- [ ] P3-04 Unfair Death Warnings & Secret Passage Look Mechanic: Implement a warning and Look mechanic before Laura steps into the dark secret passage in Olympia's office, preventing unannounced instant death (from PDF outline). Verified when Laura halts at the threshold with a darkness warning if lacking a light source.
- [ ] P3-05 Act 1 Progression Trigger Simplification: Simplify the sequence of events required to acquire the dirty taxi and evening dress in Act 1, eliminating rigid ordering dependencies (from PDF outline). Verified by testing non-linear order of docks, baseball, and Ziggy conversations.
- [ ] P3-06 NPC Wander Mechanic Stabilization: Ensure NPCs halt movement during conversation to prevent mid-dialogue vanishing, and keep key characters (O'Reilly) accessible longer in Acts 3 and 4 (from PDF outline). Verified when NPC motion pauses on dialogue init and resumes on dismiss.

## Phase 4: Mystery, Grading, and Ending Logic

Goal: Reconcile coroner inquest evidence requirements, fix scoring calculation bugs, and eliminate misleading red-herring penalties.

- [ ] P4-01 Mystery Accessibility & Wattney Little Evidence Discovery: Provide clearer, non-pixel-hunt clues to the existence of Wattney Little and the contents of the police file (from PDF outline). Verified when Carrington's desk file is clearly noticeable and registers Little in the notebook.
- [ ] P4-02 Evidence Validity, Red Herrings & Inquest Credit: Integrate planted physical evidence (Ankh medallion, Evette's schedule, footprints) into the inquest so thorough players are credited for discovering framing attempts rather than penalized (D-006, from PDF outline). Verified when coroner recognizes planted clues and awards insight score.
- [ ] P4-03 Hint Book Contradictions & Best Ending Alignment: Harmonize internal code logic for the Super Sleuth ending with Sierra hint book requirements and physical evidence necessity (from PDF outline). Verified when meeting hint book criteria guarantees the maximum rank.
- [ ] P4-04 Quiz / Dagger Possession Logic Decoupling: Decouple coroner questionnaire results from physical possession of the Dagger of Amon Ra in ending epilogue headlines (D-006, from PDF outline). Verified when epilogue acknowledges recovery of the dagger regardless of quiz scores.
- [ ] P4-05 Grading and Scoring System Standardization: Standardize point divisors across all acts so scores accurately reflect percentage of possible points, and fix initial F-grade display bug at game launch (D-006, from PDF outline). Verified when launch status displays valid initial score and final percentages match tally.
- [ ] P4-06 Non-Essential Quiz Questions Delineation: Clearly delineate required homicide questions from optional museum trivia (Art Theft, High Priest) and eliminate ending rank penalties for optional trivia (from PDF outline). Verified when inquest UI distinguishes required from bonus questions.
