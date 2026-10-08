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

- **Context:** In vanilla LB2, missing wire cutters or cheese in earlier acts renders Act 5 unwinnable hours later.
- **Decision:** Introduce emergency backups in Act 5 accessible areas (Room 510 basement) and prevent act transitions
  if required items are unacquired.
- **Consequences:** Players cannot reach the finale in a doomed state, adhering to modern adventure game fairness standards.

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

## D-009 Inaccessible Plot Information & Notebook Fallback Triggers

Establish a two-tier fallback trigger mechanism ensuring all Act 2 suspects and staff are recorded in Laura's notebook.

- **Context:** In vanilla LB2, suspect clues 263..272 (Steve, Ziggy, Heimlich, Yvette, Ernie, Rameses, Countess, Olympia,
  Tut, Watney) were only recorded during optional Act 1 dialogues (e.g., Lo Fat's laundry in room 270; clue 271 was
  omitted entirely by Sierra outside debug scripts). Missing these conversations permanently locked players out of
  questioning gala attendees about these key figures in Act 2. Sierra recognized this deficiency by manually granting
  clues 263..272 in debug warp `proc0_13` in `Main.sc`.
- **Decision:** Implement a dual-tier fallback mechanism:
  1. **Diegetic Check-in Fallback (`LB2/src/rm335.sc` / Script 335):** When Laura presents her press pass to Ernie Leach
     at the museum benefit desk (`sGiveInvite` state 5, or passing into the rotunda in `sExitNorth` state 3), the game
     diegetically simulates consulting the benefit guest register and invokes `((ScriptID 21 0) doit: 263..272)`.
     Because `addCluesCode` (Script 21) is idempotent, existing clues are preserved without duplication.
  2. **Direct Visual/Conversational Encounter Fallback (`LB2/src/RotundaRgn.sc` / Script 93):** Intercept Look (verb 1)
     and Talk (verb 2) in `doVerb` (`sel_300:`) across all 11 rotunda characters (Countess, Heimlich, Olympia, O'Riley,
     Pippin, Rameses, Steve, Tut, Watney, Yvette, Ziggy) to ensure examining or speaking with any character registers
     their clue immediately.
- **Consequences:** Eliminates the Act 2 suspect inquiry lockout while maintaining immersion and vanilla story flow.

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

---

## Open questions

- **Q-001**: Resolved by D-007: Omit insensitive original CD voice tracks; restore murder lines as text messages in
  `.MSG`, leaving talker audio hooks open for future custom voice recordings.
- **Q-002**: Resolved by D-008: Implement diegetic knowledge acquisition threshold for Act 2 progression and plan
  contextual museum activities/puzzles.
