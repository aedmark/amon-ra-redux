# Documentation map

Every fact has one home; update the document that owns a change.

## Documentation inventory

| Document | Answers | Update when |
| --- | --- | --- |
| `AGENTS.md` | How should coding agents work in this repository? | Agent protocols, conventions, or protected areas change. |
| `docs/ROADMAP.md` | What work is planned, active, done, or dropped? | Task progress, phase status, or item scope changes. |
| `docs/HANDOFF.md` | What is true right now, and what happens next? | Work pauses or current state changes materially. |
| `docs/ARCHITECTURE.md` | How does the system fit together and what invariants hold? | Engine boundaries, patch loading, or subsystem designs change. |
| `docs/DECISIONS.md` | Why was a durable architectural choice made? | An architectural choice is made or superseded; questions asked. |
| `docs/TESTING.md` | How is behavior verified and what remains unproved? | Test commands, test cases, or DOSBox-X recipes change. |
| `docs/ALPHA_PLAYTESTING.md` | How do public testers install, test, and report the current build? | Install steps, checks, or reporting change. |
| `docs/alpha-playtest.html` | The same, as a self-contained page for Neocities. | The download, checklist, or report form changes. |
| `docs/PLAYTEST_CHECKLIST.md` | What does the maintainer's Phase 5 gate run cover, and what was found (`PLAY-nnn`)? | A checkpoint passes or a finding is logged or triaged. |
| `docs/SOURCE_PROVENANCE.md` | Where did `LB2/src/` come from, and what are Sierra's retail patches? | Source tools, pinned inputs, hashes, or terms change. |
| `docs/SECURITY.md` | What assets are sensitive and how are vulnerabilities handled? | Trust boundaries, asset policies, or disclosure paths change. |
| `docs/CONTRIBUTING.md` | How does a contribution move from idea to patch, and what references must be checked before changing SCI objects? | Development workflow, reference-first investigation rules, branching, or pull-request rules change. |
| `docs/CHANGELOG.md` | What changed for players and users? | A playable release, patch build, or feature lands. |
| `docs/archive/` | Historical context, including the completed P5-00 migration plan. | HANDOFF's session log passes 10 entries. |
| `docs/manual/` | What/How/Why manual source and built manual? | Technical features, fixes, or implementation details change. |
| `docs/dialogue/` | What exact tuple-addressed wording defines the reviewed dialogue passes? | A character line is approved, revised, or added to an act-level rewrite. |
| `docs/reference/` | What source material defines the modernization scope? | Reference documents or extracted source text change. |

## Update triggers

- If you change engine loading rules or patch distribution: update `docs/ARCHITECTURE.md` and `docs/DECISIONS.md`;
  for a release, also `CHANGELOG.md`, `ALPHA_PLAYTESTING.md`, and `alpha-playtest.html`.
- If you start or complete a task: update `docs/ROADMAP.md` and `docs/HANDOFF.md`.
- If you change verification procedures or DOSBox-X commands: update `docs/TESTING.md`.
- If an SCI object or interaction fix reveals a reusable engine lesson: update the reference-first workflow in `docs/CONTRIBUTING.md`, record durable policy in `docs/DECISIONS.md`, and add the concrete runtime case to `docs/TESTING.md`.
- If the full-game run finds or clears an issue: update `docs/PLAYTEST_CHECKLIST.md`; promote confirmed work to a permanent roadmap ID during triage.
- Run `python3 tools/check_docs.py` before completing any session.
