#include <stdio.h>
#include <stdlib.h>
#include <pthread.h>
#include <unistd.h>

/* This program demonstrates the use of condition variables for thread communication.
 * It creates two threads: one that waits for a signal and another that sends a signal
 * after a delay. The waiting thread will block until it receives the signal from the signaling thread.
 */

pthread_mutex_t mutex = PTHREAD_MUTEX_INITIALIZER;
pthread_cond_t cond = PTHREAD_COND_INITIALIZER;

int ready = 0;

void* waiter(void* arg) {
    pthread_mutex_lock(&mutex);
    while (!ready) {
        printf("Waiter: waiting...\n");
        pthread_cond_wait(&cond, &mutex);
    }
    printf("Waiter: received signal! ready=%d\n", ready);
    pthread_mutex_unlock(&mutex);
    return NULL;
}

void* signaler(void* arg) {
    sleep(2); // simulate work
    pthread_mutex_lock(&mutex);
    ready = 1;
    printf("Signaler: setting ready and signaling\n");
    pthread_cond_signal(&cond);
    pthread_mutex_unlock(&mutex);
    return NULL;
}

int main() {
    pthread_t t1, t2;

    pthread_create(&t1, NULL, waiter, NULL);
    pthread_create(&t2, NULL, signaler, NULL);

    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    pthread_mutex_destroy(&mutex);
    pthread_cond_destroy(&cond);

    return 0;
}
