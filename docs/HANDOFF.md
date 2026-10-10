# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-10, session 29: Act 2 Rameses and Heimlich dialogue passes._

**Where things stand, in one paragraph:** P2-08's act-by-act dialogue pass is underway. Act 1 is complete. Act 2 now has reviewed routine-dialogue passes for Rameses Najeer (94 records in module 1891) and Wolf Heimlich (109 records in module 1889). Rameses speaks as a precise, reserved accountant and informed advocate for Egyptian cultural repatriation; Heimlich remains a militant, paranoid, darkly comic security chief grounded in period duelling culture and personal shame rather than faux-German spelling or premature Nazi parody. Rameses's Dr. Smith self-reference error and Heimlich's anachronistic “Heimlich Death Maneuver” are corrected. Their explicit later murder-reaction records remain untouched for their respective act review. Tuple-addressed manifests reproduce every approved rewrite through `tools/dialogue.py`, and all tuple/talker/reference metadata remains unchanged (D-031).

**Verified** (2026-10-10, Linux workspace)

| Suite | Result |
| --- | --- |
| P2-08 Act 2 Heimlich rewrite | **Pass: 109 manifest records match module 1889; all 187 tuple/talker records preserved; 4 later reaction records unchanged** |
| P2-08 Act 2 Rameses rewrite | **Pass: 94 manifest records match module 1891; all 144 tuple/talker records preserved; 18 later reaction records unchanged** |
| P2-08 Act 1 message rewrites | **Pass: modules 270/290/295 structurally parsed; exact tuple/talker/reference metadata preserved** |
| D-030 / PLAY-001 dirty cab gating | **Pass: 250.SCR/250.HEP compiled, gated on flag 125 & (not flag 27)** |
| D-030 clue flow preservation | **Pass: 14.SCR/14.HEP matches authentic baseline (648 / 52 bytes)** |
| Act 1 message resource mapping | **Pass: 20.MSG, 230.MSG, 240.MSG, 270.MSG, 290.MSG, 310.MSG verified** |
| P4-06 Script compilation | **Pass: 750.SCR/750.HEP emitted by SCI Companion** |
| P4-05 Script compilation | **Pass: 26.SCR/26.HEP emitted by SCI Companion** |
| P4-04 Script compilation | **Pass: 750.SCR emitted by SCI Companion** |
| P4-03 Script compilation | **Pass: 560.SCR and 750.SCR emitted by SCI Companion** |
| P4-02 Script compilation | **Pass: 454.SCR/454.HEP and 750.SCR/750.HEP emitted by SCI Companion** |
| P4-01 Script compilation | **Pass: 560.SCR/560.HEP emitted by SCI Companion** |
| P3-06 Script compilation | **Pass: 90.SCR/90.HEP and 22.SCR/22.HEP emitted by SCI Companion** |
| P3-04 Script compilation | **Pass: 530.SCR/530.HEP emitted by SCI Companion** |
| `python3 tools/check_docs.py` | **Pass: 0 errors, 0 warnings** |
| `python3 tools/manual.py check ...` | **Pass: 6 sections, 30 entries, 0 errors** |
| `python3 tools/manual.py build ...` | **Pass: compiled docs/manual/manual.html** |
| DOSBox-X headless startup | **Pass: original interpreter environment initialized with loose patches mounted** |
| Base Game Archive MD5 Integrity | **Pass: RESOURCE.000 and RESOURCE.MAP match vanilla bit-for-bit** |

**What works**

- **Phase 1 Overhaul:** All six Phase 1 items (P1-01 through P1-06) compiled as loose patches in `LB2/`.
- **Phase 2 Restorations:** Suspect fallbacks (P2-01), watch confrontation (P2-02), murder reactions (P2-03), historical dialogue (P2-04), acquaintance routing (P2-05), Steve continuity (P2-06), and dagger reactions (P2-07).
- **Phase 3 Mechanics:** Supply safety audit (P3-01), snake oil feedback (P3-02), fair stairwell (P3-04), flexible Act 1 and cab gating (P3-05, D-030), and museum conversation lock (P3-06).
- **Phase 4 Scoring & Mystery:** Accurate act grades (P4-05), clear inquest scope (P4-06), evidence checklist (P4-03), and decoupled quiz/dagger outcome (P4-04).
- **Act 1 Investigation Context:** Authentic starting contacts preserved in `lb2InitCode.sc`; suspects discovered naturally through Act 1 inquiry trees (D-030).
- **Act 1 Dialogue:** Lo Fat, Sgt. O'Flaherty, and O'Riley rewritten as distinct, readable period characters without altering dialogue logic (P2-08, D-031).
- **Act 2 Dialogue:** Rameses and Heimlich routine dialogue rewritten as distinct, readable period characterization; later murder reactions deliberately deferred (P2-08, D-031).
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-001 through D-031), `docs/manual/`, `docs/manual/manual.html`, and `docs/PLAYTEST_CHECKLIST.md` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game verification of the playtest findings during continuous run.

