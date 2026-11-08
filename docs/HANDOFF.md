# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-11-08, session 62, on `master` (`5ab3399` plus this session's documentation changes): Manifold Tier 3. Session 59 holds the last game change: patch-only distribution, PLAY-002/004/008/009, alpha v0.10._

**Session owner:** none since session 62 (2026-11-08).

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

- Q-003 How the `tools/*.c` Wine helpers are built; blocks rebuilding one on a fresh machine.

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

### Session 56: 2026-10-14: Ziggy's Voice

**Contributor:** Claude Code and maintainer

**Goal:** Restore the sleaze the P2-08 rewrite took out of Ziggy.

**Done:**
- Rewrote all 118 Ziggy lines in `310.msg` (Act 1 speakeasy, 32) and `1890.msg` (Acts 2-6, 86) to the maintainer's brief: light accent, flirting between vanilla and P2-08, full scope (D-043). Manifests `act1-ziggy-voice-2026-10.json` and `act2-ziggy-voice-2026-10.json` record the pass.

- PLAY-019: fixed MuseumRgn's `sayAndHold`, which since P3-06 forwarded the always-zero caller argument as the message module, breaking every Act 3+ conversation with the seven MuseumRgn actors. Script 90 differs from the committed build by one instruction.

- PLAY-020 to PLAY-024: Ziggy's Pippin topic (cases 103 and 3) and Countess bluff gating (case 214), Pippin on Najeer, Steve's 7:30 meeting entering from the far side and waiting for both to arrive, and the act-break window (black picture 780 restored in Script 26, Art Deco corners for room 26 in Main). Main compiles with only that one change. Verified by routine-by-routine comparison and headless startup; runtime retest pending.
- Rewrote Ziggy's 19 lines in the party eavesdropping (`340.msg`) and intercom (`562.msg`) scenes in the same voice.
- Built `LB2/LB2-Redux-v0.05.zip` with the v0.04 layout, excluding saves and older zips: 949 files, 7,097,351 bytes; integrity test, vanilla archive MD5s, every tracked `LB2` file identical to the working tree, and headless startup of the extracted copy. Moved `alpha-playtest.html` (storage key `v005`) and `ALPHA_PLAYTESTING.md` to v0.05 and cut CHANGELOG `0.05-alpha`.
- PLAY-025 (after v0.05): room 550's floor lamp asked for a carbon-paper message Sierra never wrote when the lamp is off or its bulb is gone; it now uses the existing `(45, 39, 6)`. Script 550 differs by one instruction.

**Decisions:** D-043; D-042 amended (case + 200 for condition variants).

**Verified:** Only Ziggy's records changed text; record sets and reference bytes unchanged; documentation checks.

**Next session should start with:** The maintainer's fresh playthrough (Next steps 1-2).

### Session 55: 2026-10-14: Act 1 and 2 Playtest Findings

**Contributor:** Claude Code and maintainer

**Goal:** Fix the maintainer's findings from the last playthrough up to Act 2 before a fresh run.

**Done:**
- Logged PLAY-012 to PLAY-018 in `docs/PLAYTEST_CHECKLIST.md`.
- Room 335: the banner's Look plays a new Act 1 line about formal attire (`335.msg (1, 1, 2)`).
- RotundaRgn (Script 93): `PartyCase` plays a topic's case + 100 during Act 2 when it exists (D-042). Added Rameses on Ziggy `(1, 6, 109)` and Yvette on Tut `(1, 6, 116)`, which stops before the murder questions. Yvette's Pippin line `(1, 6, 3)` is present tense again. Ziggy now knows Heimlich `(1, 6, 10)` and Tut `(1, 6, 16)`.
- Room 350 (Scripts 350, 2350): the table outline covers the guests throughout Act 2, `sMeetSteve` meets beside the group on Laura's side, and `sExitNorth` no longer walks Laura's head over the lintel.
- Room 454: the Ankh's click target grows from 6x6 to 13x14 without overlapping nearby objects.
- Added a scratch renderer for LB2's pictures, views, and control screens (VGA 1.1 cels; SCI1.0 resource map) to check positions against the art; it confirmed the guests, doorway, and Ankh geometry.

**Decisions:** D-042.

**Verified:** Each rebuilt script compared routine by routine with its committed build shows only the intended changes; message files changed only in the listed records; headless DOSBox-X startup; base archive MD5s unchanged; documentation checks. Runtime retest pending.

