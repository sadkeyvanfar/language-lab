#include <stdio.h>

void map(int* input, int* output, int size, int (*func)(int)) {
    for (int i = 0; i < size; i++) {
        output[i] = func(input[i]);
    }
}

int square(int x) {
    return x * x;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int result[5];

    map(arr, result, 5, square);

    printf("Mapped array: ");
    for (int i = 0; i < 5; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    return 0;
}
