# Security

Security model, trust boundaries, and asset policies for *The Dagger of Amon Ra: Redux*.

## Supported versions

Only the latest alpha and `master` are maintained.

## Reporting

Report security or asset-integrity concerns through the repository issue tracker.

## Threat model and trust boundaries

1. **Resource integrity:** loose patches (`.SCR`, `.HEP`, `.MSG`, `.V56`) are parsed by Sierra's interpreter; malformed
   bytecode, heaps, or cels can crash it (PLAY-034). Boot-test every patch in DOSBox-X before distribution.
2. **Base assets:** never modify `RESOURCE.000`/`RESOURCE.MAP` (MD5s in `SOURCE_PROVENANCE.md`); never commit saves.
3. **Distribution:** public packages and the repository contain only Redux's files, never Sierra's (D-047).
4. **Execution environment:** SCI Companion runs under Wine; do not run untrusted plugins.
5. **No network exposure:** an offline single-player mod with no telemetry.
