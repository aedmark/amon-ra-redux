# Architecture

How Redux patches the DOS floppy v1.000 release (D-001) with loose files (D-002), and how each subsystem it changes
works. The floppy is a hybrid SCI1/SCI1.1 build (D-028). This file says what is; why lives in
[DECISIONS.md](DECISIONS.md). Update it when the shape changes (a subsystem, tool, or boundary added, moved, or
retired), not for every fix inside one.

## The shape, in one paragraph

Sierra's interpreter (`SCIDHUV.EXE`) in DOSBox-X loads `LB2/RESOURCE.000` through `RESOURCE.MAP`, but any numbered
loose file beside them (`N.SCR`/`N.HEP` script and heap, `N.MSG` messages, `N.V56` views, `997.VOC` selector names)
replaces that resource. Redux is that set of loose files. Its script source is `LB2/src/*.sc`, reconstructed with
Sluicebox's tools (`SOURCE_PROVENANCE.md`) and compiled one script at a time by SCI Companion under Wine, driven by
`tools/compile.py`; message text is edited in SCI Companion's message editor (D-038). `tools/package_patch.py` zips
the patch files, minus anything Sierra shipped, for players to extract over their own retail copy (D-047). Nothing
runs on a network.

## System overview

```
                                 +-------------------------+
                                 |   SCI Companion (Wine)  |
                                 +------------+------------+
                                              |
                   Edit source & messages     | Compile Source (.sc)
                   +--------------------------+--------------------------+
                   |                                                     |
                   v                                                     v
         +-------------------+                                 +-------------------+
         |  Source (.sc)     |                                 |  Loose Patches    |
         |  Messages (.msg)  |                                 |  <num>.SCR/.HEP   |
         |  Palettes & Views |                                 |  <num>.MSG        |
         +-------------------+                                 +---------+---------+
                                                                         |
                                                                         v
+----------------------------------------------------------------------------------+
|                              Game Directory (LB2/)                               |
|                                                                                  |
|  Loose Overrides: 0.SCR, 13.SCR, 20.SCR, 440.SCR, 500.SCR, 0.MSG ... (Priority)  |
|  Base Archives:   RESOURCE.000, RESOURCE.MAP, RESOURCE.CFG                       |
+-----------------------------------------+----------------------------------------+
                                          |
                                          v
                              +-----------------------+
                              |       DOSBox-X        |
                              |   Runtime Execution   |
                              +-----------------------+
```

## Core components

| Component | Files / Scope | Role |
| --- | --- | --- |
| **Base assets** | `LB2/RESOURCE.000`, `LB2/RESOURCE.MAP`, `LB2/VERSION` | Immutable retail archives; pristine copies in `LB2_vanilla/`. |
| **Sierra's retail patches** | 23 loose scripts shipped with the floppy (`LB2_vanilla/`) | Vanilla behavior for those scripts; Redux builds contain all their fixes (`SOURCE_PROVENANCE.md`). |
| **SCI Companion** | `SCI Companion/SCICompanion.exe`, untracked build of the maintainer's fork ([aedmark/SCICompanion](https://github.com/aedmark/SCICompanion)) | Runs under Wine to edit and compile scripts, save messages (D-038), and inspect polygons. Class and kernel docs in `SCI Companion/Help/`. |
| **Loose patches** | `LB2/*.SCR`, `*.HEP`, `*.MSG`, `*.V56`, `*.VOC` (uppercase, D-048) | Override archive resources by number. |
| **Distribution** | `tools/package_patch.py`, `LB2 (legal)/` | Zips only Redux's patches for extraction over a retail copy (D-047). |
| **Testing harness** | `./tools/run_dosbox.sh` | Sierra's interpreter in DOSBox-X with the checked-in configuration. |
| **3x manual** | `docs/manual/` | What/How/Why entries validated against `manual.schema.json`, built to `manual.html`. |

## Key subsystem architectures

### 1. Notebook (Script 20)
- **Vanilla:** five steps per question: Ask icon, character, category tab, topic, confirm.
- **Redux (P1-01, D-003):** Script 20's `inNotebook init` opens on the People tab or the last active tab; a
  double-click in `NotebookItem doVerb` confirms the topic.

### 2. Dialogue, identity, and museum actors (messages; Scripts 21, 90, 93, 335)
- **Text only (P2-03, D-007):** CD voice tracks are omitted; restored murder dialogue is `.MSG` text. Talker hooks
  stay intact for a future voice pack.
