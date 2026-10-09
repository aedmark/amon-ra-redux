#!/usr/bin/env bash
# tools/make_test_copy.sh <name> [git-rev]
# Build a throwaway game copy in /tmp/amon-ra-test/<name> with its own DOSBox-X config, so a suspect
# patch set can be boot-tested (or bisected) without touching LB2/. With [git-rev], the .SCR/.HEP files
# come from that commit instead of the working tree. Prints the command that boots the copy.
set -euo pipefail
name=${1:?usage: make_test_copy.sh <name> [git-rev]}
rev=${2:-}
root="$(cd "$(dirname "${BASH_SOURCE[0]}")/.." && pwd)"
dest="/tmp/amon-ra-test/$name"
rm -rf "$dest"; mkdir -p "$dest"
cp -r "$root/LB2" "$dest/LB2"
rm -rf "$dest/LB2/src"
if [ -n "$rev" ]; then
  rm -f "$dest"/LB2/[0-9]*.SCR "$dest"/LB2/[0-9]*.HEP
  git -C "$root" ls-tree -r --name-only "$rev" LB2 | grep -E '^LB2/[0-9]+\.(SCR|HEP)$' | while read -r f; do
    git -C "$root" show "$rev:$f" > "$dest/LB2/$(basename "$f")"
  done
fi
sed "s#^mount c LB2#mount c $dest/LB2#" "$root/tools/dosbox-x.conf" > "$dest/dosbox-x.conf"
echo "Test copy: $dest/LB2 (edit or delete patches there freely)"
echo "Boot it:   dosbox-x -conf $dest/dosbox-x.conf"