**Gotchas for the next session**

- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`, `.MSG`).
- Single-script compilation only: use `python3 tools/compile.py <script>`. Never use Compile All or resource rebuild.
- If a script disappears from SCI Companion's list when patch files are deleted, restore files and restart with `wineserver -k`.

## Next steps (in order)

1. Obtain maintainer review of Heimlich's applied Act 2 wording; revise before beginning the next character if requested.
2. Continue P2-08 in the approved order: Yvette, O'Riley, Ziggy, then Tut and adjacent-speaker cleanup, with separate maintainer review for each character.
3. Resume the clean DOSBox-X playthrough and begin P5-01 only after the dialogue and playtest gates close.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

### Session 29: 2026-10-10: Act 2 Rameses and Heimlich Dialogue Passes

**Contributor:** Codex and maintainer

**Goal:** Give Rameses Najeer and Wolf Heimlich readable, period-appropriate individual voices without changing their clues, relationships, or dramatic functions.

**Done:**
- Audited module 1891 and separated 94 routine records from 18 explicit later murder-reaction records.
- Replaced the written lisp with precise standard spelling and characterized Rameses as a reserved accountant, devoted family man, and informed advocate for Egyptian cultural repatriation.
- Replaced recurring cobra, pyramid, laundry, and “wilds of Egypt” cliches with character-based humor while preserving his established interests and suspicions.
- Corrected the Dr. Smith topic response from “Mister Najeer” to “Dr. Smith.”
- Added `docs/dialogue/act2-rameses.json` and applied it idempotently to `LB2/1891.MSG`.
- Reworked Heimlich's 109 routine records with standard spelling and a terse, authoritarian security voice while preserving his militance, Heidelberg duelling scars, museum obsession, paranoia, and grief over his mother's stolen paintings.
- Replaced constant execution threats and German-superiority gags with credible ejection, arrest, restraint, and implied-menace language; retained the goose-step animation as the upper limit of the caricature.
- Removed the anachronistic “Heimlich Death Maneuver” reference and added `docs/dialogue/act2-heimlich.json`, applied idempotently to `LB2/1889.MSG`.

**Changed:** `LB2/1889.MSG`, `LB2/1891.MSG`, `docs/dialogue/act2-heimlich.json`, `docs/dialogue/act2-rameses.json`, and synchronized roadmap, decision, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** Modules 1889 and 1891 retain identical message tuple/talker metadata; exactly 109 Heimlich and 94 Rameses approved-scope texts changed; all 4 Heimlich and 18 Rameses later reaction records remain outside the manifests; no targeted caricature spelling remains in either routine scope; documentation/manual validation and build pass; DOSBox-X original-interpreter startup smoke passes with both loose overrides active.

**Next session should start with:** Maintainer review of Heimlich, followed by Yvette only after approval.

### Session 28: 2026-10-10: Act 1 Period Dialogue De-Caricature Pass

**Contributor:** Codex and maintainer

**Goal:** Rewrite Lo Fat, Sgt. O'Flaherty, and Detective O'Riley without erasing their identities, period setting, clues, humour, or dramatic roles.

**Done:**
- Inventoried every Act 1 spoken record for the three characters directly from modules 270, 290, and 295.
- Reworked Lo Fat with polished grammar, dry charm, and a light British-English cadence; reviewed all 86 spoken records and cleaned six adjacent narrator records that repeated the caricature.
- Reworked 49 of O'Flaherty's 64 lines, retaining restrained Irish-American idiom while removing phonetic stage-Irish spelling; also removed the anachronistic “in like Flynn” phrase.
- Reworked all 11 O'Riley office lines into readable but deliberately blustering and patronizing dialogue, retaining his period sexism as villain characterization.
- Added tuple-addressed JSON manifests under `docs/dialogue/` and the idempotent `tools/dialogue.py` patcher.
- Added loose message overrides `LB2/290.MSG` and `LB2/295.MSG`; updated the existing `LB2/270.MSG` override.

**Changed:** `LB2/270.MSG`, `LB2/290.MSG`, `LB2/295.MSG`, `docs/dialogue/`, `tools/dialogue.py`, and project documentation/manual files.

**Decisions:** D-031.

**Verified:** Exact manifest-to-message text audit; unique tuple audit; unchanged talker/reference metadata against archived modules; DOSBox-X headless startup; documentation/manual validation and build.

**Next session should start with:** Continue P2-08 with the next act's character inventory after the maintainer identifies the desired cast.

### Session 27: 2026-10-10: Act 1 Diegetic Clue Flow Verification and Script/Message Mapping

**Contributor:** Antigravity and maintainer

**Goal:** Investigate user playtest observations regarding Crodfoller/Rameses and dockworker/Olympia/Yvette/Heimlich dialogue trees; verify exact script handlers and message resources.

**Done:**
- Audited `LB2/src/rm230.sc` (Crodfoller in Newsroom), `LB2/src/rm240.sc` (Steve Dorian at Docks), `LB2/src/rm270.sc` (Lo Fat's Laundry), and `LB2/src/rm310.sc` (Ziggy at Speakeasy).
- Decompressed and inspected SCI 1.1 message modules directly from `LB2/RESOURCE.MSG` (`20.MSG`, `230.MSG`, `240.MSG`, `270.MSG`, `290.MSG`, `310.MSG`) using PKWare DCL explode decompression.
- Confirmed full notebook clue mappings: Clue 264 is Ziggy (not Rameses); Rameses Najeer is Clue 268; Clue 514 is Police Station; Clue 517 is Leyendecker Museum; Clue 516 is 12th Street Docks; Clue 515 is Lo Fat's Laundry.
- Verified Point 2: Asking Crodfoller about Leyendecker Museum (517) introduces Dr. Archibald Carrington (259) and Dr. Pippin Carter (258); Crodfoller never mentions Rameses. In Act 1, Rameses Najeer (268) is introduced by Ziggy in Room 310 when asked about Egyptology (1028).
- Verified Point 5: 12th Street Docks is Room 240 (Steve Dorian). Steve introduces Countess (269) and Tut (271). Room 270 is Lo Fat's Laundry, where asking Lo Fat about Leyendecker Museum (517) introduces Dr. Olympia Myklos (270), Wolf Heimlich (265), and Yvette Delacroix (266).
- Corrected documentation discrepancies across `docs/DECISIONS.md` (D-030), `docs/PLAYTEST_CHECKLIST.md` (PLAY-005/007), and `docs/HANDOFF.md`.
- Archived Session 17 to `docs/archive/SESSION_LOG_2026_10.md` to maintain the 10-session rolling window.

**Changed:** `docs/DECISIONS.md`, `docs/PLAYTEST_CHECKLIST.md`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-030.

**Verified:** Bytecode and message resource audits; `python3 tools/check_docs.py` (0 errors); `python3 tools/manual.py check` (0 errors).

**Next session should start with:** Continue full-game playtest checklist run in DOSBox-X.

### Session 26: 2026-10-09: Dirty Cab Progression Gating and Act 1 Clue Flow Preservation

**Contributor:** Antigravity and maintainer

**Goal:** Resolve PLAY-001 (gate dirty cab on a prior normal ride and eliminate it after ticket collection) and audit Act 1 starting notebook entries against diegetic dialogue flow (D-030).

**Done:**
- Re-verified single-script compilation environment: refreshed `Main.sco` and `Inset.sco` object symbol tables; verified unmodified scripts recompile cleanly.
- Implemented PLAY-001 / D-030 in `LB2/src/Trash.sc`: allocated persistent flag 125 (`proc0_3 125`) in `sDoTakeOffFlight` on taking a normal cab ride; gated dirty cab appearance in `rm250` init, `Trash::sel_110`, and `cornerTrash::sel_300` on `(and (proc0_10 1) (proc0_2 125) (not (proc0_2 27)))`. Compiled `LB2/250.SCR` (5,194 bytes) and `LB2/250.HEP` (2,490 bytes).
- Audited Act 1 clue progression across `rm230.sc` (Crodfoller in Newsroom), `rm240.sc` (Steve at Docks), `rm270.sc` (Lo Fat's Laundry), `rm290.sc` (Police Station), and `rm310.sc` (Ziggy at Speakeasy). Confirmed Rube does not know Countess, Olympia, Ernie, or Yvette, and never mentions Rameses; suspects are introduced diegetically as Laura explores (Rube introduces Carrington/Carter/Ziggy/O'Riley; Steve at Docks introduces Countess/Tut; Lo Fat introduces Olympia/Yvette/Heimlich; Ziggy introduces Rameses; Ernie is introduced in Act 2).
- Restored `LB2/src/lb2InitCode.sc` and compiled `LB2/14.SCR` (648 bytes) and `LB2/14.HEP` (52 bytes) matching baseline byte-for-byte.
- Verified zero errors on DOSBox-X headless boot smoke test.
- Archived Session 16 to `docs/archive/SESSION_LOG_2026_10.md` to keep live session log under limit.

**Changed:** `LB2/src/Trash.sc`, `LB2/src/Main.sco`, `LB2/src/Inset.sco`, `LB2/250.SCR`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/PLAYTEST_CHECKLIST.md`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-030.

