#include <windows.h>
#include <stdio.h>
#include <string.h>

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
    char title[256];
    GetWindowTextA(hwndMain, title, sizeof(title));
    printf("Found window: 0x%p, title: '%s'\n", hwndMain, title);

    printf("Sending ID_COMPILE (32838) to compile active script...\n");
    SendMessageA(hwndMain, WM_COMMAND, 32838, 0);

    Sleep(2000);
    printf("Compile command sent.\n");
    return 0;
}
