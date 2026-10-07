#include <windows.h>
#include <commctrl.h>
#include <stdio.h>

HWND g_hwndList = NULL;

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

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "SysListView32") == 0) {
        int count = SendMessageA(hwnd, LVM_GETITEMCOUNT, 0, 0);
        if (count > 0) {
            g_hwndList = hwnd;
            return FALSE;
        }
    }
    return TRUE;
}

BOOL CALLBACK PrintWindowsProc(HWND hwnd, LPARAM lParam) {
    char title[256];
    GetWindowTextA(hwnd, title, sizeof(title));
    if (strlen(title) > 0) {
        printf("  Window 0x%p: '%s'\n", hwnd, title);
    }
    return TRUE;
}

int main() {
    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) return 1;

    // First ensure Scripts tab is active: 33062
    SendMessageA(hwndMain, WM_COMMAND, 33062, 0);
    Sleep(500);

    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    if (!g_hwndList) {
        printf("List not found.\n");
        return 1;
    }
    int count = SendMessageA(g_hwndList, LVM_GETITEMCOUNT, 0, 0);
    printf("Found ListView: 0x%p with %d items\n", g_hwndList, count);

    // Get bounds of item 0
    RECT rc = { LVIR_BOUNDS, 0, 0, 0 };
    SendMessageA(g_hwndList, LVM_GETITEMRECT, 0, (LPARAM)&rc);
    printf("Item 0 rect: (%ld, %ld, %ld, %ld)\n", rc.left, rc.top, rc.right, rc.bottom);

    int x = rc.left + 15;
    int y = rc.top + 10;
    LPARAM lp = MAKELPARAM(x, y);

    // Simulate mouse double click
    SendMessageA(g_hwndList, WM_LBUTTONDOWN, MK_LBUTTON, lp);
    SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
    SendMessageA(g_hwndList, WM_LBUTTONDBLCLK, MK_LBUTTON, lp);
    SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);

    Sleep(1500);

    printf("Windows after double-click:\n");
    EnumWindows(PrintWindowsProc, 0);

    return 0;
}
