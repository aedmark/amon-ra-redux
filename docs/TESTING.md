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

## Save state test checkpoints

To ensure regression coverage without manual playthroughs:

1. **Save 01 (Act 1 Transition):** In the newsroom prior to cab ride; verifies `P3-05` and `P2-06`.
2. **Save 02 (Act 2 Museum Party):** In room 230; verifies `P1-01` interrogation, `P1-04` About screen, and `P2-01` fallback notebook triggers.
3. **Save 03 (Act 3 Armor Room):** Room 440 prior to Countess meeting; verifies `P1-03` key glint hitbox and `P2-02` pocket watch confrontation.
4. **Save 04 (Act 4 Secret Passage):** Room 420; verifies `P3-04` darkness warning gate.
5. **Save 05 (Act 5 Chase Entrance):** Room 500; verifies `P1-02` save/load availability, `P3-01` emergency backups, and `P3-02` snake oil bottle.
6. **Save 06 (Act 6 Coroner Inquest):** Room 700; verifies `P4-01` through `P4-06` inquest logic, scoring standardization, and dagger decoupling.

## Known limitations

- Headless DOSBox-X startup verifies initialization but does not traverse dialogue or animation branches; deterministic
  save-state playback and manual interaction remain necessary for behavioral verification.
- DOSBox-X reproduces the original interpreter environment but offers less direct SCI object/flag introspection than a
  dedicated reimplementation debugger, so source-level flag audits remain part of regression testing.
