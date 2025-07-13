#define _GNU_SOURCE
#include <string.h>
#include <pthread.h>
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <sched.h>
#include <errno.h>

/*
 * This program demonstrates how to set different scheduling policies for threads in C.
 * It creates two threads: one with a real-time scheduling policy (SCHED_FIFO) and another with the normal scheduling policy (SCHED_OTHER).
 * The real-time thread simulates real-time work, while the normal thread simulates regular work.
 * The program uses pthreads to manage the threads and set their scheduling policies.
 * To compile this code, use the following command:
 * gcc -o set_policy set_policy.c -lpthread
 * This will create an executable named "set_policy".
 * To run the program, use the following command:
 * ./set_policy
 * Note: Setting real-time policies may require root privileges or specific capabilities.
 */
void *rt_thread(void *arg) {
    printf("Real-time thread started with SCHED_FIFO\n");
    while(1) {
        // Real-time work simulation
        usleep(100000);
    }
    return NULL;
}

void *normal_thread(void *arg) {
    printf("Normal thread started with SCHED_OTHER\n");
    while(1) {
        // Normal work simulation
        usleep(200000);
    }
    return NULL;
}

int set_thread_policy(pthread_t thread, int policy, int priority) {
    struct sched_param param;
    param.sched_priority = priority;
    int ret = pthread_setschedparam(thread, policy, &param);
    if (ret != 0) {
        fprintf(stderr, "Failed to set policy %d with priority %d: %s\n",
                policy, priority, strerror(ret));
    }
    return ret;
}

int main() {
    pthread_t t1, t2;

    // Create the threads
    if (pthread_create(&t1, NULL, rt_thread, NULL) != 0) {
        perror("Failed to create real-time thread");
        exit(EXIT_FAILURE);
    }
    if (pthread_create(&t2, NULL, normal_thread, NULL) != 0) {
        perror("Failed to create normal thread");
        exit(EXIT_FAILURE);
    }

    // Set real-time scheduling policy for t1
    // Requires root privileges or CAP_SYS_NICE capability
    if (set_thread_policy(t1, SCHED_FIFO, 80) != 0) {
        printf("Warning: Could not set real-time scheduling for thread 1\n");
    }

    // Set normal scheduling policy for t2 (priority ignored)
    if (set_thread_policy(t2, SCHED_OTHER, 0) != 0) {
        printf("Warning: Could not set normal scheduling for thread 2\n");
    }

    // Join threads (infinite loop here, so will not actually join)
    pthread_join(t1, NULL);
    pthread_join(t2, NULL);

    return 0;
}
