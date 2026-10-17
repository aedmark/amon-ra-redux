# Full-game playtest checklist

Use this checklist for the clean DOSBox-X playthrough that gates Phase 5. It combines broad exploratory coverage with
the regression paths already defined in [TESTING.md](TESTING.md). Do not fix findings while the playthrough is in
progress unless they block completion; preserve the run, record a reproducible save, and triage related observations
together afterward.

## Marking and reporting

- `[ ]` not tested · `[x]` passed · `[!]` issue observed · `[~]` partly tested or uncertain.
- Run the checked-in loose patches with DOSBox-X, not ScummVM.
- Keep a rotating save before each act transition and a separate save immediately before every reproducible issue.
- For each issue, record the act, room, game time, score, save slot, exact inputs, expected result, actual result, and
  whether restoring the save reproduces it.
- Capture wording exactly when dialogue, notebook text, or interaction feedback is involved.
- Note whether an issue is a regression, a vanilla quirk, missing feedback, inaccessible existing content, or a new
  content opportunity. That classification happens during triage, not during play.

## Whole-game invariants

- [ ] Save and restore work from ordinary rooms, inset views, conversations, danger sequences, and the inquest.
- [ ] Consecutive new saves each receive their own slot (`LB2SG.000`, `.001`, …) and all restore; none overwrites another
  unless Replace is chosen (Script 990).
- [ ] Restoring a save preserves act, room, clock, score, inventory, notebook entries, NPC schedules, and music state.
- [ ] Every visible person and meaningful prop gives a specific or contextually appropriate response to Look, Talk,
  Hand, and relevant inventory items; repeated generic responses are noted.
- [ ] Music starts where expected, survives room transitions appropriately, and does not disappear after save/restore.
- [ ] Laura never uses a person's name before learning it through dialogue, observation, or an authored record.
- [ ] The notebook adds People and Things entries only when Laura has a diegetic reason to know them.
- [ ] Asked topics visibly become complete; a topic becomes available again when later events add new dialogue.
- [ ] Nearby characters react when a question naturally concerns them; missing interjections are recorded for the
  Act 2-and-later proximity-dialogue sweep rather than filled with speculative dialogue during the run.
- [ ] Inventory ownership matches the story after giving, consuming, emptying, refilling, or surrendering an item.
- [ ] Score changes occur once, survive restore, and agree with the act-break grade.
- [ ] Optional actions can be skipped without blocking required progression or concealing essential case information.

## Prologue and Act 1

- [ ] About screen opens without a false memory warning.
- [ ] The title screen's restore option reads “Resume Case” and opens the restore dialog.
- [ ] Save/load remains available throughout the introduction and Act 1.
- [ ] Speaking with Steve records the personal relationship path; skipping him retains the professional path later.
- [ ] Showing the press pass once permanently establishes Laura's identity with the cabbie.
- [ ] The dirty cab becomes available after a prior normal cab ride once the press pass is acquired, without requiring the docks, baseball, or Ziggy errands.
- [ ] After Laura obtains the claim ticket, normal taxi travel never requires entering the dirty cab again.
- [ ] Lo Fat accepts the claim ticket, supplies the gown, and the dressed taxi trip advances to Act 2.
- [ ] The docks, baseball trade, and Ziggy conversation remain available and independently completable.
- [ ] Music plays in the speakeasy, its bathroom, and the street outside Lo Fat's laundry, including after restore.
- [ ] Each of the two men at the speakeasy bar has distinct interaction feedback.
- [ ] Act 1 ends with the expected score, inventory, notebook state, and first real act grade.

## Act 2: museum party

- [ ] Record the People and Things lists immediately on arrival; check-in alone must not grant an omniscient cast list.
- [ ] Heimlich's entrance description points out the leather-bound benefit register.
- [ ] Reading the register with Look, Hand, or Magnifier records Steve, Heimlich, Yvette, Rameses, Countess, Olympia, and Tut, with no duplicate entries on repeat inspection.
- [ ] Laura routes around the podium from both sides; Look, Hand, and Magnifier stop her in front of it at about
  `(186, 180)`.
