/*
 * Description:
 * This program reads the contents of a file named "output.txt" line by line
 * and prints each line to the console. It demonstrates how to open a file
 * for reading, handle file errors, and read text using fgets().
 * This kind of functionality is useful for displaying logs, configuration files,
 * or any structured text output stored in a file.
 */

 #include <stdio.h>  // Standard input/output library for file operations

 int main() {
     char line[100];  // Buffer to store each line read from the file
 
     // Open the file "output.txt" in read mode ("r")
     FILE *fp = fopen("output.txt", "r");
 
     // Check if the file was successfully opened
     if (fp == NULL) {
         printf("File not found!\n");
         return 1;  // Return non-zero to indicate an error
     }
 
     // Read each line from the file until the end
     while (fgets(line, sizeof(line), fp)) {
         printf("%s", line);  // Print the current line to the console
     }
 
     // Close the file to free system resources
     fclose(fp);
 
     return 0;  // Return 0 to indicate successful execution
 }