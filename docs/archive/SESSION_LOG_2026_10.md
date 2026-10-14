# Session log: October 2026

Archived verbatim from `docs/HANDOFF.md` when its live session log exceeded ten entries.

### Session 45: 2026-10-11: Diegetic Benefit Register and Identity Flow

**Contributor:** Codex and maintainer

**Goal:** Stop Act 2 check-in from granting an omniscient cast list while preserving fair access to character topics.

**Done:** Added an inspectable leather-bound register beside Heimlich in Room 335. Look, Hand, and Magnifier record only Steve, Heimlich, Yvette, Rameses, Countess, Olympia, and Tut; the text identifies Pippin and the apparent Carrington without exposing Watney. Removed the automatic check-in batches and the disguised Watney actor's clue-272 encounter hook. Reworked Lo Fat's museum discussion so he foreshadows Heimlich and Olympia without names or clues while still naming Yvette and preserving her Act 1 inquiry branches. Added tuple-addressed register and Lo Fat manifests and synchronized roadmap, ADR, architecture, testing, changelog, manual, and public/internal playtest guidance.

**Decisions:** D-009 refined; D-033.

**Verified:** Maintainer compiled Scripts 270, 335, and 93; lowercase Wine outputs were normalized to tracked uppercase names. Message manifests reapply idempotently. Static source audit confirms the intended clue set and Watney exclusion. `RESOURCE.000` and `RESOURCE.MAP` retain vanilla MD5 hashes, and the original interpreter completes its headless startup smoke. Runtime hotspot placement remains to be checked in DOSBox-X.

**Next session should start with:** Test the entrance register from the Act 2 save, including repeat inspection and notebook contents, then continue the clean playthrough.

### Session 44: 2026-10-11: Public Alpha Playtesting Guide

**Contributor:** Codex and maintainer

**Goal:** Give SQH Discord alpha testers a clear, public-facing way to test v0.01 and submit useful reports.

**Done:** Added `docs/ALPHA_PLAYTESTING.md` with reference-environment guidance, save-handling advice, universal quality checks, spoiler-light act coverage, a collapsible focused regression checklist, a standard Discord/GitHub report template, and examples of high-value alternate-route testing. Added `docs/alpha-playtest.html`, a one-file Art Deco page ready for Neocities with a direct v0.01 download, device-local checklist progress, responsive and print layouts, accessible controls, spoiler separation, and a copyable report form. Linked both artifacts from the project and documentation indexes and distinguished them from the internal triage checklist.

**Verified:** Documentation consistency check passes with the new public guide and links.

**Next session should start with:** Collect public alpha reports, reproduce them in DOSBox-X, and assign stable `PLAY-nnn` IDs in the internal checklist.

### Session 43: 2026-10-10: Act 1 Playtest Music, Grade Frame, and Ziggy Continuity

**Contributor:** Codex and maintainer

**Goal:** Resolve the first three concrete regressions found during the clean Act 1 playthrough.

**Done:** Restored Script 310's native randomized music wrapper and preserved its current song across the bathroom cue; retained picture 26's neutral gold Art Deco frame for all act-grade narration instead of drawing picture 780; and added explicit, plot-safe Act 1 replies when Laura asks Ziggy about Yvette or the Countess. Extended the tuple-manifest tool with idempotent SCI 1.1 record insertion so the two additive messages remain reproducible.

**Verified:** Maintainer confirmed both speakeasy songs rotate and bathroom return no longer restarts the song; Script 310 compiled at 0 errors/0 warnings; Script 26 emitted updated loose patches; both additive message tuples parse and the manifest reapplies with zero changes; immutable base archives retain their vanilla hashes.

**Next session should start with:** Continue the Act 1 playthrough and retest the neutral grade frame plus both new Ziggy inquiry replies.

### Session 42: 2026-10-10: Act 6 Final-Inquest Dialogue Closure

**Contributor:** Codex and maintainer

**Goal:** Finish the act-by-act dialogue rewrite with the coroner's complete final interrogation before beginning the clean playthrough.

**Done:** Recast the coroner as a dry, formal, exacting professional; replaced the dated “mental deficiency” answer; removed repetitive shouting and unsupported suggestions that Laura herself committed the murders; sharpened weak, partial, and successful verdicts; retained the rubbish-bin hint and fence-installer joke; and left all sixteen questions, answer routing, evidence gates, Tut testimony, verdicts, and ending states unchanged.

**Decisions:** D-031.

**Verified:** All 77 records in module 750 structurally compared; exactly 28 approved text tuples changed; all tuple/talker/reference metadata preserved; the Act 6 manifest reapplies idempotently.

**Next session should start with:** Run the clean DOSBox-X playthrough, including every final-inquest outcome required by `docs/TESTING.md`.

### Session 41: 2026-10-10: P5-00 Sluicebox Source Baseline Migration

**Contributor:** Codex and maintainer

**Goal:** Replace the mixed legacy decompilation with a coherent, maintainable 221-script baseline without losing any verified Redux behavior.

**Done:** Verified the pinned `ra-dos-1.000` archive and exact version match; discovered that its contextual selector aliases cannot be represented in one SCI vocabulary; reconstructed the effective Redux resources through Sluicebox's annotation pipeline with stable numeric selector IDs; repaired nine demonstrated decompiler/compiler boundary cases; normalized the selector vocabulary while preserving SCI metadata names; imported all 221 `.sc`/`.sco` pairs and recovered script names; updated compile aliases, provenance, architecture, testing, roadmap, decision, handoff, changelog, and manual documentation.

**Decisions:** D-032.

**Verified:** 221/221 scripts and 2,337/2,337 functions decompiled; targeted blocker scripts compile at zero errors/warnings; isolated Compile All captured no errors; immutable repository archives retain vanilla MD5 hashes; documentation/manual validation and DOSBox-X startup smoke pass.

**Next session should start with:** Finish the maintainer's clean playthrough gate, then begin P5-01 design against the migrated source baseline.

### Session 39: 2026-10-10: Act 5 and Ending Dialogue Closure

**Contributor:** Codex and maintainer

**Goal:** Complete the period-dialogue audit through the Society of Amon Ra confrontation, escape, inquest, and jail epilogue without changing the ending structure.

**Done:**
- Reworked every Rameses and adjacent Laura line in modules 710 and 715, removing the written lisp while preserving capture, threat, sacrifice failure, both riddles, successful escape, and the alternate Dagger death.
- Made Rameses acknowledge Laura's historically correct point that ancient Egyptians did not practice human sacrifice, defining the dangerous rite as the modern society's invention rather than authentic Egyptology.
- Reworked Tut Smith's inquest testimony as a clear eyewitness account and dignified demand for justice, retaining restrained faith in Amon Ra without camel, sand, or mystical-revenge cliches.
- Reworked O'Riley's six-line jailhouse threat in his established vindictive voice without stage-Irish spelling.
- Corrected `herpetology` and `hieroglyphs` in the escape tunnel while preserving the authored danger-comedy; left Steve's already-clean escape dialogue and the deliberately absurd mummy-storage exhibit jokes intact.
- Scanned the complete effective message layer and found zero remaining faux-German, faux-French, stage-Irish, or written-lisp targets.

**Changed:** `LB2/710.MSG`, `LB2/715.MSG`, `LB2/730.MSG`, `LB2/750.MSG`, `LB2/770.MSG`, five manifests under `docs/dialogue/`, and synchronized roadmap, decision, changelog, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 169 records across the five touched modules structurally compared; 64 intended text changes; every tuple/talker/reference field and untargeted line preserved; all manifests apply idempotently; complete effective-layer target scan clear.

**Next session should start with:** Review the Act 5 wording in context during the clean DOSBox-X playthrough, then return to playtest triage and the P5-01 entry gate.

### Session 38: 2026-10-10: Act 4 Dialogue Closure

**Contributor:** Codex and maintainer

