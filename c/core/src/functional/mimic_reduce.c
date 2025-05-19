/*
 * This program demonstrates a simple implementation of a functional-style
 * `reduce` operation in C using function pointers. It defines a `reduce`
 * function that combines elements of an input array into a single result
 * using a provided binary function (in this case, addition).
 *
 * The program calculates and prints the sum of all elements in the array.
 */

 #include <stdio.h>  // Include standard I/O library for printf

 // reduce: Applies a binary function cumulatively to the elements of an array,
 // starting from an initial value, to reduce the array to a single result.
 int reduce(int* input, int size, int (*func)(int, int), int initial) {
     int result = initial;
     for (int i = 0; i < size; i++) {
         result = func(result, input[i]);  // Accumulate result
     }
     return result;  // Return the final reduced value
 }
 
 // add: Binary function that returns the sum of two integers
 int add(int a, int b) {
     return a + b;
 }
 
 int main() {
     // Define and initialize the input array
     int arr[] = {1, 2, 3, 4, 5};
 
     // Apply the reduce function using the add operation and initial value 0
     int sum = reduce(arr, 5, add, 0);
 
     // Print the reduced value (sum)
     printf("Reduced (sum): %d\n", sum);
 
     return 0;
 }
 