**Next session should start with:** The maintainer's fresh playthrough, starting with Next steps 1.

### Session 54: 2026-10-14: Museum Selectors, Class Numbering, and the Inquest Layout

**Contributor:** Claude Code and maintainer

**Goal:** Finish session 53's deferred items: separate the museum lock from vanilla selectors 667/668, explain the 34 drifted patches, and stop batch compiles from leaving script windows open.

**Done:**
- Gave the P3-06 museum lock its own selectors, 681 `inConversation` and 682 `sayAndHold` (`selector_names.json`, `997.voc`, `MuseumRgn.sc`); rebuilt Script 90, which matches the committed build except for the selector IDs (D-039).
- `compile_any` gained `--is-open` and `--close`; `compile.py` waits for the patches and closes the window it opened.
- Rebuilt the 30 other drifted scripts in place, compared each with the committed build using a normalizing disassembler, and restored every committed patch. Differences are codegen except for the findings in D-040 and D-041.
- Rewrote the three indexed compound assignments (`Main` `SetFlag`/`ClearFlag`, `n027` `proc27_2`) as plain assignments; `Main` now compiles byte-identical to its committed patch and `proc27_2` matches the archive build (D-041).
- Fixed and rebuilt room 310 (`WrapMusic dispose:`), room 450 (class 47 for `WrapMusic`, value-preserving message case, standard `super doVerb:`), room 640 (`of Actions`; now a loose patch), and room 750 (object property blocks from `7d48893`, un-shifted `state`/`cycles`/`seconds`/`font`) (D-040).

- Built `LB2/LB2-Redux-v0.04.zip` from `f62ad5a` with v0.03's layout (game files at the root plus `msg/` and `src/`), excluding `LB2SG.*` saves (v0.03 had shipped the maintainer's saves) and older zips: 949 files, 7,096,350 bytes (rebuilt in session 55 with PLAY-012 to PLAY-018 and in session 56 with Ziggy's restored voice, which moved into CHANGELOG 0.04-alpha; the playtest page and guide gained matching checks and the page a fresh checklist storage key (now `v004r3` after the Ziggy check was added), because saved checks are stored by position). Moved `docs/alpha-playtest.html` to v0.04 with a "New in v0.04" card, checks for the five changed rooms, a v0.04 report template, and a fresh checklist storage key.

**Decisions:** D-040, D-041.

**Verified:** v0.04 zip integrity test, vanilla archive MD5s, changed patches equal to `HEAD`, and headless startup of the extracted copy. Script 90, 310, 450, 640, and 750 builds compared routine by routine against the committed, archive, and Sierra patch builds; 750's object sizes, property values, and slot writes match vanilla. Headless DOSBox-X startup; base archive MD5s unchanged; documentation and manual checks. Runtime retest pending.

**Next session should start with:** The maintainer's retest of rooms 90, 310, 450, 640, and 750 (Next steps 1).

### Session 53: 2026-10-13: Readable Selector Names

**Contributor:** Claude Code and maintainer

**Goal:** Make the source readable in SCI Companion by naming selectors without changing compiled output.

**Done:**
- Built `tools/selector_names.json` (563 IDs) by aligning `LB2/src` with the pinned Sluicebox publication and resolving disagreements from class definitions; cross-checked against the CD release's vocab 997 extracted from the maintainer's disc image (528 names in matching order). Added `tools/name_selectors.py` and applied it to `LB2/997.voc` and 218 source files (D-039).
- Verified with two full SCI Companion rebuilds (original vs. renamed source) and targeted reruns: every compiled script is byte-identical. Fixed the one difference by naming selector 343 `theControls`.
- Restored all playtested `.scr`/`.hep` patches from git afterwards; kept the regenerated `Interface.sco`, which fixes `Dialog`'s "Unknown class DItem" errors. Fixed `tools/make_test_copy.sh` for lowercase patch names.

**Decisions:** D-039 (supersedes D-032's numeric-selector rule).

**Verified:** Byte comparisons as above; headless DOSBox-X startup; base archive MD5s unchanged; documentation and manual checks.

**Next session should start with:** Give Redux's museum-actor uses of selectors 667/668 their own names (new IDs), then decide whether to rebuild the 34 scripts whose committed patches differ from current source.