**Goal:** Carry the approved character voices through Act 4 and distinguish its actual phase-gated dialogue from shared museum and ending resources.

**Done:**
- Mapped Act 4 through its `global123 == 4` scene gates instead of treating every late-numbered message module as Act 4 content.
- Confirmed that the earlier cross-act passes already cover the substantive Yvette, O'Riley, Olympia, Rameses, and murder-reaction dialogue used during Act 4.
- Lightly polished Laura and Steve's reunion while preserving Olympia's fascination with Steve's dock scars, the flirtation, and Steve's discovery that paintings in the Old Masters Gallery are wet forgeries.
- Replaced Heimlich's last mock-German Yvette-murder and Dagger reactions, his water-glass aside, and the room-600 lantern gibberish with his established severe, controlled voice.
- Scanned the complete effective message layer and isolated the remaining written-lisp hits to three Rameses records in ending modules 710 and 715, outside Act 4.

**Changed:** `LB2/600.MSG`, `LB2/1510.MSG`, `LB2/1889.MSG`, two Act 4 manifests under `docs/dialogue/`, the existing Heimlich manifest, and synchronized roadmap, decision, changelog, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 255 records across the three touched modules structurally compared; 19 intended text changes; every tuple/talker/reference field and untargeted line preserved; all relevant manifests apply idempotently; effective-layer caricature scan clear through Act 4.

**Next session should start with:** Begin Act 5/ending review with Rameses's three known written-lisp records in modules 710 and 715, then audit the remaining ending cast and room-local messages.

### Session 31: 2026-10-10: Act 2 O'Riley Dialogue Pass

**Contributor:** Codex and maintainer

**Goal:** Keep Detective O'Riley a swaggering, sexist, corrupt, and prejudiced antagonist while removing leprechaun vocabulary and repetitive stage-Irish eye-dialect.

**Done:**
- Reviewed all 97 routine O'Riley records in module 1888, rewriting 96 and retaining one already-clean response verbatim.
- Preserved his dismissive burglary investigation, grapes clue, evidence handoff, class prejudice, sexism, xenophobia, homophobia, and Laura's authored rebuttals because these expose his character and support the mystery.
- Replaced “begorrah,” pots-of-gold jokes, sainted-mother language, `me` for `my`, and repetitive “lassie/wee” signaling with readable Irish-American rhythm, police slang, and the occasional restrained “lass.”
- Replaced the narrator's generic Irish-red-hair description with a direct observation of O'Riley's proprietary swagger.
- Added `docs/dialogue/act2-oriley.json` and applied it idempotently to `LB2/1888.MSG`; deferred all 38 explicit later murder-reaction records.

**Changed:** `LB2/1888.MSG`, `docs/dialogue/act2-oriley.json`, and synchronized roadmap, decision, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 185 message tuple/talker records retain identical metadata; all 98 manifest texts match; exactly 96 O'Riley and one narrator text changed; all 38 explicit later reaction records remain outside the manifest; documentation/manual validation and build pass.

**Next session should start with:** Maintainer review of O'Riley, followed by Ziggy only after approval.

### Session 30: 2026-10-10: Act 2 Yvette Dialogue Pass

**Contributor:** Codex and maintainer

**Goal:** Preserve Yvette Delacroix's intelligence, ambition, sexual confidence, and mystery-relevant relationships while removing faux-French spelling, broken grammar, and reflexive promiscuity jokes.

**Done:**
- Reworked all 111 routine Yvette records in module 1885 with fluent English, selective French vocabulary, poised social observation, and deliberate rather than accidental innuendo.
- Preserved the plot-bearing implications of her work as a speakeasy hostess and her relationships with Sterling, Carrington, O'Riley, Lo Fat, Pippin, and Steve.
- Rewrote the Steve topic and its adjacent Laura response to foreshadow their later encounter rather than report it prematurely.
- Cleaned Laura's adjacent speakeasy question and replaced the narrator's jealous “mousy and naive” comparison with a direct description of Yvette's elegance and self-possession.
- Added `docs/dialogue/act2-yvette.json` and applied it idempotently to `LB2/1885.MSG`; deferred the later Sterling-diary talker-ID error and explicit murder reactions.

**Changed:** `LB2/1885.MSG`, `docs/dialogue/act2-yvette.json`, and synchronized roadmap, decision, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 172 message tuple/talker records retain identical metadata; exactly 111 Yvette, two Laura, and one narrator texts changed; all 13 explicit later reaction records remain outside the manifest; documentation/manual validation and build pass.

**Next session should start with:** Maintainer review of Yvette, followed by O'Riley only after approval.

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

### Session 17: 2026-10-08: P4-01 Watney Little Evidence Discovery

**Contributor:** Codex

**Goal:** Make Watney Little's narratively essential police file and notebook evidence discoverable without a pixel hunt.

**Done:**
- Audited the roadmap premise and traced the real file path to the special book and insets in Room 560; Room 420 and Script 13 are unrelated.
- Confirmed that inventory item 24's original Take path already adds file-content clue 793 and Watney People clue 272.
- Expanded the special volume hotspot from 11x15 to 36x38 pixels and routed Look, Hand, or Magnifier on the full bookcase to the same inset until the file is acquired.
- Added idempotent clue 793 and 272 registration when the exposed file is inspected, while retaining the original Take, point, and inventory behavior.
- Compiled Script 560 and synchronized the architecture, roadmap, decision log, changelog, testing matrix, handoff, and manual.

**Changed:** `LB2/src/rm560.sc`, `LB2/560.SCR`, `LB2/560.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-022 (Expose Watney's existing police-file path).

**Verified:** SCI Companion compilation of Script 560; static ownership, hotspot, clue-ID, inventory, and score-path audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct Room 560 observation remains a manual save-based regression test.

**Next session should start with:** P4-02 (Evidence Validity, Red Herrings & Inquest Credit).

### Session 16: 2026-10-08: P3-06 NPC Wander Mechanic Stabilization

**Contributor:** Codex

**Goal:** Prevent museum NPCs from leaving during dialogue and keep O'Reilly available for later-act questioning without destroying authored schedules.

**Done:**
- Traced Script 90's shared `MuseumActor` and `TravelToRoom` controller and confirmed that actor message calls had no dismissal callback while movement scripts continued to cycle.
- Routed all 112 museum-actor message dispatches through `sel_668`, which locks only the selected actor and stops its mover before opening the message.
- Added `museumDialogueResume` and a `TravelToRoom.sel_145` guard so dismissal clears the lock and re-enters the same travel state, preserving fixed destinations and random routes.
- Gated Script 22's 10:15 O'Reilly removal outside Acts 3 and 4, leaving the authored behavior unchanged in other acts.
- Compiled Scripts 90 and 22 and synchronized the architecture, roadmap, decision log, changelog, testing matrix, handoff, and manual.

**Changed:** `LB2/src/MuseumRgn.sc`, `LB2/src/triggerAndClock.sc`, `LB2/90.SCR`, `LB2/90.HEP`, `LB2/22.SCR`, `LB2/22.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-021 (Preserve museum travel state across dialogue).

**Verified:** SCI Companion compilation of Scripts 90 and 22 with 0 errors and 0 warnings; static audit of all museum-actor message paths, pause/resume state handling, and the Act 3–4 clock guard; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based observation of a moving speaker and O'Reilly after 10:15 remains a manual regression test.

**Next session should start with:** P4-01 (Mystery Accessibility & Wattney Little Evidence Discovery).

### Session 15: 2026-10-08: P3-05 Act 1 Progression Trigger Simplification

**Contributor:** Codex

**Goal:** Remove arbitrary Act 1 prerequisites from the dirty-taxi and evening-gown route while preserving essential credentials and authored side content.

