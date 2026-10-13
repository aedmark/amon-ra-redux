# Alpha playtesting guide

Thank you for testing *The Dagger of Amon Ra: Redux*. This alpha is a modernization patch for the DOS floppy version
of Sierra's *The Dagger of Amon Ra*. It repairs bugs, softlocks, interface problems, clue logic, scoring, and dialogue
while preserving the original mystery, artwork, puzzles, and character arcs.

This is still an alpha. A complete game can take many hours, so reports from partial runs are useful too. Strange
behavior, awkward wording, missing music, visual glitches, and small continuity problems are all worth reporting—not
only crashes.

## Before you begin

- Use the build named `LB2-Redux-v0.02.zip` and keep an untouched backup.
- Extract it into a fresh directory. Do not mix its files with another Redux build, the CD edition, or an existing
  modded installation.
- Start a new game for the most useful test. Old Sierra saves, including v0.01 saves, may contain state that bypasses a fix.
- DOSBox-X is the reference environment. Reports from ScummVM are welcome, but identify them as ScummVM results.
- Keep several rotating saves, especially near the end of each act and immediately before anything goes wrong.
- Do not overwrite the save that reproduces a bug. Attach the complete matching `LB2SG.*` save set when possible.

If launching manually in DOSBox-X, mount the extracted game directory as drive C and run `SCIDHUV.EXE`. Repository
users can run `./tools/run_dosbox.sh` from the project root.

## What's new in v0.02

- Act 2's check-in no longer hands Laura the whole cast list. A leather-bound benefit register on a podium beside
  Heimlich records the guests and staff when Laura reads it, and Hand lets her sign it.
- Lo Fat foreshadows two museum figures instead of naming them outright.
- Saving a new game no longer overwrites your previous save. If you tested v0.01, your saves may have been
  overwritten silently; please re-check save and restore with several slots.
- The title screen's restore option now reads “Resume Case.”

## What every tester should watch for

- [ ] The game starts without a black screen, Sierra error dialog, or missing-resource message.
- [ ] A new game reaches the newsroom and responds normally to mouse and keyboard input.
- [ ] Save, restore, restart, and quit work wherever the interface makes them available.
- [ ] Several saves made in a row each keep their own slot; none replaces an earlier save unless you choose Replace.
- [ ] Restoring a save preserves the room, score, inventory, notebook, music, clock, and character positions.
- [ ] No character disappears during a conversation, walks through scenery, or blocks progression.
- [ ] Room exits, enlarged close-ups, dialogue windows, and the icon bar open and close cleanly.
- [ ] Music starts, stops, changes, and resumes naturally across rooms and after restore.
- [ ] Inventory items are not duplicated, lost early, or restored after their intended use.
- [ ] Scores are awarded once, survive restore, and produce a believable grade at each act break.
- [ ] Rewritten dialogue is clear, period-appropriate, and consistent with what Laura currently knows.
- [ ] Required clues and conversations remain discoverable without following one exact walkthrough route.
- [ ] The game can be played from the introduction through the credits without a crash or softlock.

## Spoiler-light playthrough checklist

Use this section if you want to play naturally without being told where every clue is.

### Prologue and Act 1

- [ ] Explore freely, use the About screen, save and restore, and try optional errands in different orders.
- [ ] Pay close attention to taxi recognition, the dirty cab, the claim ticket, and travel after receiving the ticket.
- [ ] Visit the speakeasy more than once and enter and leave its bathroom while a song is playing.
- [ ] Ask Ziggy about every available person, especially Yvette and the Countess.
- [ ] Confirm the first act grade appears against an appropriate neutral frame.

### Act 2

- [ ] Note which People and Things appear in the notebook immediately upon arrival.
- [ ] Find the benefit register and try every action on it, more than once, both after walking up and while standing
  right in front of it.
- [ ] Meet characters in an unusual order and watch for anyone Laura names before learning who they are.
- [ ] Ask characters about people standing nearby and note any response that feels unnaturally isolated.
- [ ] Confirm characters remain present until a conversation ends, then resume moving normally.
- [ ] Follow the party and eavesdropping sequence without a walkthrough and report any unclear next step or long stretch
  with nothing interactive to do.

