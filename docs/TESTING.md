# Testing

How Redux changes are verified.

## Test strategy

1. **Static checks:** documentation consistency and the 3x manual schema.
2. **Builds:** each changed script compiles, and a routine-by-routine comparison against its committed build shows
   only the intended changes (heap and property layout included).
3. **Runtime:** Sierra's interpreter in DOSBox-X: boot after every compile, then the affected scenes from saves.

## Test matrix and commands

| Suite | Command | Proves | Does not prove | Time, needs |
| --- | --- | --- | --- | --- |
| **Doc consistency** | `python3 tools/check_docs.py` | No placeholders, dangling `P-`/`D-`/`Q-`/`T-` IDs, broken links, duplicate sessions, missing layout paths, or invisible characters | That the prose matches the code | Seconds |
| **3x manual check** | `python3 tools/manual.py check docs/manual/amon-ra.manual.json` | The manual matches its schema and its What/How/Why triads and cross-references resolve | That an entry describes the shipped behaviour | Seconds |
| **3x manual build** | `python3 tools/manual.py build docs/manual/amon-ra.manual.json --output docs/manual/manual.html` | The single-page manual builds | Anything about the game | Seconds |
| **Property layout** | `python3 tools/check_layout.py` | Each instance in every loaded script has its class's property count, and each class extends its superclass's selectors (D-049) | Heap values, method tables, or behaviour | Seconds; reads the archive and loose patches |
| **Routine comparison** | by hand: the rebuilt `.SCR`/`.HEP` against `git show HEAD:LB2/N.SCR` (D-041) | Only the intended routines and heap entries changed | That the change works in play | Minutes per script |
| **DOSBox-X headless smoke** | `SDL_VIDEODRIVER=dummy SDL_AUDIODRIVER=dummy timeout --signal=INT 20 ./tools/run_dosbox.sh -silent -log-con` | `scidhuv` starts and has not returned to the DOS prompt at the timeout | What the screen shows: a black-screen stall would also pass | 20 seconds, DOSBox-X |
| **DOSBox-X boot** | `./tools/run_dosbox.sh` | The intro appears with the patch set loaded (D-029) | Any scene after the intro | A minute; the maintainer's eyes |
| **Save checkpoints** | the saves below, in `./tools/run_dosbox.sh` | The named branches behave as described | Branches not on the list; saves from other builds | Minutes to hours; the maintainer |
| **Release package** | `python3 tools/package_patch.py <version>` | The zip's integrity test passes; a copy of `LB2_vanilla/` with the zip extracted over it matches every `LB2/` game file and passes the headless smoke (D-047) | That the build plays correctly | A minute; `LB2_vanilla/` |

**The fast set** (before every commit): doc consistency and the 3x manual check. **Script changes** add the routine
comparison, property layout, and the boot test. **The full set** (before a release): all of the above, plus the
playtest checklist.

**Expected results** live in HANDOFF's "Verified" section, with the date and commit they were measured on.

## Before any run

- **Ask first** if the maintainer may be playing; a boot test or compile changes files the running game reads.
- **Clean state:** bisect or try risky patches in a throwaway copy (`tools/make_test_copy.sh <name> [git-rev]`, in
  `/tmp/amon-ra-test/`), not in `LB2/`. Never delete or move `LB2/LB2SG.*`.
- **SCI Companion:** "Compile modified scripts before run" is off, the loaded archive is `LB2/RESOURCE.MAP`, and the
  working copy is on the case-insensitive drive (D-037).
- **References:** `LB2_vanilla/` is present (the release check and Sierra-patch comparisons need it).

## Compile and boot workflow

