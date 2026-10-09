# Testing

Verification strategy, testing recipes, and quality assurance workflows for *The Dagger of Amon Ra: Redux*.

## Test strategy

Because Sierra SCI 1.1 operates as an interpreted virtual machine executing compiled bytecode, testing spans three
distinct verification boundaries:

1. **Static Documentation & Schema Verification:** Automated checks enforcing documentation consistency, roadmap
   alignment, and 3x manual schema conformance.
2. **Resource & Bytecode Compilation Checks:** Ensuring decompiled and modified `.sc` sources compile into valid `.SCR`
   and `.HEP` lumps without selector mismatch or stack overflow errors.
3. **Runtime Regression Testing via DOSBox-X:** Validating live event handling, room transitions, save/load state, and
   script flag behavior under Sierra's original DOS interpreter.

## Test matrix and commands

| Suite | Scope | Command | Verification Target |
| --- | --- | --- | --- |
| **Doc Consistency** | Repository memory | `python3 tools/check_docs.py` | 0 errors; no orphaned IDs, broken links, or placeholders. |
| **3x Manual Check** | Manual specification | `python3 tools/manual.py check docs/manual/amon-ra.manual.json` | 0 errors; validates What/How/Why triads and cross-references. |
| **3x Manual Build** | HTML compilation | `python3 tools/manual.py build docs/manual/amon-ra.manual.json --output docs/manual/manual.html` | Generates portable single-page manual HTML. |
| **DOSBox-X Smoke** | Original interpreter startup | `./tools/run_dosbox.sh` | Mounts `LB2/` as drive C and launches `SCIDHUV.EXE` with loose patches active. |
| **DOSBox-X Headless Smoke** | Automated startup | `SDL_VIDEODRIVER=dummy SDL_AUDIODRIVER=dummy timeout --signal=INT 10 ./tools/run_dosbox.sh -silent` | Initializes DOSBox-X and the configured game environment without a desktop window. |

## Interactive DOSBox-X workflow

Run `./tools/run_dosbox.sh`. The checked-in configuration mounts `LB2/` as C: and starts `scidhuv`, so SCI executes
the loose patches through the same interpreter shipped with the game. Use deterministic in-game saves immediately before
each target branch and record the observed dialogue, inventory, room transition, and timing behavior.

For the complete exploratory run that gates Phase 5, use [PLAYTEST_CHECKLIST.md](PLAYTEST_CHECKLIST.md). It tracks broad
act-by-act behavior and assigns stable `PLAY-nnn` IDs to observations before they are consolidated into roadmap work.

## Save state test checkpoints

To ensure regression coverage without manual playthroughs:

1. **Save 01 (Act 1 Transition):** Keep one save before taking the press pass and one immediately afterward, without visiting the docks, trading the baseball, or questioning Ziggy. Verify that the clean taxi is used before the pass, the dirty taxi and claim ticket become available after it, Lo Fat exchanges the ticket for the gown, and a dressed taxi ride from Room 300 starts Act 2 (`P3-05`, `P2-06`).
2. **Save 02 (Act 2 Museum Party):** In room 230; verifies `P1-01` interrogation, `P1-04` About screen, and `P2-01` fallback notebook triggers.
3. **Save 03 (Act 3 Armor Room):** Room 440 prior to Countess meeting; verifies `P1-03` key glint hitbox and `P2-02` pocket watch confrontation. Also start Talk and several Ask responses with a museum NPC while that actor is en route: the actor must remain in place until the final message is dismissed, then continue the same route. Advance through 10:15 and confirm O'Reilly remains available (`P3-06`).
4. **Save 04 (Act 4 Secret Passage and Carrington Office):** In Room 420, verify the `P3-04` darkness warning gate; in Room 560 before acquiring inventory item 24, verify that Look/Hand/Magnifier on the bookcase opens the special volume, the enlarged volume hotspot remains usable, and looking at the exposed file registers clues 793 and 272 before Take (`P4-01`). At Pippin's Room 454 scene, inspect the bloody high-heel footprint so point bit 179 persists for the inquest (`P4-02`). Repeat the moving-NPC dialogue check and confirm O'Reilly remains available after 10:15 (`P3-06`).
5. **Save 05 (Act 5 Chase Entrance):** Room 500; verifies `P1-02` save/load availability, `P3-01` emergency backups, and `P3-02` snake oil bottle.
6. **Save 06 (Act 6 Coroner Inquest):** Room 750, after collecting the Ankh (item 20), Pippin's notepad (item 21), and Yvette's shoe (item 30) and inspecting the Room 454 footprint. Verify three distinct coroner acknowledgements after question 16 and one-time insight point bits 180..182; restore and repeat with each evidence chain absent to confirm independent gating (`P4-02`). For `P4-03`, answer both murder and theft groups correctly while satisfying the full Sierra checklist: dagger 11, police file 24, Ankh 20, red hair 27, pocket watch 7, wire cutters 10, carbon paper 29, bifocals 26, notepad 21, shoe 30, garter 17, grapes 31, and warthog hair 25. Confirm the maximum outcome, then omit each item in turn and confirm the evidence gate fails. Separately verify the durable equivalents: dagger acquisition bit 155 after surrender, carbon-paper read bit 170 after consumption, and police-file discovery bit 183 after Look without Take. For `P4-04`, exercise all four combinations of murder-case success and recovered/not-recovered dagger while deliberately varying theft answers; verify the coroner still critiques wrong answers, but newspaper art, outcome routing, and Script 785 cards use the physical dagger state. Repeat the recovered cases after handing item 11 to O'Reilly and confirm bit 155 preserves credit. For `P4-06`, verify the required-case notice appears before question 1 and the bonus-museum notice before question 12 (or the first reachable bonus question after an authored skip). Hold questions 1–11 and evidence constant, vary wrong answers across questions 12–16, and confirm the coroner result, newspaper, ending route, and epilogue cards remain identical while the authored bonus feedback still changes.

For `P4-05`, retain a save immediately before each Script 26 act break. With every then-attainable point, verify cumulative totals/divisors of Act 1 `5/5`, Act 2 `13/13`, Act 3 `38/38`, Act 4 `48/48`, and Act 5 `51/51`, each selecting the A band at 100%. Repeat representative 0%, 20%, 21%, 40%, 41%, 60%, 61%, 80%, 81%, and 100% boundaries. On a fresh game, confirm the introduction displays no grade and the first later F uses the first F narrator message. After P4-02's inquest review, verify the raw score can reach 54 without changing the already-issued Act 5 grade.

## Known limitations

- **Never rebuild resources (D-028).** Compile All is safe. Any SCI Companion rebuild or repack replaces `RESOURCE.000`/`RESOURCE.MAP` with a 5-byte-map volume holding only loose files. A healthy base is `RESOURCE.000` 5,035,964 bytes and `RESOURCE.MAP` 6,489 bytes (compare `LB2_vanilla/`).
- Compile All writes lowercase patch names under Wine. Run `python3 tools/uppercase_patches.py` afterwards; it never overwrites and reports skipped files.
- Headless DOSBox-X startup verifies initialization but does not traverse dialogue or animation branches; deterministic
  save-state playback and manual interaction remain necessary for behavioral verification.
- DOSBox-X reproduces the original interpreter environment but offers less direct SCI object/flag introspection than a
  dedicated reimplementation debugger, so source-level flag audits remain part of regression testing.
