#include <windows.h>
#include <stdio.h>

BOOL CALLBACK EnumWindowsProc(HWND hwnd, LPARAM lParam) {
    char title[256] = {0};
    GetWindowTextA(hwnd, title, sizeof(title));
    char className[256] = {0};
    GetClassNameA(hwnd, className, sizeof(className));
    if (strcmp(className, "#32770") == 0) {
        printf("Found dialog 0x%p ('%s')\n", hwnd, title);
        HWND btn = GetDlgItem(hwnd, IDOK);
        if (btn) {
            printf("Found IDOK button 0x%p, clicking it!\n", btn);
            SendMessageA(hwnd, WM_COMMAND, MAKEWPARAM(IDOK, BN_CLICKED), (LPARAM)btn);
            return FALSE;
        }
    }
    return TRUE;
}

int main() {
    EnumWindows(EnumWindowsProc, 0);
    return 0;
}