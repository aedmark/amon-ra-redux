#include <windows.h>
#include <commctrl.h>
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

HWND g_hwndList = NULL;
BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "SysListView32") == 0) {
        int count = SendMessageA(hwnd, LVM_GETITEMCOUNT, 0, 0);
        if (count > 50) {
            g_hwndList = hwnd;
            return FALSE;
        }
    }
    return TRUE;
}

int main(int argc, char **argv) {
    int targetIndex = 14; // rm500
    if (argc > 1) {
        targetIndex = atoi(argv[1]);
    }

    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }

    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    if (!g_hwndList) {
        printf("SysListView32 with 29 items not found.\n");
        return 1;
    }

    DWORD pid = 0;
    GetWindowThreadProcessId(hwndMain, &pid);
    HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
    void *remoteMem = VirtualAllocEx(hProc, NULL, sizeof(RECT), MEM_COMMIT, PAGE_READWRITE);

    SendMessageA(g_hwndList, LVM_ENSUREVISIBLE, targetIndex, FALSE);
    Sleep(200);

    RECT rc = { LVIR_BOUNDS, 0, 0, 0 };
    WriteProcessMemory(hProc, remoteMem, &rc, sizeof(RECT), NULL);
    SendMessageA(g_hwndList, LVM_GETITEMRECT, targetIndex, (LPARAM)remoteMem);
    ReadProcessMemory(hProc, remoteMem, &rc, sizeof(RECT), NULL);
    printf("Item %d rect: (%ld, %ld, %ld, %ld)\n", targetIndex, rc.left, rc.top, rc.right, rc.bottom);

    int x = rc.left + 15;
    int y = rc.top + 8;
    LPARAM lp = MAKELPARAM(x, y);

    printf("Double clicking at (%d, %d)...\n", x, y);
    SendMessageA(g_hwndList, WM_LBUTTONDOWN, MK_LBUTTON, lp);
    SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
    SendMessageA(g_hwndList, WM_LBUTTONDBLCLK, MK_LBUTTON, lp);
    SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
    Sleep(1500);

    VirtualFreeEx(hProc, remoteMem, 0, MEM_RELEASE);
    CloseHandle(hProc);

    char title[256];
    GetWindowTextA(hwndMain, title, sizeof(title));
    printf("Main window title after double click: '%s'\n", title);
    return 0;
}
