#include <stdio.h>
#include "../kernel_structs/task_struct.h"
#include "cfs.h"

/* This is a simple simulation of the Completely Fair Scheduler (CFS) in C.
 * It creates a few tasks with different nice values and simulates the scheduling process.
 */

// Define the global task list head used in task_struct.c
struct list_head task_list;

int main() {
    // Initialize the global task list and the run queue
    INIT_LIST_HEAD(&task_list);
    init_run_queue();

    // Create some tasks with different nice values
    struct task_struct *p1 = create_task(1, "task-A", NULL, TASK_RUNNING, 0);
    p1->nice = 0;
    p1->weight = 0; // will be set in enqueue_task()

    struct task_struct *p2 = create_task(2, "task-B", NULL, TASK_RUNNING, 0);
    p2->nice = 5;
    p2->weight = 0;

    struct task_struct *p3 = create_task(3, "task-C", NULL, TASK_RUNNING, 0);
    p3->nice = -5;
    p3->weight = 0;

    // Add tasks to the run queue
    enqueue_task(p1);
    enqueue_task(p2);
    enqueue_task(p3);

    printf("\n--- CFS Scheduling Simulation ---\n");
    for (int i = 0; i < 10; i++) {
        struct task_struct *next = pick_next_task();
        if (!next) break;

        printf("[Cycle %d] Chose to run: %s (PID %d, vruntime: %lu)\n",
               i + 1, next->name, next->pid, next->vruntime);

        // Simulate task running for 10 time units
        update_vruntime(next, 10);
    }

    return 0;
}
