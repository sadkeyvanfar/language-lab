#include <stdio.h>
#include <stdatomic.h>
#include <pthread.h>

/*
 * Example of using atomic operations in a multi-threaded environment.
 * This program creates multiple threads that increment a shared counter
 * using atomic operations to ensure thread safety without locks.
 */

#define NUM_THREADS 4
#define INCREMENTS_PER_THREAD 1000000

// Shared counter
atomic_int counter = 0;

void* increment_counter(void* arg) {
    (void)arg;  // Silence unused parameter warning
    for (int i = 0; i < INCREMENTS_PER_THREAD; ++i) {
        atomic_fetch_add(&counter, 1); // Atomic increment, Atomically adds 1 to counter, thread-safe without locks.
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];

    // Create threads
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_create(&threads[i], NULL, increment_counter, NULL);
    }

    // Join threads
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_join(threads[i], NULL);
    }

    printf("Final counter value: %d\n", counter); // Should be NUM_THREADS * INCREMENTS_PER_THREAD
    return 0;
}