- [ ] Hand signs once (flag 124); repeat Hand reports the existing signature; Look reflects it.
- [ ] Without moving, repeat LOOK/LOOK, DO/LOOK, LOOK/DO, DO/DO, and a Magnifier repeat: only the register response
  appears, with no generic flash, palette change, freeze, or Error 5 (D-035, D-036).
- [ ] Ziggy, Ernie, and Watney Little are absent from the register; Ernie enters after his personal introduction and Watney only after evidence or explicit identification.
- [ ] Determine whether Yvette's absence from the initial People list is intentional; compare her acquisition path with
  every other museum character and record any other missing or premature entries.
- [ ] The guest register and first encounters provide fallback introductions without replacing authored content or exposing Carrington's true identity.
- [ ] Pippin, Dr. Smith, Countess, Yvette, O'Riley, and Rameses introduce themselves naturally if Laura missed the
  rotunda introductions; no one is addressed by name prematurely.
- [ ] Steve's museum greeting matches whether Laura spoke with him in Act 1.
- [ ] Ask Archibald Carrington about Pippin Carter while Pippin is nearby and record the missing/present snide reply.
- [ ] For every nearby pair, ask about the other person and record where an interjection would clarify relationships,
  motives, or recognition without hiding existing dialogue behind the new exchange.
- [ ] Complete each available notebook topic once and confirm its completion mark/state.
- [ ] Advance the clock or discover new evidence, then confirm only topics with genuinely new material reopen.
- [ ] NPCs remain present for the full conversation and resume their previous route afterward.
- [ ] Essential conversations and eavesdropping scenes remain discoverable in authored order without a hidden counter.
- [ ] The Pippin discovery/report sequence reaches Act 3 without requiring unrelated optional conversations.
- [ ] Act 2 ends with the expected score, inventory, notebook state, and 100% grade when all available points are earned.

## Act 3

- [ ] The skeleton-key glint is comfortably discoverable with Look and Magnifier as well as the intended action.
- [ ] Countess remains available in the Armor Room through the intended meeting window.
- [ ] The pocket-watch confrontation can be completed without the old 1:45 lockout.
- [ ] Murder reactions become available only after Laura learns of the corresponding death.
- [ ] Moving NPC conversations remain stable, and O'Riley stays available after 10:15.
- [ ] Notebook topic completion and reopening continue to track newly available dialogue.
- [ ] Act 3 ends with the expected score, inventory, notebook state, and 100% grade on a complete run.

## Act 4

- [ ] The dark eastern stairwell stops Laura safely, repeats its warning, and becomes traversable after bulb replacement.
- [ ] Watney's Room 560 police file is discoverable through the bookcase and enlarged special-volume target.
- [ ] Looking at the exposed police file records both its contents and Watney's People entry before Take.
- [ ] Inspecting Pippin's bloody high-heel footprint records it for the later evidence review.
- [ ] Restored homicide reactions, including O'Riley's Countess response, remain reachable.
- [ ] Nearby-character interjections and notebook topic state remain coherent as deaths change available questions.
- [ ] Act 4 ends with the expected score, inventory, notebook state, and 100% grade on a complete run.

## Act 5

- [ ] Entry repairs genuinely missing wire cutters, snake oil, and cheese exactly once without duplicating held items.
- [ ] The snake-oil bottle shows its empty state, the laboratory jar refills it in one action, and the jar supplies only
  three successful refills while rejecting full-bottle and depleted-jar attempts.
- [ ] Intended consumption does not cause the Act 5 safety audit to recreate an item later.
- [ ] Save/load remains usable throughout chase, danger, corpse, and inset sequences.
- [ ] The recovered dagger receives specific reactions and transfers out of inventory when surrendered to O'Riley.
- [ ] Act 5 ends with the expected score, inventory, notebook state, and 100% grade on a complete run.

## Act 6, inquest, and ending

