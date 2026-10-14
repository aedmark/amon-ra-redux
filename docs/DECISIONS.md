# Architecture Decisions

Item IDs are permanent: `D-<nnn>` (accepted) or `D-<nnn> (superseded by D-<mmm>)`. Never renumber; append new
decisions at the end. Open questions use `Q-<nnn>`.

## D-001 Base Engine Version: DOS Floppy v1.000

The DOS Floppy release (version 1.000) is the immutable base for the Amon Ra Redux project.

- **Context:** The later CD version introduced voice acting but altered background graphics (losing subtle brushstroke
  textures, e.g. on the newsroom desk in rooms 100/110) and introduced restrictive save/load lockouts during the Act 5
  chase.
- **Decision:** Use the DOS floppy version 1.000 located in `LB2/`. Original resources in `RESOURCE.000` remain unmodified.
- **Consequences:** Visual art deco fidelity is preserved. CD speech assets must either be referenced as optional
  add-ons or mapped into text message lumps.

## D-002 Patch Strategy: Modular Loose File Overrides

Use Sierra SCI 1.1's native loose-file priority loader rather than repacking `RESOURCE.000`.

- **Context:** Modifying `RESOURCE.000` requires recalculating `RESOURCE.MAP` offsets and risks silent corruption across
  the entire game data lump.
- **Decision:** Modified scripts and messages are compiled as loose files (`0.SCR`, `13.SCR`, `440.SCR`, `0.MSG`, etc.)
  in the `LB2/` directory.
- **Consequences:** Patches are cleanly version-controllable, individual script diffs can be verified, and players can
  revert to vanilla by deleting loose overrides.

## D-003 Interrogation Streamlining: Double-Click and Context Pre-selection

Streamline the five-click interrogation loop in Act 2 without compromising notebook inquiry depth.

- **Context:** Asking a single question previously required: Ask icon -> Target NPC -> Category tab -> Topic name ->
  Confirm button. In Act 2, this required hundreds of redundant clicks.
- **Decision:** Intercept `vAsk` in `Script 0` and `Script 13`. Clicking an NPC pre-selects the NPC tab; double-clicking
  or pressing Enter immediately repeats the last asked topic or prompts context-sensitive inquiries.
- **Consequences:** Dramatically reduces interaction friction in Act 2 while preserving all original dialogue trees.

## D-004 Unrestricted Save/Load Policy

Enable Save and Restore functions across all screens and game phases.

- **Context:** The CD release locked out the icon bar and save dialog during the Act 5 museum chase, turning deaths into
  punitive full-act replays.
- **Decision:** Remove `theIconBar disable: ICON_SAVE` across chase rooms (`500.SCR` through `550.SCR`). In chase
  movement scripts, pause antagonist pursuers while save/restore dialogs are open.
- **Consequences:** Prevents softlock on restore and eliminates player frustration during trial-and-error action sequences.

## D-005 Softlock Prevention: Multi-Layer Item Safety

Eliminate "Dead Man Walking" states for Act 5 critical items (Wire Cutters, Snake Oil, Cheese).

- **Context:** In vanilla LB2, missing wire cutters, exhausting snake oil, or missing cheese in earlier acts renders Act 5 unwinnable hours later. The initial plan incorrectly described Room 510 as a basement cache; it is a museum gallery and does not cover existing saves already beyond that room.
- **Decision:** In Main's central room-transition handler (Script 0), perform a one-time audit whenever `global123 == 5` and guard flag 123 is unset. Grant only missing inventory indices 10 (Wire Cutters), 14 (Snake Oil), and 16 (Cheese); if the snake-oil charge counter `global150` is zero, restore it to four. Set flag 123 after the audit. This catches normal Act 5 entry, debug warps, and pre-patch Act 5 saves without blocking progression or adding room-specific pickups.
- **Consequences:** Resolves P3-01. Players cannot enter or resume Act 5 in a doomed inventory state, while the one-shot guard prevents cheese and snake oil from being recreated after their intended consumption. The repair is save-compatible and does not change earlier-act puzzle acquisition.

## D-006 Inquest Scoring Standardization and Physical Clue Decoupling

Standardize point math and decouple physical dagger ownership from inquest questionnaire results.

- **Context:** Answering quiz questions incorrectly caused the epilogue to report the Dagger of Amon Ra was lost even
  when Laura possessed it. Scoring also suffered from inconsistent divisors and a startup F-grade bug.
- **Decision:** Decouple epilogue newspaper text from questionnaire score, standardizing ending evaluation to reflect
  actual possession. Standardize total point divisors and fix uninitialized grade index.
- **Consequences:** Ending headlines reflect physical game reality and grading math is mathematically accurate.

## D-007 Voice Asset Policy: Omit Original CD Audio, Prioritize Text with Extensible Voice Hooks

Omit the original 1993 CD voice acting assets from the project baseline and modernize all dialogue exclusively through
text message tables (`.MSG`), maintaining an extensible architecture for future community or professional re-recordings.

- **Context:** The original CD release's voice performances have been widely criticized for cultural insensitivity,
  exaggerated caricatures, and uneven delivery. Furthermore, the floppy base release (`LB2/`) does not contain or rely
  on CD audio tracks.
- **Decision:** Do not backport or package the original CD voice acting tracks. Restore all inaccessible murder
  dialogues, death descriptions, and character interactions strictly through message resources (`.MSG`). Keep the SCI
  audio sync and talker hooks intact so new, modern voice recordings can be seamlessly slotted in as an optional pack
  in the future.
- **Consequences:** Resolves Q-001. Eliminates insensitive caricatures, keeps patch file sizes minimal, preserves the
  pure floppy aesthetic, and establishes a clean hook for future voice talent projects.

## D-008 Act 2 Progression Model: Diegetic Knowledge Gating and Contextual Activity Framework

Replace the mechanical 14-eavesdropping requirement with a diegetic knowledge acquisition threshold and pad out Act 2
with contextual puzzles and investigative activities.

- **Context:** In vanilla LB2, Act 2 requires listening to 14 specific hallway eavesdropping conversations to advance
  the museum clock. This turns the act into a passive waiting game where Laura does little actual detective work.
- **Decision:** Implement a diegetic knowledge progression model in `Script 0` and `Script 230`:
  1. Progression to Act 3 is unlocked once Laura acquires a necessary baseline of case knowledge—specifically
     discovering core suspect motives, key character alibis, and museum relationships—regardless of whether this is
     achieved through eavesdropping, direct interrogation, or finding physical notes.
  2. Plan contextual mini-puzzles and active investigative tasks throughout the museum (e.g. examining exhibit security,
     inspecting museum registry discrepancies, cross-referencing staff movements) to give players meaningful things to
     *do* rather than merely loiter in corridors.
- **Consequences:** Resolves Q-002. Replaces arbitrary event counting with logical detective agency; players can advance
  naturally as soon as they understand enough of the scenario to justify moving forward.

**Status:** Superseded by D-017 after source audit showed that the described 14-eavesdrop Act 2 gate does not exist.

## D-009 Inaccessible Plot Information & Notebook Fallback Triggers

Establish encounter-based fallback triggers so optional Act 1 routes cannot permanently lock later interrogation topics.

- **Context:** In vanilla LB2, suspect clues 263..272 (Steve, Ziggy, Heimlich, Yvette, Ernie, Rameses, Countess, Olympia,
  Tut, Watney) depended on uneven optional routes, and clue 271 was absent outside debug scripts. The first implementation
  granted the entire range invisibly at benefit check-in and on every direct encounter. That prevented lockouts but also
  told Laura names she had not learned, most seriously revealing Watney while he was still posing as Carrington.
- **Decision:** Preserve idempotent direct Look/Talk registration for characters Laura can identify, but never translate
  the disguised Carrington actor into Watney clue 272. Replace the invisible check-in batch with the physical register
  specified by D-033. Preserve authored personal introductions, including Ernie's Room 355 introduction, and use the
  Room 560 police file or later explicit identification for Watney.
- **Consequences:** Later questions remain reachable without turning the notebook into an omniscient cast list. Identity
  acquisition now follows what Laura has actually read, heard, or observed.

