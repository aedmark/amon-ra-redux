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
        printf("Usage: %s <script_name_or_number> (e.g. rm500.sc or 500)\n", argv[0]);
        return 1;
    }

    char target[256];
    strncpy(target, argv[1], sizeof(target) - 1);
    target[sizeof(target) - 1] = 0;
    // If target doesn't end with .sc, check if it's like "500" or "rm500"
    if (strstr(target, ".sc") == NULL) {
        // if starts with rm, append .sc
        // else check
        strcat(target, ".sc");
    }

    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }

    // Switch to scripts tab (33062)
    SendMessageA(hwndMain, WM_COMMAND, 33062, 0);
    Sleep(500);

    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    if (!g_hwndList) {
        printf("Scripts SysListView32 not found.\n");
        return 1;
    }

    DWORD pid = 0;
    GetWindowThreadProcessId(hwndMain, &pid);
    HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
    if (!hProc) {
        printf("OpenProcess failed.\n");
        return 1;
    }

    int count = SendMessageA(g_hwndList, LVM_GETITEMCOUNT, 0, 0);
    void *remoteMem = VirtualAllocEx(hProc, NULL, sizeof(LVITEMA) + 256, MEM_COMMIT, PAGE_READWRITE);
    if (!remoteMem) {
        printf("VirtualAllocEx failed.\n");
        CloseHandle(hProc);
        return 1;
    }
    char *remoteText = (char*)remoteMem + sizeof(LVITEMA);

    int targetIndex = -1;
    for (int i = 0; i < count; i++) {
        LVITEMA item = {0};
        item.mask = LVIF_TEXT;
        item.iItem = i;
        item.iSubItem = 0;
        item.pszText = remoteText;
        item.cchTextMax = 256;

        WriteProcessMemory(hProc, remoteMem, &item, sizeof(LVITEMA), NULL);
        SendMessageA(g_hwndList, LVM_GETITEMA, 0, (LPARAM)remoteMem);

        char buf[256] = {0};
        ReadProcessMemory(hProc, remoteText, buf, sizeof(buf) - 1, NULL);
        if (strcasecmp(buf, target) == 0 || (strlen(target) > 0 && strstr(buf, argv[1]) != NULL)) {
            printf("Found target '%s' as '%s' at index %d\n", argv[1], buf, i);
            targetIndex = i;
            break;
        }
    }

    // Clear all selection
    LVITEMA itemState = {0};
    itemState.mask = LVIF_STATE;
    itemState.stateMask = LVIS_SELECTED | LVIS_FOCUSED;
    itemState.state = 0;
    WriteProcessMemory(hProc, remoteMem, &itemState, sizeof(LVITEMA), NULL);
    SendMessageA(g_hwndList, LVM_SETITEMSTATE, -1, (LPARAM)remoteMem);

    // Select and focus target item
    itemState.state = LVIS_SELECTED | LVIS_FOCUSED;
    WriteProcessMemory(hProc, remoteMem, &itemState, sizeof(LVITEMA), NULL);
    SendMessageA(g_hwndList, LVM_SETITEMSTATE, targetIndex, (LPARAM)remoteMem);
    SendMessageA(g_hwndList, LVM_ENSUREVISIBLE, targetIndex, FALSE);
    Sleep(200);

    printf("Sending VK_RETURN to item %d...\n", targetIndex);
    SendMessageA(g_hwndList, WM_KEYDOWN, VK_RETURN, 0);
    SendMessageA(g_hwndList, WM_KEYUP, VK_RETURN, 0);
    Sleep(2000);

    VirtualFreeEx(hProc, remoteMem, 0, MEM_RELEASE);

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

    char title[256];
    GetWindowTextA(hwndMain, title, sizeof(title));
    printf("Window title after opening: '%s'\n", title);

    // Trigger ID_COMPILE (32838)
    printf("Sending ID_COMPILE (32838)...\n");
    SendMessageA(hwndMain, WM_COMMAND, 32838, 0);
    Sleep(2000);

    // Scroll output listbox to ensure captured text is rendered
    EnumChildWindows(hwndMain, EnumListBoxProc, 0);
    if (g_hwndListBox) {
        int lbCount = SendMessageA(g_hwndListBox, LB_GETCOUNT, 0, 0);
        printf("ListBox has %d entries. Scrolling to force paint...\n", lbCount);
        for (int i = 0; i < lbCount; i += 5) {
            SendMessageA(g_hwndListBox, LB_SETTOPINDEX, i, 0);
            InvalidateRect(g_hwndListBox, NULL, TRUE);
            UpdateWindow(g_hwndListBox);
            Sleep(5);
        }
    }

    CloseHandle(hProc);
    printf("Compilation completed!\n");
    return 0;
}
