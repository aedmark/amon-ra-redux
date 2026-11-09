# Retired tools: the compiler-output capture helpers

Written 2026-11-08 (session 66), when the last of these helpers was retired (D-051, D-052). Nothing here is current.

## Why they existed

On 2026-10-07, the first day of the toolchain (`8d764df`), Redux had to compile scripts in SCI Companion under Wine
with no command-line compiler and no way to read the compiler's output from outside the window. These five helpers
were the attempts to get that output into a file an agent could read. Each one tried a different route into SCI
Companion's process or its output list: a hooked drawing call, the clipboard through three different copy commands,
and forced redraws. Which routes worked was not recorded.

They were the groundwork for the compile path that stayed. `compile_any.c` shares their way of finding SCI Companion's
window and walking its child controls, and reads the script list through remote memory. `tools/compile.py` settled
the question another way: a compile succeeded when SCI Companion rewrote the script's `.SCR` and `.HEP`, and the boot
test (D-029) proves the rest. By 2026-11-08 no tool read the captured output, and since `dumps/` was removed on
2026-10-17, none of the five could save anything.

## The helpers

| Helper | What it did | Last source |
| --- | --- | --- |
| `hook_dll.c` (`hook.dll`) | Injected into SCI Companion, it patched `DrawTextA` to log every string the output pane drew to `dumps/compiler_captured.txt` | `git show ee05c34:tools/hook_dll.c` |
| `inject_and_scroll.c` | Injected `hook.dll`, pressed Compile, then scrolled the output list so every line was redrawn and logged | `git show ee05c34:tools/inject_and_scroll.c` |
| `copy_output.c` | Selected every line of the output list, sent `Ctrl+C`, and saved the clipboard to `dumps/compile_output.txt` | `git show 8e18e27:tools/copy_output.c` |
| `get_compile_log.c` | The same through `WM_COMMAND` `ID_EDIT_COPY` and `WM_COPY`, printing the first 2,000 characters as well | `git show 8e18e27:tools/get_compile_log.c` |
| `get_errors.c` | Clicked the list to focus it, selected each line with `LB_SETSEL`, then copied through `Ctrl+C` and printed the output | `git show 8e18e27:tools/get_errors.c` |

`compile_any.c` and `compile_by_name.c` also injected `hook.dll` and scrolled the output list after each compile
until D-051 removed that code; their earlier versions are at `ee05c34`.

## If the need returns

To read compile errors automatically again (D-051's review trigger), start from `get_errors.c`, the most thorough of
the clipboard routes, and point it at a folder that exists. The listbox can probably also be read directly with
`LB_GETTEXT` through remote memory, as `compile_any.c` reads the script list, which avoids the clipboard altogether;
none of these helpers tried that.