## D-010 Pocket Watch Confrontation Timing & Armor Room Lockout Adjustment

Adjust item acquisition lockouts, schedule gating, and confrontation scripting to make presenting Carrington's pocket watch to Countess Waldorf-Carlton in the Armor Room reliably accessible.

- **Context:** In vanilla LB2, Sierra authored dramatic confrontation dialogue in module 1440 (`noun 1, verb 17`) where Laura confronts Countess Waldorf-Carlton with Carrington's pocket watch in the Armor Room (`rm440.sc`). However, players were completely unable to trigger this exchange due to three compounding logic bugs:
  1. Retrieving the pocket watch from Carrington's office (`rm630.sc` in `inWatchOpen sel_111:`) advances the clock to 1:45 by setting bit 16 (`4880`) in `global124`.
  2. In `rm440.sc` `sOutTapestry` state 2, initiating `sTalkWithCountess` was gated behind `(not (proc0_10 4880))`. Possessing the watch guaranteed `(proc0_10 4880)` evaluated to TRUE, making the confrontation check evaluate to FALSE whenever the player carried the watch.
  3. In `rm440.sc` `sel_403`, the secondary meeting script `sMeetingNo2` (Ziggy/Little) was checked via `(proc0_10 8224 1)`. Because `proc0_10` with `param2 = 1` checks whether all lower bits sum to 31 (`0x1f`), setting bit 16 upon taking the watch caused `(proc0_10 8224 1)` to evaluate to TRUE prematurely at 1:45, overriding the Countess meeting and skipping it entirely.
  4. In `triggerAndClock.sc` line 176, the clock tick at 1:45 unconditionally rerouted the Countess destination room `sel_618` to 520, causing her to wander away before Laura could return with the watch.
- **Decision:**
  1. **Tapestry Emergence Gating (`LB2/src/rm440.sc`):** Removed `(not (proc0_10 4880))` from `sOutTapestry` state 2 so Laura emerging from behind the tapestry reliably initiates `sTalkWithCountess` (`(ScriptID 441 3)`) as long as Countess is present and flag 120 is unset.
  2. **Armor Room Meeting Scheduling (`LB2/src/rm440.sc`):** Adjusted `sel_403` condition so `sMeetingNo2` only takes precedence if the Countess confrontation has concluded (`(proc0_2 120)`) or the clock has legitimately reached 2:00 (`(proc0_10 8224)` bit 32). This guarantees Meeting 1 (Countess) precedes Meeting 2.
  3. **Direct Confrontation & Item Handler (`LB2/src/sCountessMeeting.sc`):** Updated `sCountessNoMeet` state 3 so if Laura enters Room 440 carrying the pocket watch (`(gEgo sel_238: 7)`), she immediately triggers `sTalkWithCountess`. In `askQuestions of Actions`, wired verb 17 (pocket watch) and verb 2 (talk) to step Laura out from behind the tapestry (`sOutTapestry`) if interacted with while hidden, returning 1.
  4. **Countess Relocation Schedule (`LB2/src/triggerAndClock.sc`):** At 1:45 (`145`), preserved Countess destination at Room 440 until confrontation is completed (`if (proc0_2 120)`), moving her to 520 at 2:00 (`200`) if missed.
- **Consequences:** Resolves P2-02. Restores the dramatic pocket watch confrontation and dialogue in the Armor Room whether Laura hides behind the tapestry or enters directly carrying the watch.

## D-011 Unused Dialogue & Murder Reaction Restoration

Establish a dual-tier flag synchronization architecture and restore missing NPC interrogation branches for discovered homicides.

- **Context:** Sierra's writers authored extensive, high-quality dialogue sequences across character modules 1883..1892 where suspects and museum staff react to the murders of Dr. Archibald Carrington, Ziggy, Ernie Leach, Yvette Delacroix, Dr. Pippin Carter, and Countess Waldorf-Carlton, as well as the recovery of the Dagger of Amon Ra. In vanilla LB2, these dialogues were inaccessible due to systematic flag disconnects between discovery cutscenes and NPC interrogation dispatchers:
  1. Carrington (clue 259, sequence 69): Room 630 set physical discovery flag 12 upon opening the trunk, but interrogation switches in `MuseumRgn.sc`, `RotundaRgn.sc`, `aHeimlich.sc`, and `aRameses.sc` checked flag 171 (which was only set in room 560 when discovering Watney Little in the boiler).
  2. Ziggy (clue 264, sequence 74): Room 435 set corpse discovery flag 72, but interrogation handlers checked flag 143, and Ziggy's severed head display in room 490 was gated behind `(if (proc0_2 143))`, causing the head display to never initialize.
  3. Ernie Leach (clue 267, sequence 71): Room 420 set corpse discovery flag 67, but interrogation handlers checked flag 158.
  4. Yvette Delacroix (clue 266, sequence 73): Room 500 set corpse discovery flag 68 upon discovering Yvette, but interrogation handlers checked flag 161 (which was only set if Laura completed `sSmashPlaster`).
  5. Countess Waldorf-Carlton (clue 269, sequence 70): Sierra authored a complete 8-line sequence in module 1888 for questioning O'Riley about Countess's murder, but case 269 was entirely omitted from `aORiley` in `MuseumRgn.sc`.
  6. Dagger of Amon Ra (clue 780, sequence 75): O'Riley's reaction to finding the Dagger in the alcohol vat checked score flag 155 rather than physical item possession.
- **Decision:**
  1. **Diegetic Discovery Setting:** Set narrative homicide flags (`171` & `134` in `rm630.sc`, `143` in `rm435.sc`, `158` in `rm420.sc`, `161` in `rm500.sc`, `165` in `rm525.sc`, and `155` in `rm620.sc`) directly within discovery cutscenes and detailed examination insets (`inBones`, `inZiggyDead`, `inDeadErnie`, `inDeadYvette`).
  2. **Interrogation Handler Fallbacks:** Update interrogation switches across `MuseumRgn.sc`, `RotundaRgn.sc`, `aHeimlich.sc`, and `aRameses.sc` to check dual-tier conditions:
     - Carrington (259): `(or (proc0_2 171) (proc0_2 12))` -> Sequence 69
     - Ziggy (264): `(or (proc0_2 143) (proc0_2 72))` -> Sequence 74
     - Yvette (266): `(or (proc0_2 161) (proc0_2 68))` -> Sequence 73
     - Ernie (267): `(or (proc0_2 158) (proc0_2 67))` -> Sequence 71
     - Countess (269): Added case 269 in `aORiley` in `MuseumRgn.sc` checking `(or (proc0_2 69) (proc0_2 165) (proc0_2 166))` -> Sequence 70
     - Dagger (780): `(or (proc0_2 155) (proc0_2 22) (gEgo sel_238: 11))` -> Sequence 75
  3. **Room 490 Head Display Restoration:** Update `rm490.sc` line 66 to check `(if (or (proc0_2 143) (proc0_2 72)))`.
- **Consequences:** Resolves P2-03. Completely restores all authored murder reactions across suspects, enables Ziggy's severed head exhibit in room 490, and connects O'Riley's Countess dialogue without requiring modifications to base resource files.

## D-012 Late-1926 Historical Dialogue Corrections

Anchor narrative corrections to the chronology established by the game itself and deliver them as isolated message overrides.

- **Context:** P2-04 identified three suspect references in the archived message corpus. Pippi Longstocking was not published until 1945. Transatlantic commercial telephone service opened in 1927, but the first experimental two-way radiotelephone conversation between New York and London occurred in 1926. *The Sun Also Rises* was published in late 1926. The game is likewise set late in 1926: Rocco's license says it was renewed September 5, 1926, Laura can ask how characters feel now that the year is almost over, and a notice advertises Lindbergh's proposed flight for the following spring.
- **Decision:** Treat late 1926 as the internal chronology rather than the design outline's inaccurate Spring 1926 description. Replace Lo Fat's Pippi joke with a period-valid misunderstanding involving Pip from Dickens' *Great Expectations*. Preserve the genuine transatlantic milestone but explicitly call it an experimental two-way radiotelephone conversation. Identify Hemingway's book as the newly published *The Sun Also Rises*. Package only affected modules as `LB2/250.MSG`, `LB2/270.MSG`, and `LB2/310.MSG`; do not alter `RESOURCE.MSG` or either base archive.
- **Consequences:** Resolves P2-04 without discarding a real 1926 technology reference or inventing an early publication scenario for Hemingway's novel. The three patches preserve message tuple metadata and talkers while replacing only four text records. Effective-resource auditing across all 103 modules and 5,888 message records finds none of the obsolete target strings.

