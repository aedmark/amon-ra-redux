# Security

Security model, trust boundaries, and asset policies for *The Dagger of Amon Ra: Redux*.

## Supported versions

| Release / Branch | Status |
| --- | --- |
| `main` | Actively maintained |
| `v1.0.0-dev` | Development preview |

## Reporting

Report security concerns or asset integrity issues directly to project maintainers via the repository issue tracker.

## Threat model and trust boundaries

1. **Game Resource Integrity:** All loose patch files (`.SCR`, `.HEP`, `.MSG`) are parsed by Sierra SCI interpreters
   and ScummVM. Malformed bytecode or heap offsets could trigger interpreter crashes or buffer overflows in native
   emulators. All recompiled bytecode must be validated in ScummVM before distribution.
2. **Execution Environment:** SCI Companion runs under Wine in Linux. Maintain proper file permission boundaries
   and avoid executing untrusted binary plugins.
3. **No Network Exposure:** The project is an offline single-player retro adventure mod with zero remote telemetry or
   network listeners.
