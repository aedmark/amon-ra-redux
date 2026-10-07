#include <windows.h>
#include <stdio.h>
#include <string.h>

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

int main(int argc, char **argv) {
    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }
    printf("Found main window: 0x%p\n", hwndMain);

    printf("Posting ID_COMPILEALL (32844)...\n");
    PostMessageA(hwndMain, WM_COMMAND, 32844, 0);

    for (int sec = 0; sec < 10; sec++) {
        Sleep(1000);
        HWND hwndDlg = GetLastActivePopup(hwndMain);
        char title[256] = "";
        if (hwndDlg) GetWindowTextA(hwndDlg, title, sizeof(title));
        printf("sec %d: popup = 0x%p, title = '%s'\n", sec, hwndDlg, title);
    }
    return 0;
}
