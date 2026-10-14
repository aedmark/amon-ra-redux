# Sluicebox Source Baseline Migration Plan

This is the execution runbook for `P5-00`. It is deliberately separate from the player-facing Phase 5 design work:
the source migration changes the maintainability of the project, not the behavior of the shipped game.

## Objective

Replace the old SCI Companion decompilation in `LB2/src/` with a coherent Sluicebox-annotated reconstruction for the
exact DOS floppy v1.000 release while preserving the already verified Redux bytecode behavior.

## Executed result

P5-00 completed with one necessary change to the proposed method. The published readable sources use contextual names
for reused numeric selectors; those aliases cannot coexist in SCI's single global selector vocabulary and therefore do
not compile as a coherent tree. Sluicebox was instead run against the effective Redux resources with annotations enabled
and a numeric-selector writer. This reconstructed the already-patched behavior directly, so no Redux delta was lost to
manual replay. The result retains readable globals, objects, procedures, control flow, and comments, with numeric
selectors plus four reserved metadata names. See D-032 and `docs/SOURCE_PROVENANCE.md`.

Upstream source:

- Repository: `https://github.com/sluicebox/sci-scripts`
- Pinned revision: `870a8015b689474484bf3d8b41416956d4315432`
- Game directory: `ra-dos-1.000/`
- Downloaded archive SHA-256 observed on 2026-10-10:
  `1d94151d2cd05109487bdc50c98b9e30f59334e2106a2d17987c9ff008929bd6`

Do not silently advance the upstream revision. A newer revision requires a new comparison and an explicit decision.

## Why this is worth doing

The current and proposed baselines each contain 221 `.sc` and 221 `.sco` files. Static comparison found:

| Measurement | Current baseline | Pinned Sluicebox baseline |
| --- | ---: | ---: |
| `sel_NNN` references | 40,878 | 0 in the reference tree; contextual and non-compilable |
| Distinct `sel_NNN` names | 567 | 0 |
| `--UNKNOWN-PROP-NAME--` placeholders | 4 | 0 |
| Declared classes | 114 | 114 |

The new sources recover meaningful properties and methods such as `init`, `cue`, `changeState`, `setScript`,
`setMotion`, `noun`, and `picture`. They also recover standard SCI system classes and correct several mistaken local
script names. Of the 191 `.sco` filenames shared by both trees, 114 are byte-identical and 77 differ. In particular,
`rm720.sco` is byte-identical, which is a useful version-match signal, but the differing object files mean that the
two `.sco` sets must not be mixed casually.

The upstream README says that compilation may require adjustments. Treat readability and version identity as strong
evidence, not as proof that the complete tree compiles unchanged in this project's SCI Companion configuration.

## Non-negotiable invariants

1. Never modify `LB2/RESOURCE.000` or `LB2/RESOURCE.MAP`.
2. Never use Compile All or rebuild resources against repository `LB2/`. P5-00 used Compile All once in a disposable
   `/tmp` copy as a compatibility diagnostic and discarded its rebuilt archives.
3. Keep the current uppercase loose `.SCR`, `.HEP`, `.MSG`, and other patch resources in place until replacements are
   individually compiled and verified.
4. Use DOSBox-X with the original interpreter for runtime testing; do not substitute ScummVM.
5. Treat the upstream `.sc`, `.sco`, and `game.ini` as one coherent baseline.
6. Replay Redux changes semantically. Do not paste selector-heavy functions wholesale over the readable source.
7. Preserve the old source through Git history; do not retain a duplicate legacy tree in the repository.
8. Keep unrelated message-resource work, including the Act 5 dialogue closure, byte-for-byte intact.
9. Record attribution and determine the upstream redistribution terms before pushing imported source files. The pinned
   archive did not contain an obvious `LICENSE`, `COPYING`, or `NOTICE` file during the initial audit.

## Known script-name translations

Most modified scripts retain their names. These Redux-touched scripts are renamed by the better baseline:

