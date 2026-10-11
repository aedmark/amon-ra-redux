# Source provenance

## DOS floppy v1.000 baseline

`LB2/src/` was reconstructed for P5-00 from the maintainer's legally obtained DOS floppy v1.000 resources with
[Sluicebox sci-tools](https://github.com/sluicebox/sci-tools), using the readable
[`ra-dos-1.000`](https://github.com/sluicebox/sci-scripts/tree/870a8015b689474484bf3d8b41416956d4315432/ra-dos-1.000)
publication as the symbol and annotation reference.

- Pinned `sci-scripts` revision: `870a8015b689474484bf3d8b41416956d4315432`
- Pinned archive SHA-256: `1d94151d2cd05109487bdc50c98b9e30f59334e2106a2d17987c9ff008929bd6`
- Retrieved and verified: 2026-10-10
- Inventory: 221 `.sc` and 221 `.sco` files
- Tool license: `sci-tools` declares the MIT License.
- Published-script terms: the pinned `sci-scripts` archive contains no `LICENSE`, `COPYING`, or `NOTICE` file. No
  upstream license grant is asserted here. The game code and assets remain the property of their respective owners;
  this project treats the source as research material for a noncommercial interoperability patch.

The published selectors are contextual aliases: one numeric SCI selector can have several human-readable names, so
the published tree cannot be compiled against one global `vocab.997`. Redux therefore regenerated the effective
compiled game through Sluicebox's annotation pipeline while emitting stable numeric selector names. All globals,
objects, procedures, recovered control flow, and annotations remain readable. `LB2/997.voc` names selectors `sel_N`
except for SCI's required metadata selectors 4098 (`-propDict-`), 4100 (`-classScript-`), 4102 (`-super-`), and 4103
(`-info-`). Rebuild that developer vocabulary with `tools/normalize_selector_vocab.py`.

The immutable retail archives are not derived outputs and are never committed. Their required MD5 values remain:

- `RESOURCE.000`: `2d591d9416607beeac48303c6f4fe212`
- `RESOURCE.MAP`: `330d4a87da2ea2520a316c9f25ab538e`