## D-013 Reuse Museum Acquaintance Flags for Formal Introductions

Route later museum conversations through the introductions Sierra already authored instead of adding parallel state.

- **Context:** `RotundaRgn.sc` already assigns one acquaintance flag to each principal museum character when Laura meets them during the party: Pippin 110, Dr. Smith 111, Countess 112, Yvette 113, O'Riley 114, and Rameses 115. Their later actor implementations did not consult those flags, so Laura could skip the rotunda encounter and then address the character by name elsewhere. The condition-80 dialogue is the intended formal introduction, but the Pippin, Smith, and O'Riley versions still had Laura say their names before they introduced themselves.
- **Decision:** In actor scripts 35, 36, and 90, intercept Talk when the corresponding acquaintance flag is unset and play message condition 80; otherwise preserve the existing handler. Do not allocate new globals. Supply loose message overrides 1882, 1883, and 1888 that retain tuple/talker metadata while changing only the first two condition-80 records to a neutral greeting followed by the character's self-introduction.
- **Consequences:** Resolves P2-05 for all six rotunda acquaintances, preserves established save-state semantics, and avoids new flag-array dependencies. A player who missed the party introduction now receives it on first later conversation, while already-acquainted dialogue remains unchanged.

## D-014 Gate Steve Romance Sequences on Act 1 Conversation

Use a dedicated relationship bit to distinguish an established personal connection from an ignored coworker.

- **Context:** Act 2 room scripts could automatically stage a kiss, embrace, or intimate reunion between Laura and Steve even when the player never spoke to him in Act 1. The Act 1 interaction lives in `rm240.sc`, while the affected museum arrivals are distributed across Scripts 330, 335, and 350.
- **Decision:** Reserve flag 122 as the Steve Act 1 conversation bit. Set it when either `sTalkSteve` or `sAskSteve` begins its dialogue in Script 240. Require the bit alongside the existing timing and presence conditions before starting the romantic sequences in Scripts 330, 335, and 350. When it is unset, preserve the normal room initialization and professional coworker flow.
- **Consequences:** Resolves P2-06 without rewriting dialogue resources or changing the museum schedule. Existing saves default to the non-romantic branch unless the Act 1 conversation has occurred in that playthrough.

## D-015 Treat the Recovered Dagger as Physical Evidence

Use the existing dagger inventory verb and ownership state to represent recognition and police custody.

- **Context:** The real Dagger of Amon Ra is acquired as inventory item 11 and presented to actors with verb 22. Existing records in message modules 1884, 1885, and 1887..1892 mostly dismissed it as a gift-shop replica, even after Laura recovered it from the alcohol vat. O'Reilly's three-line verb-22 exchange offered to borrow the dagger but left item 11 in Laura's inventory, duplicating custody in story and UI.
- **Decision:** Supply loose message overrides for the eight accessible reactions, preserving their noun/verb/condition/sequence/talker metadata while rewriting only the dagger text. In both O'Reilly implementations (`MuseumRgn.sc` / Script 90 and `RotundaRgn.sc` / Script 93), intercept verb 22, retain the inherited message dispatch, and call `(gEgo sel_351: 11)` when Laura still owns the item. Do not allocate a separate hand-off flag; dagger ownership is the authoritative custody state.
- **Consequences:** Resolves P2-07. Suspects now react to the authentic central artifact, and surrendering it to O'Reilly immediately removes it from Laura's inventory in either actor context. The loose-patch approach preserves base archives and the earlier P2-05 edits already carried by module 1888.

## D-016 Use Charge State as the Snake Oil UI Source of Truth

Derive bottle feedback and refill eligibility from the existing `global150` charge counter rather than adding parallel state.

- **Context:** The P3-02 outline misidentified the inventory owner as Script 20 and the refill location as Room 510. Audit found the Snake Oil item in Script 15 and the refill jar in Room 610's Alcoholic Preservation Laboratory. View 61 originally supplied one cel in each of its cursor, inventory, and toolbar loops, so no empty cel existed. The jar's verb-25 handler incremented its display cel on each use and refilled only after four applications, while the actual jar depletion flags 107, 106, and 105 already represented three available portions. No grape check exists in the vanilla handler.
- **Decision:** Keep `global150` as the sole bottle-state authority. Supply loose `61.V56` with cel 1 added to the inventory and toolbar loops as a clear red-X empty state; Script 15 selects cel 0 when charges remain and cel 1 at zero. In Room 610, reject refill attempts when `global150 == 4` or flag 105 marks the jar empty; otherwise restore four charges in one action, advance exactly one depletion flag/cel, and enlarge the oil jar's interaction rectangle. Preserve the audited independence from inventory item 31 (Grapes).
- **Consequences:** Resolves P3-02 without new globals or base-archive edits. Bottle appearance cannot drift from usable charges, repeated full-bottle clicks cannot consume jar supply, and the jar's three portions now correspond to three successful refills. The View 61 transformation is reproducible with `tools/build_snake_oil_view.py`.

## D-017 Preserve Authored Act Transitions and Scene-Scheduler Semantics

Do not build a replacement knowledge threshold on the outline's unsupported “14 mandatory eavesdropping scenes” premise.

- **Context:** A complete source-reference audit found no Act 2 eavesdropping counter in Script 0 or Room 230. Act changes enter Script 26 directly from authored sequences. The Act 2-to-3 break is reached through Room 454's Pippin discovery/report sequence. The only plausible counter, `global111`, is used later by Rooms 510, 560, and 630 to order door-listening and character scenes across acts; Script 22 can set it directly to 15 at 3:00, and Room 610 also sets 15 after its scheduled event. Script 26 never reads it.
- **Decision:** Preserve the existing event-driven act transitions and `global111` save semantics. Do not introduce a parallel clue bitmask, force a threshold into Room 230, or skip scheduler states. Treat new museum activities as an explicit content-expansion milestone requiring narrative, message, art, and save-state specifications.
- **Consequences:** Completes P3-03's technical audit without a risky binary change and avoids skipping authored scenes or invalidating saves. It does not dismiss the underlying pacing problem; that design goal continues as P5-01 after the bug-fix roadmap.

## D-018 Stage Act 2 Interactive Content After Core Bug Fixes

Retain Act 2's essential social context while adding player-driven investigation only after the existing bug-fix phases are stable.

- **Context:** P3-03 established that the often-described “14 eavesdrops” are not a literal progression counter, but the player experience remains overly passive: essential motives, alibis, and relationships are delivered through a long run of dialogue and overheard conversations with too little mechanical variety between them.
- **Decision:** Add Phase 5 and P5-01 as a post-bugfix content milestone. Its design pass will map the complete Act 2 schedule and clue dependencies before selecting several compact museum activities that route the player naturally between existing conversations. Prefer mechanics grounded in existing rooms and props—such as exhibit-security inspection, guest/staff record comparison, or artifact observations—while preserving essential dialogue, authored act transitions, `global111`, and old-save behavior. Require explicit narrative text, resource ownership, scoring, state allocation, and deterministic DOSBox-X test saves before implementation.
- **Consequences:** The pacing concern remains first-class work rather than being closed by the technical audit. Deferring new content until P3 and P4 bug fixes are complete prevents new scripts and state from obscuring current defects and gives the expansion a stable behavioral baseline.

## D-019 Reuse the Stairwell's Existing Darkness State and Warning Text

Block the unlit hidden-stairwell boundary using its existing bulb flag and Look description rather than inventing a parallel light-source system.

