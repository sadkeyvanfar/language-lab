#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>

/* This program demonstrates the use of a POSIX mutex to synchronize access
 * to a shared counter variable across multiple threads. Each thread increments
 * the counter a specified number of times while holding the mutex.
 */

#define NUM_THREADS 4
#define INCREMENTS_PER_THREAD 1000000

int shared_counter = 0;               // Shared data
pthread_mutex_t lock;                 // Mutex for mutual exclusion

void* increment(void* arg) {
    for (int i = 0; i < INCREMENTS_PER_THREAD; ++i) {
        pthread_mutex_lock(&lock);    // Lock before modifying shared data
        ++shared_counter;
        pthread_mutex_unlock(&lock);  // Unlock after done
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];

    // Initialize the mutex
    if (pthread_mutex_init(&lock, NULL) != 0) {
        perror("pthread_mutex_init");
        return EXIT_FAILURE;
    }

    // Create threads
    for (int i = 0; i < NUM_THREADS; ++i) {
        if (pthread_create(&threads[i], NULL, increment, NULL) != 0) {
            perror("pthread_create");
            return EXIT_FAILURE;
        }
    }

    // Wait for threads to finish
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_join(threads[i], NULL);
    }

    // Destroy the mutex
    pthread_mutex_destroy(&lock);

    printf("Final counter value: %d\n", shared_counter); // Expected: NUM_THREADS * INCREMENTS_PER_THREAD
    return 0;
}