1. Start SCI Companion under Wine by opening the working archive explicitly: `wine "SCI Companion/SCICompanion.exe" 'Z:\run\media\gordonk\Oopy Goopy\amon-ra-redux\LB2\RESOURCE.MAP'`. Do not pass `game.ini`, and do not open the browse-only copy. Its hybrid settings remain SCI 1.0 map, SCI 1.1 package/compression, and VGA 1.1 View/Pic (D-028).
2. If SCI Companion was running before a `997.VOC` change (for example a new selector), restart it; it reads the vocabulary only at startup.
3. Compile one script: `python3 tools/compile.py rm750` (name or `.sc` base name). It drives the GUI through `tools/compile_any.exe`, waits until the `.SCR`/`.HEP` have been rewritten in place, renames the lowercase files SCI Companion writes to uppercase (D-048), and then closes the script window it opened; a window that was already open stays open. Pressing Compile in SCI Companion is equivalent. `wine tools/compile_any.exe --is-open <script>` and `--close <script>` expose the same check and close; `--close` only matches a window titled exactly with the script's file name. If the script is missing from the helper's list (`wine tools/list_scripts.exe`), restart SCI Companion; it drops a script when its patch files vanish and does not re-add it.
4. Stop SCI Companion with `wineserver -k` so it cannot touch `LB2/` again. After saving anything else in SCI Companion (messages, views), run `python3 tools/uppercase_names.py`; `--check` lists stragglers.
5. Boot-test (D-029): `./tools/run_dosbox.sh`. The intro must appear; a black screen or an "Oops! Error n" dialog means the patch set is bad even when the compile reported success.
6. Only then commit.

**Before step 1:** SCI Companion's "Compile modified scripts before run" option must be off (registry `CompileModifiedScriptsBeforeRun=0`). With it on, pressing Run silently recompiles every script whose source is newer than its patch and overwrites the committed files. Launch the game only with `./tools/run_dosbox.sh`.

**Before shipping a rebuilt script that had a drifted committed patch (D-041),** compare the two builds routine by routine rather than byte by byte, and run `python3 tools/check_layout.py` so every object's property count matches its class. Write compound assignments to array elements with a computed index as plain assignments (D-041).

**Compile output must match the committed layout.** After compiling an unmodified script, its `.SCR`/`.HEP` should be byte-identical to the committed files (compare with `git show HEAD:LB2/N.HEP | cmp - LB2/N.HEP`). A larger heap (extra entry per object) means the SCI Companion version setting or `.sco` caches are wrong; such patches crash the game (D-028). For the 23 scripts Sierra patched, compare against `LB2_vanilla/`, not the archive.

To find a bad patch, build a throwaway copy with `tools/make_test_copy.sh <name> [git-rev]` and boot it with the command it prints. Delete or swap patches inside the copy and re-boot. Useful controls: a copy built from the last known-good commit (proves the archive and environment are healthy), then the working tree minus a suspect group. A headless run cannot show the game screen, and screenshot capture with ImageMagick `import` did not work in this environment, so the maintainer reports what the window shows.

## Interactive DOSBox-X workflow

Run `./tools/run_dosbox.sh` (mounts `LB2/` as C: and starts `scidhuv`). Save just before each target branch and
record dialogue, inventory, room transitions, and timing. The Phase 5 gate run uses
[PLAYTEST_CHECKLIST.md](PLAYTEST_CHECKLIST.md), which assigns `PLAY-nnn` IDs; public testers use
[ALPHA_PLAYTESTING.md](ALPHA_PLAYTESTING.md).

## Save state test checkpoints

Keep these saves for targeted regression runs:

