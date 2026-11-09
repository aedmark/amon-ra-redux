# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-11-08, session 66, on `master` (`8e18e27` plus this session's changes): the capture helpers are retired (D-051, D-052). Session 59 holds the last game change: patch-only distribution, PLAY-002/004/008/009, alpha v0.10._

**Session owner:** none since session 66 (2026-11-08).

**In one paragraph:** Phases 1 to 4 are done; Phase 5's entry gate is the clean DOSBox-X playthrough in
`PLAYTEST_CHECKLIST.md`. Alpha v0.10 is the current patch-only release (v0.09 was the first): `tools/package_patch.py` zips only Redux's
patch files, which players extract over their own floppy v1.000 copy. Findings
PLAY-001 to PLAY-037 are logged; most are fixed and confirmed, PLAY-037, PLAY-002, PLAY-004, PLAY-008, PLAY-009, and PLAY-012 to PLAY-024
await a retest, and PLAY-006 is open (Phase 5). Act 3 patrols (D-046) change Script 90's method tables and D-049 grows
Scripts 31 to 37's heaps, so Act 3 to 6 saves from earlier builds may not restore.

**Verified** (on `master` at `5ab3399`; game files last changed in `fa0e1ed`, 2026-10-18; Linux, Wine 11.21,
DOSBox-X 2026.10.01, Python 3.14.9)

Rows run this session say so; the rest are carried over with their date.

| Check | Result |
| --- | --- |
| `python3 tools/check_docs.py` (2026-11-08, session 62) | **0 errors, 0 warnings**, 18 files |
| `python3 tools/manual.py check docs/manual/amon-ra.manual.json` (2026-11-08, session 62) | passed, 31 entries |
| `python3 tools/check_layout.py` (2026-11-08, session 62) | **0 mismatches**: 221 scripts, 2,362 objects, 114 classes |
| Each fix: routine comparison against its committed build, headless startup, base archive MD5s (carried over; per session in the log) | only intended changes |
| Maintainer-confirmed in DOSBox-X (carried over, through 2026-10-17) | PLAY-003, PLAY-018, PLAY-025 to PLAY-036, the podium's repeat LOOK and DO |
| v0.10 package (carried over, 2026-10-17, session 59) | `LB2_vanilla/` plus the zip matches every `LB2/` game file and passes the headless smoke |

**Not verified**

- An end-to-end playthrough of every act.
- Session 54's rebuilt rooms (Script 90, 310, 450, 640, 750) and the podium's collision and Magnifier repeat.

**Gotchas**

- Message text: edit in the forked SCI Companion (`SCI Companion/`, D-038). `docs/dialogue/*.json` are historical
  records; re-running `tools/dialogue.py` would overwrite later editor changes.
- Interactive room objects: follow `CONTRIBUTING.md`'s reference-first workflow (D-034).
- Selector names live only in `tools/selector_names.json`; after a change run `python3 tools/name_selectors.py LB2`,
  restart SCI Companion (it reads `997.VOC` only at startup), and confirm byte-identical output (D-039). A selector
  must not share a name with an instance, class, or procedure used in a method.
- SCI Companion resolves other scripts' classes through `.sco` files: compile a changed class's script first
  (`Interface` before `Dialog`). Several committed `.sco` files predate the current source.
- SCI Companion ignores a game path on its command line and reopens the last game. Before any GUI action, confirm
  the loaded archive; if unsure, ask the maintainer.
- Class numbers: Redux's `Main` has `WrapMusic` 47 and `Actions` 127, the reverse of vanilla; check any
  Sierra-compiled script that names either (D-040). Avoid `(and c v)` for values and compound assignments to
  computed array indexes (D-041). Check multi-line `[localN` indexes against the archive build (PLAY-033).
- Compare against Sierra's retail patches in `LB2_vanilla/` where they exist, not the archive (`SOURCE_PROVENANCE.md`).
- Files in `LB2/` are uppercase on a case-insensitive exFAT drive (D-037, D-048); `core.fileMode` is false there.
  SCI Companion writes everything lowercase: `compile.py` renames its outputs; after other saves run
  `tools/uppercase_names.py` (`--check` before committing, since `git status` cannot see case-only changes).
- Compile one script at a time with `tools/compile.py`; never Compile All or rebuild resources (D-028). If a script
  drops out of SCI Companion's list, restore its patch files and restart with `wineserver -k`.
