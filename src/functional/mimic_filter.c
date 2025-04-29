/*
 * This program demonstrates a simple implementation of a functional-style
 * `filter` operation in C using function pointers. It defines a `filter`
 * function that selects elements from an input array based on a predicate
 * (in this case, whether the number is even) and stores them in an output array.
 *
 * The program prints the resulting filtered array.
 */

 #include <stdio.h> 

 // filter: Applies a predicate function to each element of the input array.
 // If the predicate returns true, the element is copied to the output array.
 // Returns the number of elements copied.
 int filter(int* input, int* output, int size, int (*predicate)(int)) {
     int count = 0;
     for (int i = 0; i < size; i++) {
         if (predicate(input[i])) {
             output[count++] = input[i];  // Copy element if it satisfies the predicate
         }
     }
     return count;  // Return how many elements were kept
 }
 
 // is_even: Predicate function that returns 1 if a number is even, 0 otherwise
 int is_even(int x) {
     return x % 2 == 0;
 }
 
 int main() {
     // Define and initialize the input array
     int arr[] = {1, 2, 3, 4, 5};
     
     // Declare the output array to hold filtered values
     int result[5];
 
     // Apply the filter function using is_even predicate
     int filtered_size = filter(arr, result, 5, is_even);
 
     // Print the filtered array
     printf("Filtered array (even): ");
     for (int i = 0; i < filtered_size; i++) {
         printf("%d ", result[i]);
     }
     printf("\n");
 
     return 0;
 }
 