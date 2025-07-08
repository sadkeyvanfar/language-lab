// file inclusion macro
#include <stdio.h>
#include "signal.h"
#include "signal.h" // Including the header file twice to demonstrate the include guard

int main() {
    struct signal_struct act;
    act.sig = 1; // Example signal number
    act.flags = 0; // Example flags

    // Sending a signal
    send_signal(act.sig, &act);

    // Using the include guard to prevent multiple inclusions
    printf("Include guard is working correctly.\n");

    return 0;
}
