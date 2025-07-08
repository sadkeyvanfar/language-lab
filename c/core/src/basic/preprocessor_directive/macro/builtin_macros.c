#include <stdio.h>

// Built-in macros example in C
// This code demonstrates the use of built-in macros in C, such as __FILE__, __LINE__, __DATE__, and __TIME__.
// These macros provide information about the current file, line number, date, and time of compilation.
// They can be useful for debugging and logging purposes.

int main() {
    // Print the current file name
    printf("File: %s\n", __FILE__);

    // Print the current line number
    printf("Line: %d\n", __LINE__);

    // Print the date of compilation
    printf("Date: %s\n", __DATE__);

    // Print the time of compilation
    printf("Time: %s\n", __TIME__);

    return 0;
}
