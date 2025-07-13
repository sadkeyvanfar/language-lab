#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

#define NUM_THREADS 4
#define INCREMENTS_PER_THREAD 1000000

/* This program demonstrates the use of a POSIX spinlock to synchronize access
 * to a shared counter variable across multiple threads. Each thread increments
 * the counter a specified number of times while holding the spinlock.
 */

// Shared counter and POSIX spinlock
int counter = 0;
pthread_spinlock_t lock;

void* worker(void* arg) {
    for (int i = 0; i < INCREMENTS_PER_THREAD; ++i) {
        pthread_spin_lock(&lock);
        ++counter;
        pthread_spin_unlock(&lock);
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];

    // Initialize spinlock (PTHREAD_PROCESS_PRIVATE: only used by threads in this process)
    if (pthread_spin_init(&lock, PTHREAD_PROCESS_PRIVATE) != 0) {
        perror("pthread_spin_init");
        return EXIT_FAILURE;
    }

    // Create threads
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_create(&threads[i], NULL, worker, NULL);
    }

    // Wait for threads to finish
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_join(threads[i], NULL);
    }

    printf("Final counter value: %d\n", counter); // Should be NUM_THREADS * INCREMENTS_PER_THREAD

    // Destroy spinlock
    pthread_spin_destroy(&lock);

    return 0;
}