**Verified:** SCI Companion single-script compilation of Script 250 with 0 errors/0 warnings; DOSBox-X headless boot test (0 errors); bytecode flag audits; `python3 tools/check_docs.py` (0 errors); `python3 tools/manual.py check` (0 errors).

**Next session should start with:** Continue full-game playtest checklist run in DOSBox-X.

### Session 25: 2026-10-09: Catastrophe Recovery and Object Cache Baseline Tracking

**Contributor:** Antigravity and maintainer

**Goal:** Recover from a broken "Compile All" attempt in SCI Companion that corrupted loose patches and caused Sierra Error 3 on boot; establish a permanent, restorable baseline in git including all 221 `.sco` object cache files.

**Done:**
- Preserved the broken state on safety backup branch `catastrophe-2026-10-09`.
- Restored working tree and `master` branch to the verified `8d98dcf` baseline (retaining P4-05, P4-06, and PLAY-001..PLAY-009).
- Restored the 104 verified loose patch files in `LB2/` and confirmed MD5 integrity of base game archives (`RESOURCE.000`, `RESOURCE.MAP`, `RESOURCE.MSG`, `MESSAGE.MAP`).
- Configured `.gitattributes` to mark `*.sco binary` and `*.sc text eol=lf`.
- Updated `.gitignore` to un-ignore `*.sco` so object caches are versioned and permanent, while ignoring external SCI Companion IDE runtime binaries/caches.
- Normalized line endings on `LB2/src/Class_255_0.sc` and `LB2/src/SRDialog.sc`.
- Verified clean startup in DOSBox-X (0 errors) and validated docs and manual.