- **Context:** The P3-04 outline points to Rooms 420/450 and Olympia's office, but the unannounced fall is in Script 530's eastern-tower stairwell. Its `sel_57` handler sent Laura directly to `sFallStairs` whenever boundary signal 8 and blown-bulb flag 32 were active. The room already exposes `darkPassage` Look text at message tuple noun 11 / verb 1 / condition 2: Laura can barely see a narrow, treacherous staircase descending into blackness. Item 23 is the intended replacement bulb. Although inventory item 15 is a lantern, its timer deliberately switches it off below room 730, so it is not a valid Script 530 solution.
- **Decision:** Replace only the unsafe boundary dispatch with `sWarnDarkStairs`. Freeze input, move Laura back to y=165, display the existing dark-passage warning tuple, restore control, and leave the lit stair traversal unchanged. Retain the original fall animation as unreachable legacy code instead of deleting unrelated assets or death state.
- **Consequences:** Resolves P3-04 without a new flag, message override, or altered inventory behavior. Players receive the same diegetic warning whether they Look first or approach the hazard, and must restore the intended bulb before proceeding.

## D-020 Make the Press Pass the Act 1 Taxi Milestone

Use the essential press-pass event to unlock the dirty taxi instead of requiring every unrelated introductory errand.

- **Context:** The P3-05 outline described a strict order among the docks, baseball, and Ziggy tasks. Source audit found that Script 22 already records the press pass, first docks visit, baseball trade, and first substantive Ziggy conversation as independent `global124` bits 1, 2, 4, and 8, so those tasks can be completed in any order. The actual bottleneck is Script 250's `(proc0_10 16 1)` test, which requires all four low bits before the dirty taxi appears. The taxi contains the claim ticket used to receive the evening gown from Lo Fat, making the docks, baseball, and Ziggy errands collectively mandatory despite their unrelated narrative and item rewards.
- **Decision:** Change all three coordinated Script 250 taxi-state checks—room appearance, trash hotspot handler selection, and corner-trash description—from the complete-low-nibble test to `(proc0_10 1)`, the persistent press-pass acquisition bit. Preserve the dirty-taxi introduction, claim ticket, Lo Fat gown exchange, and dressed taxi Act 1 transition. Do not auto-complete or remove the docks, baseball, or Ziggy content.
- **Consequences:** Resolves P3-05 without new flags, inventory grants, dialogue, or save-format changes. New and existing Act 1 saves that acquired the press pass can reach the claim ticket and gown immediately; the other errands remain available in any order for their clues, character context, clock advancement, and magnifying-glass reward.

## D-021 Preserve Museum Travel State Across Dialogue

Pause the selected museum actor's existing route for the lifetime of a message instead of replacing its destination or globally freezing the cast.

- **Context:** Script 90's `MuseumActor` instances use `TravelToRoom` for both fixed schedules and random wandering. Their Talk and Ask handlers launched `gLb2Messager` without a completion callback, so the mover and travel script could continue while the text UI was open and carry the speaker out of the room. The outline's suggested generic `Wander` restart would discard fixed destinations. Separately, Script 22 removed O'Reilly at 10:15 in every act, cutting off later murder questioning in Acts 3 and 4.
- **Decision:** Route all Script 90 museum-actor messages through a shared wrapper. It sets an actor-local lock, stops the active mover, and assigns `museumDialogueResume` as the message callback. `TravelToRoom` does not advance while locked; on dismissal, the callback clears the lock and re-enters the same travel state so its original fixed or random destination survives. Gate O'Reilly's 10:15 removal out only when `global123` is 3 or 4, preserving the authored behavior in other acts.
- **Consequences:** Resolves P3-06 without new globals, save-state fields, room-table rewrites, or a museum-wide freeze. The speaking NPC remains present throughout dialogue, other NPCs continue their schedules, and O'Reilly remains reachable for the restored Act 3–4 questioning. Direct DOSBox-X observation from deterministic Act 3 and Act 4 saves remains the behavioral regression test.

## D-022 Expose Watney's Existing Police-File Path

Improve access through the authored Room 560 book and clue records instead of inventing a second file or dialogue trail.

- **Context:** The P4-01 outline identifies Watney Little's police file as narratively essential but does not name a room. The provisional manual incorrectly placed a desk dossier in Room 420 and proposed new O'Reilly or Yvette dialogue. Source audit found the complete existing path in Room 560: an 11x15-pixel special volume opens insets 562/1, the exposed file grants inventory item 24, and Take already records Things clue 793 and People clue 272. Room 420 and Script 13 do not participate. Before the change, merely looking at the exposed file recorded neither clue.
- **Decision:** Preserve the existing item, message, score, and clue identities. Expand the special volume's rectangle to 36x38 pixels and route Look, Hand, or Magnifier on the larger bookcase feature to the same closed-book inset while item 24 remains uncollected. On Look at the exposed file, idempotently add clues 793 and 272 before showing the original description; retain the original Take path as a second registration route. Do not add speculative dialogue or new save-state fields.
- **Consequences:** Resolves P4-01 through a prominent environmental interaction and two independent clue-registration paths. Existing saves remain compatible, repeated inspection cannot duplicate notebook entries, and the later inquest receives the same canonical evidence IDs as the vanilla Take path.

## D-023 Reconcile Canonical Planted Evidence in Script 750

Recognize the game's real evidence identities at the inquest and award idempotent insight credit without changing questionnaire answers or ending tiers.

- **Context:** The P4-02 outline named Scripts 700/720, “Yvette's schedule,” and multiple footprints. Source and message audits found that the complete coroner questionnaire and outcome evaluation live in Script 750. Inventory item 21 is Pippin's notepad and reveals appointments for Yvette, Tut, and Carrington after charcoal treatment; item 29 is carbon paper containing an unrelated message about Ernie's fencing job. Room 454's bloody high-heel footprint had authored visual and description resources but no persistent discovery state. The Ankh is item 20/clue 789 and Yvette's shoe is item 30/clue 799.
- **Decision:** Record opening Room 454's footprint inset through unused score bit 179. After the sixteenth inquest question, review three evidence chains independently: Ankh item 20, appointment-notepad item 21, and footprint bit 179 paired with shoe item 30. Use the existing score-bit mechanism to award one point per recognized chain through unused bits 180..182, making repeat entry idempotent. Explain in coroner text that the items contribute timeline or framing evidence but do not by themselves establish guilt. Do not relabel the carbon paper, change murder-answer correctness, or alter final outcome tiers; those remain scoped to P4-03 through P4-06.
- **Consequences:** Resolves P4-02 in the actual owning scripts, preserves old saves and inventory semantics, and turns the previously ephemeral footprint into durable investigative state. Saves created before the patch can still receive Ankh and notepad credit; footprint comparison credit requires inspecting the footprint under the patched script. D-026 accounts for the footprint in Acts 2–5 and records the three later evidence-review awards in the post-grade raw maximum.

## D-024 Use Sierra's Complete Evidence Checklist for the Best Ending

Replace the accidental vanilla subset with the official 13-item evidence list while crediting evidence Laura legitimately discovered and no longer carries.

- **Context:** The user-provided OneShortEye analysis identifies a long-standing contradiction between the ending logic and Sierra's hint book. Source audit confirms that all inquest and outcome logic is in Script 750: vanilla calls a five-condition test “all evidence,” requiring the dagger, grapes, wire cutters, bifocals, and red hair. The first three are effectively forced by progression, so only the last two are meaningful missable gates. Sierra's official hint book instead tells the player that the coroner studies 13 evidence objects: Dagger of Amon Ra, Watney's police file, Ankh medallion, red hair, pocket watch, wire cutters, carbon paper, bifocals, Pippin's notepad, Yvette's shoe, garter, grapes, and warthog hair. The old test omits eight of those objects, including the narratively critical police file.
- **Decision:** Centralize the best-evidence predicate in Script 750 and require all 13 published objects. Test ordinary evidence by inventory identity. Treat dagger acquisition bit 155 as equivalent to still carrying item 11 because P2-07 allows Laura to surrender it to O'Reilly; treat carbon-paper read bit 170 as equivalent to item 29 because reading consumes the paper. Record Room 560 police-file inspection in previously unused bit 183 with zero score, allowing either Look or Take to satisfy item 24. Preserve the independent correct-murder (`local4`) and correct-theft (`local5`) answers and the existing `global126` outcome meanings for later P4-04 and P4-06 work.
- **Consequences:** A maximum outcome now corresponds to Sierra's documented investigation rather than two arbitrary missable objects. Legitimate custody, consumption, and inspection paths do not invalidate a completed investigation. Old saves that already took the police file still pass through inventory; old saves that only looked at it must revisit the inset because no prior durable discovery state existed. Bit 183 is state only and does not alter the score denominator targeted by P4-05.