- Ask before a boot test while the maintainer may be playing.

## Next steps (in order)

1. Maintainer retest of PLAY-037 (Tut's Act 3 introduction, ankh and Dagger reactions, Carrington's Dagger line),
   PLAY-002 (Rocco's greeting on a second clean-cab ride), PLAY-004 (the barflies' Talk, Ask, Magnifier), and
   PLAY-008 (grey answered topics in Act 1 and the museum; reopening after a death, after O'Riley's folder,
   and at an act break), and PLAY-009 (Crodfoller's introduction and the starts of Acts 3 and 5, no quiz).
2. Publish v0.10 when ready (`LB2/LB2-Redux-v0.10.zip`, patch-only).
3. Retest PLAY-012 to PLAY-024 and session 54's rooms during the fresh playthrough (`PLAYTEST_CHECKLIST.md`).
4. Check the podium's collision from both sides and a Magnifier repeat.
5. PLAY-006 belongs to Phase 5; no other finding is open.
6. Begin P5-01 design only after the playthrough gate closes.

## Open questions for maintainers

None open. Q-003 was answered in session 63 (`docs/DECISIONS.md`).

## Session log

Newest first. Copy the template for each new session. Work done between sessions (a maintainer's commits, another
agent) gets a short entry too, written by whoever notices it. Past 10 entries, move the oldest to `docs/archive/`.

```
### Session N: YYYY-MM-DD: short title

**Contributor:** person or agent/tool
**Goal:**
**Done:** roadmap, PLAY, and decision IDs; files and behaviour changed
**Decisions:** D-numbers added
**Verified:** checks and their results; for each rebuilt script, the routine comparison and boot
**Not verified:** checks skipped or environments unavailable
**Problems / surprises:**
**Corrections:** earlier notes (here or in other docs) found wrong, and what was actually true
**Left undone:**
**Next session should start with:**
```

### Session 66: 2026-11-08: Retire the Clipboard Output Helpers

**Contributor:** Claude Code and maintainer

**Goal:** Retire the three unused helpers that wrote to the missing `dumps/`, and keep their history (D-052).

**Done:**
- Deleted `tools/copy_output.c`, `get_compile_log.c`, and `get_errors.c`; moved their untracked `.exe` files to the
  session scratch folder with the D-051 binaries.
- Wrote `docs/archive/RETIRED_TOOLS.md`: why the five capture helpers existed, what each did, the commit that holds its
  last source, and where to start if the need returns. Linked it from the archive README; removed the Claims vs. code
  row. Moved session 56 to the archive.

**Decisions:** D-052.

**Verified:** `git grep` found no use of the three outside today's notes. `python3 tools/check_docs.py`: 0 errors,
0 warnings.

**Not verified:** Nothing ran; no game or compile path uses these helpers.

**Left undone:** Other `tools/*.c` helpers may be unused too (only `compile_any`, `list_scripts`, and `list_windows`
are named in the docs); not audited.

**Next session should start with:** the maintainer's retests (Next steps 1).

### Session 65: 2026-11-08: Retire the hook.dll Capture

**Contributor:** Claude Code and maintainer

**Goal:** Retire `hook.dll` once it was confirmed that nothing needs it (D-051).

**Done:**
- Removed the DLL injection and the output-list scrolling from `tools/compile_any.c` and `compile_by_name.c`
  (114 lines); deleted `tools/hook_dll.c` and `inject_and_scroll.c`. Rebuilt the two compile helpers. Moved the
  untracked `hook.dll` and `inject_and_scroll.exe`, and the previous two compile helpers, to the session scratch folder.
- Updated TESTING's build recipe and ARCHITECTURE's state and Claims vs. code (three other helpers still write to the
  missing `dumps/`). Moved session 55 to the archive.

**Decisions:** D-051.

**Verified:** Both helpers build with `-Wall` and no warnings, and their sources contain no `hook`, `ListBox`, or `LoadLibrary`
references. `python3 tools/check_docs.py`: 0 errors, 0 warnings.

**Verified (maintainer-approved compile):** `python3 tools/compile.py rm230` through the rebuilt `compile_any.exe`
wrote `230.SCR` and `230.HEP` byte-identical to HEAD; `tools/uppercase_names.py --check` clean; SCI Companion stopped
with `wineserver -k`. No game file changed, so no boot test.

**Not verified:** `compile_by_name.exe` was rebuilt but not run (`compile.py` does not use it).

**Left undone:** `copy_output`, `get_compile_log`, and `get_errors` still write to the missing `dumps/`.

**Next session should start with:** the maintainer's retests (Next steps 1).

### Session 64: 2026-11-08: Helpers Find hook.dll Beside Themselves

**Contributor:** Claude Code and maintainer

**Goal:** Stop three helpers depending on a hardcoded `hook.dll` path.

**Done:**
- `tools/compile_any.c`, `compile_by_name.c`, and `inject_and_scroll.c` resolve `hook.dll` from their own location
  (`GetModuleFileNameA`, then `hook.dll` in the same folder) instead of
  `Z:\home\gordonk\PycharmProjects\amon-ra-redux\tools\hook.dll`. If it is missing, the two compile helpers say
  so and compile without it, as they effectively did before when injection failed; `inject_and_scroll` exits 1.
  Rebuilt the three `.exe` files with `i686-w64-mingw32-gcc -Wall` (old binaries kept in the session scratch folder).
- Recorded under ARCHITECTURE's Claims vs. code that `hook.dll` itself captures nothing: it writes to a `dumps/`
  folder that no longer exists, and nothing reads the file. `hook_dll.c` is unchanged. Moved session 54 to the archive.

**Decisions:** none.

**Verified:** All three build without warnings, and none contains the old path (`strings`). A test program with the
same function, run under Wine from `tools/`, resolved `O:\amon-ra-redux\tools\hook.dll` (Wine's drive for the exFAT
mount) and returned 1; run from a folder without `hook.dll`, it returned 0. `python3 tools/check_docs.py`: 0 errors,
0 warnings.

**Verified (maintainer-approved compile):** With SCI Companion on `LB2` (`CompileModifiedScriptsBeforeRun` 0),
`python3 tools/compile.py rm230` ran through the rebuilt `compile_any.exe`, printed no "hook.dll not found" line, and
wrote `230.SCR` and `230.HEP` byte-identical to HEAD; `tools/uppercase_names.py --check` clean; SCI Companion stopped
with `wineserver -k`. No game file changed, so no boot test.

**Not verified:** That `hook.dll` loaded inside SCI Companion (it logs nothing, since `dumps/` is gone).

**Corrections:** Session 63 called `/home/gordonk/PycharmProjects/amon-ra-redux` an old checkout. It is a symlink to
this repository (created 2026-10-12), so the "two" `hook.dll` copies were one file.

**Left undone:** Whether to repair or retire `hook.dll`'s capture (it has done nothing since `dumps/` was removed).

**Next session should start with:** the maintainer's retests (Next steps 1).

### Session 63: 2026-11-08: Helper Build Command and Incident Response

**Contributor:** Claude Code and maintainer

**Goal:** Answer Q-003 and record the maintainer's confirmation of the incident response.

**Done:**
- Pushed session 62 (`f4af14b`). The maintainer confirmed `SECURITY.md`'s incident response.
- Q-003: the helpers are 32-bit MinGW-w64 builds. Evidence: `i686-w64-mingw32` CRT paths and GCC strings in the
  binaries; imports limited to `KERNEL32`, `USER32`, and the UCRT; `tools/compile.py` has built a missing
  `compile_any.exe` with `i686-w64-mingw32-gcc` since `8d764df`. Recorded in TESTING's environment recipes,
  ARCHITECTURE's dependencies and state, and AGENTS.
- Found that three helpers load `hook.dll` from the old checkout path (`/home/gordonk/PycharmProjects/amon-ra-redux`);
  recorded under ARCHITECTURE's Claims vs. code. Moved session 53 to the archive.

**Decisions:** none.

**Verified:** All 24 `tools/*.c` built without errors in a scratch folder with GCC 16.2.0 (`-shared` for
`hook_dll.c`). 15 match the committed-era binaries' DLL imports; the other 9 differ only by extra UCRT import DLLs
in the older builds. The two `hook.dll` copies have the same MD5. `python3 tools/check_docs.py`: 0 errors,
0 warnings. The binaries in `tools/` were not replaced.

**Not verified:** A rebuilt helper was not run against SCI Companion.

**Left undone:** Pointing the three helpers at this repository's `hook.dll` (a code change; not requested).

**Next session should start with:** the maintainer's retests (Next steps 1).

### Session 62: 2026-11-08: Manifold Tier 3 (Docs Structure)

**Contributor:** Claude Code and maintainer

**Goal:** Bring HANDOFF, ARCHITECTURE, TESTING, SECURITY, CONTRIBUTING, and the documentation map up to the
Manifold template's structure (Tier 3).

**Done:**
- Pushed session 61 (`5ab3399`).
- `ARCHITECTURE.md`: a one-paragraph shape; Code map; Interfaces and data flow; every invariant names what enforces
  it (most are by hand), plus a new uppercase-names invariant; Boundaries; Dependencies with observed versions; State
  and caches; Failure modes; Claims vs. code (the 34 drifted patches, stale `.sco` files, `docs/dialogue/`, D-041's
  untested hazard). The diagram's "Decompile & Edit" label now reads "Edit source & messages", since the source came
  from Sluicebox's tools.
- `TESTING.md`: the suite table gains Proves and Does not prove columns and three rows (routine comparison, windowed
  boot, save checkpoints); fast and full sets; Before any run; Adding a check; Change-to-check matrix; Manual checks;
  Environment recipes; three pitfalls.
- `HANDOFF.md`: a stamped Verified table (commit, environment, which rows were carried over), branch and commit in
  Last updated, and the session-log template.
- `SECURITY.md`: an assets table with owners, secure development rules, security verification, and an incident
  response the maintainer has not yet confirmed. `CONTRIBUTING.md`: assumption check, Verify, Submit and review,
  Compatibility and migrations. `docs/README.md`: a Does not own column and an update-triggers table.
  `archive/README.md`: the retention line. Moved session 52 to the archive.

**Decisions:** none.

**Verified:** `python3 tools/check_docs.py`: 0 errors, 0 warnings in 18 files. The manual check passed.
`python3 tools/check_layout.py`: 0 mismatches. Code-map files and entry points checked against `LB2/src/`.

**Not verified:** No game files changed; no boot test needed. The headless-smoke pitfall (a black-screen stall would
pass) is inferred, not observed.

**Corrections:** The first code-map draft named a nonexistent `n090.sc`; Script 90 is `MuseumRgn.sc`.

**Left undone:** Q-003 (helper build command). The incident response in `SECURITY.md` needs the maintainer's
confirmation.

**Next session should start with:** the maintainer's retests (Next steps 1).

### Session 61: 2026-11-08: Manifold Tier 2 (AGENTS.md)

**Contributor:** Claude Code and maintainer

**Goal:** Bring `AGENTS.md` up to the Manifold template's sections and rules (Tier 2).

**Done:**
- Pushed session 60 (`f232b37`).
- `AGENTS.md`: added Zones and untrusted context, the template's while-working rules (session owner check, part
  against whole, loop back, stop on resistance, reconstruct the question, no silent assumptions, prefer enforcement),
  the review and consolidation steps in Finishing, Working agreement, Maintainer preferences, Protected areas, Names
  and terms, Engineering conventions, Environments, and Run and verify. Every existing rule is kept. The heading stays
  "Layout" because `tools/check_docs.py` validates that table's paths.
