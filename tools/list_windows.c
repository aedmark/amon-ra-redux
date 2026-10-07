#include <windows.h>
#include <stdio.h>

BOOL CALLBACK EnumWindowsProc(HWND hwnd, LPARAM lParam) {
    char title[256];
    GetWindowTextA(hwnd, title, sizeof(title));
    if (strlen(title) > 0) {
        printf("HWND 0x%p: '%s'\n", hwnd, title);
    }
    return TRUE;
}

int main() {
    printf("Enumerating all windows:\n");
    EnumWindows(EnumWindowsProc, 0);
    return 0;
}
