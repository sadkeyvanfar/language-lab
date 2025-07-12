#ifndef TASK_STRUCT_H
#define TASK_STRUCT_H

#include "list_head.h"

/* Simulated task states similar to Linux's task_struct */
enum task_state {
    TASK_RUNNING = 0,
    TASK_INTERRUPTIBLE,
    TASK_UNINTERRUPTIBLE,
    TASK_STOPPED,
    TASK_ZOMBIE
};

/* Simulated representation of a task (process/thread) */
struct task_struct {
    int pid;                     // Process ID
    char name[32];               // Task name (up to 31 chars + null terminator)
    int state;                   // Task state (running, sleeping, etc.)
    int nice;                    // User-defined priority (-20 to +19)
    int weight;                  // Scheduler weight derived from nice
    unsigned long vruntime;     // Virtual runtime for fair scheduling

    struct list_head tasks;        // Entry in the global run queue
    struct task_struct *parent;    // Pointer to parent task (if any)
    struct list_head children;     // Head of this task's children list
    struct list_head sibling;      // Entry in parent's children list
    struct list_head thread_group; // Thread group membership (if multithreaded)
};

/* Create and initialize a task_struct */
struct task_struct *create_task(int pid, const char *name, struct task_struct *parent, int state, unsigned long vruntime);

/* Print the task's information (with indentation) */
void print_task(struct task_struct *task, int indent);

#endif // TASK_STRUCT_H