- The maintainer's answers: direct-to-master, agents commit and push only on request; adopt the Manifold writing rule;
  confirm before any SCI Companion GUI action, save-breaking change, release zip, or message-text change; report
  result, evidence, then gaps.
- Removed the em dashes from the live docs (DECISIONS, ROADMAP, ALPHA_PLAYTESTING). Added a Session owner line to
  current state. Q-003 records the unknown helper build command. Moved session 51 to the archive.

**Decisions:** none.

**Verified:** `python3 tools/check_docs.py`: 0 errors, 0 warnings in 18 files. Paths named in the new sections exist
(`LB2/997.VOC`, `LB2/src/rm750.sc`, `package_patch.py --mirror`).

**Not verified:** No game files changed; no boot test needed.

**Left undone:** Manifold Tier 3 (HANDOFF, ARCHITECTURE, TESTING, SECURITY, CONTRIBUTING structure).

**Next session should start with:** the maintainer's retests (Next steps 1), or Manifold Tier 3.

### Session 60: 2026-11-08: Manifold Tier 1 Adoption

**Contributor:** Claude Code and maintainer

**Goal:** Compare Redux with the expanded Manifold template (`the-manifold`, root template) and adopt its
checker and decision-record structure (Tier 1).

**Done:**
- `tools/check_docs.py` replaced by the template's checker: held tensions (`T-NNN`: duplicates, order, dangling
  references) and invisible or bidirectional control characters are now errors. It also reads
  `ALPHA_PLAYTESTING.md`, `PLAYTEST_CHECKLIST.md`, and `SOURCE_PROVENANCE.md`, which it skipped before.
