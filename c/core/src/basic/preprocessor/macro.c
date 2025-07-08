#include <stdio.h>

// simple constant macro definition
#define PI 3.14

// macro function to calculate the square of a number
#define SQUARE(x) ((x) * (x))

int main() {
    // using the constant macro
    printf("Value of PI: %f\n", PI);

    // using the macro function
    int num = 5;
    printf("Square of %d: %d\n", num, SQUARE(num));

    return 0;
}
