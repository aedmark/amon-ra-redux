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

### 3. Save/Load Subsystem & Chase Safety (`Script 0`, `Script 500` - `550`)
- **Vanilla Flow:** CD release disabled `theIconBar` save buttons in Act 5 chase sequences, causing instant-death punishment.
- **Modernized Flow (P1-02, D-004):** `(theIconBar disable: ICON_SAVE)` calls are removed across chase rooms. Chase villain timer threads check `(theGame isPaused:)` during save dialog interaction to prevent ambush deaths upon restore.

### 4. Progression State Engine & Diegetic Gating (`Script 0`, `Script 230`)
- **Vanilla Flow:** Act 2 progression required waiting for 14 arbitrary hallway eavesdropping scenes.
- **Modernized Flow (P3-03, D-008):** Progression advances once Laura achieves a diegetic threshold of case knowledge (uncovering core suspect motives, alibis, and relationships) through any combination of questioning, discovery, and observation. Act 2 is supplemented with contextual puzzle hooks (inspecting exhibit locks, checking visitor logs) to give players meaningful investigative agency.

### 5. Softlock Prevention & Item Management (`Script 20`, `Script 510`)
- **Vanilla Flow:** Missing Wire Cutters, Snake Oil, or Cheese in earlier acts creates unrecoverable "Dead Man Walking" states in Act 5.
- **Modernized Flow (P3-01, P3-02, D-005):** Emergency backup items are placed in Room 510 (Basement). The snake oil inventory item in `20.SCR` utilizes dynamic multi-cel views (empty vs full) and guards against redundant refills.

### 6. Coroner Inquest & Scoring Logic (`Script 700`, `Script 720`, `Script 780`)
- **Vanilla Flow:** Quiz scoring errors retroactively forced the epilogue to report the Dagger was lost even if Laura retained it. Act score divisors were inconsistent and uninitialized grade indices flashed startup F grades.
- **Modernized Flow (P4-04, P4-05, P4-06, D-006):** Physical dagger ownership is decoupled from questionnaire score. The total point denominator is standardized, and homicide inquest questions are delineated from optional museum trivia.

## Invariants and boundaries

1. **Archive Immutability:** `RESOURCE.000` and `RESOURCE.MAP` must never be directly modified. All fixes are delivered as loose files.
2. **Floppy Visual Preservation:** No dithered or downgraded CD background graphics may replace the original 256-color hand-painted brushstroke assets (P1-06).
3. **Voiceover Policy:** Original CD voice tracks remain excluded; talker hooks remain clean for prospective voice talent (D-007).
4. **Save Compatibility:** Save files (`LB2SG.*`) must deserialize safely across patched rooms without pointer corruption.
5. **Toolchain Portability:** Development workflow must remain fully operational under Linux using Wine for SCI Companion and DOSBox-X for original-interpreter regression testing.
