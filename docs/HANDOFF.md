# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-16, session 58: PLAY-033 to PLAY-036 and alpha v0.07 (D-046 Act 3 patrols)._

**Where things stand, in one paragraph:** Alpha v0.01 is public in the SQH Discord; alpha v0.02 (`LB2/LB2-Redux-v0.02.zip`, built from `master` at `43b1fbc`) is packaged and its tester guides are updated, pending publication. The room 335 benefit podium remains at `(190, 174)` with visual bounds `nsTop: 148, nsLeft: 182, nsBottom: 174, nsRight: 198` and fixed priority 12. Script 2335's existing 14-point barred room polygon reaches `(190, 176)` around the podium, and Script 335 routes Look/Hand/Magnifier to `(186, 180)` in front of the ledger. Old saves rebind that same polygon object to current static points without heap writes or new objects. Script 21's duplicate-clue repair prevents the prior Error 5 memory corruption. The remaining one-frame “interesting approach” flash was traced to the global fallback for an unsupported verb dispatch occurring before the valid podium dispatch on exact-position repeats. The podium now handles its three intended verbs normally and locally consumes any unsupported dispatch instead of forwarding it to the global narrator (D-035). The flash persisted, and occurred only on the engine's immediate-dispatch ending, when Laura was already in place. The podium now sets `sightAngle` -1 and `approachDist` 4, so repeats take the same deferred `CueObj` path as a fresh approach (D-036). The maintainer confirmed in DOSBox-X that repeat LOOK and DO show only the guestbook response. Saved games no longer overwrite slot 0 (Script 990 fix). Session 54 found that Redux's `Main` numbers `WrapMusic` and `Actions` the reverse of vanilla, which broke Sierra-compiled rooms 450 and 640 and the archive-derived room 310, and that the committed room 750 inquest had every object property shifted one slot; all four now build from corrected source and await a runtime retest (D-040). Drifted patches stay unless their script changes; `Main`'s and `n027`'s indexed compound assignments are rewritten, and `Main` now rebuilds byte-identical to its committed patch (D-041).

**Verified** (2026-10-12, Linux workspace)