**Changed:** `.gitattributes`, `.gitignore`, `LB2/src/*.sco`, `LB2/src/Class_255_0.sc`, `LB2/src/SRDialog.sc`, `docs/HANDOFF.md`.

**Verified:** DOSBox-X headless boot test passed (0 errors); `python3 tools/check_docs.py` (0 errors); `python3 tools/manual.py check` (0 errors); base archive MD5 match.

**Next session should start with:** Continue full-game playtest and address PLAY-001..PLAY-009 triage using single-script compilation (`python3 tools/compile.py <script>`).

### Session 24: 2026-10-09: Compile-All Recovery and Hybrid Version Diagnosis

**Contributor:** Claude and maintainer

**Goal:** Diagnose hundreds of Compile All errors (undeclared `msgGET`/`palSET_INTENSITY`/`fi*`/`snd*` constants, script numbers above 999) and confirm no patch work was lost.

**Done:**
- Traced the errors to SCI Companion's map-format setting: format 1.0 drops the `SCI_1_1` defines and caps script numbers at 999. Identified the floppy as a hybrid (SCI1.1 scripts, SCI1-style 6-byte `RESOURCE.MAP`).
- Found that a resource rebuild under format 1.1 had replaced the base archive with a volume containing only loose-file resources (451 entries against 1,075), losing `0.FON` and all views, pics, and sounds. The maintainer restored the original archive and `MESSAGE.MAP`.
- Got Compile All to finish by editing 13 decompiled sources (commit `7d48893`), then found its output does not boot: the game stalls on a black screen. Tested copies: the `4c79bcf` patch set boots; the Compile All set does not, with or without the nine newly loose scripts or recompiled 450/720/973/998.
- Reverted all patches to the `4c79bcf` set and removed the nine new overrides (310, 640, 770, 928, 999, 1888, 1895, 1904, 1906). Reverted the 13 compile-fix sources; only `rm750.sc` (P4-06) differs from `4c79bcf`. Kept the Compile All build of `750.SCR`/`750.HEP`; a copy with that pair and the `4c79bcf` patches boots.
- Added `tools/uppercase_patches.py`, `.gitattributes` (LF for `.sc`, binary for patches), and D-028.

