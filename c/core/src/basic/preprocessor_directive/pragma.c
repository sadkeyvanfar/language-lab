// pragma directive to provide additional information to the compiler
// This code demonstrates the use of the `#pragma` directive in C.
#include <stdio.h>

// not standard but widely supported
#pragma once // Ensures the file is included only once

#pragma message("This is a pragma message") // Displays a message during compilation
#pragma warning "This is a pragma warning" // Generates a warning during compilation
#pragma error "This is a pragma error" // Generates an error during compilation

#pragma GCC diagnostic push // Saves the current state of diagnostics
#pragma GCC diagnostic ignored "-Wunused-variable" // Ignores warnings about unused variables
#pragma GCC diagnostic ignored "-Wunused-function" // Ignores warnings about unused functions

#pragma  optimize("O2") // Sets optimization level to O2

int main() {
    int unused_variable = 42; // This will not generate a warning due to the pragma directive
    printf("Hello, World!\n");

    // The following function is unused, but it won't generate a warning due to the pragma directive
    void unused_function() {
        printf("This function is unused.\n");
    }

    return 0;
}
