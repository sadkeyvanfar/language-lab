#include <stdio.h>
#include <stdlib.h>
#include <stdatomic.h>
#include <pthread.h>
#include <unistd.h>

/*
 * This program demonstrates a simple spinlock implementation using atomic operations
 * to synchronize access to a shared counter variable across multiple threads.
 * Each thread increments the counter a specified number of times while holding the spinlock.
 */

#define NUM_THREADS 4
#define INCREMENTS_PER_THREAD 1000000

// Simple spinlock using atomic_flag
typedef struct {
    atomic_flag flag;
} spinlock_t;

void spinlock_init(spinlock_t* lock) {
    atomic_flag_clear(&lock->flag);
}

void spinlock_lock(spinlock_t* lock) {
    while (atomic_flag_test_and_set(&lock->flag)) {
        // Busy wait (spin)
    }
}

void spinlock_unlock(spinlock_t* lock) {
    atomic_flag_clear(&lock->flag);
}

// Shared counter and lock
int counter = 0;
spinlock_t lock;

void* worker(void* arg) {
    for (int i = 0; i < INCREMENTS_PER_THREAD; ++i) {
        spinlock_lock(&lock);
        ++counter;
        spinlock_unlock(&lock);
    }
    return NULL;
}

int main() {
    pthread_t threads[NUM_THREADS];
    spinlock_init(&lock);

    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_create(&threads[i], NULL, worker, NULL);
    }

    for (int i = 0; i < NUM_THREADS; ++i) {
        pthread_join(threads[i], NULL);
    }

    printf("Final counter value: %d\n", counter); // Expect: NUM_THREADS * INCREMENTS_PER_THREAD
    return 0;
}
