#!/usr/bin/env python3
"""
tools/compile.py - Recompile an SCI script using SCI Companion under Wine
and ensure uppercase loose patch overrides are created in LB2/.
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
    "20": "NotebookItem",
    "notebookitem": "NotebookItem",
    "562": "Button",
    "button": "Button",
    "650": "MyFeature",
    "myfeature": "MyFeature",
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

    # Clean existing patch files and bak files for this script before compiling
    # to avoid Wine MoveFile ERROR_ALREADY_EXISTS (183)
    if script_num is not None:
        for ext in [".scr", ".SCR", ".hep", ".HEP", ".scr.bak", ".hep.bak"]:
            fpath = f"LB2/{script_num}{ext}"
            if os.path.exists(fpath):
                os.remove(fpath)

    # Ensure compile_any.exe exists
    exe_path = "tools/compile_any.exe"
    if not os.path.exists(exe_path) and os.path.exists("tools/compile_any.c"):
        subprocess.run(["i686-w64-mingw32-gcc", "-o", exe_path, "tools/compile_any.c"], check=True)

    # Call compile_any.exe
    cmd = ["wine", exe_path, name]
    res = subprocess.run(cmd, stdout=subprocess.PIPE, stderr=subprocess.PIPE, text=True)
    if res.returncode != 0:
        print(f"[-] Compilation trigger failed: {res.stderr}")
        return False

    print(res.stdout)

    # Check generated files in LB2/
    if script_num is not None:
        scr_lower = f"LB2/{script_num}.scr"
        hep_lower = f"LB2/{script_num}.hep"
        scr_bak = f"LB2/{script_num}.scr.bak"
        hep_bak = f"LB2/{script_num}.hep.bak"
        scr_upper = f"LB2/{script_num}.SCR"
        hep_upper = f"LB2/{script_num}.HEP"

        # If bak file was created because move failed, use bak file
        if os.path.exists(scr_bak) and not os.path.exists(scr_lower):
            shutil.move(scr_bak, scr_upper)
            print(f"[+] Moved {scr_bak} -> {scr_upper} ({os.path.getsize(scr_upper)} bytes)")
        elif os.path.exists(scr_lower):
            shutil.move(scr_lower, scr_upper)
            print(f"[+] Moved {scr_lower} -> {scr_upper} ({os.path.getsize(scr_upper)} bytes)")

        if os.path.exists(hep_bak) and not os.path.exists(hep_lower):
            shutil.move(hep_bak, hep_upper)
            print(f"[+] Moved {hep_bak} -> {hep_upper} ({os.path.getsize(hep_upper)} bytes)")
        elif os.path.exists(hep_lower):
            shutil.move(hep_lower, hep_upper)
            print(f"[+] Moved {hep_lower} -> {hep_upper} ({os.path.getsize(hep_upper)} bytes)")

    print(f"[+] Compilation of {name} completed successfully.")
    return True

if __name__ == "__main__":
    if len(sys.argv) < 2:
        print("Usage: python3 tools/compile.py <script_name_or_number>")
        sys.exit(1)
    success = compile_script(sys.argv[1])
    sys.exit(0 if success else 1)
