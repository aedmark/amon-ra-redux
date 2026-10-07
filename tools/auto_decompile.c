#include <windows.h>
#include <stdio.h>

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

int main(int argc, char **argv) {
    HWND hwndMain = NULL;
    EnumWindows(EnumWindowsProc, (LPARAM)&hwndMain);
    if (!hwndMain) {
        printf("Main window not found\n");
        return 1;
    }
    printf("Found main window: 0x%p\n", hwndMain);

    // Open Decompile dialog: ID_SCRIPT_MANAGEDECOMPILATION = 33179
    PostMessageA(hwndMain, WM_COMMAND, 33179, 0);
    Sleep(2000);

    HWND hwndDlg = NULL;
    for (int i = 0; i < 20; i++) {
        hwndDlg = GetLastActivePopup(hwndMain);
        if (hwndDlg && hwndDlg != hwndMain) {
            char title[256];
            GetWindowTextA(hwndDlg, title, sizeof(title));
            if (strstr(title, "Decompile") || strstr(title, "Manage")) {
                printf("Found decompile dialog: '%s' (0x%p)\n", title, hwndDlg);
                break;
            }
        }
        Sleep(500);
    }

    if (!hwndDlg || hwndDlg == hwndMain) {
        printf("Decompile dialog not found\n");
        return 1;
    }

    // Click Assign Filenames
    printf("Clicking Assign Filenames (1242)...\n");
    SendMessageA(hwndDlg, WM_COMMAND, MAKEWPARAM(1242, BN_CLICKED), (LPARAM)GetDlgItem(hwndDlg, 1242));
    Sleep(5000);

    // Click Decompile (1240)
    printf("Clicking Decompile (1240)...\n");
    SendMessageA(hwndDlg, WM_COMMAND, MAKEWPARAM(1240, BN_CLICKED), (LPARAM)GetDlgItem(hwndDlg, 1240));
    Sleep(1500);

    // Check if AfxMessageBox popped up asking "Decompile all?"
    HWND hwndMsg = FindWindowA(NULL, "SCICompanion");
    if (hwndMsg) {
        printf("Found confirm dialog: 0x%p. Sending IDYES...\n", hwndMsg);
        SendMessageA(hwndMsg, WM_COMMAND, MAKEWPARAM(IDYES, BN_CLICKED), (LPARAM)GetDlgItem(hwndMsg, IDYES));
    }

    printf("Decompile started!\n");
    return 0;
}
