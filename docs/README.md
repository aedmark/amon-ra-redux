# Documentation map

Every fact has one home; update the document that owns a change.

## Documentation inventory

| Document | Answers | Does not own | Update when |
| --- | --- | --- | --- |
| `AGENTS.md` | How should coding agents work in this repository? | Project facts or history | Agent protocols, conventions, or protected areas change. |
| `docs/ROADMAP.md` | What work is planned, active, done, or dropped? | Implementation detail | Task progress, phase status, or item scope changes. |
| `docs/HANDOFF.md` | What is true right now, and what happens next? | Permanent design rules | Work pauses or current state changes materially. |
| `docs/ARCHITECTURE.md` | How does the system fit together and what invariants hold? | Rationale (DECISIONS) or chronology | Engine boundaries, patch loading, or subsystem designs change. |
| `docs/DECISIONS.md` | Why was a durable architectural choice made? | Routine implementation detail | A durable choice is made or superseded, a tension is held or resolved, or a question is asked or answered. |
| `docs/TESTING.md` | How is behavior verified and what remains unproved? | Current results (HANDOFF) | Test commands, test cases, or DOSBox-X recipes change. |
| `docs/ALPHA_PLAYTESTING.md` | How do public testers install, test, and report the current build? | Findings (PLAYTEST_CHECKLIST) | Install steps, checks, or reporting change. |
| `docs/alpha-playtest.html` | The same, as a self-contained page for Neocities. | Anything not in the tester guide | The download, checklist, or report form changes. |
| `docs/PLAYTEST_CHECKLIST.md` | What does the maintainer's Phase 5 gate run cover, and what was found (`PLAY-nnn`)? | Planned work beyond triage (ROADMAP) | A checkpoint passes or a finding is logged or triaged. |
| `docs/SOURCE_PROVENANCE.md` | Where did `LB2/src/` come from, and what are Sierra's retail patches? | How the source is compiled (TESTING) | Source tools, pinned inputs, hashes, or terms change. |
| `docs/SECURITY.md` | What assets are sensitive and how are vulnerabilities handled? | Architecture detail | Trust boundaries, asset policies, or disclosure paths change. |
| `docs/CONTRIBUTING.md` | How does a contribution move from idea to patch, and what references must be checked before changing SCI objects? | Agent-only rules (AGENTS) | Development workflow, reference-first investigation rules, branching, or pull-request rules change. |
| `docs/CHANGELOG.md` | What changed for players and users? | Commit or session history | A playable release, patch build, or feature lands. |
| `docs/archive/` | Historical context, including the completed P5-00 migration plan. | Anything current | HANDOFF's session log passes 10 entries. |
| `docs/manual/` | What/How/Why manual source and built manual? | Decision rationale (DECISIONS) | Technical features, fixes, or implementation details change. |
| `docs/dialogue/` | What exact tuple-addressed wording defines the reviewed dialogue passes? | Current message text (the `.MSG` files, D-038) | A character line is approved, revised, or added to an act-level rewrite. |
| `docs/reference/` | What source material defines the modernization scope? | Redux's own design | Reference documents or extracted source text change. |

## Update triggers

Update documents because a relevant fact changed, not merely because a session ended.

| Change | Required documentation |
| --- | --- |
| Engine loading rules or patch distribution | ARCHITECTURE and DECISIONS; for a release, also CHANGELOG, `ALPHA_PLAYTESTING.md`, and `alpha-playtest.html` |
| A task starts or finishes | ROADMAP and HANDOFF |
| A player-visible fix or change | CHANGELOG; the 3x manual |
| A durable tradeoff or reversal, or a tension held or resolved | DECISIONS; mark the old decision superseded, or resolve the tension |
| Verification procedures or DOSBox-X commands | TESTING |
| A reusable SCI object or interaction lesson | The reference-first workflow in CONTRIBUTING; durable policy in DECISIONS; the runtime case in TESTING |
| The full-game run finds or clears an issue | PLAYTEST_CHECKLIST; promote confirmed work to a roadmap ID during triage |
| A trust boundary, asset policy, or disclosure path | SECURITY |
| Work pauses with context another session needs | HANDOFF |
| A contribution or release workflow change | CONTRIBUTING and, if agents are affected, AGENTS |

Run `python3 tools/check_docs.py` before completing any session.
