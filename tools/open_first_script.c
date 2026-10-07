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

    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    if (!g_hwndList) {
        printf("List not found.\n");
        return 1;
    }
    printf("Found ListView: 0x%p\n", g_hwndList);

    // Select item 0
    LVITEMA lvi = {0};
    lvi.stateMask = LVIS_SELECTED | LVIS_FOCUSED;
    lvi.state = LVIS_SELECTED | LVIS_FOCUSED;
    SendMessageA(g_hwndList, LVM_SETITEMSTATE, 0, (LPARAM)&lvi);

    // Press Enter
    printf("Sending Enter to ListView...\n");
    SendMessageA(g_hwndList, WM_KEYDOWN, VK_RETURN, 0);
    SendMessageA(g_hwndList, WM_KEYUP, VK_RETURN, 0);

    Sleep(1500);

    printf("Listing all windows after Enter:\n");
    EnumWindows(PrintWindowsProc, 0);

    return 0;
}
