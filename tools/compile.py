#!/usr/bin/env python3
"""
tools/compile.py - Recompile an SCI script using SCI Companion under Wine
and report the uppercase loose patch overrides written to LB2/ (D-048).
"""

import sys
import os
import re
import subprocess
import shutil
import time

SCRIPT_MAP = {
    "0": "Main",
    "main": "Main",
    "13": "aboutCode",
    "aboutcode": "aboutCode",
    "15": "invCode",
    "lbiconitem": "invCode",
    "17": "eRS",
    "lbroom": "eRS",
    "20": "inNotebook",
    "notebookitem": "inNotebook",
    "250": "rm250",
    "trash": "rm250",
    "530": "rm530",
    "screwinbulb": "rm530",
    "562": "theIntercom",
    "button": "theIntercom",
    "650": "rm650",
    "myfeature": "rm650",
    "937": "IconBar",
    "iconi": "IconBar",
}

def get_script_number(name):
    # Try finding in LB2/src/<name>.sc
    src_path = os.path.join("LB2", "src", f"{name}.sc")
    if os.path.exists(src_path):
        with open(src_path, "r", errors="ignore") as f:
            for line in f:
                m = re.match(r"^\s*\(script#\s+(\d+)\)", line)
                if m:
                    return int(m.group(1))
    # If name is like rm500
    m = re.match(r"^rm(\d+)$", name, re.IGNORECASE)
    if m:
        return int(m.group(1))
    return None

def uppercase_name(path):
    """Rename a patch SCI Companion created under a lowercase name to its uppercase name (D-048)."""
    folder, name = os.path.split(path)
    stored = next((f for f in os.listdir(folder) if f.lower() == name.lower()), None)
    if stored and stored != name:
        # Two steps, since a case-only rename can be a no-op on a case-insensitive filesystem.
        temp = os.path.join(folder, name + ".casetmp")
        os.rename(os.path.join(folder, stored), temp)
        os.rename(temp, path)
        print(f"[*] Renamed {stored} to {name}")


def compile_script(target):
    name = SCRIPT_MAP.get(target.lower(), target)
    if name.endswith(".sc"):
        name = name[:-3]

    script_num = get_script_number(name)
    print(f"[*] Compiling script '{name}' (script number {script_num})...")

    # Patches are tracked uppercase (D-048). On a case-insensitive workspace SCI Companion
    # rewrites an existing patch in place under its name; a new one it writes lowercase.
    outputs = [f"LB2/{script_num}.SCR", f"LB2/{script_num}.HEP"] if script_num is not None else []
    before = {p: os.path.getmtime(p) if os.path.exists(p) else None for p in outputs}

    # Ensure compile_any.exe exists
    exe_path = "tools/compile_any.exe"
    if not os.path.exists(exe_path) and os.path.exists("tools/compile_any.c"):
        subprocess.run(["i686-w64-mingw32-gcc", "-o", exe_path, "tools/compile_any.c"], check=True)

    # Leave a window the maintainer already had open; close the one we open.
    was_open = subprocess.run(["wine", exe_path, "--is-open", name],
                              stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL).returncode == 0

    # Call compile_any.exe
    cmd = ["wine", exe_path, name]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    print(res.stdout)
    if res.returncode != 0:
        print(f"[-] Compilation trigger failed: {res.stderr.strip()[-500:]}")
        return False

    # SCI Companion can finish writing the patches after compile_any returns.
    deadline = time.time() + 30
    while time.time() < deadline and any(
            not os.path.exists(p) or os.path.getmtime(p) == before[p] for p in outputs):
        time.sleep(0.5)
    time.sleep(1)

    for path in outputs:
        uppercase_name(path)

    ok = True
    for path in outputs:
        if not os.path.exists(path):
            print(f"[-] Missing output {path}")
            ok = False
        elif before[path] is not None and os.path.getmtime(path) == before[path]:
            print(f"[-] {path} was not rewritten")
            ok = False
        else:
            print(f"[+] {path} ({os.path.getsize(path)} bytes)")

    if ok and not was_open:
        subprocess.run(["wine", exe_path, "--close", name],
                       stdout=subprocess.DEVNULL, stderr=subprocess.DEVNULL)

    print(f"[{'+' if ok else '-'}] Compilation of {name} {'completed' if ok else 'FAILED'}.")
    return ok

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 tools/compile.py <script_name_or_number>")
        sys.exit(1)
    success = compile_script(sys.argv[1])
    sys.exit(0 if success else 1)