- [ ] The inquest first labels questions 1–11 as required case findings.
- [ ] The inquest labels questions 12–16 as bonus museum inquiries before question 12.
- [ ] Varying bonus answers changes only their authored feedback, not the coroner result or ending route.
- [ ] The Ankh, appointment notepad, and footprint/shoe chains receive separate, one-time evidence acknowledgements.
- [ ] The maximum result requires the complete 13-item Sierra evidence list documented in [TESTING.md](TESTING.md).
- [ ] Surrendered dagger, consumed carbon paper, and inspected-but-not-taken police file retain evidence credit.
- [ ] Murder answers and physical dagger recovery produce the correct four newspaper/ending combinations.
- [ ] Every Script 785 character card agrees with whether Laura solved the murders and physically recovered the dagger.
- [ ] Final score and ranks/messages are internally consistent; no optional museum-trivia answer reduces the result.
- [ ] Credits and return-to-game/exit behavior complete without a hang or corrupted display.

## Open findings: leads

Read-only analysis for the findings still open. Ground rules (D-028, D-029): group fixes by owning script, compile one
script at a time with `tools/compile.py`, boot-test before every commit, and bisect with `tools/make_test_copy.sh`.
Scripts still loaded from the archive (D-040's list) are first-time compiles and carry boot risk.

| Finding | Owning script(s) | Lead | Proposed approach |
| --- | --- | --- | --- |
| PLAY-006 | 1882 to 1892 `.MSG`, museum conversation handlers | Interjections need new message records and a hook that fires when the asked-about character is in range. | Phase 5 content sweep; prototype Pippin/Carrington first. |
| PLAY-009 | 1, 3, 5 | The copy-protection screen after the intro, on first talking to Crodfoller, should be removed entirely rather than merely neutralized. | Analyzed; fix planned (see the leads above). |

## Findings register

These are observations from the current run, not yet implementation decisions. Preserve existing content and prefer
diegetic discovery or additive reactions over moving old dialogue behind a new prerequisite.

| ID | Act | Observation / desired behavior | Triage status |
| --- | --- | --- | --- |
| PLAY-001 | 1 | The dirty cab should only appear after a first normal cab ride, and never reappear once the claim ticket is taken. | Resolved (D-030): gated on `(and (proc0_10 1) (proc0_2 125) (not (proc0_2 27)))`; clean ride sets flag 125 in `Trash.sc`. |
| PLAY-002 | 1 | After Laura shows the press pass once, the cabbie should remember her. | Fixed, retest pending: flag 125 (set when a clean-cab ride starts, which needs the pass) already means Rocco has seen it. On later rides he says "Welcome back, Miss Bow!" (`250.MSG (1, 0, 11, 1)`) and goes straight to asking her destination (Script 250 `sHasPressPass`). Bob, the dirty cab's driver, is unchanged. |
| PLAY-003 | 1 | Music is absent in the speakeasy, its bathroom, and outside Lo Fat's laundry. The CD speakeasy rotates two songs, including a live recording of “I Want to Marry an Archaeologist”; determine the intended floppy equivalent. | Resolved: the speakeasy's `WrapMusic` rotation is restored and survives the bathroom (maintainer-verified). Room 270 has no exit motif on the floppy (only the baseball trade's sounds); kept as Sierra shipped it (2026-10-16). |
| PLAY-004 | 1 | The two men at the speakeasy bar need distinct interaction messages. | Fixed, retest pending: they already had distinct Look and Hand replies; Talk, Ask, and the Magnifying Glass fell to the shared generic reply. Six new `310.MSG` lines (nouns 3 and 10, verbs 2, 6, 8); `Feature doVerb` plays them with no script change. |
| PLAY-005 | 2 | Yvette is absent from the notebook People list; establish whether this is intentional and audit every other lost entry. | Audited: introduced in Act 1 at Lo Fat's Laundry (rm270) or Act 2 at museum (D-030). |
| PLAY-006 | 2+ | Nearby characters should sometimes interject when asked about one another, beginning with Pippin's snide response when Laura asks Carrington about him. | Content sweep candidate; additive dialogue must not isolate existing content. |
| PLAY-007 | 2 | Ernie, Tut, Olympia, and Watney Little appear in the notebook before Laura meets them or learns their names. | Audited: Rameses, Countess, Olympia, Yvette, Tut have Act 1 diegetic routes; Ernie and Watney remain for Act 2 diegetic checks (D-030). |
| PLAY-008 | All | Discussed notebook topics should show completion and reopen only when new dialogue becomes available. | Fixed, retest pending (D-049): topics the character being asked has answered draw in grey, for the museum cast and eight Act 1 characters; a murdered person's topic reopens once the death is known, O'Flaherty's O'Riley topic after Laura reads O'Riley's folder, and everything at each act break. |
| PLAY-009 | 1, 3, 5 | The copy-protection screen after the intro, on first talking to Crodfoller, should be removed entirely rather than merely neutralized. | Analyzed; fix drafted, blocked on the compile environment. See the gameplan row. |
| PLAY-010 | 1 | The upbeat “perky demeanor” act-grade text is presented against a skull-and-crossbones frame. | Superseded by PLAY-024: the bones were the narrator window's corners, not picture 780. |
| PLAY-011 | 1 | Asking Ziggy about Yvette or the Countess makes him claim he has never heard of either, contradicting his later dialogue and relationships. | Resolved: Ziggy now gives discreet, plot-safe acknowledgements for both women. |
| PLAY-012 | 1 | Looking at the banner at the Leyendecker entrance should remark that the party needs formal attire, and only in Act 1. | Fixed, retest pending: the banner's Look plays new `335.msg (1, 1, 2)` in Act 1; Act 2 keeps the original line. |
| PLAY-013 | 2 | Asking Rameses about Ziggy at the party talks about the party as if it were over. | Fixed, retest pending: Act 2 plays new `1891.msg (1, 6, 109)` through RotundaRgn's party-line rule (D-042); later acts keep the original. |
| PLAY-014 | 2 | Ziggy claims not to know Heimlich, who checked his invitation at the door, or Tut Smith, who stands across from him at the party. | Fixed, retest pending: `1890.msg (1, 6, 10)` and `(1, 6, 16)` rewritten so he knows both. Module 1890 is used only from Act 2 on. |
| PLAY-015 | 2 | Asking Yvette about Pippin in Act 2 treats him as already dead. | Fixed, retest pending: her Pippin line `1885.msg (1, 6, 3)` is present tense again (it plays only before Laura learns of his death). Her Tut conversation `(1, 6, 16)` asks whether Tut killed Dr. Carter; Act 2 now plays new `(1, 6, 116)`, which stops before the murder questions (D-042). |
| PLAY-016 | 2 | After the 7:30 Steve cutscene in the front rotunda, Steve walks through two guests at the table. | Fixed, retest pending: room 350's table outline now covers the guests throughout Act 2 (Script 2350), and `sMeetSteve` stages the meeting beside the group on Laura's side instead of among the guests. |
| PLAY-017 | 2 | Leaving the front rotunda north into the Mastodon Room, Laura walks so far into the doorway that her head draws over the lintel. | Fixed, retest pending: `sExitNorth` takes one step to the doorway's centre instead of walking 15 pixels in (the opening tops out at y 57). |
| PLAY-018 | 2 | The Ankh near Pippin's body needs a bigger hotspot. | Fixed; confirmed 2026-10-16. The first fix used a misread render; the medallion keeps its bounds (`x 227-232, y 122-127`) plus a margin above and left (`x 219-231, y 112-124`), clear of the footprint, blood, Pippin, and doorway. |
| PLAY-019 | 3+ | Asking O'Riley about Pippin in Act 3 shows `<Messager> 0: 1,6,72,1 not found`. | Fixed, retest pending: MuseumRgn's `sayAndHold` (P3-06) forwarded the always-zero caller slot as the module, breaking every Act 3+ conversation with its seven actors. It now forwards the sixth argument (one instruction). |
| PLAY-020 | 2 | Ziggy has no answer about Pippin Carter in Act 2 (Act 1 is fine: his speakeasy dispatcher routes Pippin to his own line). | Fixed, retest pending: the topic maps to case 3, which did not exist, while vanilla's Pippin lines sat unreachable at cases 70 and 71. Added `1890.msg (1, 6, 103)` (alive, party) and `(1, 6, 3)` (after the death); his MuseumRgn actor plays the party version until Laura learns of the death (flag 134). |
| PLAY-021 | 2+ | Asking Ziggy about the Countess before asking her about him has Laura claim the Countess says she knows him. | Fixed, retest pending: until the Countess's Ziggy topic has been asked (`global303` or `global366`, bit 0), Ziggy plays new `1890.msg (1, 6, 214)`, only his denial, and the topic stays open so the bluff exchange plays later (D-042). |
| PLAY-022 | 2 | Pippin says he has never heard of Rameses Najeer, who stands next to him. | Fixed, retest pending: `1882.msg (1, 6, 13, 5)` now has Pippin acknowledge the museum's accountant dismissively. |
| PLAY-023 | 2 | Re-entering the front rotunda from the far side after the gift-shop dagger, Laura runs past Steve and talks to him while facing away. | Fixed, retest pending: Steve now enters from the side opposite Laura along the front of the room, and both walk with a cue so they face each other only once both have arrived. |
| PLAY-024 | Act breaks | The grade text between acts uses the death message's bone-corner window, and the act marquee stays visible behind it. | Fixed, retest pending: picture 780 is plain black, so PLAY-010's removal of it only exposed the marquee; the bones came from the narrator window's corner loop 4, the default for unlisted rooms. Restored the black fade in Script 26 and gave room 26 the Art Deco corners (loop 0) in Main's `lb2Win`. |
| PLAY-025 | 3 | Using the carbon paper on Yvette's floor lamp while it is off shows `<Messager> 550:5,39,6 not found`. | Fixed; confirmed 2026-10-16: a vanilla bug. With the lamp off (flag 40) or its bulb taken (flag 64), the floor lamp asked for `(5, 39, 6)`, which Sierra never wrote; it now uses `(45, 39, 6)`, "You can't read it this way," as the lamp close-up and the bulb already did. The carbon paper still reads against the lit bulb. Script 550 changes by one instruction. |
| PLAY-026 | 4 | Hand on the stairwell's burned-out bulb always says "Ouch!", even after leaving and returning, instead of hinting at a replacement. | Fixed; confirmed 2026-10-16: Script 530 tracks a bulb that burned out during the current visit (flag 184, cleared on entry). Hand says "Ouch!" only then; afterwards it gives a rewritten `530.msg (14, 4, 1)` pointing to a spare bulb; with the spare in hand it swaps the bulb; a lit bulb says "You've already changed the lightbulb." |
| PLAY-027 | 3+ | The skull in Olympia's office opens the hidden passage and walks Laura straight in; without the lantern the bats kill her with no chance to decline. | Fixed; confirmed 2026-10-16 (D-044): the skull opens or closes the panel and stops. Look and Magnifier on the open panel describe the darkness (`520.MSG` noun 59); Hand on it, or walking in, enters. The panel uses the doorway's bounds as its click area (its open cel is one blank pixel). Retests found two soft locks on entry: a pathfinding move to an unwalkable point, then the one-pixel open cel at (293,159) blocking the straight path; the walk now uses straight moves, and the panel and Laura ignore actors (Laura also ignores control until room 666 normalizes her). |
| PLAY-028 | All | The Countess's dialogue still leans on constant all-caps. | Fixed; confirmed 2026-10-16: 79 lines in `1884.msg` and `340.msg` rewritten so emphasis comes from phrasing, keeping five capitals (including "RAHTHER") and her Cockney slip (D-045). |
| PLAY-029 | 3+ | The Thinker's raised head has no message of its own, and Magnifier still describes the closed seam; Olympia raises the head before Laura discovers it. | Fixed; confirmed 2026-10-16: with the head up, Look and Magnifier on the head and on the neck play four new `510.msg` lines; the neck hotspot stays active in both positions. Olympia's demonstration is vanilla (her scene runs the first time Laura enters from Olympia's office) and is unchanged. |
| PLAY-030 | 3+ | The police-file volume in Carrington's office only responds near the floor. | Fixed; confirmed 2026-10-16: its click area was its rectangle intersected with control color 6 (a 4x14 strip), so D-022's enlargement never applied, and the shelf feature claimed clicks first. The book now uses its whole rectangle (`x 214-241, y 76-104`) and is checked before the bookcase. |
| PLAY-031 | 3+ | Intercom buttons respond only a few pixels to the right of the buttons. | Fixed; confirmed 2026-10-16: P1-03 gave the on/off and send/receive switches click areas across the button column, and they are checked first. Each switch and button now responds around its own knob. |
| PLAY-032 | 2 | The bloody footprint beside the Ankh gives the generic Look reply unless the Magnifying Glass is used first. | Fixed; confirmed 2026-10-16: a vanilla bug; the footprint had no noun. It now uses noun 3, so Look and Hand play its existing messages, and the Magnifying Glass still opens the close-up that records it for the inquest (D-023). |
| PLAY-033 | 3+ | Hand on any vat in the preservation lab (room 610) walks Laura out of the room instead of climbing the vat. | Fixed; confirmed 2026-10-16: a decompiler error in every alpha used the next vat's `init:` result, the climb side, or `handsOff`'s result as the vat-number index (D-041), so every approach point was garbage. The vat setup and both climb scripts are rewritten in Sierra's order and match the archive build apart from codegen and P1-02. |
| PLAY-034 | 3+ | Entering the back storeroom (room 630, Carrington's skeleton crate) crashes to DOS with `Build Line Error  View: -1  Loop: -1  Cel: -1`. | Fixed; confirmed 2026-10-16 (D-016): the shelf's snake oil bottle comes from P3-02's `61.V56`, whose tool encoded literal runs across row ends; the interpreter decodes one scanline at a time. The tool now encodes row by row; the rebuilt patch has identical pixels, headers, and palette. `335.V56` was already row-bounded. Any earlier alpha could crash wherever the bottle is drawn. |
| PLAY-035 | 3+ | After O'Riley takes the dagger, the notebook still offers it as a topic, and asking him plays his reaction as if Laura still had it. | Fixed; confirmed 2026-10-16 (D-015): both O'Riley handlers (Scripts 90 and 93) now also drop clue 780, as Sierra drops the baseball's topic when Biff takes it. |
| PLAY-036 | 3 | O'Riley, Watney, Olympia, and Yvette stand in one place in Act 3. | Changed; confirmed 2026-10-16 (D-046): Watney (`aWatney`, posing as Carrington) and, from 11:15, Olympia follow Sierra's authored patrols; O'Riley patrols 430, 450, and 454 with 20 to 45 second pauses and resumes after rooms 490 and 500 borrow him; from eavesdropping count 7 Yvette strolls room 510 until count 10, 12:45, or the end of Act 3. Needs a run from Act 2. |
| PLAY-037 | 3+ | Talking to Dr. Smith (Tut) for the first time in Act 3, Laura admires the ankh he no longer wears and she now carries; showing him the ankh or the Dagger gets only a generic reply. | Fixed, retest pending: new Act 3+ introduction (`1883.MSG` case 82, Script 90); ankh reaction (verb 31: he claims it, Laura keeps it as evidence) and Dagger reaction (verb 22: he claims it for Egypt). Audit of every ankh (case 47) and Dagger (case 38) answer: Yvette's now says he *wore* one (`1885.MSG`); Carrington gains a Dagger reaction (`1886.MSG`). Manifests `act3-tut-ankh-dagger-2026-10.json`, `act3-yvette-ankh-2026-10.json`, `act3-carrington-dagger-2026-10.json`. |

## New finding template

Copy one row into the register, assign the next `PLAY-nnn` ID, and retain the ID through audit, roadmap promotion, fix,
and regression testing.

| ID | Act | Observation / desired behavior | Triage status |
| --- | --- | --- | --- |
| PLAY-nnn |  |  | Observed; save `__`, room `__`, time `__`, score `__`. |
