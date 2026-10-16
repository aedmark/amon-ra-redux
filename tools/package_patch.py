#!/usr/bin/env python3
"""Package Redux's loose patch files for distribution, without any Sierra files.

The package holds only the git-tracked patch resources in LB2/ (numbered .SCR, .HEP, .MSG,
.V56, .P56, and .VOC files). It leaves out every Sierra file: the archives, interpreter,
drivers, installer, and font, and any patch byte-identical to one of Sierra's retail patches
in LB2_vanilla/, which players already have. Players unzip it over their own floppy v1.000
install. Entry names are uppercase, as on Sierra's disks.

Usage:
    python3 tools/package_patch.py 0.09
    python3 tools/package_patch.py 0.09 --mirror "LB2 (legal)/patched files" [--prune]
"""

import argparse
import hashlib
import re
import subprocess
import sys
import zipfile
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
GAME = ROOT / "LB2"
VANILLA = ROOT / "LB2_vanilla"
PATCH_NAME = re.compile(r"^\d+\.(scr|hep|msg|v56|p56|voc)$", re.IGNORECASE)


def digest(path):
    return hashlib.md5(path.read_bytes()).hexdigest()


def patch_files():
    """Return the tracked patch files in LB2/, minus copies of Sierra's retail patches."""
    if not VANILLA.is_dir():
        sys.exit("LB2_vanilla/ is missing; it is needed to leave out Sierra's retail patches.")
    vanilla = {p.name.lower(): digest(p) for p in VANILLA.iterdir() if p.is_file()}
    tracked = subprocess.run(
        ["git", "ls-files", "-z", "LB2"], cwd=ROOT, capture_output=True, check=True, text=True
    ).stdout.split("\0")
    files, skipped = [], []
    for rel in tracked:
        path = ROOT / rel
        if path.parent != GAME or not PATCH_NAME.match(path.name):
            continue
        if vanilla.get(path.name.lower()) == digest(path):
            skipped.append(path.name)
            continue
        # Uppercase, as on Sierra's disks, so the package replaces an uppercase install's files on any filesystem.
        files.append((path, path.name.upper()))
    return sorted(files, key=lambda f: f[1].lower()), sorted(skipped, key=str.lower)


def build_zip(files, version):
    out = GAME / f"LB2-Redux-v{version}.zip"
    if out.exists():
        sys.exit(f"{out.relative_to(ROOT)} already exists; remove it first.")
    with zipfile.ZipFile(out, "w", zipfile.ZIP_DEFLATED, compresslevel=9) as zf:
        for path, name in files:
            zf.write(path, name)
    with zipfile.ZipFile(out) as zf:
        if zf.testzip() is not None:
            sys.exit("zip integrity test failed")
        for path, name in files:
            if zf.read(name) != path.read_bytes():
                sys.exit(f"zip copy of {path.name} differs from LB2/")
    return out


def mirror(files, target, prune):
    target.mkdir(parents=True, exist_ok=True)
    wanted = {name.lower(): (path, name) for path, name in files}
    stray = [p for p in target.iterdir() if p.is_file() and p.name.lower() not in wanted]
    for path in stray:
        if prune:
            path.unlink()
            print(f"removed {path.name}")
        else:
            print(f"not in the patch set (use --prune to remove): {path.name}")
    existing = {p.name.lower(): p for p in target.iterdir() if p.is_file()}
    copied = 0
    for key, (src, name) in wanted.items():
        dest = existing.get(key)
        if dest is not None and dest.name != name:
            # Two-step rename, since a case-only rename can be a no-op on case-insensitive filesystems.
            temp = dest.with_name(name + ".tmp")
            dest.rename(temp)
            temp.rename(target / name)
            copied += 1
        dest = target / name
        if not dest.exists() or dest.read_bytes() != src.read_bytes():
            dest.write_bytes(src.read_bytes())
            copied += 1
    print(f"mirrored {len(files)} files into {target} ({copied} updated)")


def main():
    parser = argparse.ArgumentParser(description=__doc__, formatter_class=argparse.RawDescriptionHelpFormatter)
    parser.add_argument("version", nargs="?", help="build LB2/LB2-Redux-v<version>.zip")
    parser.add_argument("--mirror", type=Path, help="also sync the patch set into this folder")
    parser.add_argument("--prune", action="store_true", help="with --mirror, delete files outside the patch set")
    args = parser.parse_args()
    if not args.version and not args.mirror:
        parser.error("give a version, --mirror, or both")

    files, skipped = patch_files()
    print(f"{len(files)} patch files; left out {len(skipped)} retail Sierra patches: {', '.join(skipped)}")
    if args.version:
        out = build_zip(files, args.version)
        print(f"built {out.relative_to(ROOT)}: {len(files)} files, {out.stat().st_size:,} bytes, integrity OK")
    if args.mirror:
        mirror(files, args.mirror if args.mirror.is_absolute() else ROOT / args.mirror, args.prune)


if __name__ == "__main__":
    main()
