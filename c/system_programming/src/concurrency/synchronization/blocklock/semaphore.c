#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <semaphore.h>

/* This program demonstrates the use of a semaphore to synchronize access
 * to a shared counter variable among multiple threads. Each thread increments
 * the counter a specified number of times, ensuring that only one thread can
 * modify the counter at a time.
 */

#define NUM_THREADS 4
#define INCREMENTS_PER_THREAD 1000000

int shared_counter = 0;        // Shared data
sem_t sem;                     // Semaphore for mutual exclusion

void* increment(void* arg) {
    for (int i = 0; i < INCREMENTS_PER_THREAD; ++i) {
        sem_wait(&sem);        // Acquire semaphore (lock)
        ++shared_counter;
        sem_post(&sem);        // Release semaphore (unlock)
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];

    // Initialize the semaphore to 1 (binary semaphore — acts like a mutex)
    if (sem_init(&sem, 0, 1) != 0) {
        perror("sem_init");
        return EXIT_FAILURE;
    }

    // Create threads
    for (int i = 0; i < NUM_THREADS; ++i) {
        if (pthread_create(&threads[i], NULL, increment, NULL) != 0) {
            perror("pthread_create");
            return EXIT_FAILURE;
        }
    }

    // Wait for all threads to finish
    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_join(threads[i], NULL);
    }

    // Destroy the semaphore
    sem_destroy(&sem);

    printf("Final counter value: %d\n", shared_counter); // Expected: 4,000,000
    return 0;
}
