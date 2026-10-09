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

- [ ] Record the complete People and Things lists immediately on arrival, before talking, looking, or reading anything.
- [ ] Ernie, Tut, Olympia, and Watney Little do not appear until a specific diegetic discovery introduces each name.
- [ ] Determine whether Yvette's absence from the initial People list is intentional; compare her acquisition path with
  every other museum character and record any other missing or premature entries.
- [ ] The guest register and first encounters provide fallback introductions without replacing authored content.
- [ ] Pippin, Dr. Smith, Countess, Yvette, O'Reilly, and Rameses introduce themselves naturally if Laura missed the
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
- [ ] Moving NPC conversations remain stable, and O'Reilly stays available after 10:15.
- [ ] Notebook topic completion and reopening continue to track newly available dialogue.
- [ ] Act 3 ends with the expected score, inventory, notebook state, and 100% grade on a complete run.

## Act 4

- [ ] The dark eastern stairwell stops Laura safely, repeats its warning, and becomes traversable after bulb replacement.
- [ ] Watney's Room 560 police file is discoverable through the bookcase and enlarged special-volume target.
- [ ] Looking at the exposed police file records both its contents and Watney's People entry before Take.
- [ ] Inspecting Pippin's bloody high-heel footprint records it for the later evidence review.
- [ ] Restored homicide reactions, including O'Reilly's Countess response, remain reachable.
- [ ] Nearby-character interjections and notebook topic state remain coherent as deaths change available questions.
- [ ] Act 4 ends with the expected score, inventory, notebook state, and 100% grade on a complete run.

## Act 5

- [ ] Entry repairs genuinely missing wire cutters, snake oil, and cheese exactly once without duplicating held items.
- [ ] The snake-oil bottle shows its empty state, the laboratory jar refills it in one action, and the jar supplies only
  three successful refills while rejecting full-bottle and depleted-jar attempts.
- [ ] Intended consumption does not cause the Act 5 safety audit to recreate an item later.
- [ ] Save/load remains usable throughout chase, danger, corpse, and inset sequences.
- [ ] The recovered dagger receives specific reactions and transfers out of inventory when surrendered to O'Reilly.
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

## Triage gameplan

Prepared during the run so triage can start the moment the playthrough ends. Everything below is read-only analysis;
nothing in `LB2/` changes until the run closes and the maintainer picks items.

**Ground rules (D-028, D-029):** group fixes by owning script so each script is compiled once; compile one script at a
time with `tools/compile.py`; boot-test before every commit; use `tools/make_test_copy.sh` to bisect. A script with no
committed loose patch (today: 310, 640, 770, 928, 999, 1888, 1895, 1904, 1906) is a first-time compile and carries
boot risk; a script already in the shipped set (for example 250, 21, 20, 13, 0) is an ordinary edit.

| Finding | Owning script(s) | Patch exists? | First read-only lead | Proposed approach |
| --- | --- | --- | --- | --- |
| PLAY-001 | 250 (`rm250`, `Trash.sc`) | Yes (D-020, D-030) | Gated dirty cab on prior normal ride (flag 125) and uncollected ticket (`not (proc0_2 27)`). | Resolved in Session 26 (D-030). |
| PLAY-002 | 250 (`Trash.sc`) | Yes | Trace cabbie recognition states. | Low risk; identify existing recognition state. |
| PLAY-003 | 310 (`rm310`, speakeasy), plus the bathroom and Lo Fat street rooms (to be located) | **No** for 310 | In `rm310` the music resource is picked by `(DoSound sndGET_POLYPHONY)`: 310 when it returns 32, otherwise 314. The DOSBox-X config sets `mididevice=default` and the log reports `MIDI:Opened device:none`, so the sound driver's polyphony, not a missing call, may decide whether anything plays. | First, with no code change: check `RESOURCE.CFG`, boot with each configured sound device, and confirm whether the other rooms also depend on the driver. Only if the music call is genuinely missing, patch the three rooms. |
| PLAY-004 | 310 and its message resource | **No** | `barfly1` and `barfly2` are plain `View` instances with no dedicated verb handler, so they fall back to a shared response. | Add two distinct Look/Talk messages as a loose `.MSG` plus a minimal handler. First-time compile of 310 (source needs the `View`→`Actor` edit and other fixes from `7d48893`). Do it with PLAY-003 in a single 310 compile. |
| PLAY-005, PLAY-007, PLAY-008 | 21 (`addCluesCode`), 20 (`NotebookItem`), 14 (`lb2InitCode`), 13 (`aboutCode`), 0 (`Main`) | Yes | Clues live in packed arrays `global202`, `global220`, `global228`, `global263` and are added by clue ID through `addCluesCode`. | Source audit confirms Act 1 diegetically introduces suspects through investigation (Rube→Rameses, Police/Lo Fat→Countess, Docks→Olympia/Yvette/Heimlich; D-030). Remaining entries: map exact clue-add triggers for Watney and Tut. For PLAY-008, find topic-complete flag. |
| PLAY-006 | `.MSG` resources (1882–1892 already loose) and the museum conversation handlers | MSG yes; scripts mostly | Additive interjections need new message tuples plus a hook that fires when the asked-about character is within range. | Defer to the Phase 5 content sweep. Prototype Pippin/Carrington first to prove the hook, then roll out. |