## D-025 Normalize Physical Dagger State at the Epilogue Boundary

Keep the inquest's answer assessment intact, but derive every post-inquest dagger claim from recovery history rather than quiz correctness.

- **Context:** The outline identifies Script 720 as the ending controller, but source audit found the four-way result is assembled and routed in Script 750. `global126` encodes two independent dimensions: states 1/4 mean the murder case was established, while states 1/2 mean the theft questions were answered correctly. Script 750's newspaper, the intermediate ending routes, and Script 785's 19 character cards all reuse those states as if theft-answer correctness proved physical recovery. Consequently, wrong theft answers produce claims that the dagger was lost even when item 11 remains in inventory or P2-07 transferred it to O'Reilly. Script 620 already persists authentic recovery in acquisition bit 155 before either custody path.
- **Decision:** Add one Script 750 recovery predicate accepting item 11 or bit 155. Preserve `global126` unchanged through the coroner's evaluation and response so wrong answers still receive appropriate feedback. For the newspaper preview and the epilogue boundary, derive a normalized four-way outcome from the existing murder-success dimension plus the recovery predicate: 1 = murders solved and dagger recovered, 2 = dagger recovered only, 3 = neither, 4 = murders solved only. Store that normalized value immediately before route selection so the later Rooms 770, 775, 785, and 790 and every condition-indexed epilogue message agree without parallel state.
- **Consequences:** P4-04 is contained in the actual owning script and remains compatible with old saves. Answering the theft questions incorrectly no longer changes physical history, while failing the murder case still selects the authored unsolved-murder content. A dagger handed to O'Reilly is treated identically to one Laura still carries. No message resources, inventory format, or additional save bit are required.

## D-026 Grade Against Attainable Cumulative Points

Use each act's real maximum score as its percentage divisor and leave the introduction ungraded.

- **Context:** The outline provisionally points to Scripts 0/780, but all grade math and message-band selection live in Script 26 (`actBreak`). It multiplies cumulative score `global15` by 100 and divides by hard-coded maxima. The video author's published point audit and a complete source audit agree that vanilla's attainable cumulative maxima are 5, 12, 37, 47, and 50, while Script 26 uses 5, 12, 43, 58, and 61. A perfect vanilla run therefore falls to 86%, 81%, and 81% after Acts 3–5 instead of reporting 100%. P4-02 adds footprint point 179 during Act 2, raising Redux's graded maxima by one from that act onward. Its evidence-review points 180–182 are awarded only after the Act 5 break. Separately, the introduction enters Script 26 with `global123 == 0` and uninitialized `local8 == 0`; message display is suppressed, but vanilla still selects the F band and advances `global131`, silently consuming the first F response.
- **Decision:** Set Script 26's cumulative divisors to 5, 13, 38, 48, and 51 for Acts 1–5. Retain the existing inclusive grade bands: F 0–20, D 21–40, C 41–60, B 61–80, and A 81–100. Guard grade-band selection and its per-band message-counter increments behind nonzero `global123`, leaving the introduction ungraded. Do not fold the three post-grade inquest points into earlier denominators; document the complete post-inquest raw maximum as 54.
- **Consequences:** A player who collects every point currently available at an act break receives 100%, while partial runs are measured against achievable progress rather than cut or future awards. Existing saves remain compatible because score flags, raw totals, thresholds, and message counters are unchanged. Fresh games retain the first authored F response until a real scored act earns that band.

## D-027 Isolate Bonus Museum Questions from Inquest Verdict State

Make the questionnaire's existing outcome boundary visible to players and structural in Script 750.

- **Context:** The P4-06 outline provisionally assigns the questionnaire and ending evaluation to Scripts 700 and 720, but both live in Script 750. Auditing all sixteen questions found three actual groups: questions 1–9 can clear murder-correctness flag `local4`, questions 10–11 can clear theft-answer flag `local5`, and questions 12–16 cover the painting ring, High Priest, and museum accomplice without writing either flag or awarding score. The optional questions were already outcome-neutral, but they shared `sTenOn` with required theft questions and the UI never told the player that the boundary existed.
- **Decision:** Present a required-case notice before question 1 explaining that questions 1–11 determine the coroner's murder and dagger-theft conclusions. Move questions 12–16 unchanged into `sBonusQuestions` and present an explicit bonus-museum notice before that state begins. Preserve every original answer menu, feedback message, and conditional skip. Keep all `local4` writes in the homicide scripts and all `local5` writes in the required theft script; the bonus script contains neither verdict flag.
- **Consequences:** Players can distinguish the essential case findings from optional lore before answering them. Wrong art-theft or High Priest answers still receive their authored feedback but cannot affect the coroner result, newspaper, ending route, epilogue cards, or rank. No new save flag, message resource, score event, or answer requirement is introduced, and existing saves remain compatible.

## D-028 Treat the Floppy as a Hybrid SCI1/SCI1.1 Build; Compile Single Scripts and Never Compile All or Rebuild

Compile only the scripts whose source changed, one at a time, and never run Compile All or any resource rebuild.

- **Context:** The v1.000 floppy is an inter-version build. Its scripts, heaps, and message resources are SCI1.1 (separate `.HEP` heaps, `SCI_1_1` header defines, script numbers above 999), but `RESOURCE.MAP` uses SCI1-style 6-byte entries (16-bit number plus 32-bit offset) instead of SCI1.1's 5-byte entries. With SCI Companion's map format set to 1.0 the compiler loses the `SCI_1_1` defines and rejects script numbers above 999, yielding hundreds of false errors. With it set to 1.1 compilation works, but the original map is misread, and a resource rebuild then replaced `RESOURCE.000`/`RESOURCE.MAP`/`RESOURCE.MSG`/`MESSAGE.MAP` with a 5-byte-map volume containing only loose files (451 entries against 1,075; no views, pics, sounds, or fonts such as `0.FON`). A later Compile All, run with the map format fixed, also failed in a different way: the sources of the decompiled base scripts needed edits before they would compile at all (stray `name` properties, `--UNKNOWN-PROP-NAME--` tokens, invented selector defines such as `sel_4098`), and the resulting 400+ recompiled patches changed bytes in every script (+2 to +8 bytes of offset shifts) and made the game stall on a black screen at boot. Booting the committed `4c79bcf` patch set worked; the Compile All set did not, with or without the nine scripts it newly made loose (310, 640, 770, 928, 999, 1888, 1895, 1904, 1906) and with or without recompiled 450, 720, 973, and 998. Separately, SCI Companion under Wine deletes the uppercase `N.SCR`/`N.HEP` it replaces and writes lowercase names.
- **Decision:** Keep the map format at 1.1 for compilation. Treat the committed `.SCR`/`.HEP` set as authoritative for every script not deliberately changed by a roadmap item. Compile one script at a time with `python3 tools/compile.py <script>`, which restores uppercase names; `tools/uppercase_patches.py` handles any stragglers without overwriting. Never run Compile All and never run any SCI Companion command that rebuilds or repacks resources. The original `RESOURCE.000`, `RESOURCE.MAP`, `RESOURCE.MSG`, and `MESSAGE.MAP` stay the base (pristine copies live in `LB2_vanilla/`) and all fixes remain loose patches.
- **Consequences:** Base scripts that no roadmap item touched keep running from the original archive or their known-good committed patches. Source edits that exist only to make decompiled output compile (such as the 13 listed in the Session 24 handoff) are not kept in the tree; they remain in commit `7d48893`. After any compile, boot the game before committing, because a compile can succeed and still stall the game at startup. If a rebuild ever happens, the symptom is a roughly 2 KB 5-byte `RESOURCE.MAP` and a `RESOURCE.000` under 1 MB; restore the four base files from `LB2_vanilla/`.

