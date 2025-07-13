#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

/* This program demonstrates the use of a POSIX reader-writer lock to synchronize
 * access to a shared resource across multiple reader and writer threads.
 * Readers can access the resource concurrently, while writers have exclusive access.
 * It's like a mutex but allows multiple readers or one writer.
 */

#define NUM_READERS 4
#define NUM_WRITERS 2

int shared_data = 0;                  // Shared resource
pthread_rwlock_t rwlock;              // Reader-writer lock

void* reader(void* arg) {
    int id = *(int*)arg;
    for (int i = 0; i < 5; ++i) {
        pthread_rwlock_rdlock(&rwlock);   // Acquire read lock
        printf("Reader %d: read shared_data = %d\n", id, shared_data);
        pthread_rwlock_unlock(&rwlock);   // Release lock
        usleep(100000);                   // Simulate work
    }
    return NULL;
}

void* writer(void* arg) {
    int id = *(int*)arg;
    for (int i = 0; i < 3; ++i) {
        pthread_rwlock_wrlock(&rwlock);   // Acquire write lock
        ++shared_data;
        printf("Writer %d: wrote shared_data = %d\n", id, shared_data);
        pthread_rwlock_unlock(&rwlock);   // Release lock
        usleep(200000);                   // Simulate work
    }
    return NULL;
}

int main() {
    pthread_t readers[NUM_READERS], writers[NUM_WRITERS];
    int rids[NUM_READERS], wids[NUM_WRITERS];

    pthread_rwlock_init(&rwlock, NULL);   // Initialize the rwlock

    // Start reader threads
    for (int i = 0; i < NUM_READERS; ++i) {
        rids[i] = i;
        pthread_create(&readers[i], NULL, reader, &rids[i]);
    }

    // Start writer threads
    for (int i = 0; i < NUM_WRITERS; ++i) {
        wids[i] = i;
        pthread_create(&writers[i], NULL, writer, &wids[i]);
    }

    // Wait for all threads
    for (int i = 0; i < NUM_READERS; ++i) {
        pthread_join(readers[i], NULL);
    }
    for (int i = 0; i < NUM_WRITERS; ++i) {
        pthread_join(writers[i], NULL);
    }

    pthread_rwlock_destroy(&rwlock);      // Clean up
    printf("Final shared_data value: %d\n", shared_data);
    return 0;
}
