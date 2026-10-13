#!/usr/bin/env python3
"""
tools/compile.py - Recompile an SCI script using SCI Companion under Wine
and report the lowercase loose patch overrides written to LB2/ (D-037).
"""

import sys
import os
import re
import subprocess
import shutil

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

def compile_script(target):
    name = SCRIPT_MAP.get(target.lower(), target)
    if name.endswith(".sc"):
        name = name[:-3]

    script_num = get_script_number(name)
    print(f"[*] Compiling script '{name}' (script number {script_num})...")

    # SCI Companion writes lowercase patch names (D-037). On a case-insensitive
    # workspace it replaces the existing files in place, so nothing is deleted first.
    outputs = [f"LB2/{script_num}.scr", f"LB2/{script_num}.hep"] if script_num is not None else []
    before = {p: os.path.getmtime(p) if os.path.exists(p) else None for p in outputs}

    # Ensure compile_any.exe exists
    exe_path = "tools/compile_any.exe"
    if not os.path.exists(exe_path) and os.path.exists("tools/compile_any.c"):
        subprocess.run(["i686-w64-mingw32-gcc", "-o", exe_path, "tools/compile_any.c"], check=True)

    # Call compile_any.exe
    cmd = ["wine", exe_path, name]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    print(res.stdout)
    if res.returncode != 0:
        print(f"[-] Compilation trigger failed: {res.stderr.strip()[-500:]}")
        return False

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

    print(f"[{'+' if ok else '-'}] Compilation of {name} {'completed' if ok else 'FAILED'}.")
    return ok

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 tools/compile.py <script_name_or_number>")
        sys.exit(1)
    success = compile_script(sys.argv[1])
    sys.exit(0 if success else 1)
