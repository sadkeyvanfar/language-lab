/*
 * This program demonstrates a simple implementation of a functional-style
 * `map` operation in C using function pointers. It defines a `map` function
 * that applies a given function (in this case, `square`) to each element
 * in an input array and stores the result in an output array.
 *
 * The program prints the resulting array after applying the transformation.
 */

 #include <stdio.h>

 // map: Applies a function to each element in the input array
 // and stores the result in the output array
 void map(int* input, int* output, int size, int (*func)(int)) {
     for (int i = 0; i < size; i++) {
         output[i] = func(input[i]);  // Apply the function to each element
     }
 }
 
 // square: Function that returns the square of an integer
 int square(int x) {
     return x * x;
 }
 
 int main() {
     // Define and initialize the input array
     int arr[] = {1, 2, 3, 4, 5};
     
     // Declare the output array to store the results
     int result[5];
 
     // Apply the square function to each element of arr using map
     map(arr, result, 5, square);
 
     // Print the mapped (squared) array
     printf("Mapped array: ");
     for (int i = 0; i < 5; i++) {
         printf("%d ", result[i]);
     }
     printf("\n");
 
     return 0;
 }
 