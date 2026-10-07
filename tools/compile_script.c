#include <windows.h>
#include <commctrl.h>
#include <stdio.h>
#include <string.h>

HWND g_hwndList = NULL;

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

int main(int argc, char **argv) {
    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }
    char title[256];
    GetWindowTextA(hwndMain, title, sizeof(title));
    printf("Found main window: 0x%p ('%s')\n", hwndMain, title);

    if (strstr(title, "Main.sc") == NULL) {
        // Switch to Scripts tab
        printf("Switching to Scripts tab...\n");
        SendMessageA(hwndMain, WM_COMMAND, 33062, 0);
        Sleep(500);

        EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
        if (!g_hwndList) {
            printf("ListView not found.\n");
            return 1;
        }
        printf("Found ListView: 0x%p\n", g_hwndList);

        // Double click item 0
        RECT rc = { LVIR_BOUNDS, 0, 0, 0 };
        SendMessageA(g_hwndList, LVM_GETITEMRECT, 0, (LPARAM)&rc);
        LPARAM lp = MAKELPARAM(rc.left + 15, rc.top + 10);
        SendMessageA(g_hwndList, WM_LBUTTONDOWN, MK_LBUTTON, lp);
        SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
        SendMessageA(g_hwndList, WM_LBUTTONDBLCLK, MK_LBUTTON, lp);
        SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
        Sleep(1500);
    }

    GetWindowTextA(hwndMain, title, sizeof(title));
    printf("Window title after opening: '%s'\n", title);

    // Send ID_COMPILE (32838)
    printf("Sending ID_COMPILE (32838)...\n");
    SendMessageA(hwndMain, WM_COMMAND, 32838, 0);
    Sleep(2000);

    printf("Done!\n");
    return 0;
}
