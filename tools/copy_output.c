#include <windows.h>
#include <stdio.h>
#include <string.h>

HWND g_hwndListBox = NULL;

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "ListBox") == 0) {
        int count = SendMessageA(hwnd, LB_GETCOUNT, 0, 0);
        if (count > 0) {
            g_hwndListBox = hwnd;
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
    if (!g_hwndListBox) {
        printf("ListBox not found.\n");
        return 1;
    }
    printf("Found ListBox: 0x%p\n", g_hwndListBox);

    SetForegroundWindow(hwndMain);
    SetFocus(g_hwndListBox);
    SendMessageA(g_hwndListBox, LB_SETSEL, TRUE, -1);
    Sleep(200);

    // Send Ctrl+C
    keybd_event(VK_CONTROL, 0, 0, 0);
    keybd_event('C', 0, 0, 0);
    Sleep(100);
    keybd_event('C', 0, KEYEVENTF_KEYUP, 0);
    keybd_event(VK_CONTROL, 0, KEYEVENTF_KEYUP, 0);
    Sleep(500);

    if (OpenClipboard(NULL)) {
        HANDLE hData = GetClipboardData(CF_TEXT);
        if (hData) {
            char *pText = (char*)GlobalLock(hData);
            if (pText) {
                FILE *f = fopen("compile_output.txt", "w");
                if (f) {
                    fputs(pText, f);
                    fclose(f);
                    printf("Saved %zu bytes to compile_output.txt\n", strlen(pText));
                }
                GlobalUnlock(hData);
            }
        } else {
            printf("No CF_TEXT in clipboard.\n");
        }
        CloseClipboard();
    } else {
        printf("Failed to open clipboard.\n");
    }
    return 0;
}
