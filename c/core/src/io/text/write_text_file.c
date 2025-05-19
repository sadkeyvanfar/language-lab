#include <stdio.h>  // Include standard input/output header for file functions

int main() {
    // Open a file named "output.txt" for writing ("w" mode).
    // If the file does not exist, it will be created.
    // If it exists, it will be overwritten.
    FILE *fp = fopen("output.txt", "w");

    // Check if the file was opened successfully
    if (fp == NULL) {
        // Print an error message if file couldn't be opened
        printf("Error opening file!\n");
        return 1;  // Return a non-zero value to indicate error
    }

    // Write a line of text to the file using fprintf (formatted output)
    fprintf(fp, "Writing this line to a file.\n");

    // Close the file to ensure data is written and resources are freed
    fclose(fp);

    return 0;  // Return 0 to indicate successful execution
}