**Changed:** `LB2/*.SCR`/`*.HEP` (reverted to `4c79bcf` except 750), `LB2/src/rm750.sc`, `tools/uppercase_patches.py`, `.gitattributes`, `docs/DECISIONS.md`, `docs/ARCHITECTURE.md`, `docs/TESTING.md`, `docs/HANDOFF.md`.

**Decisions:** D-028.

**Verified:** The patch set committed here boots in DOSBox-X (maintainer). A fresh single-script compile of `rm750` under Wine (`tools/compile.py`) reproduces the committed `750.SCR`/`750.HEP` byte for byte. Not verified: P4-06 in the inquest itself.

**Gotchas:** `tools/compile.py` deletes the existing `N.SCR`/`N.HEP` before compiling and does not restore them if the helper fails, so back them up first. SCI Companion (started with `wine SCICompanion/Release/SCICompanion.exe 'Z:\...\LB2\game.ini'`) drops a script from its list when its patch files vanish and does not re-add it; restart it after restoring files. Stop it with `wineserver -k` when finished.

**Also added:** `tools/make_test_copy.sh` (throwaway boot-test copies, optional git revision), the Compile and boot workflow in `docs/TESTING.md`, D-029, a corrected contributor workflow, and the triage gameplan in `docs/PLAYTEST_CHECKLIST.md`.

**Compile environment is currently unusable (open blocker, 2026-10-09):** every script compiled by the present SCI Companion setup is incompatible with the shipped patches. Compiling the unmodified `Trash.sc` gives `250.SCR` 5,138 bytes and `250.HEP` 2,602 bytes against the committed 5,136 and 2,490: each object gains an extra heap entry (header count `1e` to `1f`). Booting such a build ends in "Oops! Error 4" (entering the taxi) or a nonsense missing-resource error. The same pattern appears in the Compile All build. Without the restored `LB2/src/*.sco` object caches a compile writes nothing. Do not compile anything until the original SCI Companion version/object-format setting is recovered; it is not in `game.ini` or the Wine registry and is likely in SCI Companion's game-version dialog. The `.sco` set in `LB2/src` dates from the 11:34 Compile All run (a backup copy of it was taken at 12:00 on this machine; no earlier set exists). Also, SCI Companion's "Compile modified scripts before run" option (registry `CompileModifiedScriptsBeforeRun`) recompiles scripts on every Run and silently replaced `0.SCR`/`250.SCR`; the maintainer turned it off. Launch the game only with `./tools/run_dosbox.sh`.