### Acts 3 and 4

- [ ] Revisit characters after every major discovery and look for missing, premature, or contradictory reactions.
- [ ] Check whether time-sensitive characters and confrontations remain reasonably available.
- [ ] Use both ordinary Look and the Magnifying Glass on small or reflective clues.
- [ ] Save before dark or dangerous routes and report deaths that occur without a fair warning.
- [ ] Examine bookshelves, files, footprints, and other evidence before taking anything.

### Act 5

- [ ] Confirm the game does not become unwinnable because an essential item was missed or used earlier.
- [ ] Exercise the snake-oil refill puzzle, including trying a full bottle and returning after all refills are gone.
- [ ] Save and restore during the chase and other dangerous sequences.
- [ ] Show recovered evidence to multiple characters before surrendering it to the police.

### Act 6 and ending

- [ ] Confirm the inquest clearly distinguishes required case questions from bonus museum questions.
- [ ] Answer some bonus questions incorrectly and check that the murder verdict still reflects the required evidence.
- [ ] Check that the newspaper, ending, character cards, score, and final grade agree with what Laura actually solved and
  recovered.
- [ ] Let the credits finish and confirm the game exits or returns cleanly.

<details>
<summary><strong>Focused regression checklist — contains substantial spoilers</strong></summary>

### Prologue and Act 1

- [ ] The About screen opens without a false memory warning.
- [ ] Speaking with Steve records the personal relationship path; skipping him produces the professional greeting later.
- [ ] Once Laura shows her press pass, the cabbie remembers her.
- [ ] The dirty cab appears only after a prior normal ride and acquisition of the press pass.
- [ ] The docks, baseball trade, and Ziggy conversation are optional; none is required merely to obtain the gown.
- [ ] After Laura takes the claim ticket, ordinary taxi travel never puts her in the dirty cab again.
- [ ] Lo Fat accepts the ticket, supplies the gown, and the dressed taxi trip advances to Act 2.
- [ ] The speakeasy rotates both songs. Entering the bathroom interrupts the current song; returning resumes it without
  restarting.
- [ ] The street outside Lo Fat's laundry has its intended music.
- [ ] The two men at the speakeasy bar have distinct Look and Talk feedback.
- [ ] Ziggy acknowledges knowing Yvette and the Countess without revealing later plot information.
- [ ] The Act 1 grade uses the gold Art Deco frame rather than a skull-and-crossbones frame.

### Act 2: museum party

- [ ] Check-in alone does not fill the notebook; reading the entrance register adds its named guests and staff, while Ziggy, Ernie, and Watney remain absent.
- [ ] Laura cannot walk through or behind the register podium from either side.
- [ ] Look, Hand, and the Magnifying Glass walk Laura to stand in front of the podium before the response.
- [ ] Hand signs the register once; repeating it says she already signed, and Look then mentions her signature.
- [ ] Repeating Look and Hand without moving shows only the register response, with no brief generic message first,
  no palette change, freeze, or error, and no duplicate People entries.
- [ ] Lo Fat names Yvette in Act 1 but only foreshadows the severe security chief and black-clad woman doctor.
- [ ] Ernie enters after introducing himself, and Watney Little appears only after Laura discovers evidence or hears an explicit identification.
- [ ] Pippin, Dr. Smith, the Countess, Yvette, O'Riley, and Rameses introduce themselves if their earlier introduction
  was missed.
- [ ] Steve's greeting reflects whether Laura spoke with him in Act 1.
- [ ] Asking Carrington about Pippin while Pippin is nearby produces a believable exchange.
- [ ] Discussed notebook topics show completion and reopen only when new information becomes available.
- [ ] Walking characters pause for the entire conversation and resume the same route afterward.
- [ ] Essential conversations and eavesdropping scenes remain available in their intended order without a hidden
  conversation counter.
- [ ] Discovering and reporting Pippin's body advances to Act 3 without unrelated optional conversations.
- [ ] A complete run can earn the full Act 2 grade.

