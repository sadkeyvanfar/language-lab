#include <stdio.h>
#include <stdlib.h>

// Function to read binary data from a file
void read_binary_file(const char *filename) {
    // Open the file in binary read mode ("rb")
    FILE *file = fopen(filename, "rb");
    if (file == NULL) {
        perror("Error opening file");
        return;
    }

    // Array to store the data read from the file
    int numbers[5];
    
    // Read data from the file in binary format
    size_t result = fread(numbers, sizeof(int), 5, file);
    if (result != 5) {
        printf("Error reading data from file.\n");
    } else {
        // Print the data read from the file
        printf("Data read from file:\n");
        for (int i = 0; i < 5; i++) {
            printf("%d ", numbers[i]);
        }
        printf("\n");
    }

    // Close the file after reading
    fclose(file);
}

int main() {
    // Specify the binary file name (it should already contain some data)
    const char *filename = "binary_output.dat";
    
    // Read and display data from the binary file
    read_binary_file(filename);

    return 0;
}
