#include <windows.h>
#include <stdio.h>
#include <string.h>

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "ListBox") == 0) {
        int count = SendMessageA(hwnd, LB_GETCOUNT, 0, 0);
        printf("ListBox 0x%p count: %d\n", hwnd, count);
        for (int i = 0; i < count; i++) {
            int len = SendMessageA(hwnd, LB_GETTEXTLEN, i, 0);
            LPARAM data = SendMessageA(hwnd, LB_GETITEMDATA, i, 0);
            printf("  Item %d: len=%d, itemData=0x%lx\n", i, len, (unsigned long)data);
            if (len > 0) {
                char buf[512] = {0};
                SendMessageA(hwnd, LB_GETTEXT, i, (LPARAM)buf);
                printf("    text: '%s'\n", buf);
            }
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
    if (!hwndMain) { printf("Main not found\n"); return 1; }
    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    return 0;
}