### Act 3

- [ ] The skeleton-key glint is comfortably discoverable with Look and the Magnifying Glass.
- [ ] The Countess remains available for the intended Armor Room meeting.
- [ ] The pocket-watch confrontation is not lost merely because the clock has passed 1:45.
- [ ] Characters react to murders only after Laura learns of the corresponding death.
- [ ] O'Riley remains available after 10:15 for follow-up questions.
- [ ] Notebook completion marks and reopened topics track genuinely new dialogue.
- [ ] A complete run can earn the full Act 3 grade.

### Act 4

- [ ] The dark eastern stairwell stops Laura with a repeatable warning instead of killing her at the threshold.
- [ ] Replacing the bulb makes the stairwell traversable.
- [ ] Watney Little's police file can be found through the Room 560 bookcase and its enlarged special-volume target.
- [ ] Looking at the exposed file records both its contents and Watney's People entry before Take.
- [ ] Inspecting Pippin's bloody high-heel footprint preserves it for the inquest evidence review.
- [ ] Restored homicide reactions, including O'Riley's Countess response, remain reachable.
- [ ] A complete run can earn the full Act 4 grade.

### Act 5

- [ ] Entry restores genuinely missing wire cutters, snake oil, or cheese once, without duplicating held items.
- [ ] The empty snake-oil bottle looks empty; the laboratory jar refills it in one action.
- [ ] The jar permits three successful refills and rejects a full bottle or a depleted jar.
- [ ] Intended item consumption does not cause the safety check to recreate the item later.
- [ ] The recovered dagger receives character-specific reactions.
- [ ] Giving the dagger to O'Riley removes it from inventory but retains recovery credit.
- [ ] A complete run can earn the full Act 5 grade.

### Act 6 and ending

- [ ] Questions 1–11 are labeled as required case findings; questions 12–16 are labeled as bonus museum inquiries.
- [ ] Bonus answers change only their own feedback, not the verdict or ending route.
- [ ] The Ankh, Pippin's appointment notepad, and the bloody footprint/Yvette shoe comparison each receive a separate,
  one-time acknowledgement.
- [ ] A surrendered dagger, consumed carbon paper, and inspected-but-not-taken police file retain evidence credit.
- [ ] Test as many of these combinations as practical: murders solved/dagger recovered; murders solved/dagger not
  recovered; murders unsolved/dagger recovered; neither solved nor recovered.
- [ ] The newspaper, ending route, and every character card agree with the tested combination.
- [ ] Final scores and ranks are internally consistent, and optional museum trivia cannot lower the verdict.

</details>

## How to report a problem

Post in the SQH Discord release thread or open a
[GitHub issue](https://github.com/aedmark/amon-ra-redux/issues). One report per problem is ideal. Search briefly for an
existing report first, but add your save or reproduction details when they provide new information.

Please use this template:

```text
Alpha build: v0.02
Environment: DOSBox-X version / ScummVM version / other
Operating system:
Act and location:
In-game clock and score:

What happened:
What I expected:
Steps to reproduce:
Does it happen after restoring and trying again? Always / sometimes / once

Attachments: save files, screenshot, video, DOSBox-X log
Anything unusual about this run: old save, alternate route, skipped conversation, custom MIDI setup, etc.
```

For a crash, include the exact Sierra error number or missing-resource text. For dialogue, quote the shortest phrase
needed to identify the line and explain what Laura should know at that moment. For music, describe the room entered,
the room exited, and whether a song stopped, restarted, resumed, or never began.

## What makes a particularly valuable test

- Taking an unusual but legitimate route instead of following a walkthrough.
- Restoring a save made before an act transition and choosing a different order of actions.
- Skipping optional conversations and confirming the main mystery still works.
- Showing evidence to every plausible character.
- Testing low, middle, and perfect-score act grades.
- Completing the inquest with deliberately mixed correct and incorrect answers.
- Reporting something that feels *off* even when it is not technically broken.

Thank you for helping make this the careful, definitive version this remarkable game deserves.