- **Historical text (P2-04, D-012):** loose `250.MSG`, `270.MSG`, and `310.MSG` fix the Pippi, radiotelephone, and
  *The Sun Also Rises* references for the game's late-1926 setting.
- **Acquaintance routing (P2-05, D-013):** Scripts 35, 36, and 90 check acquaintance flags 110..115 before Talk; an
  unset flag plays the condition-80 introduction (Act 3+ Tut: case 82, D-042).
- **Steve continuity (P2-06, D-014):** Script 240 sets flag 122 on an Act 1 Talk or Ask; Scripts 330, 335, and 350
  require it for the romantic museum sequences.
- **Dagger hand-off (P2-07, D-015):** modules 1884, 1885, and 1887..1892 react to the real artifact. O'Riley's actors in
  Scripts 90 and 93 take it on verb 22 with `(gEgo put: 11)` and drop notebook clue 780 (PLAY-035).
- **Party lines (D-042):** RotundaRgn's `PartyCase` plays case + 100 during Act 2 when it exists.
- **Answered topics (PLAY-008, D-049):** museum and Act 1 Ask sites set `global178` (character bit + 1); Script 20 greys
  topics whose bit is set in the asked grid (`global296`, one word per topic) and commits the chosen topic on its
  next open, after the character's own first-time check.
- **Identity acquisition (P2-01, D-009, D-033):** room 335's benefit register (Look, Hand, Magnifier) records Steve,
  Heimlich, Yvette, Rameses, Countess, Olympia, and Tut; never Ziggy, Ernie, or Watney, whose clue 272 comes from his
  police file in room 560. Script 21's `addCluesCode` stops on a duplicate instead of writing past the array. The
  podium's footprint is part of Script 2335's barred polygon, its approach is `(186, 180)`, and room 335 rebinds that
  polygon to static points for old saves without allocating or writing through saved pointers (an attempt to do so
  conditionally caused Error 1). It consumes unsupported follow-up dispatches (D-035) and uses `sightAngle` -1 and
  `approachDist` 4 so repeats take the deferred `CueObj` path (D-036). Lo Fat (room 270) foreshadows Heimlich and
  Olympia unnamed and introduces Yvette.
- **Conversation lock (P3-06, D-021):** Script 90's `sayAndHold` (selector 682) sets `inConversation` (681), stops the
  actor's mover, and passes `museumDialogueResume` as the message callback; `TravelToRoom` holds while locked and
  re-enters its state on dismissal. Script 22 keeps O'Riley past 10:15 in Acts 3 and 4.
- **Act 3 patrols (D-046):** Watney (the man posing as Carrington) and, from 11:15, Olympia start Sierra's authored
  `wander` patrols; O'Riley patrols 430, 450, and 454 with 20 to 45 second pauses via `cue`/`wander` overrides;
  Yvette strolls room 510 between eavesdropping scenes. Script 90's new methods shift later objects' method tables.

### 3. Save availability (Scripts 0, 17, 937, 525, 560, 565, 610)
- **Vanilla:** the save icon is disabled in chase and corpse rooms.
- **Redux (P1-02, D-004):** icon 7 is protected in `IconBar disable:`, `handsOn`, and `LBRoom setInset:`, and the room
  lockouts are removed. Script 990's slot search breaks on a match, so new saves no longer overwrite slot 0.