1. **Save 01 (Act 1 Transition):** Keep one save before taking the press pass and one immediately afterward, without visiting the docks, trading the baseball, or questioning Ziggy. Verify that the clean taxi is used before the pass, the dirty taxi and claim ticket become available after it, Lo Fat exchanges the ticket for the gown, and a dressed taxi ride from Room 300 starts Act 2 (`P3-05`, `P2-06`).
2. **Save 02 (Act 2 Museum Party):** Before presenting the press pass, confirm Heimlich's Look mentions the leather-bound register. Walk toward the podium from both sides and confirm Laura routes around its footprint instead of crossing through or behind it. Inspect its separate hotspot with Look, Hand, and Magnifier; each route must stop Laura at `(186, 180)` in front of the podium, show the roster, and add any missing Steve, Heimlich, Yvette, Rameses, Countess, Olympia, and Tut entries. Without moving Laura from that exact approach point, repeat Look and Hand/Do at least twice after the names already exist; only the guestbook response may appear, and the room palette, controls, polygon routing, and notebook must remain stable, with no generic fallback flash, freeze, or interpreter error. Confirm Ziggy, Ernie, and Watney are not added. Meet Ernie normally in Room 355, and confirm looking at or speaking to disguised Carrington never adds Watney. This save also verifies `P1-01`, `P1-04`, and `P2-01`.
3. **Save 03 (Act 3 Armor Room):** Room 440 prior to Countess meeting; verifies `P1-03` key glint hitbox and `P2-02` pocket watch confrontation. Also start Talk and several Ask responses with a museum NPC while that actor is en route: the actor must remain in place until the final message is dismissed, then continue the same route. Advance through 10:15 and confirm O'Riley remains available (`P3-06`). From a save made before the end of Act 2, confirm the D-046 patrols (O'Riley between 430, 450, and 454; Yvette in 510 between eavesdropping scenes).
4. **Save 04 (Act 4 Stairwell and Carrington Office):** In Room 530, verify the `P3-04` darkness warning gate; in Room 560 before acquiring inventory item 24, verify that Look/Hand/Magnifier on the bookcase opens the special volume, the enlarged volume hotspot remains usable, and looking at the exposed file registers clues 793 and 272 before Take (`P4-01`). At Pippin's Room 454 scene, inspect the bloody high-heel footprint so point bit 179 persists for the inquest (`P4-02`). Repeat the moving-NPC dialogue check and confirm O'Riley remains available after 10:15 (`P3-06`).
5. **Save 05 (Act 5 Chase Entrance):** Room 500; verifies `P1-02` save/load availability, `P3-01` emergency backups, and `P3-02` snake oil bottle.
6. **Save 06 (Act 6 Coroner Inquest):** Room 750, after collecting the Ankh (item 20), Pippin's notepad (item 21), and Yvette's shoe (item 30) and inspecting the Room 454 footprint. Verify three distinct coroner acknowledgements after question 16 and one-time insight point bits 180..182; restore and repeat with each evidence chain absent to confirm independent gating (`P4-02`). For `P4-03`, answer both murder and theft groups correctly while satisfying the full Sierra checklist: dagger 11, police file 24, Ankh 20, red hair 27, pocket watch 7, wire cutters 10, carbon paper 29, bifocals 26, notepad 21, shoe 30, garter 17, grapes 31, and warthog hair 25. Confirm the maximum outcome, then omit each item in turn and confirm the evidence gate fails. Separately verify the durable equivalents: dagger acquisition bit 155 after surrender, carbon-paper read bit 170 after consumption, and police-file discovery bit 183 after Look without Take. For `P4-04`, exercise all four combinations of murder-case success and recovered/not-recovered dagger while deliberately varying theft answers; verify the coroner still critiques wrong answers, but newspaper art, outcome routing, and Script 785 cards use the physical dagger state. Repeat the recovered cases after handing item 11 to O'Riley and confirm bit 155 preserves credit. For `P4-06`, verify the required-case notice appears before question 1 and the bonus-museum notice before question 12 (or the first reachable bonus question after an authored skip). Hold questions 1–11 and evidence constant, vary wrong answers across questions 12–16, and confirm the coroner result, newspaper, ending route, and epilogue cards remain identical while the authored bonus feedback still changes.

For `P4-05`, retain a save immediately before each Script 26 act break. With every then-attainable point, verify cumulative totals/divisors of Act 1 `5/5`, Act 2 `13/13`, Act 3 `38/38`, Act 4 `48/48`, and Act 5 `51/51`, each selecting the A band at 100%. Repeat representative 0%, 20%, 21%, 40%, 41%, 60%, 61%, 80%, 81%, and 100% boundaries. On a fresh game, confirm the introduction displays no grade and the first later F uses the first F narrator message. After P4-02's inquest review, verify the raw score can reach 54 without changing the already-issued Act 5 grade.

## Adding a check

