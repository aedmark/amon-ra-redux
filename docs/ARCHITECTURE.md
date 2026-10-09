# Architecture

A technical specification of the SCI 1.1 engine architecture, resource patching model, and modernization subsystems
for *The Dagger of Amon Ra: Redux*.

## System overview

*The Dagger of Amon Ra: Redux* modernizes Sierra On-Line's 1992 adventure game *The Dagger of Amon Ra* (Laura Bow II).
The project builds upon the DOS Floppy v1.000 release (D-001) using a modular loose-patch architecture (D-002).

```
                                 +-------------------------+
                                 |   SCI Companion (Wine)  |
                                 +------------+------------+
                                              |
                   Decompile & Edit           | Compile Source (.sc)
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
| **Base Assets** | `LB2/RESOURCE.000`, `LB2/RESOURCE.MAP`, `LB2/VERSION` | Immutable v1.000 floppy media providing uncompressed 256-color art deco backgrounds and baseline audio drivers. |
| **SCI Companion** | `/home/gordonk/PycharmProjects/SCICompanion/Release/SCICompanion.exe` | Win32 MFC IDE executed under Wine to decompile bytecode, edit message tables, inspect polygon barriers, and recompile scripts. |
| **Loose Patch Store** | `LB2/*.SCR`, `LB2/*.HEP`, `LB2/*.MSG` | High-priority drop-in script chunks overriding buggy procedures without modifying `RESOURCE.000`. |
| **Testing Harness** | `./tools/run_dosbox.sh` | DOSBox-X execution of Sierra's original interpreter with the checked-in sound, mount, and startup configuration for deterministic save-state verification. |
| **3x Manual System** | `docs/manual/` | Portable What/How/Why specification validated against `manual.schema.json` and compiled to standalone `docs/manual/manual.html`. |

## Key subsystem architectures

### 1. Interrogation and Notebook Engine (`Script 13`, `Script 0`)
- **Vanilla Flow:** Requires 5 sequential clicks: Select Ask icon -> Click NPC actor -> Select Category tab -> Select Topic string -> Click Ask confirmation.
- **Modernized Flow (P1-01, D-003):** The actor `doVerb` handler captures `vAsk`. If the notebook is closed, it launches directly focused on the target NPC's available topics. If double-clicked, it re-queries the previous subject or context clue immediately.

### 2. Dialogue & Voiceover Asset Subsystem (`RESOURCE.MSG`, `Script 90`)
- **Vanilla Flow:** Floppy release relies exclusively on text `.MSG` lumps; later CD release bundled caricatured voice tracks widely criticized for cultural insensitivity.
- **Modernized Flow (P2-03, D-007):** Original CD voice tracks are omitted. All inaccessible murder discussions and death messages are modernized strictly via text `.MSG` message lumps. SCI talker sync and audio hooks remain intact to support future community voice packs.
- **Historical Text Layer (P2-04, D-012):** Modules 250, 270, and 310 are supplied as loose `.MSG` overrides. They replace the postwar Pippi reference, distinguish the experimental 1926 transatlantic radiotelephone exchange from the 1927 commercial service, and identify *The Sun Also Rises* as a newly published late-1926 novel.
- **Acquaintance Routing (P2-05, D-013):** Actor scripts 35, 36, and 90 consult the existing museum acquaintance flags 110..115 before ordinary Talk handling. An unset flag routes to the character's condition-80 formal introduction; message overrides 1882, 1883, and 1888 remove the remaining name assumptions and let Pippin, Dr. Smith, and O'Riley identify themselves.
- **Steve Relationship Continuity (P2-06, D-014):** Script 240 sets flag 122 when Laura initiates Talk or Ask with Steve in Act 1. Scripts 330, 335, and 350 require that flag before starting the museum reunion, kiss, or embrace sequences, so ignoring Steve preserves a professional coworker relationship instead of manufacturing romantic familiarity.
- **Dagger Evidence Hand-off (P2-07, D-015):** Loose message modules 1884, 1885, and 1887..1892 replace replica/gift-shop reactions with character-specific recognition of the recovered artifact. O'Reilly's Script 90 and Script 93 actors intercept the dagger's verb 22 after ordinary dialogue dispatch and call `(gEgo sel_351: 11)`, making inventory ownership the canonical custody state without allocating another flag.
- **Museum Dialogue Movement Lock (P3-06, D-021):** Script 90 routes museum `MuseumActor` messages through `sel_668`, which marks the actor dialogue-locked before disposing its current mover. `TravelToRoom.sel_145` refuses to advance while that lock is set. The shared `museumDialogueResume` callback clears the lock when `Messager` closes and re-enters the travel script's current state, preserving both fixed destinations and random-wander routes instead of assigning a new destination. Script 22 skips O'Reilly's 10:15 removal only while `global123` is Act 3 or Act 4.

### 3. Save/Load Subsystem & Chase Safety (`Script 0`, `Script 500` - `550`)
- **Vanilla Flow:** CD release disabled `theIconBar` save buttons in Act 5 chase sequences, causing instant-death punishment.
- **Modernized Flow (P1-02, D-004):** `(theIconBar disable: ICON_SAVE)` calls are removed across chase rooms. Chase villain timer threads check `(theGame isPaused:)` during save dialog interaction to prevent ambush deaths upon restore.

### 4. Progression State Engine & Story Scheduling (`Script 26`, Scripts 22, 250, 454, 510, 560, 610, 630)
- **Act 1 Errand Gate (P3-05, D-020):** Script 22 stores the press pass, docks visit, baseball trade, and Ziggy conversation as independent `global124` bits 1, 2, 4, and 8. Script 250 formerly used `(proc0_10 16 1)` to require the entire low nibble before displaying the dirty taxi; because its claim ticket is the route to Lo Fat's evening gown, three otherwise optional errands became mandatory. The taxi's three coordinated state checks now use `(proc0_10 1)`, making the persistent press-pass milestone sufficient while preserving the dirty-taxi scene, claim ticket, gown exchange, and dressed Act 1 transition.
- **Audited Flow (P3-03, D-017):** The outline's alleged Act 2 gate requiring 14 eavesdropping scenes does not exist. Act changes are explicit calls to room 26 (`actBreak`) from authored story sequences; the Act 2-to-3 transition is driven by the Pippin discovery/report sequence in room 454. `global111` is a later ordered scene scheduler shared by rooms 510, 560, and 630, while Script 22's clock logic may set it directly to 15 at 3:00. It is neither a knowledge bitmask nor consulted by `actBreak`.
- **Preservation Rule:** Do not replace `global111` with an aggregate clue threshold. Skipping its intermediate values can suppress staged conversations, character movement, and murder-era timing, and changing its meaning would reinterpret existing saves. Add future museum activities only as independently scoped content with their own narrative and asset specification.
- **Post-Bugfix Expansion (P5-01, D-018):** Act 2's passive pacing remains a design target even though it is not caused by a numeric gate. After Phases 3 and 4, add several compact investigations that use existing museum geography and lead naturally into the essential conversation schedule. New activities must layer onto—not replace—the authored transition and scheduler state, with explicit clue, score, message, and old-save behavior.

### 5. Fair-Play Hazard Warnings (`Script 530`)
- **Dark Stairwell Warning (P3-04, D-019):** The hidden eastern-tower stairwell uses flag 32 for its blown-out bulb state and item 23 as the intended replacement light. Crossing its north boundary while dark now starts `sWarnDarkStairs`, which halts Laura, moves her back to a safe coordinate, and displays the existing noun 11 / verb 1 / condition 2 warning already used by the `darkPassage` Look handler. The original lit traversal remains unchanged. Inventory item 15 is not treated as the solution because its timer intentionally disables the lantern in rooms below 730.

### 6. Softlock Prevention & Item Management (`Script 0`, `Script 15`)
- **Vanilla Flow:** Missing Wire Cutters, Snake Oil, or Cheese in earlier acts creates unrecoverable "Dead Man Walking" states in Act 5.
- **Act 5 Supply Audit (P3-01, D-005):** Main's room-transition handler performs one guarded audit when `global123` first equals 5. Missing inventory indices 10 (Wire Cutters), 14 (Snake Oil), and 16 (Cheese) are restored; an empty oil charge counter (`global150 == 0`) is reset to four. Flag 123 makes the repair idempotent, including for existing Act 5 saves, and prevents oil or cheese from reappearing after their intended finale use.
- **Snake Oil Feedback (P3-02, D-016):** `global150` remains the authoritative four-charge counter. The Snake Oil item in Script 15 maps nonzero charges to View 61's original cel 0 and zero charges to the loose patch's red-X cel 1 in both inventory and toolbar loops. Room 610's laboratory oil jar refills a non-full bottle in one action, rejects full-bottle and empty-jar attempts, consumes one of its three portions, and exposes an enlarged interaction rectangle. The audited vanilla handler has no grape dependency, so none was introduced.

### 7. Coroner Inquest & Scoring Logic (`Script 750`, `Script 780`)
- **Vanilla Flow:** Quiz scoring errors retroactively forced the epilogue to report the Dagger was lost even if Laura retained it. Act score divisors were inconsistent and uninitialized grade indices flashed startup F grades.
- **Watney Evidence Discovery (P4-01, D-022):** Script 560 owns the police-file path: its bookcase opens a closed-book inset, whose concealed file is inventory item 24. The special volume's rectangle is expanded from 11x15 to 36x38 pixels, and the full bookcase accepts Look, Hand, or Magnifier as a discovery fallback until the file is acquired. Looking at the exposed file idempotently adds clue 793 (its contents) and clue 272 (Watney's People entry); the original Take path still adds both clues, awards its authored point, and grants the item.
- **Planted-Evidence Review (P4-02, D-023):** The questionnaire and final evaluation are both in Script 750, not the outline's proposed Scripts 700/720. Room 454 records inspection of its bloody high-heel footprint with unused point bit 179. After question 16, Script 750 separately recognizes inventory item 20 (Ankh), item 21 (Pippin's appointment notepad), and the bit-179 footprint plus item 30 (Yvette's shoe). The coroner explains why each is useful but not dispositive and awards idempotent insight points 180, 181, and 182. Carbon paper item 29 is not a schedule and remains unrelated evidence.
- **Hint-Book Evidence Alignment (P4-03, D-024):** Script 750's best-evidence predicate now implements Sierra's complete 13-item list rather than the vanilla subset of dagger, grapes, cutters, bifocals, and red hair. Inventory remains authoritative for ordinary evidence. Previously recorded acquisition/read state supplies equivalent credit for the surrendered dagger (bit 155) and consumed carbon paper (bit 170), while Room 560 records non-scoring police-file discovery in unused bit 183 so either Look or Take satisfies the file requirement. Murder-answer and theft-answer correctness remain separate inputs to `global126`.
- **Physical Dagger Outcome (P4-04, D-006, D-025):** Script 750 retains `global126`'s four quiz-result states while the coroner delivers feedback. At the epilogue boundary it preserves the murder-solved dimension (states 1/4 versus 2/3), replaces the theft-quiz dimension with actual recovery `(item 11 or bit 155)`, and writes the normalized four-state outcome before routing. The newspaper art, solved/unsolved scene, and all 19 Script 785 character cards therefore agree with physical history, including a dagger surrendered to O'Reilly.
- **Attainable Grade Denominators (P4-05, D-006, D-026):** Script 26 grades cumulative `global15` points at each act break. Its original divisors overstated the attainable maxima after Act 2. Auditing every idempotent score flag gives vanilla maxima `5/12/37/47/50`; Redux's footprint point 179 raises Acts 2–5 to `13/38/48/51`. Those five values are now the divisors, so a complete act reports 100%. Grade-band selection is skipped while `global123 == 0`, preventing the ungraded introduction from advancing the first F-message counter. The three P4-02 coroner-review points occur after the Act 5 grade and bring the final raw tally from 51 to 54 without pretending they were available earlier.
- **Required and Bonus Inquest Sections (P4-06, D-027):** Script 750 labels questions 1–11 as required case findings: questions 1–9 alone can invalidate the murder verdict, and questions 10–11 alone can invalidate the coroner's dagger-theft assessment. Questions 12–16 now run in a separate `sBonusQuestions` state machine under an explicit bonus-museum-inquiries notice. They preserve all authored art-theft, High Priest, feedback, and conditional-skip content but contain no writes to either verdict flag, so bonus answers cannot change the coroner result or ending route.

## Invariants and boundaries

1. **Archive Immutability:** `RESOURCE.000` and `RESOURCE.MAP` must never be directly modified. All fixes are delivered as loose files.
2. **Floppy Visual Preservation:** No dithered or downgraded CD background graphics may replace the original 256-color hand-painted brushstroke assets (P1-06).
3. **Voiceover Policy:** Original CD voice tracks remain excluded; talker hooks remain clean for prospective voice talent (D-007).
4. **Save Compatibility:** Save files (`LB2SG.*`) must deserialize safely across patched rooms without pointer corruption.
5. **Hybrid Version Handling (D-028):** The floppy has SCI1.1 scripts but an SCI1-style 6-byte `RESOURCE.MAP`. Compile with SCI Companion's map format at 1.1, one script at a time via `tools/compile.py`; never run Compile All or a resource rebuild, and boot the game after every compile.
6. **Toolchain Portability:** Development workflow must remain fully operational under Linux using Wine for SCI Companion and DOSBox-X for original-interpreter regression testing.
