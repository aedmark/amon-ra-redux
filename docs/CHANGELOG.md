# Changelog

All notable changes to the *The Dagger of Amon Ra: Redux* project will be documented here.

The format is based on [Keep a Changelog](https://keepachangelog.com/en/1.1.0/).

## [Unreleased]

## [0.09-alpha] - 2026-10-16

### Changed
- Redux now ships as a patch: the download contains only Redux's own files, to extract over your own copy of the DOS floppy release (version 1.000). It no longer includes any of Sierra's files. The game itself is unchanged from 0.08 (D-047, D-048).

## [0.08-alpha] - 2026-10-16

### Fixed
- Meeting Dr. Smith for the first time in Act 3, Laura no longer admires the ankh he has lost. He now reacts when shown his ankh or the Dagger, Dr. Carrington reacts to the Dagger, and Yvette remembers that Dr. Smith wore an ankh at the party rather than wearing one now (PLAY-037).

## [0.07-alpha] - 2026-10-16

### Changed
- In Act 3, more of the museum comes alive: O'Riley patrols between the pterodactyl room, the dagger case, and the spot where Pippin died; Dr. Carrington and, from 11:15, Olympia follow the rounds Sierra wrote for them; and between eavesdropping scenes Yvette strolls the Rodin room outside her office (PLAY-036, D-046).

### Fixed
- Once O'Riley takes the dagger, it leaves the notebook too, so you can no longer ask about it as if you still had it (PLAY-035, D-015).
- Entering the back storeroom no longer crashes to DOS with "Build Line Error". The snake oil bottle's redrawn graphics were stored in a form the original interpreter cannot draw on screen (PLAY-034, D-016).
- Using Hand on a vat in the preservation lab climbs it again, instead of walking Laura out of the room. Every earlier alpha had this bug (PLAY-033).

## [0.06-alpha] - 2026-10-16

### Changed
- The skull in Olympia's office opens the secret passage without sending Laura in; she can examine the darkness first, then walk in when you choose (PLAY-027, D-044).
- The Countess's dialogue no longer relies on constant capitals; her grand manner now comes from her phrasing (PLAY-028, D-045).
- The Thinker's raised head has its own descriptions, and its neck no longer describes a seam once the head is up (PLAY-029).

### Fixed
- Touching the stairwell's burned-out bulb says "Ouch!" only right after it burns out; later it hints that you need a spare, and with a spare in hand it swaps the bulb (PLAY-026).
- The police-file volume in Carrington's office responds when you click the books on its shelves (PLAY-030).
- The intercom's buttons respond when you click them directly (PLAY-031).
- The Ankh near Pippin's body is easier to click; the v0.04 enlargement missed the medallion's lower half (PLAY-018).
- Looking at the bloody footprint beside Pippin's body describes it, instead of giving the generic reply until the Magnifying Glass had been used (PLAY-032).
- Using the carbon paper on Yvette's floor lamp while it is off, or after taking its bulb, gives the normal "You can't read it this way" reply instead of a message error (PLAY-025).

## [0.05-alpha] - 2026-10-14

### Changed
- Ziggy's lines in the party eavesdropping scenes and over the intercom share his restored voice (D-043).
- Ziggy answers about Pippin Carter at the party, and after Pippin's death (PLAY-020).
- Ziggy no longer faces Laura's bluff about the Countess before Laura has asked the Countess about him (PLAY-021).
- Pippin acknowledges Rameses Najeer, the museum's accountant, instead of claiming never to have heard of him (PLAY-022).

### Fixed
- Steve's 7:30 meeting in the front rotunda: he now enters from the side opposite Laura and they face each other when they talk (PLAY-023).
- The grade text between acts appears on black with Art Deco window corners, not over the act marquee with the death window's bones (PLAY-024).
- Asking the Countess, Dr. Carrington, Olympia, O'Riley, Tut, Yvette, or Ziggy about anything from Act 3 on no longer stops with a "not found" message error. A bug in the Redux conversation lock looked every one of their lines up in the wrong message file (PLAY-019, P3-06).

## [0.04-alpha] - 2026-10-14

### Changed
- Ziggy is a slippery stool pigeon again: slang, swagger, mangled big words, and come-ons return to all his dialogue, with a light accent instead of the original phonetic spelling (D-043).
- Looking at the banner outside the museum in Act 1 notes that the party calls for formal evening attire (PLAY-012).
- At the party, Rameses talks about Ziggy as someone he met that evening, and Yvette's view of Dr. Smith no longer asks whether he killed Dr. Carter before anyone has died (PLAY-013, PLAY-015, D-042).
- Ziggy now knows Heimlich, who checked his invitation, and Dr. Smith, who stands across from him at the party (PLAY-014).
- Yvette speaks of Pippin in the present tense until Laura learns of his death (PLAY-015).

### Fixed
- The coroner's final inquest uses the game's standard object layout again. The previous build placed every inquest object's properties one slot off, which could stop the inquest from advancing and misplace its props (D-040).
- Leaving the Egyptian room to the south in Acts 3 and 4 pauses the rotating music instead of sending the command to the wrong object (D-040).
- Leaving the speakeasy stops its rotating music, as in the original game (D-040).
- Ernie's office (room 640) handles room and Ernie actions with the correct class again (D-040).
- Using an unhandled item on the Egyptian room's dagger case or its glass gives the standard response instead of running stray code from the original patch (D-040, D-041).
- Party guests at the front rotunda's buffet table block walking, and Steve's 7:30 meeting with Laura happens beside them instead of among them (PLAY-016).
- Leaving the front rotunda for the Mastodon Room no longer draws Laura's head over the doorway's lintel (PLAY-017).
- The Ankh near Pippin's body is easier to click (PLAY-018).

## [0.03-alpha] - 2026-10-13

### Changed
- Examining Heimlich at the museum door with the Magnifying Glass now shows the narrator's description of his scars, followed by his irritated reply. The description was previously unreachable.
- Revised the wording of the benefit register and Heimlich's check-in lines.

## [0.02-alpha] - 2026-10-12

### Changed
- Replaced the invisible Act 2 all-cast notebook grant with an inspectable benefit register on a podium beside Heimlich. Reading it records only legitimate guests and staff; Ziggy never signed, Ernie keeps his natural introduction, and Watney stays hidden behind Carrington's identity until evidence exposes him. Hand signs Laura's name once; later Looks reflect her signature (P2-01, D-009, D-033).
- The podium blocks ordinary walking, and Look, Hand, and Magnifier stop Laura in front of it. Old saves receive the current room boundary safely (D-033, D-034).
- Lo Fat now foreshadows Heimlich and Olympia without naming them while preserving Yvette's explicit Act 1 introduction and related inquiry dialogue (P2-01).
- The title screen's restore option now reads “Resume Case.”

### Fixed
- Repeated register inspections no longer corrupt the People list or crash with Error 5 when rediscovering existing clues (shared Script 21 clue insertion).
- Repeating Look or Hand while Laura stands at the podium shows only the guestbook response, with no flash of a generic message (D-035, D-036).
- Saving a new game no longer overwrites the previous saved game; each save receives its own slot (Script 990).

## [0.01-alpha] - 2026-10-11

### Added
- Comprehensive 4-phase modernization roadmap covering all 24 items from the design outline (`docs/ROADMAP.md`).
- Machine-readable 3x Documentation Scheme data source (`amon-ra.manual.json`) and compiled standalone HTML (`docs/manual/manual.html`).
- Engine architecture, decision records (`D-001` to `D-006`), testing matrix, and agent instructions.
- Verification harness integrating Wine-based SCI Companion and DOSBox-X.

### Changed
- Restored the speakeasy's randomized music rotation and seamless bathroom-return continuity, replaced the skull-and-crossbones act-grade backdrop with the native gold Art Deco frame, and gave Ziggy truthful Act 1 replies about Yvette and the Countess (PLAY-003, PLAY-010, PLAY-011).
- Completed the Act 6 dialogue audit by giving the coroner a dry, exacting professional voice throughout the final inquest, replacing dated language and needlessly hysterical accusations while preserving all sixteen questions, evidence checks, jokes, verdicts, and ending routes (P2-08, D-031).
- Migrated all 221 compiler-facing scripts to a coherent Sluicebox-annotated baseline reconstructed from the effective Redux resources, preserving every compiled fix while replacing opaque global/object/procedure names and documenting selector-vocabulary constraints and provenance (P5-00, D-032).
- Completed the Act 5 and ending dialogue audit: removed Rameses's written lisp from the full Society of Amon Ra confrontation, distinguished its invented sacrifice rite from ancient Egyptian history, restored Tut Smith's dignified inquest testimony, and gave O'Riley a readable final jailhouse threat (P2-08, D-031).
- Completed the compact Act 4 dialogue audit: polished Laura and Steve's reunion without removing Olympia's intentional interest in Steve's dock scars or Steve's forged-painting discovery, and replaced Heimlich's last mock-German exclamations and lantern gibberish with his established controlled authority (P2-08, D-031).
- Completed the Act 3 dialogue audit with Ziggy and Ernie's intercom dispute, the Countess's full criminal confrontation, Tut Smith's alibi interview, Olympia's remaining snake-oil and private-office scenes, and Ernie's incidental ejections; retained the Countess's camp, Olympia's morbidity, Steve's intentional scars continuity, and every clue and route while removing residual phonetic caricature and excessive typographic shouting (P2-08, D-031).
- Closed Detective O'Riley's reviewed Act 3 dialogue with a brazen “police business” cover when Laura catches him with Yvette, and cleaned his missed Pippin murder-scene interrogation without changing the discovery sequence (P2-08, D-031).
- Extended Yvette's fluent, intelligent, and deliberately sensual voice through eleven Act 3 exchanges while preserving her genuine grief for Ernie, Steve's neck rub, the O'Riley corruption clues, Icepick's gambling-debt trail, Dr. Smith's secret, and the clue-bearing “loan fish” misunderstanding (P2-08, D-031).
- Continued the period-dialogue pass into Act 3: gave Rameses and Heimlich consistent approved voices across private conversations, intercom scenes, laboratory warnings, and the Ziggy and Ernie murder discoveries; grounded Heimlich's Heidelberg scars in academic fencing and cleaned one missed Act 2 gift-shop exchange (P2-08, D-031).
- Completed the Act 1/2 period-dialogue closure sweep: rewrote the sandwich vendor, cabbie, Pippin/Tut confrontation, museum check-in, all fourteen party conversations, and Carter murder scene; removed the remaining `Andrea Doria`, `Ruhmkorf`, and ethnic-slur text; and corrected Carrington's misassigned reply (P2-08, D-031).
- Began the act-by-act period dialogue pass with Act 1: rewrote Lo Fat, Sgt. O'Flaherty, and Detective O'Riley to replace phonetic ethnic caricature with distinct, readable voices while preserving clues, jokes, period characterization, and O'Riley's deliberately antagonistic bluster (P2-08, D-031).
- Split the coroner questionnaire into clearly labeled required case findings (questions 1–11) and bonus museum inquiries (questions 12–16); optional art-theft and High Priest answers are structurally isolated from verdict and ending state (P4-06, D-027).
- Corrected cumulative act-grade divisors to attainable Redux point totals (`5/13/38/48/51`) and stopped the ungraded introduction from consuming the first F-grade narrator message (P4-05, D-026).
- Decoupled dagger recovery from theft-quiz correctness at the epilogue boundary, so the newspaper, ending route, and character outcome cards recognize a dagger Laura retained or surrendered to O'Riley (P4-04, D-025).
- Aligned the Super Sleuth evidence gate with Sierra's complete 13-item hint-book checklist, retaining discovery credit for a surrendered dagger, read carbon paper, and an inspected police file (P4-03, D-024).
- Added an inquest evidence review for the Ankh, Pippin's appointment notepad, and the bloody high-heel footprint/Yvette shoe comparison; the coroner now identifies these as possible framing evidence and awards one-time investigative insight credit (P4-02, D-023).
- Made Watney Little's police file discoverable from Room 560's full bookcase as well as an enlarged special-volume hotspot, and record both the file and Watney notebook clues when the exposed file is inspected (P4-01, D-022).
- Paused museum NPC travel for the full lifetime of their dialogue and resumed the same route afterward; kept O'Riley available past 10:15 in Acts 3 and 4 for follow-up questioning (P3-06, D-021).
- Made the press pass the sole milestone for the Act 1 dirty taxi and gown claim ticket, so the docks visit, baseball trade, and Ziggy conversation remain optional side paths rather than a four-errand progression gate (P3-05, D-020).
- Replaced the eastern-tower stairwell's unannounced darkness death with a safe threshold warning that reuses its existing treacherous-staircase Look text and preserves the replacement-bulb solution (P3-04, D-019).
- Audited P3-03's pacing premise and preserved the game's authored event-driven act transitions after confirming that no 14-eavesdrop Act 2 gate exists; routed the genuine passive-pacing concern into post-bugfix milestone P5-01 for new museum investigation mechanics around the essential conversations (D-017, D-018).
- Reworked snake oil feedback and refilling: empty bottles now show a red-X inventory/toolbar cel, the Room 610 laboratory jar refills in one guarded action, full bottles and empty jars are rejected, and the jar has a larger click target (P3-02, D-016).
- Added a one-time, save-compatible Act 5 supply audit that restores missing Wire Cutters, Snake Oil, and Cheese and refills an empty oil bottle without recreating items after use (P3-01, D-005).
- Reworked the accessible cast's recovered-dagger reactions and made either O'Riley actor remove the Dagger of Amon Ra from Laura's inventory when accepting it as evidence (P2-07, D-015).
- Gated Steve and Laura's museum romance sequences behind an Act 1 conversation flag, preserving professional continuity when Laura previously ignored Steve (P2-06, D-014).
- Corrected premature familiarity for six museum characters by reusing their existing acquaintance flags and adding neutral self-introductions for Pippin, Dr. Smith, and O'Riley (P2-05, D-013).
- Corrected late-1926 dialogue chronology in message modules 250, 270, and 310: replaced the postwar Pippi Longstocking reference, clarified the experimental transatlantic radiotelephone exchange, and identified *The Sun Also Rises* as newly published (P2-04, D-012).
