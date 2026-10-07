#include <windows.h>
#include <stdio.h>
#include <string.h>

FILE *g_log = NULL;
typedef int (WINAPI *DrawTextA_t)(HDC, LPCSTR, int, LPRECT, UINT);
DrawTextA_t g_origDrawTextA = NULL;
BYTE g_origBytes[5];

int WINAPI MyDrawTextA(HDC hdc, LPCSTR lpchText, int cchText, LPRECT lprc, UINT format) {
    if (lpchText && g_log) {
        if (cchText > 0) {
            fprintf(g_log, "%.*s\n", cchText, lpchText);
        } else {
            fprintf(g_log, "%s\n", lpchText);
        }
        fflush(g_log);
    }

    DWORD oldProtect;
    VirtualProtect((LPVOID)g_origDrawTextA, 5, PAGE_EXECUTE_READWRITE, &oldProtect);
    memcpy((void*)g_origDrawTextA, g_origBytes, 5);
    int res = g_origDrawTextA(hdc, lpchText, cchText, lprc, format);

    BYTE jmp[5] = { 0xE9 };
    *(DWORD*)(jmp + 1) = (DWORD)((BYTE*)MyDrawTextA - (BYTE*)g_origDrawTextA - 5);
    memcpy((void*)g_origDrawTextA, jmp, 5);
    VirtualProtect((LPVOID)g_origDrawTextA, 5, oldProtect, &oldProtect);
    return res;
}

void InstallHook() {
    g_log = fopen("Z:\\home\\gordonk\\PycharmProjects\\amon-ra-redux\\compiler_captured.txt", "w");
    if (!g_log) return;
    fprintf(g_log, "--- Hook installed ---\n");
    fflush(g_log);

    HMODULE hUser32 = GetModuleHandleA("user32.dll");
    g_origDrawTextA = (DrawTextA_t)GetProcAddress(hUser32, "DrawTextA");
    if (!g_origDrawTextA) return;

    DWORD oldProtect;
    VirtualProtect((LPVOID)g_origDrawTextA, 5, PAGE_EXECUTE_READWRITE, &oldProtect);
    memcpy(g_origBytes, (void*)g_origDrawTextA, 5);

    BYTE jmp[5] = { 0xE9 };
    *(DWORD*)(jmp + 1) = (DWORD)((BYTE*)MyDrawTextA - (BYTE*)g_origDrawTextA - 5);
    memcpy((void*)g_origDrawTextA, jmp, 5);
    VirtualProtect((LPVOID)g_origDrawTextA, 5, oldProtect, &oldProtect);
}

BOOL WINAPI DllMain(HINSTANCE hinst, DWORD reason, LPVOID reserved) {
    if (reason == DLL_PROCESS_ATTACH) {
        InstallHook();
    }
    return TRUE;
}