| Script | Current name | Sluicebox name |
| ---: | --- | --- |
| 15 | `LBIconItem` | `invCode` |
| 17 | `LBRoom` | `eRS` |
| 20 | `NotebookItem` | `inNotebook` |
| 250 | `Trash` | `rm250` |
| 530 | `ScrewInBulb` | `rm530` |
| 562 | `Button` | `theIntercom` |
| 650 | `MyFeature` | `rm650` |
| 937 | `IconI` | `IconBar` |

Other important recovered names include Scripts 255 `Interface`, 561 `safePicture`, 922 `Dialog`, 925
`Conversation`, 928 `Talker`, 950 `Feature`, 958 `LoadMany`, 981 `Window`, 982 `Sight`, 990 `Save`, 992
`Motion`, 993 `File`, 995 `Inventory`, 998 `Actor`, and 999 `System`.

## Redux replay inventory

The initial replay set is the following 42 scripts, derived from completed P1-01 through P4-06 implementation records:

`0, 13, 14, 15, 17, 20, 22, 26, 32, 35, 36, 90, 93, 240, 250, 330, 335, 350, 355, 360, 370, 400, 420, 435,
440, 441, 454, 490, 500, 510, 525, 530, 560, 562, 565, 600, 610, 620, 630, 650, 750, 937`.

This list is a starting ledger, not permission to assume it is exhaustive. Before replacement, cross-check it against:

- every completed roadmap item;
- every decision from D-003 through D-030 that names a source script;
- every committed loose `.SCR`/`.HEP` pair attributed to Redux;
- `git log -- LB2/src` and the relevant historical commits; and
- any source change documented in `docs/HANDOFF.md` or its archived session logs.

Record each script in a migration ledger with its old name, new name, Redux decisions, port status, compile result,
binary output sizes, DOSBox-X checkpoint, and final commit.

## Execution sequence for the 8:01 PM session

### 0. Preserve the current work

1. Confirm the working tree contains the expected Act 5 message resources, dialogue manifests, and documentation only.
2. Run the message structural comparison, complete effective-layer caricature scan, documentation checks, manual check and
   build, and DOSBox-X headless startup already used for the Act 5 closure.
3. Commit and push that closure before touching `LB2/src/`. This creates an unambiguous rollback point.
4. Record the commit ID and hashes of every current loose `.SCR` and `.HEP` file in a temporary migration manifest.

Stop if the working tree contains unexplained files or if any current verification fails.

### 1. Establish an isolated migration workspace

1. Create a `codex/p5-00-sluicebox-baseline` branch from the clean checkpoint.
2. Download the archive for the pinned revision again and verify the SHA-256 above.
3. Work in a temporary full copy of `LB2/`, including its base archives, sources, and loose patches. Do not point the
   first SCI Companion experiment at the repository copy.
4. Replace only the temporary copy's `src/` and `game.ini` with the pinned upstream set.
5. Verify file counts, script-number mappings, source encodings, and `.sco` pairing before launching SCI Companion.

Stop if the archive hash changes, the inventory is not exactly 221 `.sc` plus 221 `.sco`, or the game identity does not
match DOS floppy v1.000.

### 2. Prove the pristine baseline before porting fixes

1. Open the temporary `game.ini` in SCI Companion under Wine with automatic compile-before-run disabled.
2. Compile representative untouched scripts individually, beginning with `rm720`, plus one system class and one ordinary
   room script. Never use Compile All.
3. Confirm each compile reports zero errors and warnings and emits plausible `.SCR`/`.HEP` files.
4. Boot the temporary game with DOSBox-X and visually confirm that the Sierra logo, title, and introduction appear.
5. Compile one dependency-sensitive script such as `Main` only after the representative tests pass, then boot again.

If a pristine script fails, diagnose compiler dialect, include, selector, or `.sco` compatibility in the temporary copy.
Do not compensate by copying isolated object files from the old baseline.

### 3. Import the readable baseline

