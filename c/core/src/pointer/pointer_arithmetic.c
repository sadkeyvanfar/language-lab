#include <stdio.h>

/* This program demonstrates pointer arithmetic in C.
 * It shows how to perform arithmetic operations on pointers,
 * which can be useful for navigating arrays and other data structures.
 * Pointer arithmetic is based on the size of the data type the pointer points to.
 */
int main() {
    int a = 10;
    int b = 20;

    int *p = &a;
    int *q = &b;

    printf("Address of a: %p\n", &a);
    printf("Address of b: %p\n", &b);
    printf("p = %p, *p = %d\n", p, *p);
    printf("q = %p, *q = %d\n", q, *q);

    // Now let's try pointer arithmetic
    int *r = p + 1;  // This may or may not point to b, undefined unless you control memory layout
    printf("r = %p (p + 1), *r = %d (maybe garbage or b)\n", r, *r);



    // Demonstrating pointer arithmetic with an array
    int numbers[] = {10, 20, 30, 40, 50};
    int *p = numbers;  // points to the first element (numbers[0])

    printf("Using pointer arithmetic:\n");
    printf("p       = %p, *p = %d\n", p, *p);         // 10
    printf("p + 1   = %p, *(p + 1) = %d\n", p + 1, *(p + 1)); // 20
    printf("p + 2   = %p, *(p + 2) = %d\n", p + 2, *(p + 2)); // 30
    printf("p + 3   = %p, *(p + 3) = %d\n", p + 3, *(p + 3)); // 40
    printf("p + 4   = %p, *(p + 4) = %d\n", p + 4, *(p + 4)); // 50

    return 0;
}
