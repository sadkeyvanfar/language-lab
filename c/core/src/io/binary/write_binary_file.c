#include <stdio.h>
#include <stdlib.h>

// Function to write binary data to a file
void write_binary_file(const char *filename) {
    // Open the file in binary write mode ("wb")
    FILE *file = fopen(filename, "wb");
    if (file == NULL) {
        perror("Error opening file");
        return;
    }

    // Data to be written to the file (array of integers)
    int numbers[] = {10, 20, 30, 40, 50};
    
    // Write the array of integers to the file in binary format
    size_t result = fwrite(numbers, sizeof(int), 5, file);
    if (result != 5) {
        printf("Error writing data to file.\n");
    } else {
        printf("Data successfully written to file.\n");
    }

    // Close the file after writing
    fclose(file);
}

int main() {
    // Specify the binary file name
    const char *filename = "binary_output.dat";
    
    // Write data to the binary file
    write_binary_file(filename);

    return 0;
}
