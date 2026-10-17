# Alpha playtesting guide

Thank you for testing *The Dagger of Amon Ra: Redux*. This alpha is a modernization patch for the DOS floppy version
of Sierra's *The Dagger of Amon Ra*. It repairs bugs, softlocks, interface problems, clue logic, scoring, and dialogue
while preserving the original mystery, artwork, puzzles, and character arcs.

A complete game takes many hours, so partial runs are useful too. Strange behavior, awkward wording, missing music,
visual glitches, and continuity slips are all worth reporting, not only crashes.

## Before you begin

Redux is a patch, not a copy of the game. You need your own installed copy of the DOS floppy release, version 1.000:
its `VERSION` file starts with `1.000`, and Sierra's own patch files (`0.SCR`, `90.SCR`, and others) sit beside
`RESOURCE.000`. The CD edition, including the one sold digitally today, is a different build and will not work.

1. Copy your installed game to a new directory and keep the original as an untouched backup. Do not patch a copy that
   already holds another Redux build or other mods.
2. Extract `LB2-Redux-v0.09.zip` into that directory, replacing the existing files when asked.
   - On Windows and macOS, ordinary extraction is fine.
   - On Linux, file names are case-sensitive. Redux's files have uppercase names, as on Sierra's disks, so they
     replace a copy installed from those disks. If any of your copy's file names are lowercase, uppercase them first,
     or Sierra's original patch could stay beside Redux's replacement (`0.scr` and `0.SCR`) and the game might load
     the old one:

     ```bash
     for f in *; do mv -n -- "$f" "$(printf '%s' "$f" | tr a-z A-Z)"; done
     ```
3. Start a new game for the most useful test. Old Sierra saves, including saves from earlier alphas, may contain state
   that bypasses a fix.

- DOSBox-X is the reference environment. Reports from ScummVM are welcome, but identify them as ScummVM results.
- Keep several rotating saves, especially near the end of each act and immediately before anything goes wrong.
- Do not overwrite the save that reproduces a bug. Attach the complete matching `LB2SG.*` save set when possible.

If launching manually in DOSBox-X, mount the patched game directory as drive C and run `SCIDHUV.EXE`. Repository
users can run `./tools/run_dosbox.sh` from the project root.

## What's new in v0.09

- Redux now ships as a patch: the download holds only Redux's own files, which you extract over your own copy of
  the floppy release (see *Before you begin*). It no longer includes Sierra's game files.
- The game itself is unchanged from v0.08, so v0.08 saves work, and the v0.08 checks below still need testing.

## What's new in v0.08

- Meeting Dr. Smith for the first time in Act 3, Laura no longer admires the ankh he has lost.
- Dr. Smith reacts when Laura shows him his ankh or the Dagger, and Dr. Carrington reacts to the Dagger.
- Yvette remembers Dr. Smith wearing an ankh at the party instead of wearing one now.

None of these has had a full playthrough yet, so reports on them are especially welcome.

## What's new in v0.07

- In Act 3, O'Riley patrols between the pterodactyl room, the dagger case, and the spot where Pippin died; Dr. Carrington and,
  from 11:15, Olympia follow the rounds Sierra wrote for them; and between eavesdropping scenes Yvette strolls the
  Rodin room outside her office. Olympia is no longer always in her office to catch you with the snake oil.
- The preservation lab's vats can be climbed again.
- Entering the back storeroom no longer crashes to DOS with "Build Line Error".
- Once O'Riley takes the dagger, it leaves the notebook.

The patrols start during Act 3, so test them from a save made before the end of Act 2. Saves made in Acts 3 to 6
under builds before v0.07 may not restore correctly.

Changes in v0.02 to v0.06 are listed in the [changelog](CHANGELOG.md).

## Known issues