- Python checks go in `tools/` and use only the standard library; reuse `tools/sci_archive.py` to read resources.
- Assert on what happened (a byte, a property count, a file on disk), not on words in a message.
- Before trusting a new check, make it fail: run it against a build without the fix. `check_layout.py` was trusted
  only after it caught the pre-D-049 Script 31.

## Change-to-check matrix

| Changed area | Minimum checks | Additional evidence |
| --- | --- | --- |
| Documentation only | doc consistency | The manual check if the manual changed |
| 3x manual | manual check and build | |
| One script's logic | compile, routine comparison, boot | The save checkpoint for that branch; the maintainer's playtest |
| A class, or anything adding objects, locals, methods, or properties | the above plus property layout | Name the saves it affects; confirm with the maintainer first |
| Message text (`.MSG`) | boot | Read the changed lines in play; confirm the wording with the maintainer first |
| Selector names | `tools/name_selectors.py`, restart SCI Companion, byte-identical recompile | |
| Release | the full set and the release package | The tester guide's install recipe on a clean copy |

## Manual checks (before a release)

- The Phase 5 gate run in [PLAYTEST_CHECKLIST.md](PLAYTEST_CHECKLIST.md) for the acts the release touches.
- The tester guide's install steps, followed exactly, on a fresh retail copy.
- Record who checked what, where, and when in HANDOFF.

## Environment recipes

- SCI Companion: step 1 of the compile and boot workflow above; stop it with `wineserver -k`.
- DOSBox-X configuration: `tools/dosbox-x.conf`, used by `tools/run_dosbox.sh`.
- The `tools/*.exe` helpers (Q-003): 32-bit MinGW-w64, no extra flags or libraries. Build one with
  `i686-w64-mingw32-gcc -o tools/NAME.exe tools/NAME.c`, and the DLL with
  `i686-w64-mingw32-gcc -shared -o tools/hook.dll tools/hook_dll.c`. `tools/compile.py` builds `compile_any.exe` itself
  when it is missing. All 24 sources built cleanly with GCC 16.2.0 on 2026-11-08; the committed-era binaries came
  from GCC 15.2 (named in `hook.dll`'s strings).

## Known limitations and pitfalls

- **Never rebuild resources and never Compile All against `LB2/` (D-028).** A rebuild replaces `RESOURCE.000`/`RESOURCE.MAP` with a 5-byte-map volume holding only loose files (healthy base: `RESOURCE.000` 5,035,964 bytes, `RESOURCE.MAP` 6,489 bytes; compare `LB2_vanilla/`). Compile All regenerates every patch and previously produced a build that stalls on a black screen at boot. Compile single scripts with `tools/compile.py` and boot the game before committing. P5-00's one full-tree compatibility check ran only in a disposable `/tmp` copy and its rebuilt archives were discarded.
- Patches are tracked uppercase, as on Sierra's disks (D-048), but SCI Companion writes every compiled or saved patch in lowercase, replacing the uppercase file. Keep the working copy on a case-insensitive filesystem so that never leaves two files (D-037). `git status` cannot see a case-only change there, so run `python3 tools/uppercase_names.py --check` before committing.
- Headless DOSBox-X startup verifies initialization but does not traverse dialogue or animation branches; deterministic
  save-state playback and manual interaction remain necessary for behavioral verification.
- DOSBox-X reproduces the original interpreter environment but offers less direct SCI object/flag introspection than a
  dedicated reimplementation debugger, so source-level flag audits remain part of regression testing.

- **A headless smoke pass is not a boot pass.** The smoke checks only that `scidhuv` has not exited. A patch set that
  stalls on a black screen (D-028) would not exit, so it would pass (inferred, not observed); only the windowed boot
  shows the intro.
- **A routine comparison must start from the committed build, not a fresh compile.** 34 committed patches already
  differ from their source's compile (D-041); diffing two fresh compiles hides that drift.
- **Compare Sierra-patched scripts against `LB2_vanilla/`.** For the 23 scripts Sierra patched, the archive build is
  not vanilla (`SOURCE_PROVENANCE.md`).
