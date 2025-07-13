#include <stdio.h>
#include <stdlib.h>
#include <stdatomic.h>
#include <pthread.h>
#include <unistd.h>

/*
 * This program demonstrates a read-write spinlock implementation using atomic operations
 * to synchronize access to a shared resource across multiple reader and writer threads.
 * Readers can access the resource concurrently, while writers have exclusive access.
 */

#define NUM_READERS 4
#define NUM_WRITERS 2
#define READS_PER_THREAD 5
#define WRITES_PER_THREAD 3

typedef struct {
    atomic_int state; // >0 = readers; 0 = unlocked; -1 = writer
} rw_spinlock_t;

void rw_spinlock_init(rw_spinlock_t* lock) {
    atomic_init(&lock->state, 0);
}

void rw_spinlock_acquire_read(rw_spinlock_t* lock) {
    while (1) {
        // Wait while writer is active
        while (atomic_load(&lock->state) == -1) {
            // spin
        }

        // Try to increment reader count
        int expected;
        do {
            expected = atomic_load(&lock->state);
            if (expected == -1) break; // writer grabbed lock just before us
        } while (!atomic_compare_exchange_weak(&lock->state, &expected, expected + 1));

        if (expected != -1) break;
    }
}

void rw_spinlock_release_read(rw_spinlock_t* lock) {
    atomic_fetch_sub(&lock->state, 1);
}

void rw_spinlock_acquire_write(rw_spinlock_t* lock) {
    int expected = 0;
    while (!atomic_compare_exchange_weak(&lock->state, &expected, -1)) {
        expected = 0;
        // spin
    }
}

void rw_spinlock_release_write(rw_spinlock_t* lock) {
    atomic_store(&lock->state, 0);
}

// --- Shared data and lock
int shared_data = 0;
rw_spinlock_t rwlock;

void* reader(void* arg) {
    int id = *(int*)arg;
    for (int i = 0; i < READS_PER_THREAD; ++i) {
        rw_spinlock_acquire_read(&rwlock);
        printf("Reader %d: read %d\n", id, shared_data);
        rw_spinlock_release_read(&rwlock);
        usleep(10000); // simulate work
    }
    return NULL;
}

void* writer(void* arg) {
    int id = *(int*)arg;
    for (int i = 0; i < WRITES_PER_THREAD; ++i) {
        rw_spinlock_acquire_write(&rwlock);
        ++shared_data;
        printf("Writer %d: wrote %d\n", id, shared_data);
        rw_spinlock_release_write(&rwlock);
        usleep(30000); // simulate work
    }
    return NULL;
}

int main() {
    rw_spinlock_init(&rwlock);

    pthread_t rthreads[NUM_READERS], wthreads[NUM_WRITERS];
    int rids[NUM_READERS], wids[NUM_WRITERS];

    for (int i = 0; i < NUM_READERS; ++i) {
        rids[i] = i;
        pthread_create(&rthreads[i], NULL, reader, &rids[i]);
    }

    for (int i = 0; i < NUM_WRITERS; ++i) {
        wids[i] = i;
        pthread_create(&wthreads[i], NULL, writer, &wids[i]);
    }

    for (int i = 0; i < NUM_READERS; ++i) pthread_join(rthreads[i], NULL);
    for (int i = 0; i < NUM_WRITERS; ++i) pthread_join(wthreads[i], NULL);

    printf("Final shared value: %d\n", shared_data);
    return 0;
}
