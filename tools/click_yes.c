#include <windows.h>
#include <stdio.h>

int main() {
    HWND hwndMsg = FindWindowA(NULL, "SCICompanion");
    if (!hwndMsg) {
        printf("MessageBox not found\n");
        return 1;
    }
    printf("Found MessageBox: 0x%p\n", hwndMsg);
    // Send IDYES (6)
    SendMessageA(hwndMsg, WM_COMMAND, MAKEWPARAM(IDYES, BN_CLICKED), (LPARAM)GetDlgItem(hwndMsg, IDYES));
    printf("Sent IDYES!\n");
    return 0;
}
