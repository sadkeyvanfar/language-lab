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

struct task_struct {
    int pid;
    char name[32];
    int state;
    unsigned long vruntime;

    struct list_head tasks;        // Global task list
    struct task_struct *parent;    // Parent task
    struct list_head children;     // Head of children list
    struct list_head sibling;      // Entry in parent's child list
    struct list_head thread_group; // Threads in the same process group
};

void print_task(struct task_struct *task, int indent);
struct task_struct *create_task(int pid, const char *name, struct task_struct *parent, int state, unsigned long vruntime);

#endif // TASK_STRUCT_H
