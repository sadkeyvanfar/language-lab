
#include <stdio.h>
#include <string.h>

// Define a structure to hold data
struct student_struct {
    int id;
    char name[50];
};

int main() {
    // Create an instance of the structure
    struct student_struct student;

    // Initialize the structure members
    student.id = 1;
    strcpy(student.name, "Saeid Keyvanfar");

    // Print the structure members
    printf("Student ID: %d\n", student.id);
    printf("Student Name: %s\n", student.name);

    return 0;
}