### 4. Progression and scheduling (Scripts 22, 26, 250, 454, 510, 560, 610, 630)
- **Act 1 errands (P3-05, D-020, D-030):** Script 22 stores press pass, docks, baseball, and Ziggy as `global124` bits
  1, 2, 4, 8. The dirty taxi (claim ticket for Lo Fat's gown) now needs only the press pass `(proc0_10 1)`, a prior
  clean ride (flag 125), and no ticket yet (flag 27).
- **Act transitions (P3-03, D-017):** there is no 14-eavesdrop gate. Authored sequences call room 26 (`actBreak`);
  Act 2 ends with room 454's Pippin discovery. `global111` orders door-listening and character scenes in rooms 510,
  560, and 630 (Act 3 runs 0 to 10; the act break sets 11; Script 22 may set 15 at 3:00). Do not replace it with a
  clue threshold: skipping values suppresses scenes and reinterprets saves.
- **Act 2 expansion (P5-01, D-018):** new activities must layer onto the authored transitions and `global111`, with
  explicit clue, score, message, and old-save behavior.

### 5. Hazard warnings (Scripts 520, 530)
- **Dark stairwell (P3-04, D-019):** with the bulb out (flag 32), crossing the north boundary runs `sWarnDarkStairs`:
  Laura steps back and gets the existing `darkPassage` warning (noun 11, verb 1, condition 2). Bulb item 23 restores
  the lit route; the lantern (item 15) is no solution because its timer puts it out below room 730. Flag 184 tracks a
  bulb that burned out this visit (PLAY-026).
- **Olympia's passage (D-044):** the skull in room 520 opens or closes the panel; Hand on the open panel, or walking
  in, enters. Room 666's lantern window and bat death are unchanged.

### 6. Item safety (Scripts 0, 15, 610)
- **Act 5 supply audit (P3-01, D-005):** on first entering Act 5 (`global123` 5, flag 123 unset), Main restores
  missing items 10 (wire cutters), 14 (snake oil), and 16 (cheese) and refills an empty `global150` to four; flag 123
  makes it one-time.
- **Snake oil (P3-02, D-016):** `global150` is the four-charge counter. Script 15 shows View 61 cel 0 with charges and
  the red-X cel 1 at zero (`61.V56`, encoded row by row: PLAY-034). Room 610's jar refills a non-full bottle in one
  action and holds three portions.

### 7. Evidence, inquest, and scoring (Scripts 26, 454, 560, 750)
- **Police file (P4-01, D-022):** room 560's special volume (now its whole rectangle, PLAY-030) and the bookcase open
  the inset; looking at the exposed file adds clues 793 and 272, as Take does.
- **Evidence review (P4-02, D-023):** room 454's footprint close-up sets bit 179. After question 16, Script 750
  separately credits the Ankh (item 20), Pippin's notepad (21), and footprint plus Yvette's shoe (30) with points
  180..182, explaining that none proves guilt.
- **Best evidence (P4-03, D-024):** Sierra's 13-item hint-book list. Bits 155 (dagger acquired), 170 (carbon paper
  read), and 183 (police file seen) stand in for surrendered, consumed, or untaken items.
- **Dagger outcome (P4-04, D-025):** feedback uses the quiz states; at the epilogue, `global126` is rebuilt from murder
  success plus recovery (item 11 or bit 155), so the newspaper, scene, and 19 Script 785 cards follow physical history.
- **Grades (P4-05, D-026):** Script 26 divides cumulative `global15` by `5/13/38/48/51` (vanilla attainable
  `5/12/37/47/50` plus point 179); the introduction is ungraded. The three review points raise the final raw total to 54.
- **Required and bonus questions (P4-06, D-027):** questions 1..11 decide the verdicts; 12..16 run in
  `sBonusQuestions`, which writes neither verdict flag.

## Code map

Where to look for what. The subsystem sections above name the scripts for each fix.

