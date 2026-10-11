# Session handoff

Read this first when resuming work. Rewrite the top half whenever current state changes materially or work pauses
with context another session needs. The session log is append-only history.

Protocol: [AGENTS.md](../AGENTS.md). Plan: [ROADMAP.md](ROADMAP.md). Architecture:
[ARCHITECTURE.md](ARCHITECTURE.md). Decisions: [DECISIONS.md](DECISIONS.md). Tests: [TESTING.md](TESTING.md).
Security: [SECURITY.md](SECURITY.md). Changes: [CHANGELOG.md](CHANGELOG.md). Older sessions:
[archive/](archive/README.md).

---

## Current state

_Last updated: 2026-10-11, session 45: diegetic benefit register and identity flow._

**Where things stand, in one paragraph:** Alpha v0.01 is public in the SQH Discord from `master`. During the maintainer's playthrough, P2-01's invisible all-cast check-in grant was replaced with an inspectable Room 335 benefit register. Lo Fat now names only Yvette while foreshadowing Heimlich and Olympia, Ernie retains his personal introduction, Ziggy remains an unsigned interloper, and Watney stays concealed behind Carrington's identity until evidence exposes him. Scripts 270, 335, and 93 compile, their message manifests are idempotent, and the immutable base archives retain their vanilla hashes. Runtime register placement and interaction still require the maintainer's DOSBox-X save test.

**Verified** (2026-10-11, Linux workspace)

| Suite | Result |
| --- | --- |
| P2-01 identity-flow refinement | **Compile/static pass: explicit register records clues 263, 265, 266, 268..271; Lo Fat records only Yvette; disguised Carrington cannot add Watney 272** |
| Public alpha test plan | **Published: Markdown guide plus a self-contained Neocities-ready page with direct v0.01 download, persistent checklist, spoiler-separated regression targets, and report template** |
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
- **Act 2 Dialogue:** Rameses, Heimlich, Yvette, O'Riley, Ziggy, and Tut Smith use distinct, readable period characterization across character topics, the museum entry, all fourteen party conversations, the Carter murder scene, Pippin discovery, deferred reactions, and adjacent cleanup lines (P2-08, D-031).
- **Act 3 Dialogue:** Rameses, Heimlich, Yvette, O'Riley, Ziggy, Ernie, the Countess, Tut Smith, and Olympia retain their approved voices through private conversations, intercom scenes, laboratory warnings, relationships, office interruptions, evidence confrontations, alibi interviews, grief interviews, and murder discoveries (P2-08, D-031).
- **Act 4 Dialogue:** Laura, Steve, Olympia, and Heimlich retain their established character beats through the reunion, forged-painting discovery, murder/Dagger reactions, and lantern warning without residual mock-German spelling (P2-08, D-031).
- **Act 5 Dialogue:** Rameses's Society confrontation and riddle, Tut's inquest testimony, Steve's already-clean escape dialogue, and O'Riley's jailhouse threat preserve the ending while removing the final phonetic caricatures (P2-08, D-031).
- **Act 6 Dialogue:** The coroner conducts the complete final inquest in a dry, exacting professional voice; every question, evidence check, joke, verdict, and ending route remains intact (P2-08, D-031).
- **Source Baseline:** P5-00's Sluicebox-annotated effective reconstruction is active under D-032; normal work remains single-script compilation under D-028.
- **Documentation Architecture:** `docs/ROADMAP.md`, `DECISIONS.md` (D-001 through D-033), `docs/manual/`, `docs/manual/manual.html`, and `docs/PLAYTEST_CHECKLIST.md` synchronized.

**Not verified**

- End-to-end multi-act playthrough regression testing in DOSBox-X.
- Direct in-game verification of the playtest findings during continuous run.

**Gotchas for the next session**

- Do not replace numeric selectors with contextual readable aliases; one selector ID can have several receiver-specific names (D-032).
- Rebuild the developer vocabulary with `python3 tools/normalize_selector_vocab.py LB2/997.voc LB2/997.voc.tmp`, then replace it only after validation.
- Keep loose patch files in `LB2/` strictly uppercase (`.SCR`, `.HEP`, `.MSG`).
- Before any SCI Companion GUI action, inspect the active window and verify the loaded archive/project identity; if it is ambiguous, ask the maintainer rather than closing, reloading, or choosing a window by inference.
- Single-script compilation only: use `python3 tools/compile.py <script>`. Never use Compile All or resource rebuild.
- If a script disappears from SCI Companion's list when patch files are deleted, restore files and restart with `wineserver -k`.

## Next steps (in order)

1. From the Act 2 entrance save, verify Heimlich's register description, the register hotspot with Look/Hand/Magnifier, its seven intended notebook entries, and the absence of Ziggy, Ernie, and Watney.
2. Resume the clean DOSBox-X playthrough and triage every remaining `PLAY-nnn` finding.
3. Begin P5-01 design only after the playthrough gate closes, using the migrated compiler-facing source baseline.

## Open questions for maintainers

None currently open. Q-001 and Q-002 have been resolved by D-007, D-017, and D-018.

## Session log

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
