#include <stdio.h>

int filter(int* input, int* output, int size, int (*predicate)(int)) {
    int count = 0;
    for (int i = 0; i < size; i++) {
        if (predicate(input[i])) {
            output[count++] = input[i];
        }
    }
    return count;
}

int is_even(int x) {
    return x % 2 == 0;
}

int main() {
    int arr[] = {1, 2, 3, 4, 5};
    int result[5];
    
    int filtered_size = filter(arr, result, 5, is_even);

    printf("Filtered array (even): ");
    for (int i = 0; i < filtered_size; i++) {
        printf("%d ", result[i]);
    }
    printf("\n");

    return 0;
}