This is logged but not fixed yet, so there is no need to report it again: nearby characters rarely chime in when
asked about each other.

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
- [ ] Leave the speakeasy during a song and listen for whether its music follows Laura out.
- [ ] Ask Ziggy about every available person, especially Yvette and the Countess.
- [ ] Note any Ziggy line that feels out of character, too crude, or hard to follow.
- [ ] Confirm the first act grade appears on a black screen in a window with Art Deco corners.

### Act 2

- [ ] Note which People and Things appear in the notebook immediately upon arrival.
- [ ] Find the benefit register and try every action on it, more than once, both after walking up and while standing
  right in front of it.
- [ ] Meet characters in an unusual order and watch for anyone Laura names before learning who they are.
- [ ] Ask characters about people standing nearby and note any response that feels unnaturally isolated.
- [ ] Confirm characters remain present until a conversation ends, then resume moving normally.
- [ ] Follow the party and eavesdropping sequence without a walkthrough and report any unclear next step or long stretch
  with nothing interactive to do.
- [ ] Ask guests about one another and note any line that treats the party as already over.

### Acts 3 and 4

- [ ] Revisit characters after every major discovery and look for missing, premature, or contradictory reactions.
- [ ] Ask the Countess, Dr. Carrington, Olympia, O'Riley, Tut, Yvette, and Ziggy about several topics; every question gets an
  answer instead of an error.
- [ ] Check whether time-sensitive characters and confrontations remain reasonably available.
- [ ] Click small buttons, switches, and books directly and report any that respond only off target.
- [ ] Use both ordinary Look and the Magnifying Glass on small or reflective clues.
- [ ] Save before dark or dangerous routes and report deaths that occur without a fair warning.
- [ ] Examine bookshelves, files, footprints, and other evidence before taking anything.
- [ ] Try your inventory on display cases and museum fixtures, not only on people.

### Act 5

- [ ] Confirm the game does not become unwinnable because an essential item was missed or used earlier.
- [ ] Exercise the snake-oil refill puzzle, including trying a full bottle and returning after all refills are gone.
- [ ] Save and restore during the chase and other dangerous sequences.
- [ ] Show recovered evidence to multiple characters before surrendering it to the police.

### Act 6 and ending

- [ ] Play the inquest from the coroner's opening through the verdict and report any point where it stops advancing.
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
- [ ] Leaving the speakeasy stops its songs; they do not carry on into the next room.
- [ ] The street outside Lo Fat's laundry has its intended music.
- [ ] The two men at the speakeasy bar have distinct Look and Talk feedback.
- [ ] Looking at the banner outside the museum mentions needing formal attire in Act 1, but not in Act 2.
- [ ] Ziggy acknowledges knowing Yvette and the Countess without revealing later plot information.
- [ ] Every act grade appears on black in a window with Art Deco corners, not the death window's bones, and the act
  marquee is gone before the text appears.

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
- [ ] At the party, Rameses on Ziggy and Yvette on Pippin and Dr. Smith speak as if the evening is still going and no
  one has died.
- [ ] Ziggy knows Heimlich and Dr. Smith, and answers about Pippin Carter.
- [ ] Asking Ziggy about the Countess before asking her about him gets only his denial; after asking her, Laura's bluff
  plays.
- [ ] Pippin acknowledges Rameses Najeer.
- [ ] The Countess sounds grand without constant capitals, and none of her lines reads oddly.
- [ ] Entering the front rotunda from either side at 7:30, Steve arrives from the far side and the two face each other
  to talk.
- [ ] Nobody can walk through the guests at the front rotunda's buffet table, including Steve after his 7:30 meeting
  with Laura.
- [ ] Leaving the front rotunda north into the Mastodon Room, Laura stays inside the doorway rather than drawing over its
  lintel.
- [ ] The Ankh near Pippin's body is easy to click.
- [ ] Discovering and reporting Pippin's body advances to Act 3 without unrelated optional conversations.
- [ ] A complete run can earn the full Act 2 grade.

### Act 3

