#include <windows.h>
#include <stdio.h>
#include <string.h>

HWND g_hwndListBox = NULL;

BOOL CALLBACK EnumChildWindowsProc(HWND hwnd, LPARAM lParam) {
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
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }
    DWORD pid = 0;
    GetWindowThreadProcessId(hwndMain, &pid);
    printf("Found window 0x%p, PID: %lu\n", hwndMain, pid);

    HANDLE hProc = OpenProcess(PROCESS_ALL_ACCESS, FALSE, pid);
    if (!hProc) {
        printf("OpenProcess failed.\n");
        return 1;
    }

    const char *dllPath = "Z:\\home\\gordonk\\PycharmProjects\\amon-ra-redux\\tools\\hook.dll";
    void *pMem = VirtualAllocEx(hProc, NULL, strlen(dllPath) + 1, MEM_COMMIT, PAGE_READWRITE);
    WriteProcessMemory(hProc, pMem, dllPath, strlen(dllPath) + 1, NULL);

    HMODULE hKernel32 = GetModuleHandleA("kernel32.dll");
    void *pLoadLibrary = (void*)GetProcAddress(hKernel32, "LoadLibraryA");

    HANDLE hThread = CreateRemoteThread(hProc, NULL, 0, (LPTHREAD_START_ROUTINE)pLoadLibrary, pMem, 0, NULL);
    if (hThread) {
        WaitForSingleObject(hThread, 5000);
        CloseHandle(hThread);
        printf("DLL injected successfully!\n");
    } else {
        printf("CreateRemoteThread failed.\n");
        return 1;
    }

    // Trigger ID_COMPILE
    printf("Sending ID_COMPILE (32838)...\n");
    SendMessageA(hwndMain, WM_COMMAND, 32838, 0);
    Sleep(2000);

    // Find ListBox
    EnumChildWindows(hwndMain, EnumChildWindowsProc, 0);
    if (g_hwndListBox) {
        int count = SendMessageA(g_hwndListBox, LB_GETCOUNT, 0, 0);
        printf("Found ListBox with %d items. Scrolling to trigger render...\n", count);
        for (int i = 0; i < count; i += 10) {
            SendMessageA(g_hwndListBox, LB_SETTOPINDEX, i, 0);
            InvalidateRect(g_hwndListBox, NULL, TRUE);
            UpdateWindow(g_hwndListBox);
            Sleep(10);
        }
    }

    printf("Done scrolling!\n");
    return 0;
}