**Drafted fix waiting on the compiler (PLAY-001/002):** in `Trash.sc` (Script 250) change both `(if (proc0_10 1)` tests that select the dirty taxi (the `rm250` init and the trash hotspot's `sel_110`) to `(if (and (proc0_10 1) (not (proc0_2 27)))`. Flag 27 is set when the claim ticket is taken, so the dirty cab then never reappears. Compile only script 250, boot-test, and play the taxi both before and after taking the ticket.

**Next session should start with:** Recover the compile environment (see the blocker above), then play to the inquest to verify P4-06 (Script 750). Use `python3 tools/compile.py <script>` for any further change and boot the game before committing. Never use Compile All.

### Session 23: 2026-10-09: Pre–Phase 5 Full-Game Playtest Checklist

**Contributor:** Codex and maintainer

**Goal:** Capture a clean end-to-end DOSBox-X run and triage all observed bugs, quirks, continuity problems, and content opportunities before beginning Phase 5.

**Done:**
- Added an act-by-act checklist covering saves, state restoration, score, inventory, music, notebook acquisition, topic completion, proximity dialogue, all shipped fixes, inquest outcomes, and the ending.
- Recorded the maintainer's first eight observations as stable PLAY-001 through PLAY-008 findings without prematurely choosing implementations.
- Preserved the guiding constraint that new diegetic introductions and interjections must expose or explain existing content rather than isolate it behind new prerequisites.
- Made completion and triage of the full-game run an explicit Phase 5 entry gate and linked the checklist from the documentation and testing indexes.

**Changed:** `docs/PLAYTEST_CHECKLIST.md`, `docs/README.md`, `docs/ROADMAP.md`, `docs/TESTING.md`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** No architectural decision; findings remain observations until post-playthrough source and resource audits.

**Verified:** Documentation validation. Gameplay findings remain intentionally open pending reproduction and triage from the maintainer's DOSBox-X saves.

**Next session should start with:** Continue the full-game run and append new `PLAY-nnn` findings; do not begin P5-01 implementation until the gate closes.

### Session 22: 2026-10-09: P4-06 Non-Essential Quiz Questions Delineation

**Contributor:** Codex

**Goal:** Make the inquest distinguish required case findings from optional museum lore and guarantee that bonus answers cannot reduce the ending result.

**Done:**
- Audited all sixteen Script 750 questions and corrected the outline's provisional Script 700/720 ownership.
- Confirmed questions 1–9 alone control murder correctness, questions 10–11 alone control theft-answer correctness, and questions 12–16 already supply feedback without score or verdict writes.
- Added a required-case notice before question 1 explaining that questions 1–11 determine the coroner's conclusions.
- Moved the unchanged art-theft, High Priest, and museum-accomplice flow into `sBonusQuestions`, preceded by an explicit notice that questions 12–16 are optional and do not affect Laura's final case result.
- Preserved all authored answer menus, feedback messages, and conditional skips while structurally excluding both verdict flags from the bonus state.
- Compiled Script 750, recorded D-027, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm750.sc`, `LB2/750.SCR`, `LB2/750.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-027 (Isolate bonus museum questions from inquest verdict state).

**Verified:** SCI Companion compilation of Script 750; static all-question, verdict-write, score-write, and transition audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of both section notices and bonus-answer variants remains a manual regression test.

**Next session should start with:** P5-01 Act 2 interactive-content design inventory.

### Session 21: 2026-10-09: P4-05 Grading and Scoring System Standardization

**Contributor:** Codex

**Goal:** Grade Laura against points actually attainable at each act break and stop the introduction from consuming an F response.

**Done:**
- Traced all grading math and message-band selection to Script 26, correcting the outline's provisional Scripts 0/780 ownership.
- Cross-checked every score flag against the point audit linked by the owner-supplied OneShortEye video.
- Established vanilla cumulative maxima `5/12/37/47/50` and Redux maxima `5/13/38/48/51` after P4-02's Act 2 footprint point.
- Replaced Script 26's inflated `5/12/43/58/61` divisors with the attainable Redux values while preserving the authored percentage bands.
- Skipped grade-band selection at `global123 == 0`, preventing the ungraded introduction from advancing the first F-message counter.
- Kept P4-02's three coroner-review awards post-grade and documented the complete raw maximum of 54.
- Compiled Script 26, recorded D-026, indexed the published point audit, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/actBreak.sc`, `LB2/26.SCR`, `LB2/26.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/reference/README.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-026 (Grade against attainable cumulative points).

**Verified:** SCI Companion compilation of Script 26; static point-event, divisor, grade-band, and startup-counter audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of all act and band boundaries remains a manual regression test.

**Next session should start with:** P4-06 (Non-Essential Quiz Questions Delineation).

### Session 20: 2026-10-08: P4-04 Quiz / Dagger Possession Logic Decoupling

**Contributor:** Codex

**Goal:** Stop theft-quiz answers from retroactively changing whether Laura recovered the Dagger of Amon Ra.

**Done:**
- Traced the actual ending controller to Script 750 rather than the outline's proposed Script 720.
- Confirmed that `global126` combines murder-case success with theft-answer correctness and that downstream epilogue content misuses the latter as physical dagger state.
- Added a shared recovery predicate accepting inventory item 11 or durable acquisition bit 155, covering both retained and surrendered custody.
- Preserved the original quiz result through the coroner's feedback, then normalized the four-way outcome at the epilogue boundary from murder success plus physical recovery.
- Routed the newspaper art, intermediate ending scenes, and all 19 Script 785 character cards through the normalized state without changing message resources.
- Compiled Script 750, recorded D-025, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm750.sc`, `LB2/750.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-025 (Normalize physical dagger state at the epilogue boundary).

**Verified:** SCI Companion compilation of Script 750; static four-state outcome, recovery-bit, and downstream route audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the four outcome combinations remains a manual regression test.

**Next session should start with:** P4-05 (Grading and Scoring System Standardization).