## D-029 Gate Every Compile on a Boot Test and Treat First-Time Script Compiles as High Risk

A patch is not done until the game boots with it, and scripts that have no committed loose patch get extra scrutiny.

- **Context:** The Compile All incident (D-028) produced patches that compiled without error and still left the game on a black screen at boot. Of the scripts in `game.ini`, only the 208 in the `4c79bcf` set have ever shipped as loose patches; nine more (310, 640, 770, 928 `RTRandCycle`, 999 `Obj`, 1888, 1895, 1904, 1906) run from the original archive, and their decompiled sources did not compile without hand edits (stray `name` properties, `--UNKNOWN-PROP-NAME--`, invented `sel_4098`-style selector defines, `View` where `Actor` was needed). Several playtest findings (PLAY-003, PLAY-004) live in such a script (`rm310`). Compile errors are therefore not a reliable safety signal. Bisecting a bad build also needs the game folder copied, because editing `LB2/` loses the known-good state.
- **Decision:** Boot the game under DOSBox-X after every compile and before every commit that changes `.SCR` or `.HEP` files. Use `tools/make_test_copy.sh <name> [git-rev]` to build a throwaway copy (optionally with the patch set of an earlier commit) and bisect there, never in `LB2/`. Treat the first loose patch of a script that has none as high risk: compile it alone, boot-test it, and only then commit. Keep the repository's sources identical to the shipped patches; compile-only edits to decompiled sources that were never shipped stay out of the tree until a roadmap item needs that script. Before any bulk file operation (restore, rename, revert), copy the affected files somewhere outside the repository, and note that `git` history, not the working tree, is the recovery point; also commit before a restore.
- **Consequences:** Roadmap items that touch an unpatched script carry the first-compile cost explicitly. A boot regression is caught within one compile instead of after a bulk change. The 13 compile-fix edits and the nine overrides made on 2026-10-09 remain recoverable from commit `7d48893` for the day a roadmap item needs them.

## D-030 Dirty Cab Progression Gating and Act 1 Diegetic Clue Flow Preservation

Gate the dirty cab behind a completed normal taxi ride, eliminate it after finding the claim ticket, and preserve Act 1's authentic diegetic clue discovery chain.

- **Context:** In vanilla LB2 (and initial P3-05 simplification), obtaining the press pass immediately caused Room 250 to spawn the dirty cab containing the dry cleaner's claim ticket (item 27), and this dirty cab continued to appear on subsequent rides even after the ticket was collected. Separately, an audit of Act 1 inquiry trees was conducted to see whether museum suspects should start in Laura's notebook. Source inspection revealed that `rm230.sc` (Crodfoller) has no handler for Ernie Leach (clue 267 falls to generic fallback), has explicit lines stating he does not know Countess Waldemar (clue 269) or Dr. Olympia Myklos (clue 270), and has an out-of-context joke response for Yvette Delacroix (clue 266). Instead, Act 1 features an intentional diegetic discovery chain:
  - **Newsroom (Room 230 / Crodfoller):** Asking about the Leyendecker Museum (517) introduces Dr. Archibald Carrington (259) and Dr. Pippin Carter (258); asking about Burglary (1027) introduces Ziggy (264) and Det. Ryan O'Riley (260). Crodfoller explicitly does not know Countess, Olympia, Ernie, or Yvette, and never mentions Rameses.
  - **12th Street Docks (Room 240 / Steve Dorian):** Asking Steve about Carrington (259) introduces Countess Waldorf-Carlton (269); asking about Carter (258) introduces Dr. "Tut" Smith (271).
  - **Lo Fat's Laundry (Room 270 / Lo Fat):** Asking Lo Fat about the Leyendecker Museum (517) foreshadows the museum's severe security chief and black-clad woman doctor without naming them, then explicitly introduces Yvette Delacroix (266) so her Act 1 inquiry branches remain reachable.
  - **12th Street Speakeasy (Room 310 / Ziggy):** Asking Ziggy about Egyptology (1028) introduces Rameses Najeer (268).
  - **Act 2 Museum:** Ernie Leach (267) is introduced in the basement (Room 355); Rameses Najeer (268) can also be discovered from the guest register (Room 335) or Rotunda. Pre-populating them on boot bypassed this investigation flow.
