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

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
    char className[256];
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "SysListView32") == 0) {
        int count = SendMessageA(hwnd, LVM_GETITEMCOUNT, 0, 0);
        printf("SysListView32 0x%p, count: %d\n", hwnd, count);
        if (count > 0) {
            DWORD pid = (DWORD)lParam;
            HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
            void *remoteMem = VirtualAllocEx(hProc, NULL, sizeof(LVITEMA) + 256, MEM_COMMIT, PAGE_READWRITE);
            char *remoteText = (char*)remoteMem + sizeof(LVITEMA);
            for (int i = 0; i < count; i++) {
                LVITEMA item = {0};
                item.mask = LVIF_TEXT;
                item.iItem = i;
                item.pszText = remoteText;
                item.cchTextMax = 256;
                WriteProcessMemory(hProc, remoteMem, &item, sizeof(LVITEMA), NULL);
                SendMessageA(hwnd, LVM_GETITEMA, 0, (LPARAM)remoteMem);
                char buf[256] = {0};
                ReadProcessMemory(hProc, remoteText, buf, sizeof(buf)-1, NULL);
                printf("  [%d] %s\n", i, buf);
            }
            VirtualFreeEx(hProc, remoteMem, 0, MEM_RELEASE);
            CloseHandle(hProc);
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

    SendMessageA(hwndMain, WM_COMMAND, 33062, 0);
    Sleep(500);

    DWORD pid = 0;
    GetWindowThreadProcessId(hwndMain, &pid);
    EnumChildWindows(hwndMain, EnumChildWindowsProc, (LPARAM)pid);
    return 0;
}