| Area | Where | Entry point | Talks to |
| --- | --- | --- | --- |
| Game globals, flags, item safety | `LB2/src/Main.sc` (Script 0) | the `LB2` class (of `Game`) and the flag procedures | every script |
| Rooms | `LB2/src/rmN.sc` | the room's `init` and `doVerb` | regions, Main, messages |
| Notebook | `LB2/src/inNotebook.sc` (Script 20) | `inNotebook` | Script 21 (clues), the Ask sites |
| Scheduler | `LB2/src/triggerAndClock.sc` (Script 22) | the act clock and triggers | museum actors, rooms |
| Museum actors | `LB2/src/MuseumRgn.sc` (90), `RotundaRgn.sc` (93), actor scripts 31 to 37 (e.g. `aErnie.sc`) | `MuseumActor`, `TravelToRoom` | Scripts 20, 22 |
| Selector names | `tools/selector_names.json`, `LB2/997.VOC` | `tools/name_selectors.py` | SCI Companion (reads `997.VOC` at startup) |
| Compile driver | `tools/compile.py`, `tools/compile_any.c` | `python3 tools/compile.py <script>` | SCI Companion's GUI under Wine |
| Release | `tools/package_patch.py` | `python3 tools/package_patch.py <version>` | `LB2_vanilla/` (to leave Sierra's patches out) |
| Archive reader | `tools/sci_archive.py` | `get`, `script_numbers` | `RESOURCE.MAP`/`RESOURCE.000`; used by `check_layout.py` |
| 3x manual | `docs/manual/amon-ra.manual.json` | `tools/manual.py` | `manual.schema.json`, `manual.html` |

## Interfaces and data flow

```text
LB2/src/N.sc -> SCI Companion (via compile.py) -> LB2/N.SCR + N.HEP (+ LB2/src/N.sco) -> interpreter
SCI Companion message editor -> LB2/N.MSG -> interpreter
tracked LB2 patches -> package_patch.py -> LB2-Redux-vX.YY.zip -> player's retail copy
```

| Interface | Producer | Consumer | Contract / compatibility |
| --- | --- | --- | --- |
| Loose patch files | SCI Companion | Sierra's interpreter | Uppercase names (D-048); the heap layout must match the hybrid build's (D-028), or the game crashes |
| `.sco` class files | SCI Companion | SCI Companion, compiling other scripts | A changed class's script compiles first (`Interface` before `Dialog`) |
| `997.VOC` | `tools/name_selectors.py` | SCI Companion, at startup | Selector IDs never move; Redux-only selectors from 681 (D-039) |
| Saved games (`LB2SG.*`) | the interpreter | the interpreter, in a later build | A save restores only if every loaded script's heap and method tables are unchanged; changes that break this name the saves they affect (D-044, D-046, D-049) |
| Release zip | `tools/package_patch.py` | players | Patch files only, uppercase, extracted over floppy v1.000 (D-047) |

## Invariants

Rules that hold everywhere. Each names what enforces it; "by hand" means a workflow step, not a check that refuses.

1. **Archive immutability:** never modify `RESOURCE.000` or `RESOURCE.MAP`; every fix is a loose file. Enforced by:
   `.gitignore` keeps them untracked; their MD5s (`SOURCE_PROVENANCE.md`) are compared by hand.
2. **Floppy art:** no CD background graphics replace the floppy's (P1-06). Enforced by: nothing.
3. **Voice:** CD voice tracks stay excluded; talker hooks stay intact (D-007). Enforced by: nothing.
4. **Save compatibility:** saves (`LB2SG.*`) must restore safely; changes that add objects, locals, or methods to a
   loaded script are noted with the saves they affect (D-044, D-046). Enforced by: `tools/check_layout.py` (property
   counts against classes, D-049); heap and method-table comparisons by hand.
5. **Hybrid build (D-028, D-029):** SCI1.1 scripts with an SCI1-style 6-byte `RESOURCE.MAP`. Compile one script at a
   time with `tools/compile.py`; never Compile All or rebuild resources in `LB2/`; boot after every compile.
   Enforced by: `compile.py` compiles one script; nothing stops Compile All in the GUI; the boot test is by hand.
6. **Compiler-facing source (D-032, D-039 to D-041):** `LB2/src/` is a 221-script Sluicebox-annotated reconstruction
   of the effective Redux bytecode, with one readable name per selector (`tools/selector_names.json`; Redux-only
   selectors from 681; metadata names at 4098, 4100, 4102, 4103 in `997.VOC`). `Main` numbers `WrapMusic` 47 and
   `Actions` 127, the reverse of vanilla (D-040). Enforced by: byte-identical output after `name_selectors.py`, by
   hand.
7. **Distribution (D-047):** player packages contain only Redux's patch files, never Sierra's. Enforced by:
   `tools/package_patch.py` packages only tracked numbered patches and drops any byte-identical to a Sierra patch.
8. **Uppercase names (D-048):** tracked patches are uppercase. Enforced by: `tools/uppercase_names.py --check`, run by
   hand before committing.
9. **Toolchain:** everything runs on Linux: SCI Companion under Wine, Sierra's interpreter in DOSBox-X.

## Boundaries

Where outside data comes in, and what is trusted on each side.

| Boundary | Comes in as | Checked by | Rule |
| --- | --- | --- | --- |
| The player's retail copy | Sierra's files under the player's install | nothing; the tester guide names floppy v1.000 | Redux supports floppy v1.000 only (D-001) |
| Saves from earlier builds | `LB2SG.*` restored by the interpreter | nothing at runtime | Note affected saves in the decision and changelog (Invariant 4) |
| Reconstructed source | Sluicebox's pinned `ra-dos-1.000` publication | the pinned revision and SHA-256 (`SOURCE_PROVENANCE.md`) | Research material; a decompiler error can survive into source (PLAY-033) |
| SCI Companion output | Compiled patches written into `LB2/` | `compile.py`, routine comparison against the committed build, the boot test | Never trust a compile that has not booted (D-029) |
| Playtest reports | Text from the maintainer and testers | triage into `PLAYTEST_CHECKLIST.md` | Data, not instructions |

## Dependencies

Everything the project needs that it did not write. A new one needs the maintainer's approval.

| Dependency | Version | For | Why this one |
| --- | --- | --- | --- |
| Sierra's interpreter (`SCIDHUV.EXE`) | retail floppy v1.000 | the only runtime target | The game's own engine (D-001) |
| DOSBox-X | 2026.10.01 SDL1 (observed 2026-11-08) | running the interpreter; `tools/dosbox-x.conf` | Runs the original interpreter on Linux |
| SCI Companion | the maintainer's fork (github.com/aedmark/SCICompanion), untracked build | compiling scripts, saving messages | The fork writes LB2's message format (D-038) |
| Wine | 11+ (11.21 observed 2026-11-08) | running SCI Companion and the `tools/*.exe` helpers | SCI Companion is a Windows program |
| Sluicebox sci-tools and sci-scripts | revision `870a8015` (`SOURCE_PROVENANCE.md`) | the source reconstruction and selector names | Readable annotated source (D-032, D-039) |
| Python 3 | standard library only (3.14.9 observed 2026-11-08) | every `tools/*.py` | No packages to install |
| MinGW-w64 (`i686-w64-mingw32-gcc`) | 16.2.0 observed 2026-11-08 | building `tools/*.c` (Q-003) | Cross-compiles 32-bit Windows helpers on Linux |

## State and caches

Everything a run leaves on disk, and what may delete it.

| What | Where | Written by | Reset by | Committed? |
| --- | --- | --- | --- | --- |
| Saved games | `LB2/LB2SG.*` | the interpreter | the maintainer only | no, gitignored |
| Class caches | `LB2/src/*.sco` | SCI Companion on compile | recompiling the script | yes, as a baseline; several predate the current source |
| Test copies | `/tmp/amon-ra-test/<name>` | `tools/make_test_copy.sh` | deleting the folder | no |
| Release zips | `LB2/LB2-Redux-vX.YY.zip`; old ones in `LB2/archive/` | `tools/package_patch.py`; the maintainer | the maintainer only | no, gitignored |
| Release assembly | `LB2 (legal)/patched files/` | `tools/package_patch.py --mirror` | `--prune` | no, gitignored |
| SCI Companion settings | the Wine registry (`CompileModifiedScriptsBeforeRun` must be 0) | SCI Companion | by hand | no |
| Helper binaries | `tools/*.exe`, `tools/hook.dll` | `i686-w64-mingw32-gcc` (Q-003); `compile.py` rebuilds a missing `compile_any.exe` | rebuilding | no, gitignored |

## Failure modes and observability

| Failure | What the maintainer sees | Detection | Recovery |
| --- | --- | --- | --- |
| A bad patch set | Black screen at boot, or an "Oops! Error n" dialog | The boot test (D-029) | Bisect with `tools/make_test_copy.sh` (`TESTING.md`) |
| Resource rebuild or Compile All | A 5-byte-map volume; the game stalls on a black screen | Archive sizes against `LB2_vanilla/` | Restore the archives from `LB2_vanilla/` (D-028) |
| Heap larger than committed | An extra entry per object; the game crashes | Byte comparison with `git show HEAD:LB2/N.HEP` | Fix SCI Companion's version setting or `.sco` caches |
| Save no longer restores | An error or wrong state after restoring | Playtest | Document the affected saves (Invariant 4) |
| Script missing from SCI Companion's list | `compile.py` cannot find it | `wine tools/list_scripts.exe` | Restore its patch files; restart with `wineserver -k` |
| Lowercase patch beside an uppercase one | Two files on ext4, or a clobbered patch | `tools/uppercase_names.py --check` | Work on the case-insensitive drive (D-037) |

The interpreter has no log. A headless DOSBox-X run proves only that `scidhuv` is still running; what the screen
shows comes from the maintainer.

## Claims vs. code

Places where a doc, a name, or a committed file says more than the code does. Remove a row when the code catches up.

- 34 committed patches do not match a fresh compile of their source. The differences reviewed were equivalent codegen
  (D-041), but the source does not reproduce those builds byte for byte; compare routine by routine before
  replacing one.
- Several committed `.sco` files predate the current source.
- `docs/dialogue/*.json` look like the dialogue source; the `.MSG` files edited in SCI Companion are (D-038).
- `tools/hook.dll` is injected into SCI Companion on every compile to capture its `DrawTextA` text, but it writes to
  `Z:\home\gordonk\PycharmProjects\amon-ra-redux\dumps\compiler_captured.txt` (a symlink to this repository),
  and `dumps/` no longer exists, so it captures nothing. Nothing reads that file.
- D-041's compound-assignment hazard rests on SCI Companion's and ScummVM's models of the stack, not on a DOSBox-X run
  of this interpreter.
