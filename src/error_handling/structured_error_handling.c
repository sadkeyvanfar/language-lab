/*
 * File: structured_error_handling.c
 * Description:
 * Demonstrates best practices for error handling in C using a custom Error struct,
 * a centralized error handler function, and clean resource management.
 * Reads the first line of a file and reports detailed errors if something fails.
 */

 #include <stdio.h>
 #include <stdlib.h>
 #include <string.h>
 
 // Define error codes
 typedef enum {
     ERR_OK = 0,
     ERR_FILE_OPEN = 1,
     ERR_FILE_READ = 2,
     ERR_FILE_EMPTY = 3
 } ErrorCode;
 
 // Error struct to hold code and message
 typedef struct {
     ErrorCode code;
     const char *message;
 } Error;
 
 // Centralized error handler
 void handle_error(const Error *err) {
     fprintf(stderr, "Error [%d]: %s\n", err->code, err->message);
 }
 
 // Function that reads the first line of a file with detailed error reporting
 Error read_first_line(const char *filename, char *buffer, size_t size) {
     FILE *fp = fopen(filename, "r");
     if (fp == NULL) {
         return (Error){ERR_FILE_OPEN, "Unable to open file"};
     }
 
     if (fgets(buffer, size, fp) == NULL) {
         fclose(fp);
         if (feof(fp)) {
             return (Error){ERR_FILE_EMPTY, "File is empty"};
         } else {
             return (Error){ERR_FILE_READ, "Failed to read from file"};
         }
     }
 
     fclose(fp);
     return (Error){ERR_OK, "Success"};
 }
 
 int main() {
     const char *filename = "example.txt";
     char line[256];
 
     Error err = read_first_line(filename, line, sizeof(line));
 
     if (err.code != ERR_OK) {
         handle_error(&err);
         return EXIT_FAILURE;
     }
 
     printf("First line: %s\n", line);
     return EXIT_SUCCESS;
 }
 