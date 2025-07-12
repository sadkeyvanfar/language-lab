#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "task_struct.h"

extern struct list_head task_list;

void print_state(int state) {
    switch(state) {
        case TASK_RUNNING: printf("RUNNING"); break;
        case TASK_INTERRUPTIBLE: printf("INTERRUPTIBLE"); break;
        case TASK_UNINTERRUPTIBLE: printf("UNINTERRUPTIBLE"); break;
        case TASK_STOPPED: printf("STOPPED"); break;
        case TASK_ZOMBIE: printf("ZOMBIE"); break;
        default: printf("UNKNOWN"); break;
    }
}

void print_task(struct task_struct *task, int indent) {
    for (int i = 0; i < indent; i++) printf("  ");
    printf("[PID %d] %s | State: ", task->pid, task->name);
    print_state(task->state);
    printf(" | vruntime: %lu\n", task->vruntime);

    struct list_head *pos;
    for (pos = task->children.next; pos != &task->children; pos = pos->next) {
        struct task_struct *child = container_of(pos, struct task_struct, sibling);
        print_task(child, indent + 1);
    }
}

struct task_struct *create_task(int pid, const char *name, struct task_struct *parent, int state, unsigned long vruntime) {
    struct task_struct *task = malloc(sizeof(struct task_struct));
    task->pid = pid;
    strncpy(task->name, name, sizeof(task->name));
    task->name[sizeof(task->name)-1] = '\0'; // ensure null-terminated

    task->state = state;
    task->vruntime = vruntime;

    INIT_LIST_HEAD(&task->tasks);
    INIT_LIST_HEAD(&task->children);
    INIT_LIST_HEAD(&task->sibling);
    INIT_LIST_HEAD(&task->thread_group);

    task->parent = parent;

    // Add to global task list
    list_add(&task->tasks, &task_list);

    // Add to parent's child list
    if (parent) {
        list_add(&task->sibling, &parent->children);
    }

    return task;
}