**Done:**
- Traced Script 22's `global124` bits and confirmed the press pass, docks visit, baseball trade, and Ziggy conversation are independent events rather than an ordered chain.
- Identified Script 250's `(proc0_10 16 1)` complete-low-nibble test as the actual bottleneck: it withheld the dirty taxi and its gown claim ticket until all four errands were complete.
- Changed the three coordinated taxi-state checks to persistent press-pass bit 1, retaining the dirty-taxi scene, claim ticket, Lo Fat gown exchange, and dressed Act 1 transition.
- Preserved the docks, baseball, and Ziggy paths as optional content with their original clues, character context, clock progression, and rewards.
- Compiled Script 250 and synchronized the architecture, roadmap, decision log, changelog, handoff, and manual.

**Changed:** `LB2/src/Trash.sc`, `LB2/250.SCR`, `LB2/250.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-020 (Make the press pass the Act 1 taxi milestone).

**Verified:** SCI Companion compilation of Script 250 with 0 errors and 0 warnings; static global124, taxi-state, inventory-route, and optional-content audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based traversal from press-pass acquisition through the early dirty taxi and gown remains a manual regression test.

**Next session should start with:** P3-06 (NPC Wander Mechanic Stabilization).

### Session 14: 2026-10-08: P3-04 Unfair Death Warnings

**Contributor:** Codex

**Goal:** Replace the outline's unannounced secret-passage death with a source-backed, diegetic warning while preserving the intended puzzle solution.

**Done:**
- Traced the actual hazard to Script 530's eastern-tower stairwell rather than the outline's proposed Rooms 420/450.
- Confirmed that flag 32 represents the blown-out stairwell bulb, item 23 is its replacement, and the Act 5 lantern intentionally switches off below room 730.
- Redirected the unsafe dark boundary from `sFallStairs` to `sWarnDarkStairs`, which freezes input, moves Laura back to y=165, reuses the existing dark-passage Look tuple 11/1/2, and restores control.
- Preserved the original lit traversal and retained the now-unreachable fall sequence as legacy code.
- Synchronized the architecture, roadmap, decision log, changelog, handoff, and compiled manual.

**Changed:** `LB2/src/ScrewInBulb.sc`, `LB2/530.SCR`, `LB2/530.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-019 (Reuse the stairwell's existing darkness state and warning text).

**Verified:** SCI Companion compilation of Script 530 with 0 errors and 0 warnings; static boundary, message-tuple, and solution-state audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based traversal of the dark and repaired-bulb paths remains a manual regression test.

**Next session should start with:** P3-05 (Act 1 Progression Trigger Simplification).

### Session 13: 2026-10-08: P3-03 Pacing & Progression Audit

**Contributor:** Codex

**Goal:** Verify the claimed 14-eavesdrop Act 2 gate and replace it only if the source supported that progression model.

**Done:**
- Traced every `global111` reference and every direct Script 26 act-break call in the source tree.
- Confirmed that Act transitions are launched by authored story sequences and that the Act 2-to-3 transition follows the Pippin discovery/report sequence in Room 454.
- Confirmed that `global111` schedules later door-listening and character scenes across Rooms 510, 560, and 630; Script 22 and Room 610 can set it directly to 15, and Script 26 never reads it.
- Rejected the proposed synthetic knowledge bitmask because it would create a second progression model, skip authored scenes, and reinterpret existing saves.
- Superseded D-008 with D-017, marked P3-03 complete as a source-backed scope correction, and synchronized the architecture, roadmap, changelog, and manual.
- Following maintainer clarification, preserved the actual design goal as P5-01: a post-bugfix Act 2 content milestone adding compact museum puzzles and more natural routing through the essential dialogue/eavesdropping flow (D-018).

**Changed:** `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-017 (Preserve authored act transitions and scene-scheduler semantics; supersedes D-008) and D-018 (Stage Act 2 interactive content after core bug fixes).

**Verified:** Complete static progression-reference audit; documentation/manual validation; DOSBox-X original-interpreter startup smoke. No game binary changed for P3-03.

**Next session should start with:** P3-04 (Unfair Death Warnings & Secret Passage Look Mechanic).

### Session 12: 2026-10-08: P3-02 Snake Oil Refill & Inventory Feedback

**Contributor:** Codex

**Goal:** Make snake oil charge state visible and make the laboratory refill interaction direct, guarded, and easy to target.

**Done:**
- Corrected the outline's resource assumptions: Snake Oil is owned by Script 15, and its refill jar is in Room 610 rather than Room 510.
- Added a reproducible loose View 61 patch with a red-X empty cel for the inventory and toolbar loops, driven directly by `global150`.
- Replaced the jar's four-application refill bug with one-action logic that rejects a full bottle or empty jar and consumes exactly one of three jar portions.
- Enlarged the jar interaction rectangle and confirmed the original handler already had no grape prerequisite.
- Removed 23 invalid decompiler-only `name` properties exposed by the first Script 15 rebuild, then compiled Scripts 15 and 610.
- Recorded D-016, synchronized the manual, and smoke-tested the loose patch set under DOSBox-X.

**Changed:** `LB2/src/LBIconItem.sc`, `LB2/src/rm610.sc`, `LB2/15.SCR`, `LB2/15.HEP`, `LB2/61.V56`, `LB2/610.SCR`, `tools/build_snake_oil_view.py`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-016 (Use charge state as the Snake Oil UI source of truth).

**Verified:** SCI Companion compilation of Scripts 15 and 610; structural decode of all five View 61 cels; static guard/depletion audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based refill traversal remains a manual regression test.

**Next session should start with:** P3-03 (Pacing, Act Length & Diegetic Knowledge Rebalance).

### Session 11: 2026-10-07: P3-01 Dead Man Walking Prevention

**Contributor:** Codex

**Goal:** Prevent Act 5 from becoming unwinnable when Wire Cutters, Snake Oil, or Cheese were missed or exhausted earlier.

**Done:**
- Traced all three items through their inventory indices, acquisition paths, charge state, finale consumption, and the `actBreak` transition into `global123 == 5`.
- Corrected the original architectural assumption that Room 510 was a basement cache; it is a museum gallery and is not a reliable recovery boundary.
- Added a one-time supply audit to Main's central room-transition handler. Missing inventory items 10, 14, and 16 are granted, empty `global150` is restored to four charges, and unused flag 123 records completion.
- Kept the audit idempotent so existing Act 5 saves are repaired while snake oil and cheese remain consumed after their finale puzzles.
- Compiled Script 0, synchronized D-005 and the manual, and smoke-tested the loose patch set under DOSBox-X.

**Changed:** `LB2/src/Main.sc`, `LB2/0.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-005 (Softlock prevention through a guarded Act 5 supply audit).

**Verified:** SCI Companion compilation of Script 0; static inventory-index, charge-counter, and flag-use audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation. Direct save-based entry with deliberately missing items remains a manual regression test.

**Next session should start with:** P3-02 (Snake Oil Refill Mechanic & Inventory Feedback Overhaul).

### Session 10: 2026-10-07: P2-07 Dagger Discovery Reactions & Inventory Hand-off

**Contributor:** Codex

**Goal:** Make the museum cast recognize the recovered Dagger of Amon Ra and transfer physical custody to O'Reilly.

**Done:**
- Audited archived message modules 1882..1892 and identified eight accessible verb-22 reactions, most of which incorrectly described the recovered dagger as a gift-shop replica.
- Added loose overrides for modules 1884, 1885, 1887, and 1889..1892, and updated the existing 1888 override without disturbing its P2-05 introduction edits.
- Added character-specific recognition dialogue for Countess, Yvette, Steve, O'Reilly, Heimlich, Ziggy, Rameses, and Olympia.
- Updated both O'Reilly actor contexts in Scripts 90 and 93 to dispatch the ordinary dagger dialogue and then remove inventory item 11 with `(gEgo sel_351: 11)`.
- Compiled Scripts 90 and 93, recorded D-015, synchronized the manual, and smoke-tested the loose patch set under DOSBox-X.

**Changed:** `LB2/src/MuseumRgn.sc`, `LB2/src/RotundaRgn.sc`, `LB2/90.SCR`, `LB2/93.SCR`, `LB2/1884.MSG`, `LB2/1885.MSG`, `LB2/1887.MSG`, `LB2/1888.MSG`, `LB2/1889.MSG`, `LB2/1890.MSG`, `LB2/1891.MSG`, `LB2/1892.MSG`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-015 (Treat the recovered dagger as physical evidence).

**Verified:** SCI Companion compilation of Scripts 90 and 93; exact-string audit of all eight message overrides; static ownership-path review; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the hand-off remains a manual regression test.

**Next session should start with:** Phase 2 deterministic-save branch testing, then P3-01 (Dead Man Walking Prevention for Act 5 critical items).

### Session 9: 2026-10-07: P2-06 Steve & Laura Character Consistency

**Contributor:** Codex

**Goal:** Make Steve and Laura's museum romance conditional on the player establishing a personal connection in Act 1.

**Done:**
- Audited the Act 1 Steve conversation and the museum arrival/reunion sequences, then reserved previously unused relationship flag 122.
- Set flag 122 from both `sTalkSteve` and `sAskSteve` in Script 240.
- Gated the automatic kiss, embrace, and reunion paths in Scripts 330, 335, and 350 behind that flag while preserving ordinary room initialization when it is unset.
- Removed an invalid decompiler-only `name` property from `local_Steve`, compiled all four affected scripts, and normalized the loose patches to uppercase.
- Recorded D-014, synchronized the manual, and kept all documentation under `docs/` after removing the project-local 3x symlink.

**Changed:** `LB2/src/rm240.sc`, `LB2/src/rm330.sc`, `LB2/src/rm335.sc`, `LB2/src/rm350.sc`, `LB2/240.SCR`, `LB2/240.HEP`, `LB2/330.SCR`, `LB2/335.SCR`, `LB2/350.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-014 (Gate Steve romance sequences on Act 1 conversation).

**Verified:** SCI Companion compilation with zero errors or warnings; static flag-use audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct traversal of both relationship branches remains a manual save-based regression test.

**Next session should start with:** P2-07 (Dagger Discovery Reactions & Inventory Hand-off).

### Session 8: 2026-10-07: P2-05 Contextual Dialogue Logic & Acquaintance Checks

**Contributor:** Codex

**Goal:** Prevent Laura from addressing museum characters by name before a formal introduction and use DOSBox-X for runtime testing.

**Done:**
- Audited the rotunda introductions and found six existing acquaintance flags: Pippin 110, Dr. Smith 111, Countess 112, Yvette 113, O'Riley 114, and Rameses 115.
- Added first-contact Talk routing to `aPippin.sc`, `aRameses.sc`, and the Countess, O'Riley, Dr. Smith, and Yvette actors in `MuseumRgn.sc`. An unset acquaintance flag now selects condition 80; existing dialogue remains unchanged once the flag is set.
- Added loose `1882.MSG`, `1883.MSG`, and `1888.MSG` overrides. Only the first two condition-80 text records in each module change: Laura opens neutrally, then Pippin, Smith, or O'Riley identifies himself.
- Recompiled Scripts 35, 36, and 90 with SCI Companion and normalized the loose patch names to uppercase.
- Replaced the active regression-testing documentation with the checked-in DOSBox-X workflow and recorded D-013.
- Synchronized the 3x manual and rebuilt `docs/manual/manual.html`.

**Changed:** `LB2/src/aPippin.sc`, `LB2/src/aRameses.sc`, `LB2/src/MuseumRgn.sc`, `LB2/35.SCR`, `LB2/36.SCR`, `LB2/90.SCR`, `LB2/1882.MSG`, `LB2/1883.MSG`, `LB2/1888.MSG`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-013 (Reuse museum acquaintance flags for formal introductions).

**Verified:** SCI Companion compilation of Scripts 35, 36, and 90; structural parsing of all three message overrides; headless DOSBox-X startup; documentation/manual validation; unchanged base archive hashes.

**Next session should start with:** P2-06 (Steve & Laura Character Consistency).

### Session 7: 2026-10-07: P2-04 Narrative Anachronism Corrections

**Contributor:** Codex

**Goal:** Implement P2-04 by auditing the complete SCI message corpus and correcting or clarifying dialogue that conflicts with the game's 1926 setting.

**Done:**
- Parsed all 103 archived message modules and located the four obsolete target strings in modules 250, 270, and 310.
- Established from in-game evidence that the story occurs late in 1926: Rocco's license was renewed September 5, characters call the year almost over, and Lindbergh's flight is advertised for the following spring.
- Added `LB2/250.MSG`, clarifying the historically real 1926 New York-London exchange as an experimental two-way radiotelephone conversation rather than the 1927 commercial service.
- Added `LB2/270.MSG`, replacing the 1945 Pippi Longstocking misunderstanding and its follow-up with period-valid references to Pip from Dickens' *Great Expectations*.
- Added `LB2/310.MSG`, identifying *The Sun Also Rises* as Hemingway's newly published novel while retaining Ziggy's claim that he saw it before publication.
- Recorded D-012, marked P2-04 complete, synchronized the 3x manual source, and rebuilt `docs/manual/manual.html`.
- Audited the effective resource layer (archived messages plus loose overrides): 103 modules, 5,888 records, zero obsolete target strings.

**Changed:** `LB2/250.MSG`, `LB2/270.MSG`, `LB2/310.MSG`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-012 (Late-1926 historical dialogue corrections).

**Verified:** Message structure and effective-string audit (103 modules / 5,888 records / 0 obsolete strings), ScummVM detection, docs validation, 3x manual validation/build, and unchanged base archive hashes. Headless ScummVM startup produces the same pre-existing invalid-selector fault with and without the three new message patches.

**Next session should start with:** P2-05 (Contextual Dialogue Logic & Acquaintance Checks).

### Session 6: 2026-10-07: P2-03 Unused Dialogue & Murder Reaction Restoration

**Contributor:** Antigravity

**Goal:** Implement P2-03 (Unused Dialogue & Murder Reaction Restoration) to restore authored NPC murder reactions, reconnect missing interrogation branches, restore Ziggy's severed head display in room 490, and enable O'Riley's Countess murder confrontation.

**Done:**
- Audited message resources across suspect talkers (1883..1892) using custom DCL decompression tooling (`/tmp/dump_msg`). Discovered Sierra authors wrote complete, dramatic reactions for all discovered murders (Carrington, Ziggy, Ernie, Yvette, Carter, Countess, and Dagger of Amon Ra) across modules.
- Diagnosed root causes for inaccessible murder reactions:
  1. Carrington (clue 259, sequence 69): Room 630 set physical discovery flag 12 upon opening trunk, but interrogation switches checked flag 171 (only set in room 560 when finding Watney Little).
  2. Ziggy (clue 264, sequence 74): Room 435 set corpse discovery flag 72, but interrogation switches checked flag 143, and Ziggy's severed head in room 490 was gated behind `(if (proc0_2 143))`, preventing the exhibit from ever initializing.
  3. Ernie (clue 267, sequence 71): Room 420 set corpse discovery flag 67, but interrogation switches checked flag 158.
  4. Yvette (clue 266, sequence 73): Room 500 set corpse discovery flag 68 upon discovering Yvette, but interrogation switches checked flag 161 (only set after `sSmashPlaster`).
  5. Countess (clue 269, sequence 70): Sierra authored a full 8-line sequence in module 1888 for questioning O'Riley about Countess's murder, but case 269 was entirely omitted from `aORiley` in `MuseumRgn.sc`.
  6. Dagger (clue 780, sequence 75): O'Riley's reaction to finding the Dagger in the alcohol vat checked score flag 155 rather than physical item possession.
- Implemented fixes in accordance with ADR D-011:
  1. Set narrative homicide flags directly in discovery cutscenes and detail insets: `(proc0_3 171)` and `(proc0_3 134)` in `LB2/src/rm630.sc`, `(proc0_3 143)` in `LB2/src/rm435.sc`, `(proc0_3 158)` in `LB2/src/rm420.sc`, `(proc0_3 161)` in `LB2/src/rm500.sc`, `(proc0_3 165)` in `LB2/src/rm525.sc`, and `(proc0_3 155)` in `LB2/src/rm620.sc`.
  2. Implemented dual-tier fallback checks across interrogation switches in `LB2/src/MuseumRgn.sc` (Script 90), `LB2/src/RotundaRgn.sc` (Script 93), `LB2/src/aHeimlich.sc` (Script 32), and `LB2/src/aRameses.sc` (Script 36) for clues 259, 264, 266, 267, and 780.
  3. Added missing case 269 in `aORiley` in `MuseumRgn.sc` to trigger sequence 70 upon Countess's death.
  4. Restored Ziggy's severed head exhibit in `LB2/src/rm490.sc` by checking `(if (or (proc0_2 143) (proc0_2 72)))`.
- Compiled all 11 modified scripts: `32.SCR`, `36.SCR`, `90.SCR`, `93.SCR`, `420.SCR`, `435.SCR`, `490.SCR`, `500.SCR`, `525.SCR`, `620.SCR`, `630.SCR`.
- Recorded architectural decision D-011 in `docs/DECISIONS.md`.
- Updated `docs/ROADMAP.md` (P2-03 marked done), `docs/manual/amon-ra.manual.json`, and rebuilt `docs/manual/manual.html` (105 KB).
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm630.sc`, `LB2/src/rm435.sc`, `LB2/src/rm490.sc`, `LB2/src/rm420.sc`, `LB2/src/rm500.sc`, `LB2/src/rm525.sc`, `LB2/src/rm620.sc`, `LB2/src/MuseumRgn.sc`, `LB2/src/RotundaRgn.sc`, `LB2/src/aHeimlich.sc`, `LB2/src/aRameses.sc`, `LB2/32.SCR`, `LB2/36.SCR`, `LB2/90.SCR`, `LB2/93.SCR`, `LB2/420.SCR`, `LB2/435.SCR`, `LB2/490.SCR`, `LB2/500.SCR`, `LB2/525.SCR`, `LB2/620.SCR`, `LB2/630.SCR`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-011 (Unused dialogue & murder reaction restoration).

**Verified:** `python3 tools/compile.py` for all 11 scripts, `tools/check_docs.py` (0 errors), `manual.py check` (0 errors), `manual.py build` (105 KB), MD5 verification of base archives.

**Next session should start with:** P2-04 (Narrative Anachronism Corrections across MSG resources).

### Session 5: 2026-10-07: P2-02 Pocket Watch Confrontation Timing & Armor Room Lockout Implementation

**Contributor:** Antigravity

**Goal:** Implement P2-02 (Pocket Watch Confrontation Timing & Armor Room Lockout Adjustment) to guarantee Laura can retrieve Carrington's pocket watch from room 630 and present it to Countess Waldorf-Carlton in the Armor Room (room 440).

**Done:**
- Reverse-engineered bytecode and scripts for Carrington's office (`rm630.sc`), Armor Room (`rm440.sc`), Countess meeting controller (`sCountessMeeting.sc`), and the game clock engine (`triggerAndClock.sc`).
- Diagnosed compounding vanilla lockouts:
  1. Retrieving the watch in `rm630.sc` (`inWatchOpen sel_111:`) advances clock to 1:45 by setting bit 16 (`4880`) in `global124`.
  2. In `rm440.sc` `sOutTapestry` state 2, `(not (proc0_10 4880))` locked out the confrontation dialogue whenever Laura possessed the watch.
  3. In `rm440.sc` `sel_403`, `(proc0_10 8224 1)` tested whether lower bits summed to 31 (`0x1f`); possessing the watch set bit 16, prematurely triggering `sMeetingNo2` (Ziggy/Little) at 1:45 and completely skipping the Countess meeting.
  4. In `triggerAndClock.sc`, clock tick 1:45 (`145`) unconditionally relocated Countess to room 520.
- Implemented fixes in accordance with ADR D-010:
  1. Removed `(not (proc0_10 4880))` from `sOutTapestry` state 2 in `LB2/src/rm440.sc`.
  2. Modified `sel_403` in `rm440.sc` so `sMeetingNo2` only takes precedence if `(or (proc0_2 120) (proc0_10 8224))` is satisfied, ensuring Meeting 1 always precedes Meeting 2.
  3. Updated `sCountessNoMeet` state 3 in `LB2/src/sCountessMeeting.sc` so entering the room with the watch immediately triggers `sTalkWithCountess`.
  4. Updated `askQuestions of Actions` in `sCountessMeeting.sc` so presenting the watch from behind the tapestry triggers `sOutTapestry`, returning 1.
  5. In `LB2/src/triggerAndClock.sc`, preserved Countess destination at room 440 at 1:45 until `(proc0_2 120)` is set, relocating her to 520 at 2:00 (`200`).
- Compiled `LB2/440.SCR`, `LB2/441.SCR`, and `LB2/22.SCR`.
- Recorded architectural decision D-010 in `docs/DECISIONS.md`.
- Updated `docs/ROADMAP.md` (P2-02 marked done), `docs/manual/amon-ra.manual.json`, and rebuilt `docs/manual/manual.html`.
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm440.sc`, `LB2/src/sCountessMeeting.sc`, `LB2/src/triggerAndClock.sc`, `LB2/440.SCR`, `LB2/441.SCR`, `LB2/22.SCR`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-010 (Pocket watch confrontation timing and Armor Room lockout adjustment).

**Verified:** `python3 tools/compile.py rm440`, `python3 tools/compile.py sCountessMeeting`, `python3 tools/compile.py triggerAndClock`, `python3 tools/check_docs.py` (0 errors), `python3 tools/manual.py check` (0 errors), `manual.py build` (104 KB).

**Next session should start with:** P2-03 (Unused Dialogue & Murder Reaction Restoration in MSG resources).

### Session 4: 2026-10-07: P2-01 Notebook Fallback Triggers Implementation

**Contributor:** Antigravity

**Goal:** Implement P2-01 (Inaccessible Plot Information & Notebook Fallback Triggers) to guarantee all Act 2 suspects and museum staff (Najir, Miklo, Countess, etc.) are registered in Laura's notebook regardless of Act 1 inquiry choices.

**Done:**
- Reverse-engineered SCI 1.1 `RESOURCE.MSG` decompression and identified Category 1 suspect clues 257–274.
- Discovered vanilla bug: clues 263–272 (Steve, Ziggy, Heimlich, Yvette, Ernie, Rameses, Countess, Olympia, Tut, Watney) were strictly gated behind optional Act 1 dialogues, locking players out of Act 2 interrogations.
- Implemented dual-tier fallback in accordance with ADR D-009:
  1. Diegetic guest register check in `LB2/src/rm335.sc` (Script 335) registering clues 263..272 in `sGiveInvite` state 5 and `sExitNorth` state 3.
  2. Direct Look/Talk encounter triggers in `LB2/src/RotundaRgn.sc` (Script 93) across all 11 rotunda characters (Countess, Heimlich, Olympia, O'Riley, Pippin, Rameses, Steve, Tut, Watney, Yvette, Ziggy).
- Fixed syntax error in `RotundaRgn.sc` (`name "O'Riley"` instance property conflict with `sel_20`).
- Updated `tools/compile_any.c` to support case-insensitive, extension-agnostic target lookup in SCI Companion's SysListView32.
- Successfully compiled `LB2/335.SCR`, `LB2/335.HEP`, `LB2/93.SCR`, and `LB2/93.HEP`.
- Documented architectural decision D-009 in `docs/DECISIONS.md`.
- Updated `docs/ROADMAP.md` (P2-01 marked done), updated `docs/manual/amon-ra.manual.json`, and built `docs/manual/manual.html`.
- Validated docs with `tools/check_docs.py` (0 errors, 0 warnings) and `manual.py check` (0 errors).

**Changed:** `LB2/src/rm335.sc`, `LB2/src/RotundaRgn.sc`, `LB2/335.SCR`, `LB2/335.HEP`, `LB2/93.SCR`, `LB2/93.HEP`, `tools/compile_any.c`, `tools/compile_any.exe`, `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-009 (Dual-tier notebook fallback triggers for Act 2 suspects).

**Verified:** `python3 tools/compile.py rm335`, `python3 tools/compile.py RotundaRgn`, `python3 tools/check_docs.py` (0 errors), `python3 tools/manual.py check` (0 errors), `manual.py build` (104 KB).

**Next session should start with:** P2-02 (Pocket Watch Confrontation Timing & Armor Room Lockout Adjustment in room 440).

### Session 3: 2026-10-07: Phase 1 Overhaul Completion & Multi-Pass Convergence

**Contributor:** Antigravity

**Goal:** Implement and verify all Phase 1 items (P1-01 through P1-06) covering interrogation UI, save/load, pixel hunts, memory bug, animation/scaling glitches, and art preservation.

**Done:**
- P1-01: Interrogation UI streamlined with direct tab pre-selection (People tab / last active tab) and double-click to confirm inquiry in `LB2/src/NotebookItem.sc` (Script 20).
- P1-02: Unrestricted save/load enabled across all screens by protecting settings/save icon 7 in `LB2/src/IconI.sc` (Script 937), `LB2/src/Main.sc` (Script 0), `LB2/src/LBRoom.sc` (Script 17), and eliminating icon disables in chase and corpse rooms (Scripts 525, 560, 565, 610).
- P1-03: Expanded clickable hitboxes for skeleton key glint on painting in `rm500.sc` (Script 500), staggered intercom buttons in `Button.sc` (Script 562), poetry book in `MyFeature.sc` (Script 650), museum dagger in `rm400.sc` (Script 400), and Ernie's corpse hairs in `rm420.sc` (Script 420); enabled Look and Magnifier interactions.
- P1-04: Fixed Act 2 About screen memory check error in `Main.sc` (Script 0) sel_613 by removing false `(== global123 2)` (`gAct == 2`) lockout.
- P1-05: Fixed character door clipping for Countess in `sCountessMeeting.sc` (Script 441) and Olympia in `rm600.sc` (Script 600); corrected Laura and pursuer scaling in chase rooms (`rm500.sc`, `rm510.sc`) and rotunda headdress rooms (`rm350.sc`, `rm355.sc`, `rm360.sc`, `rm370.sc`); eliminated Steve cutscene collision overlap in `rm350.sc`.
- P1-06: Verified 256-color art deco asset preservation and immutable base archives (`LB2/RESOURCE.000`, `LB2/RESOURCE.MAP`) with identical MD5 checksums against vanilla.
- Automated multi-pass compilation across all 219 scripts in SCI Companion under Wine to resolve self-referencing cross-script dependencies and symbol tables (`996.voc`).
- Synchronized 3x manual scheme sources (`docs/manual/amon-ra.manual.json`) and rebuilt `docs/manual/manual.html`.

**Changed:** `LB2/src/Main.sc`, `LB2/src/LBRoom.sc`, `LB2/src/NotebookItem.sc`, `LB2/src/rm350.sc`, `LB2/src/rm355.sc`, `LB2/src/rm360.sc`, `LB2/src/rm370.sc`, `LB2/src/rm400.sc`, `LB2/src/rm420.sc`, `LB2/src/sCountessMeeting.sc`, `LB2/src/rm500.sc`, `LB2/src/rm510.sc`, `LB2/src/rm525.sc`, `LB2/src/rm560.sc`, `LB2/src/Button.sc`, `LB2/src/rm565.sc`, `LB2/src/rm600.sc`, `LB2/src/rm610.sc`, `LB2/src/MyFeature.sc`, `LB2/src/IconI.sc`, `docs/ROADMAP.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`.

**Decisions:** D-001 (Floppy base v1.000 preserved), D-002 (Loose patch overrides), D-003 (Interrogation streamlining), D-004 (Unrestricted save/load).

**Verified:** `python3 tools/check_docs.py` (0 errors, 0 warnings); `python3 tools/manual.py check` (5 sections, 29 entries, 0 errors); `manual.py build` (103 KB compiled standalone manual); 3-pass compilation of all 219 scripts in SCI Companion; MD5 verification of base archives.

**Not verified:** Full playthrough regression from start to end in DOSBox-X.

**Problems / surprises:** Wine ERROR_ALREADY_EXISTS (183) during script compilation due to case-insensitive rename collisions resolved by automated pre-compile purging and uppercase promotion.

**Corrections:** Self-referencing script dependencies resolved via 3-pass compile all.

**Left undone:** Phase 2 (P2-01 through P2-07) narrative coherence and dialogue accessibility.

**Next session should start with:** Phase 2 implementation starting with P2-01 (inaccessible plot info and notebook fallback triggers for Najir, Miklo, Countess) and P2-02 (pocket watch confrontation timing in Armor Room).

### Session 2: 2026-10-07: Voiceover Policy and Diegetic Act 2 Pacing Integration

**Contributor:** Antigravity

**Goal:** Incorporate maintainer feedback regarding voiceover omission (D-007) and diegetic knowledge progression (D-008).

**Done:** Recorded D-007 (omitting insensitive CD audio tracks, text-first with future voiceover hooks) and D-008
(diegetic knowledge threshold and contextual museum puzzles); updated P2-03 and P3-03 in `docs/ROADMAP.md`,
`docs/ARCHITECTURE.md`, `docs/manual/amon-ra.manual.json`, and rebuilt `docs/manual/manual.html`.

**Changed:** `docs/DECISIONS.md`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/HANDOFF.md`, `docs/manual/manual.html`.

**Decisions:** D-007 (Text-first, omit CD voices, future voice hooks), D-008 (Diegetic knowledge gating for Act 2).

**Verified:** `tools/check_docs.py` passes (0 errors, 0 warnings); `manual.py check` passes (0 errors, 0 warnings).

**Not verified:** In-engine script compilation.

**Problems / surprises:** None.

**Corrections:** None.

**Left undone:** P1-01 through P4-06 implementation.

**Next session should start with:** Decompiling target scripts in SCI Companion and executing P1-04 and P1-03 fixes.

### Session 18: 2026-10-08: P4-02 Evidence Validity, Red Herrings & Inquest Credit

**Contributor:** Codex

**Goal:** Make the inquest recognize planted physical evidence and reward careful investigation using the game's canonical resources.

**Done:**
- Traced the complete questionnaire and final evaluation to Script 750, correcting the outline's proposed Scripts 700/720.
- Identified Pippin's notepad (item 21/clue 790) as the appointment schedule; confirmed that carbon paper item 29/clue 798 instead contains an unrelated fencing message.
- Made opening Room 454's authored bloody high-heel footprint inset persist discovery through unused point bit 179.
- Added a post-question Script 750 review that independently recognizes the Ankh, Pippin's appointment notepad, and the footprint paired with Yvette's shoe, explains their evidentiary limits, and awards one-time point bits 180..182.
- Preserved questionnaire correctness and ending-tier logic for P4-03 through P4-06, then compiled both scripts and synchronized the roadmap, architecture, decision log, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm454.sc`, `LB2/src/rm750.sc`, `LB2/454.SCR`, `LB2/454.HEP`, `LB2/750.SCR`, `LB2/750.HEP`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-023 (Reconcile canonical planted evidence in Script 750).

**Verified:** SCI Companion compilation of Scripts 454 and 750; static evidence-identity, ownership, and unique point-bit audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the footprint and evidence-review branches remains a manual regression test.

**Next session should start with:** P4-03 (Hint Book Contradictions & Best Ending Alignment).

### Session 19: 2026-10-08: P4-03 Hint Book Contradictions & Best Ending Alignment

**Contributor:** Codex

**Goal:** Make the best-ending evidence gate match Sierra's published investigation requirements instead of vanilla's accidental subset.

**Done:**
- Audited the owner-supplied OneShortEye issue analysis, Sierra's official hint book, and all Script 750 outcome branches.
- Confirmed that vanilla's “all evidence” check included only dagger, grapes, wire cutters, bifocals, and red hair, while the hint book names 13 objects.
- Added a shared Script 750 predicate for all 13 objects and used it consistently in both local result and `global126` outcome selection.
- Preserved evidence credit after dagger surrender and carbon-paper consumption through existing bits 155 and 170.
- Added non-scoring Room 560 discovery bit 183 so inspecting or taking Watney's police file satisfies the published requirement.
- Compiled Scripts 560 and 750, recorded D-024, added the research-source index, and synchronized the roadmap, architecture, changelog, test plan, handoff, and manual.

**Changed:** `LB2/src/rm560.sc`, `LB2/src/rm750.sc`, `LB2/560.SCR`, `LB2/750.SCR`, `docs/ROADMAP.md`, `docs/ARCHITECTURE.md`, `docs/DECISIONS.md`, `docs/CHANGELOG.md`, `docs/TESTING.md`, `docs/reference/README.md`, `docs/manual/amon-ra.manual.json`, `docs/manual/manual.html`, `docs/HANDOFF.md`, `docs/archive/SESSION_LOG_2026_10.md`.

**Decisions:** D-024 (Use Sierra's complete evidence checklist for the best ending).

**Verified:** SCI Companion compilation of Scripts 560 and 750; static 13-item checklist and durable-state audit; DOSBox-X original-interpreter startup smoke; documentation/manual validation; unchanged base archive hashes. Direct save-based traversal of the full positive and negative ending matrix remains a manual regression test.

**Next session should start with:** P4-04 (Quiz / Dagger Possession Logic Decoupling).

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

### Session 1: 2026-10-07: Dev Plan & Modernization Roadmap Creation

**Contributor:** Antigravity

**Goal:** Establish development plan, architecture, and roadmap for modernizing The Dagger of Amon Ra using the floppy
release and SCI Companion.

**Done:** Created `docs/ROADMAP.md` covering all 24 items (P1-01 through P4-06); authored `docs/ARCHITECTURE.md`,
`docs/DECISIONS.md` (D-001 through D-006, Q-001, Q-002), `docs/TESTING.md`, `docs/SECURITY.md`, `docs/CHANGELOG.md`,
`docs/CONTRIBUTING.md`, `docs/README.md`, `AGENTS.md`, and `CLAUDE.md`; authored and compiled 3x manual `docs/manual/manual.html`.

**Changed:** Initialized project memory and documentation toolchain.

**Decisions:** D-001 (Floppy base v1.000), D-002 (Loose patch overrides), D-003 (Interrogation streamlining),
D-004 (Unrestricted save/load), D-005 (Softlock prevention), D-006 (Inquest scoring standardization).

**Verified:** `tools/check_docs.py` passes; `manual.py check` passes; ScummVM detects game; Wine executes SCI Companion.

**Not verified:** Script decompilation output and in-engine regression saves.

**Problems / surprises:** None.

**Corrections:** None.

**Left undone:** P1-01 through P4-06 implementation.

**Next session should start with:** Decompiling target scripts in SCI Companion and executing P1-04 and P1-03 fixes.

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
### Session 32: 2026-10-10: Ziggy Cross-Act Dialogue Pass

**Contributor:** Codex and maintainer

**Goal:** Give Ziggy one readable voice across both acts, preserving his criminal connections and comedy while replacing cartoon-Brooklyn eye-dialect with a nervous Peter Lorre-inspired cadence.

**Done:**
- Reworked all 30 Ziggy spoken records in Room 310 and all 85 in module 1890 as one continuous characterization: soft-spoken, ingratiating, evasive, and suddenly precise when threatened.
- Retained selective period slang including “Philly,” “sawbuck,” “lifted,” “copper,” and “stoolie,” along with the Hemingway bluff, Rameses riddle, police arrangement, Countess anxiety, fencing offers, carbon-paper clue, and Yvette history.
- Replaced the anachronistic Seabiscuit/Hialeah tip with a fictional Belmont runner and recast generalized remarks about Egyptians as personal irritation with Rameses's riddles.
- Repaired the diary answer that was written in Ziggy's voice but assigned Laura's talker ID; rewrote Laura's pronunciation-dependent John Bow exchange and both narrator descriptions.
- Added `docs/dialogue/act1-ziggy.json` and `docs/dialogue/act2-ziggy.json`; extended `tools/dialogue.py` with idempotent, explicit `set_talker` support for the one metadata correction.

**Changed:** `LB2/310.MSG`, `LB2/1890.MSG`, `tools/dialogue.py`, both Ziggy manifests, and synchronized roadmap, decision, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** Both manifests apply idempotently; all 72 records in module 310 and 114 in module 1890 parse; text changes are confined to the 120 manifest entries; only the documented diary-response talker ID changes; documentation/manual validation and DOSBox-X startup smoke pass.

**Next session should start with:** Maintainer review of Ziggy, then Tut and adjacent-speaker cleanup.
### Session 33: 2026-10-10: P2-08 Final Dialogue Sweep

**Contributor:** Codex and maintainer

**Goal:** Complete P2-08 with Tut Smith, deferred murder reactions, adjacent-speaker corrections, and isolated lines that reintroduced caricature or anachronism.

**Done:**
- Reworked all 87 Tut Smith spoken records, plus nine paired Laura responses, as an educated and imposing Cairo Museum envoy: fiercely committed to repatriation, vain, patriarchal, and suspicious without pulp-Egyptian cliches.
- Preserved Tut's motive, threats, Yvette proposals, evasive Rameses connection, ankh loss, Dagger claim, and later reactions while replacing camel, snake-charmer, amputation, racial-superiority, and mystical-native jokes.
- Rewrote all deferred murder reactions for Rameses, Heimlich, Yvette, and O'Riley in their approved voices, including Laura's line mocking Rameses's lisp.
- Cleaned adjacent Pippin, Countess, Steve, and Olympia lines; retained their vanity, class prejudice, morbidity, and plot information without collateral ethnic caricature.
- Replaced all five impossible 1926 references to the `Andrea Doria`, corrected Rameses I chronology, and fixed `hieroglyphs` and `Ruhmkorff` terminology.
- Corrected three talker-ID errors: Ziggy's diary advice, Yvette's diary answer, and Laura's clue question to O'Riley.

**Changed:** Message modules 1882–1885, 1887–1892, and 310; character and straggler manifests in `docs/dialogue/`; `tools/dialogue.py`; and synchronized roadmap, decision, handoff, and manual documentation.

**Decisions:** D-031. P2-08 is complete.

**Verified:** Exact comparison accounts for all 1,424 records across the 11 target modules; all unmanifested text is byte-identical to `HEAD`; all routing/reference metadata is unchanged except the three documented talker IDs; every manifest reapplies idempotently; obsolete caricature/anachronism scan reports zero hits; documentation/manual checks and DOSBox-X startup smoke pass.

**Next session should start with:** Resume the clean DOSBox-X playthrough and record any dialogue that needs contextual adjustment before P5-01.

### Session 34: 2026-10-10: P2-08 Effective-Layer Closure Audit

**Contributor:** Codex and maintainer

**Goal:** Reopen P2-08 after a full effective-message audit found dialogue outside the previously reviewed character-topic modules.

**Done:**
- Parsed all 103 effective message modules and 5,888 records, overlaying every loose patch on the archived resource layer.
- Rewrote the module 120 Pippin/Tut confrontation, module 335 Heimlich check-in, all fourteen module 340 party conversations, and the module 355 Carter murder scene in the established character voices.
- Reworked the Act 1 sandwich vendor and cabbie without removing their rapid sales patter, impatience, lechery, or New York character.
- Removed the four remaining `Andrea Doria` records, completing all nine original occurrences; corrected three remaining `Ruhmkorf` spellings and the underlying instrument-maker history.
- Replaced two uses of an ethnic slur in the street-kid scene, corrected two Carrington spelling errors, and assigned Carrington's interrupted response to talker 11 instead of narrator 99.
- Added twelve closure manifests and loose message overrides while preserving the immutable resource archives.

**Changed:** Message modules 10, 15, 120, 210, 240, 250, 260, 335, 340, 355, 630, and 1886; twelve manifests under `docs/dialogue/`; and synchronized roadmap, decision, changelog, handoff, and manual documentation.

**Decisions:** D-031 remains the governing decision. P2-08 is closed only after auditing both character-topic and room/cutscene message modules.

**Verified:** Exact structural comparison of 2,726 records across all 26 P2-08 modules; 1,025 manifest entries current and idempotent; all noun/verb/condition/sequence/reference metadata preserved; exactly four documented talker-ID repairs; all 5,888 effective records parse; no targeted Act 1/2 caricature or listed factual strings remain; documentation/manual checks and DOSBox-X original-interpreter startup smoke pass.

**Next session should start with:** Resume the DOSBox-X playthrough and review the party conversations in context before beginning the later-act dialogue pass or P5-01.

### Session 35: 2026-10-10: Act 3 Rameses and Heimlich Dialogue Pass

**Contributor:** Codex and maintainer

**Goal:** Carry Rameses and Wolf Heimlich's approved Act 2 voices into their Act 3 room, intercom, and murder-discovery scenes without changing mystery progression.

**Done:**
- Reworked Rameses's complete private exchanges with Yvette and Olympia, preserving the secret-room leverage, marriage, Eiffel Tower joke, Toledo sword, foot tattoos, and Egyptian sun-symbol clues.
- Reworked Heimlich's Olympia intercom and office scenes, historically grounded his Heidelberg scars in academic fencing, and retained his ambition, morbidity, romantic vanity, and implied danger.
- Reworked the Ziggy and Ernie discovery scenes with readable Heimlich and O'Riley voices while preserving Laura's suspicion, every murder clue, the security rivalry, and the grape/flask exchange.
- Replaced two laboratory warnings and closed the missed Act 2 gift-shop exchange.
- Added nine tuple-addressed manifests and loose overrides for modules 400, 562, 610, 1440, 1490, 1500, 1560, and 1600.

**Changed:** `LB2/400.MSG`, `LB2/562.MSG`, `LB2/610.MSG`, `LB2/1440.MSG`, `LB2/1490.MSG`, `LB2/1500.MSG`, `LB2/1560.MSG`, `LB2/1600.MSG`, nine manifests under `docs/dialogue/`, and synchronized roadmap, decision, changelog, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 423 records structurally compared against archived resources; 117 reviewed tuples current and idempotent; all tuple/talker/reference metadata and untargeted text preserved; documentation/manual validation and DOSBox-X startup smoke pass.

**Next session should start with:** Continue the Act 3 character audit after maintainer review of the next draft.

### Session 36: 2026-10-10: Act 3 Yvette Dialogue Pass

**Contributor:** Codex and maintainer

**Goal:** Carry Yvette's approved fluent, intelligent, and deliberately sensual voice through every Act 3 appearance without weakening her relationships or plot disclosures.

**Done:**
- Reworked eleven exchanges spanning the O'Riley exercise intercom, Ernie's private office and interruptions, Steve after Ernie's death, Olympia's chicken-bone joke, Steve's neck rub, both O'Riley relationship scenes, Laura's interruption and grief interview, and Dr. Smith's private exchange.
- Preserved Yvette's sexual confidence and strategic charm while allowing her grief for Ernie to read sincerely; softened Laura's dismissive “I know your type” response without removing suspicion.
- Preserved the Icepick gambling-debt trail, Big Al fencing, Ernie's secret observation, O'Riley's bribery account, Carrington/Dagger allegation, Dr. Smith's museum secret, and the isolated “loan fish” misunderstanding that identifies a loan shark.
- Added six tuple-addressed manifests and loose overrides for modules 640, 1510, and 1550; updated the existing 562, 610, and 1560 overrides without disturbing prior Heimlich or Rameses work.

**Changed:** `LB2/562.MSG`, `LB2/610.MSG`, `LB2/640.MSG`, `LB2/1510.MSG`, `LB2/1550.MSG`, `LB2/1560.MSG`, six manifests under `docs/dialogue/`, and synchronized roadmap, decision, changelog, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 342 records structurally compared against archived resources; 130 reviewed Yvette-scene tuples current and idempotent; all tuple/talker/reference metadata and untargeted text preserved; documentation/manual validation and DOSBox-X startup smoke pass.

**Next session should start with:** Continue the Act 3 character audit with O'Riley or the next maintainer-selected character.

### Session 37: 2026-10-10: Act 3 Dialogue Closure

**Contributor:** Codex and maintainer

**Goal:** Close O'Riley's remaining Act 3 dialogue, repair missed earlier-act stragglers, and complete every remaining substantive Act 3 character review before moving to Act 4.

**Done:**
- Replaced O'Riley's final untouched Act 3 dismissal with a brazen “police business” cover when Laura catches him with Yvette.
- Reworked the missed Pippin murder-discovery interrogation, preserving O'Riley's immediate accusation, his question about the murderer, and his order that Laura remain in the building while removing “banshee,” “lass,” and repeated stage-Irish “then.”
- Added separate tuple manifests for modules 454 and 1550; deferred the six module-770 jail-yard threats to the ending audit.
- Reworked Ziggy and Ernie's intercom dispute in their approved voices and removed the final unreviewed use of cartoon-Brooklyn phonetics from Ziggy's Act 3 material.
- Reworked all 75 records in the Countess's confrontation, diary, pocket-watch, and nervous-talk branches; preserved her camp, entitlement, criminal vanity, threats, and self-incrimination while replacing incessant typographic shouting with grand diction.
- Reworked Tut Smith's 25-record alibi interview, Olympia's remaining snake-oil and private-office scenes, and Ernie's incidental office ejections without changing any clue or scheduler route.
- Verified that Olympia's reference to Steve's scars is intentional continuity, corroborated by their following encounter and Steve's own explanation; preserved it unchanged in meaning.
- Closed two missed earlier-act lines for Ziggy and the street kid, then scanned the complete effective message layer. Only two target hits remain, both Heimlich lines belonging to later material and queued for Act 4.

**Changed:** `LB2/260.MSG`, `LB2/310.MSG`, `LB2/454.MSG`, `LB2/562.MSG`, `LB2/640.MSG`, `LB2/1440.MSG`, `LB2/1450.MSG`, `LB2/1520.MSG`, `LB2/1550.MSG`, `LB2/1600.MSG`, nine new manifests and two extended manifests under `docs/dialogue/`, and synchronized roadmap, decision, changelog, handoff, and manual documentation.

**Decisions:** D-031.

**Verified:** All 626 records across the ten touched modules structurally compared; 155 reviewed tuples current and idempotent; all tuple/talker/reference metadata and untargeted text preserved; effective-layer target scan clear through Act 3; documentation/manual validation and DOSBox-X startup smoke pass.

**Next session should start with:** Begin Act 4 with Heimlich's two identified module-1889 stragglers, then inventory the remaining cast by effective scene ownership.
