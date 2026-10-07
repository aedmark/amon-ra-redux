# Testing

Verification strategy, testing recipes, and quality assurance workflows for *The Dagger of Amon Ra: Redux*.

## Test strategy

Because Sierra SCI 1.1 operates as an interpreted virtual machine executing compiled bytecode, testing spans three
distinct verification boundaries:

1. **Static Documentation & Schema Verification:** Automated checks enforcing documentation consistency, roadmap
   alignment, and 3x manual schema conformance.
2. **Resource & Bytecode Compilation Checks:** Ensuring decompiled and modified `.sc` sources compile into valid `.SCR`
   and `.HEP` lumps without selector mismatch or stack overflow errors.
3. **Runtime Regression Testing via ScummVM:** Validating live event handling, room transitions, save/load state, and
   script flag states across deterministic checkpoints.

## Test matrix and commands

| Suite | Scope | Command | Verification Target |
| --- | --- | --- | --- |
| **Doc Consistency** | Repository memory | `python3 tools/check_docs.py` | 0 errors; no orphaned IDs, broken links, or placeholders. |
| **3x Manual Check** | Manual specification | `python3 3x-documentation-scheme/scripts/manual.py check 3x-documentation-scheme/scheme/amon-ra.manual.json` | 0 errors; validates What/How/Why triads and cross-references. |
| **3x Manual Build** | HTML compilation | `python3 3x-documentation-scheme/scripts/manual.py build 3x-documentation-scheme/scheme/amon-ra.manual.json --output manual.html` | Generates portable single-page manual HTML. |
| **ScummVM Detection** | Engine signature | `scummvm --detect --path=LB2` | Detects `sci:laurabow2` (Laura Bow II DOS/English). |
| **ScummVM Runtime** | Live gameplay & debug | `scummvm -d 1 --auto-detect --path=LB2 sci:laurabow2` | Opens game with SCI debug level 1 logging to terminal. |

## Interactive ScummVM debug console commands

Press `Ctrl+Alt+D` while running ScummVM to access the SCI debugger:

- `var g <num>`: Inspect or set global variables (e.g., score, current act, flags).
- `send ego <selector>`: Query Laura's properties (e.g., `send ego x`, `send ego y`, `send ego view`).
- `send theIconBar <selector>`: Verify active icon bar states and enabled icons.
- `sc <roomNum>`: Change room immediately to test specific rooms (e.g., `sc 440` for Armor Room, `sc 520` for Chase).
- `inv`: Dump current inventory items held by ego.

## Save state test checkpoints

To ensure regression coverage without manual playthroughs:

1. **Save 01 (Act 1 Transition):** In the newsroom prior to cab ride; verifies `P3-05` and `P2-06`.
2. **Save 02 (Act 2 Museum Party):** In room 230; verifies `P1-01` interrogation, `P1-04` About screen, and `P2-01` fallback notebook triggers.
3. **Save 03 (Act 3 Armor Room):** Room 440 prior to Countess meeting; verifies `P1-03` key glint hitbox and `P2-02` pocket watch confrontation.
4. **Save 04 (Act 4 Secret Passage):** Room 420; verifies `P3-04` darkness warning gate.
5. **Save 05 (Act 5 Chase Entrance):** Room 500; verifies `P1-02` save/load availability, `P3-01` emergency backups, and `P3-02` snake oil bottle.
6. **Save 06 (Act 6 Coroner Inquest):** Room 700; verifies `P4-01` through `P4-06` inquest logic, scoring standardization, and dagger decoupling.

## Known limitations

- ScummVM SCI execution uses reverse-engineered interpreter reimplementation; subtle cycle-exact DOS interrupt quirks
  are not fully simulated.
- Headless automated GUI interaction requires ScummVM scripted input or event recording; manual exploratory testing
  remains necessary for subtle animation timings.
