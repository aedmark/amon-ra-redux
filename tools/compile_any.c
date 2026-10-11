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
#define MAX_LIST_VIEWS 32
HWND g_hwndLists[MAX_LIST_VIEWS];
int g_hwndListCounts[MAX_LIST_VIEWS];
int g_listViewCount = 0;
BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "SysListView32") == 0) {
        int count = SendMessageA(hwnd, LVM_GETITEMCOUNT, 0, 0);
        // The resource explorer and script browser are both SysListView32
        // controls, and either one may be larger. Retain every candidate and
        // select the list that actually contains the requested source name.
        if (g_listViewCount < MAX_LIST_VIEWS) {
            g_hwndLists[g_listViewCount] = hwnd;
            g_hwndListCounts[g_listViewCount] = count;
            g_listViewCount++;
        }
    }
    return TRUE;
}

HWND g_hwndListBox = NULL;
BOOL CALLBACK EnumListBoxProc(HWND hwnd, LPARAM lParam) {
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

int main(int argc, char **argv) {
    if (argc < 2) {
        printf("Usage: %s <script_name> (e.g. Button.sc or MyFeature or rm500)\n", argv[0]);
        return 1;
    }

    char target[256];
    strncpy(target, argv[1], sizeof(target) - 1);
    target[sizeof(target) - 1] = 0;
    if (strstr(target, ".sc") == NULL) {
        strcat(target, ".sc");
    }

    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }

    // Switch to scripts tab
    SendMessageA(hwndMain, WM_COMMAND, 33062, 0);
    Sleep(300);

    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    if (g_listViewCount == 0) {
        printf("No SysListView32 controls found.\n");
        return 1;
    }

    DWORD pid = 0;
    GetWindowThreadProcessId(hwndMain, &pid);
    HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
    if (!hProc) {
        printf("OpenProcess failed.\n");
        return 1;
    }

    void *remoteMem = VirtualAllocEx(hProc, NULL, sizeof(LVITEMA) + 256, MEM_COMMIT, PAGE_READWRITE);
    if (!remoteMem) {
        printf("VirtualAllocEx failed.\n");
        CloseHandle(hProc);
        return 1;
    }
    char *remoteText = (char*)remoteMem + sizeof(LVITEMA);

    int targetIndex = -1;
    for (int listIndex = 0; listIndex < g_listViewCount && targetIndex == -1; listIndex++) {
        HWND candidate = g_hwndLists[listIndex];
        int count = g_hwndListCounts[listIndex];
        for (int i = 0; i < count; i++) {
            LVITEMA item = {0};
            item.mask = LVIF_TEXT;
            item.iItem = i;
            item.pszText = remoteText;
            item.cchTextMax = 256;

            WriteProcessMemory(hProc, remoteMem, &item, sizeof(LVITEMA), NULL);
            SendMessageA(candidate, LVM_GETITEMA, 0, (LPARAM)remoteMem);

            char buf[256] = {0};
            ReadProcessMemory(hProc, remoteText, buf, sizeof(buf) - 1, NULL);

            char targetNoExt[256];
            strncpy(targetNoExt, target, sizeof(targetNoExt) - 1);
            targetNoExt[sizeof(targetNoExt) - 1] = 0;
            char *dot = strstr(targetNoExt, ".sc");
            if (dot) *dot = 0;

            if (strcasecmp(buf, target) == 0 || strcasecmp(buf, targetNoExt) == 0) {
                g_hwndList = candidate;
                printf("Found target '%s' at index %d ('%s') in list %d (%d rows)\n",
                       target, i, buf, listIndex, count);
                targetIndex = i;
                break;
            }
        }
    }

    if (targetIndex == -1) {
        printf("Target '%s' not found in %d list views.\n", target, g_listViewCount);
        VirtualFreeEx(hProc, remoteMem, 0, MEM_RELEASE);
        CloseHandle(hProc);
        return 1;
    }

    // Ensure item visible
    SendMessageA(g_hwndList, LVM_ENSUREVISIBLE, targetIndex, FALSE);
    Sleep(200);

    // Get item rect
    RECT rc = { LVIR_BOUNDS, 0, 0, 0 };
    WriteProcessMemory(hProc, remoteMem, &rc, sizeof(RECT), NULL);
    SendMessageA(g_hwndList, LVM_GETITEMRECT, targetIndex, (LPARAM)remoteMem);
    ReadProcessMemory(hProc, remoteMem, &rc, sizeof(RECT), NULL);

    VirtualFreeEx(hProc, remoteMem, 0, MEM_RELEASE);

    int x = rc.left + 15;
    int y = rc.top + 8;
    LPARAM lp = MAKELPARAM(x, y);

    printf("Double clicking item %d at (%d, %d)...\n", targetIndex, x, y);
    SendMessageA(g_hwndList, WM_LBUTTONDOWN, MK_LBUTTON, lp);
    SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
    SendMessageA(g_hwndList, WM_LBUTTONDBLCLK, MK_LBUTTON, lp);
    SendMessageA(g_hwndList, WM_LBUTTONUP, 0, lp);
    Sleep(1500);

    char title[256];
    GetWindowTextA(hwndMain, title, sizeof(title));
    printf("Window title after opening: '%s'\n", title);

    // Inject hook DLL if not already injected
    const char *dllPath = "Z:\\home\\gordonk\\PycharmProjects\\amon-ra-redux\\tools\\hook.dll";
    void *pMem = VirtualAllocEx(hProc, NULL, strlen(dllPath) + 1, MEM_COMMIT, PAGE_READWRITE);
    if (pMem) {
        WriteProcessMemory(hProc, pMem, dllPath, strlen(dllPath) + 1, NULL);
        HMODULE hKernel32 = GetModuleHandleA("kernel32.dll");
        void *pLoadLibrary = (void*)GetProcAddress(hKernel32, "LoadLibraryA");
        HANDLE hThread = CreateRemoteThread(hProc, NULL, 0, (LPTHREAD_START_ROUTINE)pLoadLibrary, pMem, 0, NULL);
        if (hThread) {
            WaitForSingleObject(hThread, 3000);
            CloseHandle(hThread);
        }
    }

    // Trigger ID_COMPILE (32838)
    printf("Sending ID_COMPILE (32838)...\n");
    SendMessageA(hwndMain, WM_COMMAND, 32838, 0);
    Sleep(2000);

    // Check for popup dialog and dismiss if present
    HWND hwndPopup = GetLastActivePopup(hwndMain);
    if (hwndPopup && hwndPopup != hwndMain) {
        char popupTitle[256] = {0};
        GetWindowTextA(hwndPopup, popupTitle, sizeof(popupTitle));
        printf("Popup detected: 0x%p ('%s'). Dismissing...\n", hwndPopup, popupTitle);
        HWND btn = GetDlgItem(hwndPopup, IDOK);
        if (!btn) btn = GetDlgItem(hwndPopup, IDYES);
        if (btn) {
            SendMessageA(hwndPopup, WM_COMMAND, MAKEWPARAM(GetDlgCtrlID(btn), BN_CLICKED), (LPARAM)btn);
        } else {
            SendMessageA(hwndPopup, WM_COMMAND, IDOK, 0);
        }
        Sleep(500);
    }

    // Scroll output listbox
    EnumChildWindows(hwndMain, EnumListBoxProc, 0);
    if (g_hwndListBox) {
        int lbCount = SendMessageA(g_hwndListBox, LB_GETCOUNT, 0, 0);
        for (int i = 0; i < lbCount; i += 5) {
            SendMessageA(g_hwndListBox, LB_SETTOPINDEX, i, 0);
            InvalidateRect(g_hwndListBox, NULL, TRUE);
            UpdateWindow(g_hwndListBox);
            Sleep(5);
        }
    }

    CloseHandle(hProc);
    printf("Compilation completed for '%s'!\n", target);
    return 0;
}