- `DECISIONS.md`: the template's preamble and entry format (Alternatives and Review trigger fields from now on); every
  heading carries its first-recorded git date and status (D-008 superseded; D-032 and D-037 partly superseded); new
  Held tensions section (none held); open questions in the template's answered form.
- Moved session 50 to `archive/SESSION_LOG_2026_10.md`.

**Decisions:** none.

**Verified:** `python3 tools/check_docs.py`: 0 errors, 0 warnings in 18 files. Mutation check in a scratch copy: an
injected U+200B, a reference to an undefined held tension, and a broken link in a newly covered doc each produced an error.

**Not verified:** No game files changed; no boot test needed.

**Corrections:** Q-001's and Q-002's question text was never recorded; reconstructed from D-007 and D-008.

**Left undone:** Manifold Tiers 2 and 3 (AGENTS.md sections and rules; HANDOFF, ARCHITECTURE, TESTING, SECURITY,
CONTRIBUTING structure).

**Next session should start with:** the maintainer's retests (Next steps 1), or Manifold Tier 2 in `AGENTS.md`.

### Session 59: 2026-10-16/17: Patch-Only Distribution and Docs Review

**Contributor:** Claude Code and maintainer

**Goal:** Make a distributable package with no Sierra files (D-047), then review the docs.