| Suite | Result |
| --- | --- |
| Room 335 podium & collision | **Compile/static pass: 16x26 view at (190, 174), 14-point poly2335a boundary reaches (190, 176), approach (186, 180), fixed priority 12, stable old-save static-pointer reapply, Script 21 duplicate-clue repair, and object-local unsupported-dispatch guard; Scripts 21/335/2335 compiled; runtime retest pending** |
| Register signing & inspection | **Pass: flag 124 gating; Do signs with flourish [17,4,0]; repeat Do reports already signed [17,4,1]; Look reflects signature [17,1,1]; 335.MSG matches user text** |
| P2-01 identity-flow refinement | **Compile/static pass: explicit register records clues 263, 265, 266, 268..271; Lo Fat records only Yvette; disguised Carrington cannot add Watney 272** |
| Public alpha test plan | **Updated for v0.02: Markdown guide, Neocities page (download link, fresh checklist storage key, v0.02 report template), What's new section, and register/save-slot checks; v0.02 zip built from `43b1fbc` (946 files, no saves), vanilla archive MD5s and committed patches verified, extracted copy boots** |
| PLAY-003/010/011 Act 1 follow-up | **Pass: music rotation and bathroom continuity maintainer-verified; Scripts 26/310 compile; two new Ziggy tuples parse and reapply idempotently** |
| P2-08 Act 6 final inquest | **Pass: all 77 module-750 records structurally compared; exactly 28 approved text changes; all tuple/talker/reference metadata and ending routes preserved** |
| P5-00 coherent source inventory | **Pass: 221 `.sc` + 221 `.sco`; no nested duplicate tree or unknown-property placeholders** |
| P5-00 isolated compilation | **Pass: representative and blocker scripts at 0 errors/0 warnings; disposable Compile All captured no errors** |
| P2-08 Act 5 and ending closure | **Pass: 169 records across modules 710, 715, 730, 750, and 770 structurally compared; 64 intended text changes; all tuple/talker/reference metadata and untargeted text preserved** |
| P2-08 Act 4 closure | **Pass: 255 records across modules 600, 1510, and 1889 structurally compared; 19 intended text changes; all tuple/talker/reference metadata and untargeted text preserved** |
| P2-08 Act 3 final closure | **Pass: 626 records across 10 touched modules structurally compared; 155 reviewed records current and idempotent; all routing metadata and untargeted text preserved** |
| P2-08 Act 3 O'Riley closure | **Pass: 91 records across modules 454 and 1550 structurally compared; 7 reviewed records current and idempotent; all routing metadata and untargeted text preserved** |
| P2-08 Act 3 Yvette | **Pass: 342 records across modules 562, 610, 640, 1510, 1550, and 1560 structurally compared; 130 reviewed scene records current; all routing metadata and untargeted text preserved** |
| P2-08 Act 3 Rameses and Heimlich | **Pass: 423 records across modules 400, 562, 610, 1440, 1490, 1500, 1560, and 1600 structurally compared; 117 reviewed records current; all routing metadata and untargeted text preserved** |
| P2-08 effective-layer closure | **Pass: 2,726 records across 26 target modules structurally compared; 1,025 manifest entries current; only four documented talker IDs changed; Act 1/2 obsolete wording scan has 0 target hits** |
| P2-08 party and cutscene dialogue | **Pass: modules 120, 335, 340, and 355 preserve all 237 records and routing metadata; 103 reviewed entries apply idempotently** |
| P2-08 Act 1 adjacent voices | **Pass: modules 210, 250, 240, and 260 preserve all routing metadata; vendor, cabbie, Steve, and slur-cleanup manifests apply idempotently** |
| P2-08 Tut and adjacent cleanup | **Pass: 96 manifest records match module 1883; all 121 records parse; Pippin/Countess/Steve/Olympia cleanup manifests apply idempotently** |
| P2-08 Ziggy cross-act rewrite | **Pass: 31 manifest records match module 310 and 89 match module 1890; all 186 records parse; only the documented diary-response talker ID changed** |
| P2-08 Act 2 O'Riley rewrite | **Pass: 136 manifest records match module 1888; all 185 records parse; one clue-question talker ID corrected** |
| P2-08 Act 2 Yvette rewrite | **Pass: 128 manifest records match module 1885; all 172 records parse; one diary-answer talker ID corrected** |
| P2-08 Act 2 Heimlich rewrite | **Pass: 113 manifest records match module 1889; all 132 tuple/talker records preserved** |
| P2-08 Act 2 Rameses rewrite | **Pass: 113 manifest records match module 1891; all 144 tuple/talker records preserved** |
| P2-08 Act 1 message rewrites | **Pass: modules 270/290/295 structurally parsed; exact tuple/talker/reference metadata preserved** |
| D-030 / PLAY-001 dirty cab gating | **Pass: 250.SCR/250.HEP compiled, gated on flag 125 & (not flag 27)** |
| D-030 clue flow preservation | **Pass: 14.SCR/14.HEP matches authentic baseline (648 / 52 bytes)** |
| Act 1 message resource mapping | **Pass: 20.MSG, 230.MSG, 240.MSG, 270.MSG, 290.MSG, 310.MSG verified** |
| Phase 3 & 4 script compilations | **Pass: 22, 26, 90, 454, 530, 560, and 750 loose patches emitted by SCI Companion** |
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 tools/manual.py check ...` | **Pass: 6 sections, 31 entries, 0 errors** |
| `python3 tools/manual.py build ...` | **Pass: compiled docs/manual/manual.html** |
| DOSBox-X headless startup | **Pass: original interpreter environment initialized with loose patches mounted** |
| Base Game Archive MD5 Integrity | **Pass: RESOURCE.000 and RESOURCE.MAP match vanilla bit-for-bit** |

**What works**

- **Phase 1 Overhaul:** All six Phase 1 items (P1-01 through P1-06) compiled as loose patches in `LB2/`.
- **Phase 2 Narrative:** Suspect fallbacks (P2-01), watch confrontation (P2-02), murder reactions (P2-03), historical dialogue (P2-04), acquaintance routing (P2-05), Steve continuity (P2-06), dagger reactions (P2-07), and period dialogue de-caricature (P2-08) are complete.
- **Phase 3 Mechanics:** Supply safety audit (P3-01), snake oil feedback (P3-02), fair stairwell (P3-04), flexible Act 1 and cab gating (P3-05, D-030), and museum conversation lock (P3-06).
- **Phase 4 Scoring & Mystery:** Accurate act grades (P4-05), clear inquest scope (P4-06), evidence checklist (P4-03), and decoupled quiz/dagger outcome (P4-04).
- **Act 1 Investigation Context:** Authentic starting contacts preserved in `lb2InitCode.sc`; suspects discovered naturally through Act 1 inquiry trees (D-030).
- **Act 1 Dialogue:** Lo Fat, Sgt. O'Flaherty, O'Riley, Ziggy, the sandwich vendor, and the cabbie use distinct, readable period voices without altering dialogue logic (P2-08, D-031).
- **Act 2 Dialogue:** Rameses, Heimlich, Yvette, O'Riley, Ziggy, and Tut Smith use distinct, readable period characterization across character topics, the museum entry, all fourteen party conversations, the Carter murder scene, Pippin discovery, deferred reactions, and adjacent cleanup lines (P2-08, D-031).
- **Act 3 Dialogue:** Rameses, Heimlich, Yvette, O'Riley, Ziggy, Ernie, the Countess, Tut Smith, and Olympia retain their approved voices through private conversations, intercom scenes, laboratory warnings, relationships, office interruptions, evidence confrontations, alibi interviews, grief interviews, and murder discoveries (P2-08, D-031).
- **Act 4 Dialogue:** Laura, Steve, Olympia, and Heimlich retain their established character beats through the reunion, forged-painting discovery, murder/Dagger reactions, and lantern warning without residual mock-German spelling (P2-08, D-031).
- **Act 5 Dialogue:** Rameses's Society confrontation and riddle, Tut's inquest testimony, Steve's already-clean escape dialogue, and O'Riley's jailhouse threat preserve the ending while removing the final phonetic caricatures (P2-08, D-031).
- **Act 6 Dialogue:** The coroner conducts the complete final inquest in a dry, exacting professional voice; every question, evidence check, joke, verdict, and ending route remains intact (P2-08, D-031).
- **Source Baseline:** P5-00's Sluicebox-annotated effective reconstruction is active under D-032; normal work remains single-script compilation under D-028.
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-001 through D-039), `docs/manual/`, `docs/manual/manual.html`, and `docs/PLAYTEST_CHECKLIST.md` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game verification of the playtest findings during continuous run.
- Room 335 podium collision from both sides and the Magnifier repeat (LOOK and DO repeats are maintainer-verified).

**Gotchas for the next session**

- Edit message text in SCI Companion's message editor using the fork build in `SCI Companion/` (D-038); it saves LB2's message format in place. Upstream SCI Companion cannot write it (D-037). `docs/dialogue/*.json` manifests are a historical record of the P2-08 rewrites: re-running `tools/dialogue.py` would overwrite later editor changes.
- Before changing an interactive room object, follow `docs/CONTRIBUTING.md`'s reference-first SCI object workflow (D-034): consult SCI Companion's object-interaction documentation, inspect `Feature.sc`/`PApproach.sc`/`Polygon.sc`, and compare at least two established same-class hotspots before adding custom selectors, cues, dispatchers, or per-cycle mutation.
- Selectors have readable names (D-039). Change a name only in `tools/selector_names.json`, rerun `python3 tools/name_selectors.py LB2`, restart SCI Companion (it reads `997.voc` only at startup), and recompile to confirm byte-identical output. Never give a selector the same name as an instance, class, or procedure used inside a method (`controls` vs. selector 343 changed `Game`'s bytecode).
- SCI Companion resolves classes from other scripts through their `.sco` files. Compile a class's defining script before scripts that use changed classes (`Interface` before `Dialog`); several committed `.sco` files predate the current source.
- `tools/compile.py` closes the script window it opened once the patches are written, so batch compiles no longer pile up windows. SCI Companion ignores a game path given on its command line and reopens the last game, and reads `997.voc` only at startup.
- Class numbers: Redux's `Main` has `WrapMusic` 47 and `Actions` 127, the reverse of vanilla. A Sierra-compiled or archive-decompiled script that names either class needs checking before it ships (D-040). SCI Companion turns `(and c v)` into a boolean and may miscompile compound assignments to array elements with a computed index; write those as plain assignments (D-041).
- Loose patch files in `LB2/` are lowercase (`.scr`, `.hep`, `.msg`, `.v56`), matching SCI Companion's output, and the working copy lives on a case-insensitive exFAT drive (D-037). `core.fileMode` is false there because exFAT has no Unix permissions; case-only renames need `git mv -f` plus a two-step rename on disk.
- Before any SCI Companion GUI action, inspect the active window and verify the loaded archive/project identity; if it is ambiguous, ask the maintainer rather than closing, reloading, or choosing a window by inference.
- Single-script compilation only: use `python3 tools/compile.py <script>`. Never use Compile All or resource rebuild.
- If a script disappears from SCI Companion's list when patch files are deleted, restore files and restart with `wineserver -k`.

## Next steps (in order)

1. Retest PLAY-018 (ankh) and PLAY-025 to PLAY-031: the carbon paper on the off lamp, the stairwell bulb before and after leaving, Olympia's passage (open, look, close, enter with and without the lantern), the Countess's dialogue, the Thinker raised and lowered, the police-file shelf, and the intercom buttons.
2. Retest PLAY-019 to PLAY-024 (Act 3 museum conversations, Ziggy on Pippin and the Countess, Pippin on Najeer, Steve's meeting from either side, the act-break screen).
3. Read Ziggy's restored dialogue in play (speakeasy and party) and adjust any line in SCI Companion (D-043).
4. Retest PLAY-012 to PLAY-018 during the fresh playthrough: the Act 1 museum banner, Rameses and Yvette at the party (Ziggy, Pippin, Tut topics), Ziggy on Heimlich and Tut, the 7:30 Steve meeting in the front rotunda, the north doorway to the Mastodon Room, and clicking the Ankh.
5. Boot and retest session 54's rooms: a museum conversation (Script 90), leaving the speakeasy (310), leaving the Egyptian room south in Act 3 or 4 and using an item on the dagger case (450), room 640's actions, and the full final inquest (750).
6. Check the podium's collision from both sides and a Magnifier repeat.
7. Resume the clean DOSBox-X playthrough and triage every remaining `PLAY-nnn` finding.
8. Begin P5-01 design only after the playthrough gate closes, using the migrated compiler-facing source baseline.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

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

**Verified:** Routine-by-routine comparison: the new build differs from the committed one only in `rm610 init`, the two climb scripts, and one equivalent codegen change; the three rewritten routines match the archive build apart from codegen style and P1-02's removed save-icon lockout. Heap unchanged. Room 630's script and properties compared with the archive build: equivalent. Rebuilt `61.v56` decoded and checked row by row. Scripts 90 and 93 differ from their committed builds only by the `dropCluesCode` call; heaps unchanged. Script 90, 22, 370, 490, 500, 510, 600, and 650 builds differ from the committed ones only in the PLAY-036 changes plus equivalent codegen in room 500; Script 90's heap keeps every property value but its method-table offsets shift. Runtime retests of PLAY-035 and PLAY-036 pending.

**Next session should start with:** The maintainer's retest of PLAY-035 and PLAY-036 (from an Act 2 save), and of Olympia's and Yvette's patrols.

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

### Session 52: 2026-10-13: SCI Companion Message Saving and Workspace Cleanup

**Contributor:** Claude Code and maintainer

**Goal:** Make SCI Companion's message editor usable for LB2 and remove the obsolete in-repo SCI Companion copy.

**Done:**
- Added `MessageWriteTo_3411` and reference-byte preservation to the maintainer's SCI Companion fork (`aedmark/SCICompanion` `04b1aeb0`, with a round-trip unit test); the maintainer built it on Windows and placed the build in the untracked `SCI Companion/` folder.
- Verified a real editor save: `335.msg` noun 6 verb 8 now reads “He's a man of many scars (and scowls).”, and the file is byte-identical to the original apart from that text (D-038).
- Removed the tracked `SCICompanion/` folder (docs, templates, tools, and source stubs); `.gitignore` now ignores `/SCI Companion/`. Updated launch commands in `TESTING.md` and `CONTRIBUTING.md`, the tool table in `ARCHITECTURE.md`, and the `AGENTS.md` layout. Tracked `LB2/msg/335.shm`. Recorded the maintainer's move of `SOURCE_MIGRATION_PLAN.md` to `docs/archive/`.

**Decisions:** D-038; D-037 updated.

**Verified:** Byte comparison of the saved `335.msg` against `HEAD` with the single edit applied; documentation and manual checks pass. The new message text has not been viewed in game.

- Wired the orphaned (335, 6, 8) narrator line: `doorActions` now starts `sHeimlichStare` for the Magnifying Glass, which shows the narrator's scars line and then Heimlich's (1889, 1, 8) reply, following `sGiveInvite`'s room-script pattern. `335.scr` 1,872 bytes, `335.hep` 962 bytes; maintainer confirmed in DOSBox-X.

**Next session should start with:** Readable selector names (plan item B) — done in session 53.

### Session 51: 2026-10-12: Alpha v0.02 Playtest Package

**Contributor:** Claude Code

**Goal:** Update the playtest checklists for the post-v0.01 changes and package alpha v0.02.

**Done:**
- `docs/PLAYTEST_CHECKLIST.md`: added the multi-slot save invariant, the “Resume Case” title button, and the podium collision, approach, signing, and exact-position repeat matrix.
- `docs/ALPHA_PLAYTESTING.md` and `docs/alpha-playtest.html`: moved to v0.02, added a What's new section (Markdown), matching register and save-slot checks, a v0.02 download link and report template, and a new checklist storage key so v0.01 checkmarks do not carry over.
- `docs/CHANGELOG.md`: split into `[0.02-alpha]` (register/podium, Lo Fat foreshadowing, Resume Case, Script 21 duplicate-clue fix, repeat-flash fix, save slots) and `[0.01-alpha]`.
- Revised the register and Heimlich lines per the maintainer (manifests `act2-guest-register.json`, `act2-heimlich-entry.json`, reapplied idempotently to `335.MSG`) and rebuilt the zip with them.
- Built `LB2/LB2-Redux-v0.02.zip` with the v0.01 layout (game files at the root plus `src/`), excluding all `LB2SG.*` saves and zip files: 946 files, 7,073,540 bytes.

**Verified:** Zip integrity test passes; extracted `RESOURCE.000`/`RESOURCE.MAP` match the vanilla MD5s; extracted Scripts 21, 335, 990, and 2335 match `HEAD`; the extracted copy completes the headless DOSBox-X startup smoke; documentation check passes.

**Next session should start with:** Publish v0.02 (zip and updated `alpha-playtest.html`) when the maintainer is ready, then collect reports.

### Session 50: 2026-10-12: Room 335 Podium Repeat Flash and Save Slots

**Contributor:** Claude Code

**Goal:** Stop the brief generic message that still appeared before the guestbook response when Laura repeated LOOK or DO from where she stopped.

**Done:**
- Set `approachDist` (`sel_305`) to 4. This alone did not fix the flash.
- Ran silent trace builds. They logged every `gMessager say:`, every `gDoVerbCode` fallback, room `doVerb`, and podium `doVerb`, and the banner Look dumped the log. Each repeat logged exactly one podium dispatch and one `335:17,verb` message. Every trace build also hid the flash, so the defect is timing- or layout-sensitive and only on the immediate-dispatch ending of `Feature::handleEvent`.
- Fixed it by setting `sightAngle` (`sel_301`) to -1, so `facingMe` always queues the deferred `CueObj` path that a fresh approach uses. Applied it in the instance properties, room init, and the per-frame old-save reapply (D-036). D-035's guard is retained. The trace code is removed. `335.SCR` is 1,778 bytes; `335.HEP` is 902 bytes. The maintainer confirmed no flash on repeat LOOK and DO.

- Fixed saved-game slot reuse in Script 990 (`LB2/src/Save.sc`): the decompiled free-slot search and duplicate-name search had lost their `break`s, so every new save took slot 0 and overwrote the previous one. Both loops now break on a match; `990.SCR` recompiled (2,564 bytes). Restored the maintainer's overwritten Test2 save from `HEAD` as slot 1.

**Gotchas:**
- Trace code in this game: `Printf` takes a buffer first (`(Printf @buf {fmt} args)`); a missing buffer makes `Format` treat the next argument as a text resource (`1.TEX` soft lock). `&rest` forwards only arguments after a method's named parameters, so a wrapper with named parameters must forward them explicitly. Adding script locals makes saves made inside that room unsafe to restore on the new build.
- `tools/compile.py` deletes the existing `.SCR`/`.HEP` before invoking SCI Companion. If SCI Companion is not open, or the script is missing from its list, the run fails after the deletion. That removes the script from SCI Companion's list until the files are restored and SCI Companion is restarted. Before compiling, check `wine tools/list_scripts.exe` and confirm the main window is open.

**Decisions:** D-036; D-034 followed.

**Verified:** Scripts 335 and 990 compile; the headless DOSBox-X startup smoke initializes; `RESOURCE.000`/`RESOURCE.MAP` MD5s unchanged; the maintainer confirmed repeat LOOK and DO at the podium show only the guestbook response. New saves now occupy separate slots (`LB2SG.001`–`.005` created during testing).

**Next session should start with:** Resume the clean playthrough.

### Session 49: 2026-10-12: Room 335 Podium Fallback-Flash Guard

**Contributor:** Codex

**Goal:** Remove the one-frame generic narrator message that appeared before the correct guestbook response when Laura repeated an action without leaving the podium approach point.

**Done:**
- Preserved commit `ec515e0` as the runtime-stable baseline and left its approach, collision, old-save repair, and clue logic unchanged.
- Traced the exact text to module 0's verb-47 catch-all, emitted by `proc0_6` only after an unsupported verb reaches the global default handler. This proved the flash was an extra invalid dispatch rather than a missing Room 335 message.
- Kept LOOK, DO, and Magnifier on the standard `Feature`/`CueObj` path. Changed only `benefitPodium.sel_300`'s unsupported-verb branch to return handled locally instead of calling the superclass and global fallback. No custom cue, selector override, dispatcher, or new state was introduced (D-035).
- Recompiled only `rm335` through the verified `LB2/RESOURCE.MAP` project. The resulting `335.SCR` is 1,752 bytes; `335.HEP` remains 902 bytes and byte-identical to the stable checkpoint.

**Decisions:** D-035; D-034 followed.

**Verified:** Script 335 compiles successfully; the original-interpreter headless startup smoke initializes with the new loose patch; `RESOURCE.000` and `RESOURCE.MAP` retain known MD5 hashes `2d591d9416607beeac48303c6f4fe212` and `330d4a87da2ea2520a316c9f25ab538e`. Runtime confirmation of LOOK/LOOK, DO/LOOK, LOOK/DO, and DO/DO from the exact approach point remains pending.

**Next session should start with:** Run the four exact-position repeat combinations from Save 02 and confirm that only the guestbook response appears, with no flash, palette change, freeze, or interpreter error.