- [ ] The skeleton-key glint is comfortably discoverable with Look and the Magnifying Glass.
- [ ] The Countess remains available for the intended Armor Room meeting.
- [ ] The pocket-watch confrontation is not lost merely because the clock has passed 1:45.
- [ ] Characters react to murders only after Laura learns of the corresponding death.
- [ ] O'Riley remains available after 10:15 for follow-up questions.
- [ ] O'Riley moves between the pterodactyl room, the dagger case, and where Pippin died, pausing at each, and never
  walks off mid-conversation.
- [ ] Dr. Carrington and, after 11:15, Olympia move between rooms instead of standing in one place.
- [ ] After the eavesdropped scene between O'Riley and Yvette, Yvette strolls the Rodin room outside her office, and is
  gone before the next scene at her door.
- [ ] Meeting Dr. Smith for the first time in Act 3, Laura's introduction does not mention his ankh.
- [ ] Showing Dr. Smith the ankh: he claims it and Laura keeps it. Showing him the Dagger: he claims it for Egypt and
  Laura says it goes to O'Riley.
- [ ] Dr. Carrington reacts to the Dagger, and Yvette's answer about the ankh says Dr. Smith wore one at the party.
- [ ] Using Hand on a vat in the preservation lab climbs it.
- [ ] Entering the back storeroom with the snake oil on its shelf causes no crash.
- [ ] Notebook completion marks and reopened topics track genuinely new dialogue.
- [ ] A complete run can earn the full Act 3 grade.

### Act 4

- [ ] Leaving the Egyptian Room to the south causes no error, and its music pauses and resumes normally.
- [ ] Using an inventory item on the dagger case or its glass gives an ordinary response.
- [ ] In Ernie's office, the desk, toolbox, lasso, wire cutters, and wall stain respond normally, and being caught by
  Ernie plays out cleanly.
- [ ] The dark eastern stairwell stops Laura with a repeatable warning instead of killing her at the threshold.
- [ ] Replacing the bulb makes the stairwell traversable.
- [ ] Touching the burned-out bulb says "Ouch!" only right after it burns out; after leaving and returning, Laura notes
  she has no spare, and with a spare in her purse she swaps it at once.
- [ ] Watney Little's police file can be found by clicking the books on its shelf in Carrington's office.
- [ ] Looking at the exposed file records both its contents and Watney's People entry before Take.
- [ ] Looking at Pippin's bloody high-heel footprint describes it even before using the Magnifying Glass.
- [ ] Inspecting Pippin's bloody high-heel footprint preserves it for the inquest evidence review.
- [ ] The skull in Olympia's office opens and closes the hidden panel without sending Laura in. Look at the open
  passage warns of darkness, and Hand on it or walking into it takes Laura inside.
- [ ] Once the Thinker's head is raised, Look and the Magnifying Glass on the head and neck mention it.
- [ ] The intercom's buttons respond when clicked directly.
- [ ] Using the carbon paper on Yvette's lamp while it is off gives an ordinary reply, not an error.
- [ ] Restored homicide reactions, including O'Riley's Countess response, remain reachable.
- [ ] A complete run can earn the full Act 4 grade.

### Act 5

- [ ] Entry restores genuinely missing wire cutters, snake oil, or cheese once, without duplicating held items.
- [ ] The empty snake-oil bottle looks empty; the laboratory jar refills it in one action.
- [ ] The jar permits three successful refills and rejects a full bottle or a depleted jar.
- [ ] Intended item consumption does not cause the safety check to recreate the item later.
- [ ] The recovered dagger receives character-specific reactions.
- [ ] Giving the dagger to O'Riley removes it from inventory and from the notebook but retains recovery credit.
- [ ] A complete run can earn the full Act 5 grade.

### Act 6 and ending

- [ ] The inquest runs from the opening to the verdict without stalling, with the coroner, Tut, the reporters, and the
  newspaper in their proper places.
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
Alpha build: v0.09
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
