#include <windows.h>
#include <stdio.h>
#include <string.h>

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "ListBox") == 0) {
        int count = SendMessageA(hwnd, LB_GETCOUNT, 0, 0);
        if (count > 0) {
            printf("Found ListBox (0x%p) with %d items:\n", hwnd, count);
            for (int i = 0; i < count; i++) {
                char text[1024] = "";
                SendMessageA(hwnd, LB_GETTEXT, i, (LPARAM)text);
                printf("[%d] %s\n", i, text);
            }
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
    printf("Scanning child windows of 0x%p...\n", hwndMain);
    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    return 0;
}
