#include <windows.h>
#include <commctrl.h>
#include <stdio.h>

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "SysListView32") == 0) {
        int count = SendMessageA(hwnd, LVM_GETITEMCOUNT, 0, 0);
        printf("Found SysListView32 (0x%p) with %d items.\n", hwnd, count);
        int maxItems = count < 10 ? count : 10;
        for (int i = 0; i < maxItems; i++) {
            char text[256] = "";
            LVITEMA item = {0};
            item.iItem = i;
            item.mask = LVIF_TEXT;
            item.pszText = text;
            item.cchTextMax = sizeof(text);
            SendMessageA(hwnd, LVM_GETITEMA, 0, (LPARAM)&item);
            printf("  [%d] %s\n", i, text);
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
    if (!hwndMain) return 1;
    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    return 0;
}
