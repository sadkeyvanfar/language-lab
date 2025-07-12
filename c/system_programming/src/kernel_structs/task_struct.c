#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include "task_struct.h"

// External global task list head, should be defined elsewhere (e.g. main.c)
extern struct list_head task_list;

// Helper to print human-readable task state
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

// Recursively print task info and its children with indentation
void print_task(struct task_struct *task, int indent) {
    for (int i = 0; i < indent; i++) printf("  ");
    printf("[PID %d] %s | State: ", task->pid, task->name);
    print_state(task->state);
    printf(" | vruntime: %lu\n", task->vruntime);

    // Iterate over children list and print recursively
    struct list_head *pos;
    for (pos = task->children.next; pos != &task->children; pos = pos->next) {
        struct task_struct *child = container_of(pos, struct task_struct, sibling);
        print_task(child, indent + 1);
    }
}

// Create a new task, initialize fields, link to parent and global list
struct task_struct *create_task(int pid, const char *name, struct task_struct *parent, int state, unsigned long vruntime) {
    struct task_struct *task = malloc(sizeof(struct task_struct));
    if (!task) {
        perror("Failed to allocate task_struct");
        return NULL;
    }

    task->pid = pid;
    strncpy(task->name, name, sizeof(task->name));
    task->name[sizeof(task->name)-1] = '\0'; // Ensure null-termination

    task->state = state;
    task->nice = 0;          // default nice
    task->weight = 1024;     // default weight (nice=0)
    task->vruntime = vruntime;

    // Initialize embedded list heads
    INIT_LIST_HEAD(&task->tasks);
    INIT_LIST_HEAD(&task->children);
    INIT_LIST_HEAD(&task->sibling);
    INIT_LIST_HEAD(&task->thread_group);

    task->parent = parent;

    // Add to global task list
    list_add(&task->tasks, &task_list);

    // Add to parent's children list if parent exists
    if (parent) {
        list_add(&task->sibling, &parent->children);
    }

    return task;
}
