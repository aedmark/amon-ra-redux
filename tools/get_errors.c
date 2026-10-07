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
    if (strstr(title, "SCICompanion")) {
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
    int count = SendMessageA(g_hwndListBox, LB_GETCOUNT, 0, 0);
    printf("Found ListBox 0x%p with %d items.\n", g_hwndListBox, count);

    // Bring main window to foreground
    SetForegroundWindow(hwndMain);
    Sleep(200);

    // Click inside list box to give it focus and select the first visible item
    LPARAM lp = MAKELPARAM(20, 20);
    SendMessageA(g_hwndListBox, WM_LBUTTONDOWN, MK_LBUTTON, lp);
    SendMessageA(g_hwndListBox, WM_LBUTTONUP, 0, lp);
    Sleep(200);

    // Now select all items from 0 to count-1
    for (int i = 0; i < count; i++) {
        SendMessageA(g_hwndListBox, LB_SETSEL, TRUE, i);
    }

    int selCount = SendMessageA(g_hwndListBox, LB_GETSELCOUNT, 0, 0);
    printf("Selected items: %d\n", selCount);

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
                printf("=== COMPILER OUTPUT (%zu bytes) ===\n", strlen(pText));
                FILE *f = fopen("compile_output.txt", "w");
                if (f) {
                    fputs(pText, f);
                    fclose(f);
                }
                // Print first 2000 chars
                printf("%.2000s\n", pText);
                GlobalUnlock(hData);
            }
        } else {
            printf("No CF_TEXT on clipboard.\n");
        }
        CloseClipboard();
    } else {
        printf("Could not open clipboard.\n");
    }
    return 0;
}
