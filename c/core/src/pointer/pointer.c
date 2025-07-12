#include <stdio.h>

/* This program demonstrates the use of pointers in C.
 * It creates a pointer to an integer, modifies the value it points to,
 * and prints the value and address of the integer.
 * * (Pointer) are variables that store memory addresses of other variables.
 * & (Address-of operator) is used to get the address of a variable.
 */
int main() {
    int x = 42;        // normal int variable
    int *p = &x;       // 'p' is a pointer to int; &x means "address of x"

    printf("Value of x: %d\n", x);         // prints 42
    printf("Address of x: %p\n", &x);      // prints memory address of x
    printf("Pointer p points to: %p\n", p);// same address as &x
    printf("Value pointed to by p: %d\n", *p); // dereference p to get x's value

    *p = 100;  // change the value at the address p points to (modifies x)
    printf("New value of x: %d\n", x);     // prints 100

    // Demonstrating pointer to an array
    int arr[] = {1, 2, 3, 4, 5};
    int *arr_ptr = arr; // pointer to the first element of the array
    printf("First element of arr: %d\n", *arr_ptr); // prints 1
    printf("Second element of arr: %d\n", *(arr_ptr + 1)); // prints 2
    printf("Third element of arr: %d\n", *(arr_ptr + 2)); // prints 3

    // Demonstrating pointer to a structure
    struct Point { int x, y; };
    struct Point p = {1, 2};
    struct Point *ptr = &p;

    printf("%d\n", ptr->x);  // use -> for accessing members via pointer

    // Demonstrating pointer to a pointer
    int a = 5;
    int *p = &a;
    int **pp = &p;

    printf("%d\n", **pp);

}
