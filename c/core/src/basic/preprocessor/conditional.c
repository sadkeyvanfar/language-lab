#include <stdio.h>

// Conditional compilation example in C
// This code demonstrates how to use preprocessor directives for conditional compilation
// to include or exclude code based on certain conditions.

int main() {
    // Define a macro for conditional compilation
    #define DEBUG 1

    // Use the macro to conditionally compile code
    #if DEBUG
        printf("Debug mode is ON\n");
    #elif defined(DEBUG) && DEBUG == 0
        printf("Debug mode is OFF\n");
    #else
        printf("Debug mode is not defined\n");
    #endif

    // Another example of conditional compilation
    #ifdef FEATURE_X
        printf("Feature X is enabled\n");
    #else
        printf("Feature X is not enabled\n");
    #endif

    return 0;
}
