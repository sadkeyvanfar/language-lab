#ifndef CFS_H
#define CFS_H

#include "../kernel_structs/task_struct.h"

/* Initialize the run queue */
void init_run_queue(void);

/* Add a task to the run queue */
void enqueue_task(struct task_struct *task);

/* Pick the next task to run based on lowest vruntime */
struct task_struct* pick_next_task(void);

/* Update the vruntime of a task after running for delta_exec units */
void update_vruntime(struct task_struct *task, unsigned long delta_exec);

#endif // CFS_H
