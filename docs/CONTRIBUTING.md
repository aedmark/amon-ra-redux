# Contributing

Guidelines for contributing to *The Dagger of Amon Ra: Redux*.

## Development setup

1. Ensure Wine 11+ is installed for running SCI Companion: `wine --version`.
2. Ensure DOSBox-X is installed for original-interpreter runtime verification: `dosbox-x --version`.
3. Work in `LB2/` on a case-insensitive filesystem (D-037). Never overwrite `RESOURCE.000`, `RESOURCE.MAP`, `RESOURCE.MSG`, or `MESSAGE.MAP`; pristine copies live in `LB2_vanilla/`. Never run Compile All or any resource rebuild in SCI Companion (D-028).
4. Run `python3 tools/check_docs.py` to confirm documentation consistency.

## Reference-first SCI object workflow

Before editing an interactive room object, establish the engine's ordinary pattern before designing a room-local
workaround (D-034).

1. Read the applicable official SCI Companion documentation. For props, hotspots, approach verbs, and custom
   `doVerb()` handling, begin with [Interacting with Objects](https://scicompanion.com/Documentation/Tutorial/AddingObjects.html).
2. Inspect the local base-class implementation that actually ships with this project. Object-approach work normally
   starts with `LB2/src/Feature.sc`, `LB2/src/PApproach.sc`, and, when collision is involved,
   `LB2/src/Polygon.sc`.
3. Search `LB2/src/rm*.sc` for at least two established objects of the same class and interaction shape. Compare their
   initialization order, `approachVerbs`, `approachX`/`approachY`, bounds, signal/priority, `doVerb()` implementation,
   superclass fallback, and polygon relationship.
4. Keep visual placement, clickable bounds, approach destination, and walkable geometry separate. A sprite position or
   interaction rectangle is not a collision barrier, and an approach point must remain outside any barred polygon.
5. Prefer the framework's standard `Feature`/`View`/`Prop` approach and interaction state. Add a selector override,
   `CueObj` manipulation, per-cycle mutation, or custom dispatcher only when source inspection proves the standard path
   cannot express the behavior; document that proof and the reference objects in `docs/HANDOFF.md`.
6. Test both movement branches: interact from far enough away to invoke `PApproach`, then repeat each verb without
   moving from the exact approach point. Exercise every state transition twice and check for transient fallback text,
   palette changes, freezes, and interpreter errors.

## Workflow

1. Select an open task from `docs/ROADMAP.md` (e.g. `P1-01`).
2. Open the game in SCI Companion: `wine "SCI Companion/SCICompanion.exe" 'Z:\run\media\gordonk\Oopy Goopy\amon-ra-redux\LB2\RESOURCE.MAP'`.
3. Edit the script source in `LB2/src/` and compile that one script into loose `.SCR` and `.HEP` files with `python3 tools/compile.py <script>`; follow the steps in [TESTING.md](TESTING.md#compile-and-boot-workflow).
4. Boot the game in DOSBox-X before committing: `./tools/run_dosbox.sh` (D-029).
5. Update `docs/ROADMAP.md` or `docs/PLAYTEST_CHECKLIST.md`, `docs/HANDOFF.md`, and 3x manual entries.
6. Verify documentation: `python3 tools/check_docs.py`.
7. To release, build the patch-only zip with `python3 tools/package_patch.py <version>` (D-047).