**Done:**
- The maintainer created `LB2 (legal)/`: the retail game at its top level and Redux's files in `patched files/`.
  Removed the Sierra files from `patched files/` (archives, interpreter, installer, font, `MESSAGE.MAP`, `game.ini`,
  and the five patches identical to Sierra's), leaving 468.
- Added `tools/package_patch.py`: builds the patch-only zip and mirrors it into `patched files/`. Ignored
  `LB2 (legal)/` and `LB2/archive/`.
- Rewrote the tester guide's and page's install steps for a patch over the player's own floppy v1.000 copy, then moved
  both to v0.09. The maintainer's own v0.09 zip bundles `LB2_vanilla/` and `src/` for internal testing.
- D-048: all files at the top of `LB2/` and `LB2 (legal)/` renamed to uppercase (476 tracked, contents identical);
  `compile.py` uppercases a new patch, `make_test_copy.sh` uppercases older commits' patches. Folder roles recorded in
  `AGENTS.md`.
- Docs review: rewrote HANDOFF's current state; corrected stale facts (selector names, O'Riley's spelling, the stairwell
  room, the Act 5 save lockouts, the compile workflow) and trimmed duplicated prose across the live docs.

**Verified:** The retail copy plus the package reproduces every `LB2/` game file and passes the headless boot smoke
(case-insensitive extraction, and the tester guide's Linux recipe). A test copy of the renamed tree and one built from
the pre-rename commit both match and boot. Documentation and manual checks.

- PLAY-002: Rocco greets Laura by name on later clean-cab rides and goes straight to her destination (Script 250,
  `250.MSG`). PLAY-004: six `310.MSG` lines for the barflies' Talk, Ask, and Magnifier. Found that SCI Companion writes
  even existing patches in lowercase; added `tools/uppercase_names.py` to the SOP.

**Verified (PLAY-002/004):** Script 250 differs from its committed build only in `sHasPressPass` plus 16 equivalent
global reloads (D-041 drift); heap identical. Message files gain only the new records. Headless boot of a test copy.

- PLAY-008 / D-049: grey answered topics for the museum cast (Scripts 20, 90, 93, 31, 32, 35, 36, 37). Rebuilding
  Scripts 31 to 37 fixed a latent bug: their actors lacked `MuseumActor`'s 70th property (`inConversation`), so
  `TravelToRoom cue` read past them.

- PLAY-008 for Act 1: Crodfoller, Luigi, the street kid, Lo Fat, O'Flaherty, Ziggy, the bathroom man, and Steve
  (rooms 210 to 320); O'Flaherty's O'Riley topic reopens after the folder (flag 43). Every room build differs only
  by its assignment; heaps identical.

- PLAY-009 / D-050: removed the copy-protection quiz (rooms 230, 26, 420; new loose `230.MSG`). Each build
  differs only by the change; heaps identical.

- Built `LB2/LB2-Redux-v0.10.zip` with `tools/package_patch.py`: 469 patch files, 470,277 bytes, no Sierra files;
  `LB2_vanilla/` plus the zip matches every `LB2/` game file and passes the headless boot smoke. Mirrored into
  `LB2 (legal)/patched files/`. Moved the tester guide and page (storage key `v010`) to v0.10 and cut CHANGELOG
  `0.10-alpha`.

- Untracked the 18 Sierra files still in git (interpreter, installer, batch and error files, font, `MESSAGE.MAP`,
  text files, five unchanged retail patches); they stay on disk. The installer text files on disk, which git had
  converted to LF, were restored from `LB2_vanilla/`. Property-layout drift check of all 221 loaded scripts: no
  mismatches; a control with the pre-D-049 Script 31 was caught. Added it as `tools/check_layout.py`, with
  `tools/sci_archive.py` (archive reader and DCL decompressor).

**Verified (PLAY-008):** Scripts 20, 90, and 93 differ from their committed builds only in the new code; heaps
identical; misc topics added afterwards (Script 20 only, heap identical). Scripts 31 to 37 differ by the two-instruction assignment and one added property per actor, matching the
class. Headless boot of a test copy. Not yet seen in play.

**Next session should start with:** The maintainer's retest of PLAY-037, PLAY-002, PLAY-004, and PLAY-008.

### Session 58: 2026-10-16: Vats, Storeroom Crash, and Dagger Topic

**Contributor:** Claude Code and maintainer

**Goal:** Fix PLAY-033 to PLAY-035, found during the maintainer's v0.06 retest.

**Done:**
- The maintainer confirmed PLAY-018, PLAY-025, PLAY-026, and PLAY-028 to PLAY-032.
- PLAY-033: room 610's source came from a decompile that turned Sierra's array indexes (the vat number, held in the accumulator) into nested expressions: the next vat's `init:`, the climb side, and `handsOff`. Rewrote the vat setup in `rm610 init` and state 0 of `sClimbUpVat` and `sClimbDownVat` in Sierra's order. A scan of `src/*.sc` for the same multi-line index pattern found only these and one well-formed index in `MuseumRgn`.

- The maintainer confirmed PLAY-033, then hit PLAY-034: `Build Line Error` entering room 630. The snake oil bottle drawn on its shelf comes from `61.v56`, whose cels `tools/build_snake_oil_view.py` had encoded as literal runs crossing row ends. Fixed the encoder to work row by row and rebuilt the patch from the archive's View 61 (identical pixels, headers, palette). `335.v56` is already row-bounded.
- The maintainer confirmed PLAY-034. Confirmed that the floppy has no laundry exit motif (only sounds 260, 261 for the baseball trade, and 270); kept as Sierra shipped it.
- PLAY-035: O'Riley's dagger handoff (Scripts 90 and 93) now drops notebook clue 780 as well as item 11.
- Audited Script 90 after the maintainer asked why few characters wander. It matches Sierra's retail patch in `LB2_vanilla/` apart from Redux's intended changes; an earlier comparison against the archive build had wrongly suggested CD-derived code. Extended the audit to all 23 retail patch scripts (recorded in `SOURCE_PROVENANCE.md`): every Sierra fix is present. Act 3's stationary O'Riley (room 430) and Yvette (room 550) are Sierra's schedule; only actors in the off-screen pool (room -1) roam, via `wanderTimer` every 120 seconds.
- PLAY-036 / D-046, first pass: Watney's Act 3 walk to 500 starts Sierra's authored patrol (room 370); O'Riley gets an Act 3 patrol of 430, 450, and 454 with 20-45 second pauses (Script 90), resumed after the scenes in rooms 490 and 500. Second pass: Olympia's 11:15 walk to 520 and the redirects in rooms 600 and 650 start Sierra's authored patrol in Act 3 (Scripts 22, 600, 650); Yvette stays in room 510 from eavesdropping count 7 and strolls between six spots, leaving before count 10, at 12:45, or outside Act 3 (Scripts 90 and 510).
- Built `LB2/LB2-Redux-v0.07.zip` with the v0.06 layout, excluding saves and older zips: 952 files, 7,109,267 bytes; integrity test, vanilla archive MD5s, and every tracked `LB2` file identical to the working tree. Moved `alpha-playtest.html` (storage key `v007`) and `ALPHA_PLAYTESTING.md` to v0.07 with checks for PLAY-033 to PLAY-036, and cut CHANGELOG `0.07-alpha`. Headless startup of the extracted copy was skipped while the maintainer may be playing.
- The maintainer confirmed PLAY-033 to PLAY-036. PLAY-037: Tut's Act 3+ introduction (case 82), his reactions to the ankh and Dagger, Carrington's Dagger reaction, and Yvette's ankh answer; Script 90 and `1883`/`1885`/`1886.msg`. Notebook audit of all ankh (case 47) and Dagger (case 38) answers found only Yvette's out of date. Player-facing docs now say "Dr. Carrington" where v0.05 and v0.07 had used the script name "Watney", which spoils his identity.
- Built `LB2/LB2-Redux-v0.08.zip` with the v0.07 layout, excluding saves and older zips: 952 files, 7,109,601 bytes; integrity test, vanilla archive MD5s, and every tracked `LB2` file identical to the working tree. Moved `alpha-playtest.html` (storage key `v008`) and `ALPHA_PLAYTESTING.md` to v0.08 with PLAY-037 checks, and cut CHANGELOG `0.08-alpha`. Headless startup of the extracted copy skipped while the maintainer may be playing.

**Verified:** Routine-by-routine comparison: the new build differs from the committed one only in `rm610 init`, the two climb scripts, and one equivalent codegen change; the three rewritten routines match the archive build apart from codegen style and P1-02's removed save-icon lockout. Heap unchanged. Room 630's script and properties compared with the archive build: equivalent. Rebuilt `61.v56` decoded and checked row by row. Scripts 90 and 93 differ from their committed builds only by the `dropCluesCode` call; heaps unchanged. Script 90, 22, 370, 490, 500, 510, 600, and 650 builds differ from the committed ones only in the PLAY-036 changes plus equivalent codegen in room 500; Script 90's heap keeps every property value but its method-table offsets shift. Runtime retest of PLAY-037 pending.

**Next session should start with:** The maintainer's retest of PLAY-037.

### Session 57: 2026-10-15: Act 3 and 4 Findings

**Contributor:** Claude Code and maintainer

**Goal:** Research the maintainer's Act 3-4 findings, agree a plan, then fix them.

**Done:**
- PLAY-025 to PLAY-031 logged and fixed: room 550 lamp message, room 530 bulb (flag 184), room 520 player-initiated passage (D-044), the Countess's voice (D-045), room 510 Thinker messages, room 560 police-file book, and the room 562 intercom click areas.
- Found and fixed a bug in the scratch renderer (SCI1.1 cel offsets are 16-bit with the key at byte 8), which had misplaced small sprites; PLAY-018's ankh area was re-sized from correct geometry.
- New loose message files `510.msg`, `520.msg`, and `530.msg`, created from their exact archive copies.
- Confirmed Olympia raising the Thinker's head is vanilla behavior.
- Maintainer retest of PLAY-027 found the open panel unclickable (open cel is one blank pixel) and a soft lock on entry (pathfinding toward an unwalkable point); fixed with a doorway click area, an approach point, and straight moves. A second retest still soft-locked: the open panel's one-pixel cel lies on the straight path and blocked Laura; the panel and Laura's scripted walk now ignore actors (Laura also ignores control until room 666 normalizes her). PLAY-032: gave the room 454 footprint noun 3. The maintainer confirmed the passage works (2026-10-16).
- Built `LB2/LB2-Redux-v0.06.zip` with the v0.05 layout, excluding saves and older zips: 952 files, 7,107,354 bytes; integrity test, vanilla archive MD5s, and every tracked `LB2` file plus the three new message files identical to the working tree. Moved `alpha-playtest.html` (storage key `v006`) and `ALPHA_PLAYTESTING.md` to v0.06 with checks for the new fixes, and cut CHANGELOG `0.06-alpha`.

**Decisions:** D-044, D-045.

**Verified:** Each rebuilt script compared routine by routine with its committed build shows only the intended changes; message files changed only in the listed records; headless startup; base archive MD5s unchanged; documentation checks. Runtime retest pending.

**Next session should start with:** Publish v0.06 when the maintainer is ready; collect retests of PLAY-018, PLAY-025, PLAY-026, and PLAY-028 to PLAY-032.