1. Replace repository `LB2/src/` and `LB2/game.ini` as a coherent unit from the verified pinned tree.
2. Add a provenance note containing the repository URL, pinned revision, archive hash, retrieval date, and the result of
   the redistribution-terms check.
3. Update `tools/compile.py` aliases for all recovered names, including the eight Redux-touched translations above.
4. Update source-name references in architecture, testing, roadmap, decisions, handoff, and manual documentation.
5. Commit the pristine source/provenance/tooling baseline separately from all replayed gameplay changes.

At this checkpoint the shipped loose binaries must remain unchanged, so the playable game remains at the last verified
Redux behavior even though the source tree has changed.

### 4. Replay Redux patches in bounded batches

Port the 42-script ledger semantically in this order:

1. Foundation and interface: Scripts 0, 13, 14, 15, 17, 20, 937.
2. Shared schedule and actors: Scripts 22, 26, 32, 35, 36, 90, 93.
3. Act 1 and museum arrival: Scripts 240, 250, 330, 335, 350, 355, 360, 370.
4. Museum rooms and murder state: Scripts 400, 420, 435, 440, 441, 454, 490, 500, 510, 525, 530, 560, 562, 565,
   600, 610, 620, 630, 650.
5. Inquest: Script 750.

For every script:

1. Read the relevant roadmap and decision entries.
2. Locate the same vanilla behavior in the recovered source by named method and state.
3. Re-implement only the documented Redux delta using the recovered symbols.
4. Review the semantic diff; reject unexplained logic changes.
5. Compile the script individually in the isolated game copy.
6. Copy verified uppercase output into the repository only after a DOSBox-X startup smoke passes.
7. Run the relevant deterministic save checkpoint before marking the ledger entry complete.

Commit after each bounded batch. A failed batch must be revertible without disturbing earlier verified batches.

### 5. Regression and acceptance gate

The migration is complete only when all of the following are true:

- The 42-script ledger is complete, and the historical audit found no omitted Redux source patch.
- The source tree contains zero unknown-property placeholders. Numeric `sel_NNN` references are the documented
  compiler necessity established by D-032; SCI's four metadata selectors retain their reserved names.
- Every replayed script compiles individually with zero errors and warnings.
- Current `.MSG`, view, save, configuration, and manual assets are unchanged except for separately documented work.
- `RESOURCE.000` and `RESOURCE.MAP` still match their recorded vanilla MD5 hashes.
- `python3 tools/check_docs.py` passes.
- `python3 tools/manual.py check docs/manual/amon-ra.manual.json` passes.
- `python3 tools/manual.py build docs/manual/amon-ra.manual.json --output docs/manual/manual.html` succeeds.
- DOSBox-X headless startup passes after every batch.
- DOSBox-X visual startup and all six deterministic save checkpoints in `docs/TESTING.md` pass.
- The clean playthrough gate remains valid; any behavioral discrepancy receives a stable `PLAY-nnn` ID.

Only after acceptance should the migration branch be merged and pushed as the new source baseline. Then record the
architectural choice in `docs/DECISIONS.md`, close P5-00, and begin P5-01 design against the readable sources.

## Rollback strategy

- The pre-migration checkpoint commit is the authoritative rollback point.
- Existing verified loose patches are preserved until their replacements pass, so source migration failure does not
  make the game unplayable.
- Revert failed batches by commit, never by overwriting files from an untracked backup.
- If the new baseline cannot compile reliably, retain it only as documented reference material or abandon the import;
  do not leave a mixed `.sco` or partially renamed source tree on the main branch.

## First command sequence at resumption

Run these read-only checks before making migration changes:

```sh
git status --short
git log -1 --oneline
python3 tools/check_docs.py
python3 tools/manual.py check docs/manual/amon-ra.manual.json
sha256sum /tmp/sci-scripts-870a8015.zip
```

The `/tmp` archive may no longer exist after a restart. If absent, download the pinned revision again and verify its
hash before continuing.
