# Documentation map

Every fact in this project has one authoritative home. When you change how the project works, update the document
that owns the change.

## Documentation inventory

| Document | Answers | Update when |
| --- | --- | --- |
| `AGENTS.md` | How should coding agents work in this repository? | Agent protocols, conventions, or protected areas change. |
| `ROADMAP.md` | What work is planned, active, done, or dropped? | Task progress, phase status, or item scope changes. |
| `docs/HANDOFF.md` | What is true right now, and what happens next? | Work pauses or current state changes materially. |
| `docs/ARCHITECTURE.md` | How does the system fit together and what invariants hold? | Engine boundaries, patch loading, or subsystem designs change. |
| `docs/DECISIONS.md` | Why was a durable architectural choice made? | An architectural choice is made or superseded; questions asked. |
| `docs/TESTING.md` | How is behavior verified and what remains unproved? | Test commands, test cases, or ScummVM recipes change. |
| `docs/SECURITY.md` | What assets are sensitive and how are vulnerabilities handled? | Trust boundaries, asset policies, or disclosure paths change. |
| `docs/CONTRIBUTING.md` | How does a contribution move from idea to patch? | Development workflow, branching, or pull-request rules change. |
| `docs/CHANGELOG.md` | What changed for players and users? | A playable release, patch build, or feature lands. |
| `docs/archive/` | What historical context is no longer active? | Session logs exceed limit in `HANDOFF.md`. |
| `3x-documentation-scheme/` | What/How/Why manual source and built manual? | Technical features, fixes, or implementation details change. |

## Update triggers

- If you change engine loading rules or patch distribution: update `docs/ARCHITECTURE.md` and `docs/DECISIONS.md`.
- If you start or complete a task: update `ROADMAP.md` and `docs/HANDOFF.md`.
- If you change verification procedures or ScummVM commands: update `docs/TESTING.md`.
- Run `python3 tools/check_docs.py` before completing any session.
