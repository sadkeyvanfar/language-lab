#include <stdio.h>
#include <pthread.h>

void* print_message(void* ptr) {
    char* message = (char*)ptr;
    printf("%s\n", message);
    return NULL;
}

int main() {
    pthread_t thread;
    char* message = "Hello from the thread old one!";
    
    // Create a new thread
    pthread_create(&thread, NULL, print_message, (void*)message);
    
    // Wait for the thread to finish
    pthread_join(thread, NULL);
    
    return 0;
}
/* This program creates a thread that prints a message to the console.
 It uses the pthread library to manage threads in C.
 The main function creates a thread that runs the print_message function.
 The print_message function takes a void pointer as an argument, which is cast to a char pointer.
 The thread is created using pthread_create, and the main function waits for the thread to finish using pthread_join.
 This is a simple example of using threads in C to perform concurrent tasks.
 The program demonstrates how to create and manage threads using the pthread library.
 It is important to include the pthread library when compiling this code.
 To compile this code, use the following command:
 gcc -o new_thread new_thread.c -lpthread
 This will create an executable named "threads".
 To run the program, use the following command:
 ./new_thread
  This will execute the program and print the message from the thread to the console.
 The output will be: 
 Hello from the thread!
 This example can be extended to include more complex thread management and synchronization techniques. */