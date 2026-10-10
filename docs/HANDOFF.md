# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-10, session 34: P2-08 effective-layer closure audit._

**Where things stand, in one paragraph:** P2-08 is complete after an effective-layer closure audit of all 5,888 message records exposed room- and cutscene-specific dialogue outside the character-topic modules. Act 1 now includes readable sandwich-vendor and cabbie voices; Act 2 now covers the Pippin/Tut confrontation, museum entry, all fourteen party conversations, and Carter's immediate murder scene in addition to the character modules and deferred reactions. All nine original `Andrea Doria` references, the remaining `Ruhmkorf` spellings, two uses of an ethnic slur, two Carrington spelling errors, and Carrington's misassigned reply are corrected. Twenty-six tuple manifests account for 1,025 reviewed entries across 2,726 records, with only four documented talker-ID repairs (D-031).

**Verified** (2026-10-10, Linux workspace)

| Suite | Result |
| --- | --- |
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
| P4-06 Script compilation | **Pass: 750.SCR/750.HEP emitted by SCI Companion** |
| P4-05 Script compilation | **Pass: 26.SCR/26.HEP emitted by SCI Companion** |
| P4-04 Script compilation | **Pass: 750.SCR emitted by SCI Companion** |
| P4-03 Script compilation | **Pass: 560.SCR and 750.SCR emitted by SCI Companion** |
| P4-02 Script compilation | **Pass: 454.SCR/454.HEP and 750.SCR/750.HEP emitted by SCI Companion** |
| P4-01 Script compilation | **Pass: 560.SCR/560.HEP emitted by SCI Companion** |
| P3-06 Script compilation | **Pass: 90.SCR/90.HEP and 22.SCR/22.HEP emitted by SCI Companion** |
| P3-04 Script compilation | **Pass: 530.SCR/530.HEP emitted by SCI Companion** |
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
- **Act 2 Dialogue:** Rameses, Heimlich, Yvette, O'Riley, Ziggy, and Tut Smith use distinct, readable period characterization across character topics, the museum entry, all fourteen party conversations, the immediate Carter murder scene, deferred reactions, and adjacent cleanup lines (P2-08, D-031).
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-001 through D-031), `docs/manual/`, `docs/manual/manual.html`, and `docs/PLAYTEST_CHECKLIST.md` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game verification of the playtest findings during continuous run.

**Gotchas for the next session**

- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`, `.MSG`).
- Single-script compilation only: use `python3 tools/compile.py <script>`. Never use Compile All or resource rebuild.
- If a script disappears from SCI Companion's list when patch files are deleted, restore files and restart with `wineserver -k`.

## Next steps (in order)

1. Resume the clean DOSBox-X playthrough and note any dialogue that reads poorly in context.
2. Triage and resolve or schedule every remaining `PLAY-nnn` finding.
3. Begin P5-01 only after the playtest gate closes.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

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
