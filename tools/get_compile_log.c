#include <windows.h>
#include <stdio.h>
#include <string.h>

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "ListBox") == 0) {
        int count = SendMessageA(hwnd, LB_GETCOUNT, 0, 0);
        if (count > 0) {
            printf("Found ListBox (0x%p) with %d items.\n", hwnd, count);
            // Select all
            SendMessageA(hwnd, LB_SETSEL, TRUE, -1);
            // Send WM_COMMAND ID_EDIT_COPY (57634) or WM_COPY (0x301)
            HWND hwndParent = GetParent(hwnd);
            SendMessageA(hwndParent, WM_COMMAND, 57634, 0);
            SendMessageA(hwnd, WM_COPY, 0, 0);

            // Now read clipboard
            if (OpenClipboard(NULL)) {
                HANDLE hData = GetClipboardData(CF_TEXT);
                if (hData) {
                    char *pText = (char*)GlobalLock(hData);
                    if (pText) {
                        printf("=== CLIPBOARD OUTPUT (first 2000 chars) ===\n%.2000s\n", pText);
                        // Write to the repository's captured-output directory.
                        FILE *f = fopen("dumps/compile_output.txt", "w");
                        if (f) {
                            fputs(pText, f);
                            fclose(f);
                            printf("Wrote full output to dumps/compile_output.txt (%zu bytes)\n", strlen(pText));
                        }
                        GlobalUnlock(hData);
                    }
                }
                CloseClipboard();
            }
            return FALSE;
        }
    }
    return TRUE;
}

BOOL CALLBACK EnumWindowsProc(HWND hwnd, LPARAM lParam) {
    char title[256];
    GetWindowTextA(hwnd, title, sizeof(title));
    if (strstr(title, "SCICompanion") || strstr(title, "Explorer")) {
        HWND *pHwnd = (HWND*)lParam;
        *pHwnd = hwnd;
        return FALSE;
    }
    return TRUE;
}

int main() {
    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }
    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    return 0;
}
