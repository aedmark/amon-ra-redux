#include <windows.h>
#include <commctrl.h>
#include <stdio.h>
#include <string.h>

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

int main() {
    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found.\n");
        return 1;
    }
    printf("Found main window: 0x%p\n", hwndMain);

    printf("Posting ID_COMPILEALL (32844)...\n");
    PostMessageA(hwndMain, WM_COMMAND, 32844, 0);

    HWND hwndDlg = NULL;
    char lastTitle[256] = "";
    int scriptCount = 0;

    for (int ms = 0; ms < 30000; ms += 20) {
        Sleep(20);
        HWND popup = GetLastActivePopup(hwndMain);
        if (popup && popup != hwndMain) {
            char title[256];
            GetWindowTextA(popup, title, sizeof(title));
            if (strstr(title, "Compil") || strstr(title, "compil")) {
                hwndDlg = popup;
                char scriptName[256] = "";
                GetDlgItemTextA(hwndDlg, 1001, scriptName, sizeof(scriptName));
                if (strlen(scriptName) > 0 && strcmp(scriptName, lastTitle) != 0) {
                    scriptCount++;
                    printf("[%d] Compiling: %s\n", scriptCount, scriptName);
                    strcpy(lastTitle, scriptName);
                }
            }
        } else if (hwndDlg) {
            printf("Dialog closed after %d scripts!\n", scriptCount);
            break;
        }
    }
    return 0;
}
