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

---

## Open questions

- **Q-001**: Resolved by D-007: Omit insensitive original CD voice tracks; restore murder lines as text messages in
  `.MSG`, leaving talker audio hooks open for future custom voice recordings.
- **Q-002**: Resolved by D-008: Implement diegetic knowledge acquisition threshold for Act 2 progression and plan
  contextual museum activities/puzzles.