| PLAY-009 | 18 (`rm18`, loose patch `18.SCR`), callers `rm230` (`sDoTalking` to room 18, `sCopyProBack` on return), `rm355`, `rm420` | Yes | Room 18 is a hieroglyph card-flip quiz. It runs in Acts 1, 3, and 5 (it returns to rooms 230, 355, and 420 chosen by `global123`) and ends by setting or clearing flag 34 (`local29`, hard-wired to 1, so any click already passes). Flag 34 is read by `rm230` `sCopyProBack` (a failed check sends Laura to the death room with `global145` 3), by `rm355` line 36 (`sPartysOver` against `sIllegal`), and by `rm420` line 56. | Keep flag 34 always set but never show the screen: make room 18's init set flag 34 and immediately change to the act's return room (230, 355, or 420). Leave the callers and the Crodfoller reaction messages alone. One edit to Script 18, which is already a shipped patch, so it is an ordinary edit once the compiler is sound. |

**Sequence:** (1) PLAY-002; (2) PLAY-003 config test, then the combined script 310 compile for PLAY-003/004;
(3) the notebook audit table (PLAY-007/008) and its fixes; (4) PLAY-006 inside P5-01. After each step, regression-run
the relevant Save checkpoint from [TESTING.md](TESTING.md).

**New findings from the run** are added to the register below; assign each to a row here when it is triaged.

## Findings register

These are observations from the current run, not yet implementation decisions. Preserve existing content and prefer
diegetic discovery or additive reactions over moving old dialogue behind a new prerequisite.

| ID | Act | Observation / desired behavior | Triage status |
| --- | --- | --- | --- |
| PLAY-001 | 1 | The dirty cab should only appear after a first normal cab ride, and never reappear once the claim ticket is taken. | Resolved (D-030): gated on `(and (proc0_10 1) (proc0_2 125) (not (proc0_2 27)))`; clean ride sets flag 125 in `Trash.sc`. |
| PLAY-002 | 1 | After Laura shows the press pass once, the cabbie should remember her. | Observed; identify existing recognition state before allocating anything new. |
| PLAY-003 | 1 | Music is absent in the speakeasy, its bathroom, and outside Lo Fat's laundry. | Observed; compare room music initialization and restore behavior. |
| PLAY-004 | 1 | The two men at the speakeasy bar need distinct interaction messages. | Observed; inventory existing nouns/messages before adding text. |
| PLAY-005 | 2 | Yvette is absent from the notebook People list; establish whether this is intentional and audit every other lost entry. | Audited: introduced in Act 1 at the Docks (rm270) or Act 2 at museum (D-030). |
| PLAY-006 | 2+ | Nearby characters should sometimes interject when asked about one another, beginning with Pippin's snide response when Laura asks Carrington about him. | Content sweep candidate; additive dialogue must not isolate existing content. |
| PLAY-007 | 2 | Ernie, Tut, Olympia, and Watney Little appear in the notebook before Laura meets them or learns their names. | Audited: Rameses, Countess, Olympia, Yvette have Act 1 diegetic routes; Tut and Watney remain for Act 2/4 diegetic checks (D-030). |
| PLAY-008 | All | Discussed notebook topics should show completion and reopen only when new dialogue becomes available. | System audit needed across topic flags and later-act unlocks. |
| PLAY-009 | 1, 3, 5 | The copy-protection screen after the intro, on first talking to Crodfoller, should be removed entirely rather than merely neutralized. | Analyzed; fix drafted, blocked on the compile environment. See the gameplan row. |

## New finding template

Copy one row into the register, assign the next `PLAY-nnn` ID, and retain the ID through audit, roadmap promotion, fix,
and regression testing.

| ID | Act | Observation / desired behavior | Triage status |
| --- | --- | --- | --- |
| PLAY-nnn |  |  | Observed; save `__`, room `__`, time `__`, score `__`. |