- **Decision:**
  1. Allocate persistent flag 125 (`proc0_2 125`, `proc0_3 125`) in `global186` to record completion of a normal cab ride. In `Trash.sc` (Script 250) `sDoTakeOffFlight` (the clean cab ride script), call `(proc0_3 125)` at state 0.
  2. Gate dirty cab appearance in `rm250` init, `Trash::sel_110`, and `cornerTrash::sel_300` on `(and (proc0_10 1) (proc0_2 125) (not (proc0_2 27)))`. The first cab ride is always a normal cab ride. Once flag 125 is set and the press pass is acquired, the dirty cab appears. When Laura collects the claim ticket (setting flag 27), the dirty cab is permanently locked out and the cab reverts to normal rides.
  3. Keep `lb2InitCode.sc` (Script 14) restricted to the authentic starting contacts (Laura, Pippin, Carrington, O'Riley, Crodfoller, Sam, Dad), allowing the suspects to be discovered naturally through Act 1's investigation web.
- **Consequences:** Resolves PLAY-001, ensures clean cab ride progression, and preserves the diegetic investigative storytelling of Act 1 without premature notebook clutter or out-of-context dialogue.

---

## D-031 Preserve Character and Period While Removing Phonetic Caricature

Rewrite culturally stereotyped dialogue act by act without flattening distinct voices or erasing period-specific characterization.

- **Context:** The floppy text gives Lo Fat broken English despite identifying him as Newark-born, and renders Sgt. O'Flaherty and Detective O'Riley through dense stage-Irish spelling. The result can be difficult to read and makes ethnicity substitute for characterization. The same characters already have stronger individual traits worth preserving: Lo Fat is observant, educated, playful, and knowledgeable about garments and baseball; O'Flaherty is hungry, obstructive, and casually helpful when it suits him; O'Riley is a blustering, sexist antagonist whose theatrical self-presentation foreshadows his villainy.
- **Decision:** Rewrite spoken text through tuple-addressed loose `.MSG` overrides, never by changing dialogue routing. Give Lo Fat complete grammar, dry wit, and a light British-English cadence. Give O'Flaherty standard spelling with restrained Irish-American rhythm and idiom. Permit O'Riley a more performative caricature because it serves his antagonistic role, but keep every sentence intelligible. Preserve period attitudes when they reveal character, while removing phonetic ethnicity as the joke itself. Clean adjacent narrator text when it repeats the same stereotype. Store reviewed wording in `docs/dialogue/` manifests and apply it with `tools/dialogue.py` so tuple, talker, reference, and progression metadata remain unchanged.
- **Consequences:** Act 1 modules 210, 250, 260, 270, 290, 295, and 310 retain all clues and triggers while becoming clearer and less demeaning; the sandwich vendor, street kid, and cabbie keep their rapid New York patter and abrasive working-class voices without mock-Italian or dense borough eye-dialect. In Act 2, Rameses replaces the written lisp with precise, reserved speech while retaining his family, profession, Egyptian identity, repatriation argument, suspicions, and humor. Heimlich preserves his militance, duelling scars, security obsession, paranoia, and grief without faux-German spelling, ethnic-superiority jokes, or premature Nazi parody. Yvette uses fluent English and selective French vocabulary while retaining her ambition, intelligence, sexual confidence, strategic relationships, and plot-bearing history. O'Riley remains blustering, sexist, corrupt, xenophobic, and antagonistic without leprechaun vocabulary or dense stage-Irish spelling. Ziggy has one continuous Peter Lorre-inspired voice through Act 3, preserving his clues, lies, fencing offers, police arrangement, Rameses riddle, Hemingway bluff, carbon-paper hint, knowledge of Yvette, and illicit museum inspection. Tut Smith now sounds like an educated, imposing Cairo Museum envoy: fiercely committed to repatriation, vain, patriarchal, guarded about his alibi, and ominously theatrical without camel, snake-charmer, amputation, or mystical-native cliches. The Pippin/Tut confrontation, museum check-in, all fourteen party conversations, immediate Carter murder scene, Pippin discovery, and every deferred murder reaction follow the approved voices. Adjacent Pippin, Countess, Steve, Carrington, Olympia, Ernie, and Laura lines no longer reintroduce the removed caricatures. The Act 3 continuation preserves the approved ensemble voices through private conversations, intercom scenes, laboratory warnings, office interruptions, evidence confrontations, alibi interviews, and murder discoveries. Act 4 preserves Olympia's interest in Steve's dock scars and Steve's forged-painting clue while replacing Heimlich's remaining mock-German lines with controlled authority. Act 5 removes Rameses's written lisp from the complete Society of Amon Ra sequence, makes Laura's historically correct objection establish that human sacrifice is the modern society's invented rite, gives Tut dignified eyewitness testimony, and closes O'Riley without stage-Irish spelling. Act 6 recasts the coroner as a dry, exacting professional throughout the final inquest, replacing dated language and unsupported accusations while preserving all questions, evidence checks, jokes, verdicts, and ending routes. Heidelberg academic fencing replaces generic scar parody; Yvette's genuine grief, Steve's scars and neck-rub scenes, O'Riley corruption clues, Ernie gambling trail, Dr. Smith leverage, and isolated “loan fish” clue remain intact. All nine original references to the 1950s `Andrea Doria` are replaced with period-neutral steamship travel; the Rameses I chronology, `hieroglyphs`, `Ruhmkorff`, and isolated spelling errors are corrected. Four plainly erroneous talker IDs are repaired for Ziggy's diary advice, Yvette's diary answer, Laura's clue question to O'Riley, and Carrington's interrupted reply. All other routing and reference metadata remains unchanged.

---

## D-032 Use Sluicebox Annotations with Stable Numeric Selectors (selector naming superseded by D-039)

Adopt a compiler-facing source reconstruction from the effective Redux resources rather than importing the published
`ra-dos-1.000` text verbatim.

- **Context:** The pinned Sluicebox publication is an exact 221-script version match and dramatically improves symbol
  recovery, but its readable selector aliases are contextual. A single numeric selector ID can be printed as several
  names depending on the receiver, which SCI's global `vocab.997` cannot represent. Direct import produced hundreds of
  false selector/property errors. Conversely, a plain numeric decompile compiled but discarded valuable annotations.
- **Decision:** Run Sluicebox's annotation pipeline on the effective Redux loose-patch layer while emitting verified
  numeric selector IDs. Keep readable recovered globals, object names, procedures, control flow, and comments. Normalize
  `vocab.997` to `sel_N` while preserving IDs 4098 `-propDict-`, 4100 `-classScript-`, 4102 `-super-`, and 4103 `-info-`,
  which SCI Companion requires for direct metadata access. Repair only demonstrated decompiler/compiler boundary cases
  and record them in source. Treat the published tree as a pinned reference, not as directly compilable input.
- **Consequences:** All 221 script/source-object pairs are coherent and include the already-compiled Redux behavior, so
  the 42-script manual replay is unnecessary. Selector calls remain numeric, but the rest of the tree gains Sluicebox's
  substantially better names and structure. A disposable isolated Compile All is allowed only as a migration
  diagnostic; normal repository work remains single-script compilation under D-028.

---

## D-033 Make the Benefit Register an Explicit Identity Source

Use an inspectable entrance prop and restrained Act 1 foreshadowing to distinguish knowing of a person from learning a
name.

- **Context:** P2-01's invisible check-in grant claimed Laura had consulted a guest register that the player could not
  see or use. Lo Fat simultaneously named Heimlich, Olympia, and Yvette and unlocked all three notebook entries, making
  the later register redundant. Watney and Ernie require special handling: Watney attends under Carrington's stolen
  identity, while Ernie already has a clear authored introduction. Ziggy has other Act 1 discovery routes and would not
  plausibly sign the museum's register.
- **Decision:** Add a leather-bound `benefitRegister` Feature beside Heimlich in Room 335, advertised by Heimlich's Look
  description and readable with Look, Hand, or Magnifier. Reading its explicit guest/staff text idempotently adds clues
  263, 265, 266, and 268..271: Steve, Heimlich, Yvette, Rameses, Countess, Olympia, and Tut. It names Pippin and the man
  registered as Dr. Archibald Carrington III but does not add Ziggy (264), Ernie (267), or Watney (272). In Room 270,
  Lo Fat describes the severe security chief and black-clad woman doctor without naming them; he continues to name
  Yvette and add clue 266 so the authored Act 1 Yvette questions remain available.
- **Consequences:** The player chooses to consult the register, legitimate attendees gain a fair fallback introduction,
  Ziggy's absence becomes an in-character detail, Ernie retains his greeting, and Watney remains an investigative thread
  until evidence exposes him. Existing clue IDs and addCluesCode idempotence preserve save compatibility.

---

## D-034 Use a Reference-First Workflow for Interactive SCI Objects

Consult the engine documentation, local base classes, and established game objects before introducing room-local
interaction machinery.

- **Context:** Room 335's benefit podium combined a new sprite, hotspot bounds, approach coordinates, barred geometry,
  save restoration, stateful messages, and clue writes. Iterating directly on the symptom led to rejected custom
  `CueObj`/exact-position dispatch prototypes, including one that re-entered the shared cue and produced Error 2 with
  palette corruption. SCI Companion already documents the standard SCI 1.1 object pattern, and this source tree contains
  many working examples of `approachVerbs`, `approachX`/`approachY`, `doVerb()`, superclass fallback, and collision
  boundaries.
- **Decision:** For interactive object work, begin with SCI Companion's
  [Interacting with Objects](https://scicompanion.com/Documentation/Tutorial/AddingObjects.html) guidance, then inspect
  the project copies of `Feature.sc`, `PApproach.sc`, and `Polygon.sc` as applicable. Compare at least two established
  same-class room objects before changing behavior. Treat sprite placement, click bounds, approach destination, and
  walkable geometry as separate concerns. Preserve the standard object approach/dispatch path unless source evidence
  shows it cannot represent the requirement. Any custom selector override, cue manipulation, per-cycle mutation, or
  dispatcher requires documented justification and must be tested both after a walk-in approach and as an immediate
  repeat from the exact approach point.
- **Consequences:** Future sessions have an explicit starting point and should reuse proven engine behavior before
  inventing local state machines. Reviews can ask which documentation, base classes, and reference objects were checked.
  Repeat-action testing becomes mandatory for stateful hotspots, reducing transient fallback messages, cue re-entry,
  palette corruption, and interpreter errors.

---

## D-035 Consume Unsupported Podium Dispatches at the Object Boundary

Keep the Room 335 benefit podium's valid verbs on the engine path while preventing an extra unsupported dispatch from
reaching the game's generic narrator fallback.

- **Context:** Runtime testing showed that after Laura approached the podium once, repeating an action without moving
  briefly displayed “While this is an interesting approach, it serves no practical purpose.” before the correct
  guestbook response. Moving away and approaching again avoided the flash. The exact text is module 0's verb-47
  catch-all, selected by `proc0_6` only when a verb not recognized by the global fallback reaches it. LOOK, DO, and
  Magnifier already reached the podium's correct messages; custom `CueObj` and exact-position dispatch prototypes had
  previously caused Error 2, palette corruption, and follow-on instability.
- **Decision:** Preserve `Feature` event handling, `PApproach`, `CueObj`, the approach coordinates, old-save repairs,
  and all clue writes. `benefitPodium.sel_300` handles LOOK, DO, and Magnifier exactly as before, but returns handled for
  every unsupported dispatch instead of calling the superclass/global fallback. This adds no object, state, selector
  override, cue manipulation, or save data.
- **Consequences:** The extra follow-up dispatch cannot expose module 0's generic message, while the three supported
  interactions keep their established movement and response behavior. Unsupported actions on this decorative register
  are silent rather than receiving a generic narrator quip. The change is isolated to Script 335 and must retain the
  exact-position repeat matrix in `docs/TESTING.md`.

---

## D-036 Route Room 335 Podium Repeats Through the Deferred CueObj Path

Use the engine's standard `sightAngle` and `approachDist` properties so a repeat interaction from the approach point
takes the same deferred `CueObj` path as an interaction after walking up.

- **Context:** After D-035, the maintainer still saw a brief generic message before the guestbook response whenever
  Laura repeated LOOK or DO without leaving the podium's approach point. Walking up and moving away first never
  flashed. `Feature::handleEvent` (Script 950) has two endings. After a `PApproach` walk, `CueObj` turns Laura, waits
  three cycles, and calls `doVerb` from `gTheDoits`. When Laura is already within `approachDist` and facing within
  `sightAngle`, it calls `CueObj changeState: 3` immediately, so `doVerb` and the message display run inside
  `User::handleEvent`. Only this immediate ending flashed.
  - Setting `approachDist` to 4 alone did not remove the flash.
  - Trace builds that logged every `gMessager say:`, `gDoVerbCode` fallback, room `doVerb`, and podium `doVerb`
    recorded exactly one podium dispatch and one `335:17,verb` message per click, with no generic message call. Every
    trace build also stopped the flash, so the defect is timing- or layout-sensitive. The exact draw source was not
    isolated.
- **Decision:** Set `benefitPodium`'s `sightAngle` (`sel_301`) to -1 and its `approachDist` (`sel_305`) to 4. Apply both
  in the instance properties, the room's podium init, and the room's existing per-frame old-save reapply. Because
  -1 is never "already facing", `facingMe` calls `faceOn`, which queues `CueObj` instead of dispatching inside
  the event handler. D-035's local consumption of unsupported verbs is retained.
- **Consequences:** No custom cue, dispatcher, or state is added (D-034).
  - A repeat reply arrives three cycles after the click; no visible delay was reported.
  - The first approach may stop up to 4 px short of `(186, 180)`, still in front of the podium and outside the barred
    polygon.
  - The maintainer confirmed in DOSBox-X that repeat LOOK and DO show only the guestbook response.
  - If a similar flash appears on another hotspot's immediate-dispatch path, apply the same property pattern before
    adding code.

---

## D-037 Lowercase Loose Patches on a Case-Insensitive Workspace

Track loose patches under the lowercase names SCI Companion writes, and keep the working copy on a case-insensitive
filesystem, so SCI Companion's own Save and Compile work without post-processing.

- **Context:** SCI Companion runs under Wine and writes lowercase patch names (`335.scr`, `335.msg`). On the
  case-sensitive ext4 checkout this collided with the tracked uppercase files. Wine resolves names case-insensitively,
  so a save deleted `335.MSG` and left an empty `335.msg`, and compiles failed with `ERROR_ALREADY_EXISTS` (183) unless
  `tools/compile.py` deleted the patch first. That deletion in turn dropped scripts from SCI Companion's list. The
  uppercase convention had no engine requirement: the interpreter, DOSBox-X, and ScummVM are case-insensitive.
- **Decision:** Move the working copy to the maintainer's exFAT drive, which is case-insensitive and case-preserving.
  Rename all 466 tracked loose `.SCR`/`.HEP`/`.MSG`/`.V56` patches to lowercase as pure renames. `tools/compile.py`
  no longer deletes or renames files; it only triggers SCI Companion and confirms the outputs were rewritten.
  `tools/uppercase_patches.py` is removed. Remove the stale `SCICompanion/docs` folder, which collided with
  `SCICompanion/Docs` on a case-insensitive filesystem.
- **Consequences:** Pressing Compile in SCI Companion produces exactly the tracked names; a test recompile of `rm335`
  rewrote `335.scr`/`335.hep` in place byte-identically. Clones on a case-sensitive filesystem reintroduce the Wine
  collision, so the case-insensitive workspace is a requirement. exFAT lacks Unix permissions (`core.fileMode false`),
  symlinks (the unused `.venv` stays off the drive), and journaling (eject cleanly and push often). D-028's one-script
  rule still stands. SCI Companion's message editor cannot save LB2 message resources at all: upstream implements writing only for format 4000+, and LB2's are `0x0C29`–`0x0D0C`. D-038 supersedes this with the fork's writer.

---

## D-038 Edit Messages in the Forked SCI Companion

Make SCI Companion's message editor the source of truth for LB2 message text, using the maintainer's fork.

- **Context:** Upstream SCI Companion reads LB2's message format (versions `0x0C29`–`0x0D0C`) but writes only the
  4000+ format, so saves produced a 4-byte header with no records (D-037). The maintainer's fork
  ([aedmark/SCICompanion](https://github.com/aedmark/SCICompanion), commit `04b1aeb0`) adds `MessageWriteTo_3411`
  and preserves each entry's three reference bytes. A Python model of that layout rebuilt 46 of 49 shipped message
  files byte-for-byte; `0.msg` and `13.msg` match to their declared end but carry unreferenced trailing bytes that a
  save drops.
- **Decision:** Use the fork build in the untracked `SCI Companion/` folder. Edit and save message text there. Keep
  `docs/dialogue/*.json` and `tools/dialogue.py` as the historical record and audit tool for the P2-08 rewrites, not
  as the editing path.
- **Consequences:** A real edit of `335.msg` (6, 8, 0) saved in place under its lowercase name and was byte-identical
  to the original with only that text changed, including junk reference bytes. Re-applying an old manifest would
  revert later editor changes. SCI Companion also writes `LB2/msg/<n>.shm` noun and condition name files, which are
  tracked so names chosen in the editor persist.

---

## D-039 Name Selectors from the Sluicebox Reference, Verified Against the CD Vocabulary

Replace the `sel_N` placeholders with one readable name per selector ID, keeping every ID unchanged.

- **Context:** The floppy release ships without vocab 997, so D-032 normalized all selectors to `sel_N`, which made the
  source hard to edit in SCI Companion. D-032's objection was that Sluicebox's published names are contextual. A
  token alignment of the 221 scripts against the pinned `ra-dos-1.000` publication, pairing methods by body within each
  class, matched 98.4% of the 37,516 selector uses and gave 543 of 563 IDs a near-unanimous name. The rest were settled
  from class property and method lists (for example `File`, `List`, `DItem`, `Script`). The CD release's vocab 997,
  extracted from the maintainer's disc image (DCL-compressed resource), lists Sierra's names with shifted IDs: 528 of
  the 563 names appear in the same order, and all but six exist in it.
- **Decision:** Store the mapping in `tools/selector_names.json` and apply it with `tools/name_selectors.py`, which
  rewrites `997.voc` and every `src/*.sc` without touching IDs or line endings. Selector 343 is `theControls` because
  the Sierra name `controls` collides with the `controls` instance in `Game.sc` and changed `Rm`'s bytecode. Selectors
  667 and 668 keep their vanilla names (`convRoom`, `convReturn`) even though Redux's P3-06 conversation lock reuses them
  for a museum-actor flag and method; giving those uses their own names requires new selector IDs and is a separate
  change. This supersedes D-032's numeric-selector rule.
- **Consequences:** Every script SCI Companion compiled from the renamed source is byte-identical to the same script
  compiled from the `sel_N` source with the same `.sco` class files (full two-pass rebuild plus targeted reruns). The
  12 scripts absent from SCI Companion's script list were not rebuilt and are unchanged. The rebuild also showed that
  committed patches for 34 scripts (including `Main`, `Game`, `Actor`, `User`, `Feature`, `Sound`, and rooms 18, 250,
  330, 450, 610, 720, 730, and 750) cannot be reproduced from the current source; the playtested patches remain in place
  and a future edit to one of those scripts will also carry those latent source differences.

---

## Open questions

- **Q-001**: Resolved by D-007: Omit insensitive original CD voice tracks; restore murder lines as text messages in
  `.MSG`, leaving talker audio hooks open for future custom voice recordings.
- **Q-002**: Resolved by D-017 and D-018: preserve the existing transition/scheduler model, then address the genuine
  passive-pacing problem through the post-bugfix P5-01 Act 2 content milestone.
