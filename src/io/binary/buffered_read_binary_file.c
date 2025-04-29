/*
 * This C program demonstrates the use of the **Decorator Pattern** to dynamically 
 * alter the behavior of file reading and writing operations using function pointers.
 * The program defines a custom `Stream` structure that allows us to change the file 
 * reading behavior (e.g., basic, buffered, binary) at runtime.
 *
 * The `Stream` structure holds function pointers to handle reading and writing data 
 * from/to a file, which can be modified using different decorators (e.g., 
 * `buffered_read`, `binary_read`). These decorators can add new functionality, such 
 * as additional processing or behavior, without modifying the core file-handling logic.
 *
 * In this example:
 * 1. A `Stream` is initialized to open a file in "read" mode.
 * 2. The `basic_read` function is used to read the file's contents and print them.
 * 3. The stream is decorated with a `buffered_read` decorator, which modifies the 
 *    behavior by adding additional functionality (e.g., printing a message).
 * 4. The stream is further decorated with the `binary_read` function to simulate 
 *    reading binary data from the file.
 * 
 * This pattern can be extended to include more complex file reading and writing 
 * behaviors, and is a powerful tool for creating flexible and extendable programs.
 *
 * Compilation: gcc -o stream_example stream_example.c
 *
 * Expected behavior:
 * - It opens the file `output.txt` for reading.
 * - It demonstrates how to read the content using different reading strategies 
 *   (basic, buffered, binary).
 * - It prints the file content at each stage of modification.
 * 
 * For this to work, a file `output.txt` should exist with sample content.
 */

 #include <stdio.h>
 #include <stdlib.h>
 
 // A basic stream structure for abstraction
 // The Stream structure allows us to represent file reading and writing operations 
 // as function pointers that can be changed dynamically.
 typedef struct {
     FILE *file; // Pointer to the file being operated on
     size_t (*read)(void *ptr, size_t size, size_t count, FILE *stream); // Function pointer for reading
     size_t (*write)(const void *ptr, size_t size, size_t count, FILE *stream); // Function pointer for writing
 } Stream;
 
 // Basic read function using fread to read data from a file stream.
 size_t basic_read(void *ptr, size_t size, size_t count, FILE *stream) {
     return fread(ptr, size, count, stream);  // Calls the default fread to read the data
 }
 
 // Basic write function using fwrite to write data to a file stream.
 size_t basic_write(const void *ptr, size_t size, size_t count, FILE *stream) {
     return fwrite(ptr, size, count, stream);  // Calls the default fwrite to write the data
 }
 
 // Function to initialize a Stream object. It opens the file and sets up the read and write functions.
 void init_stream(Stream *s, const char *filename, const char *mode) {
     s->file = fopen(filename, mode); // Open the file in the specified mode
     if (!s->file) { // If opening the file fails, print an error and exit
         perror("Error opening file");
         exit(1);
     }
     s->read = basic_read;  // Set the default read function (basic read)
     s->write = basic_write;  // Set the default write function (basic write)
 }
 
 // Close the stream by closing the file.
 void close_stream(Stream *s) {
     fclose(s->file); // Close the file stream
 }
 
 // Decorator pattern: A function to add buffering behavior during read. This simulates adding new functionality to an existing object.
 size_t buffered_read(void *ptr, size_t size, size_t count, FILE *stream) {
     printf("Buffered read:\n");  // Output a message to indicate buffered read
     return fread(ptr, size, count, stream);  // Calls fread as a placeholder for buffered reading logic
 }
 
 // Decorator pattern: A function to simulate binary reading behavior.
 size_t binary_read(void *ptr, size_t size, size_t count, FILE *stream) {
     printf("Binary read:\n");  // Output a message to indicate binary read
     return fread(ptr, size, count, stream);  // Calls fread as a placeholder for binary reading logic
 }
 
 int main() {
     // Initialize basic Stream
     Stream my_stream;
     init_stream(&my_stream, "binary_output.dat", "r");
 
     // Reading text data using basic read function
     char buffer[100];
     my_stream.read(buffer, sizeof(char), 100, my_stream.file);
     printf("Read text: %s\n", buffer);
 
     // Now decorate the stream to do buffered reading
     my_stream.read = buffered_read;
     my_stream.read(buffer, sizeof(char), 100, my_stream.file);
     printf("Read with buffer: %s\n", buffer);
 
     // Switch to binary read (another decorator)
     my_stream.read = binary_read;
     my_stream.read(buffer, sizeof(char), 100, my_stream.file);
     printf("Read binary: %s\n", buffer);
 
     // Close the stream
     close_stream(&my_stream);
 
     return 0;
 } 