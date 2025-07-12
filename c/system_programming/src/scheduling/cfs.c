#include <stddef.h>
#include "cfs.h"
#include "../kernel_structs/list_head.h"
#include <limits.h>

static struct list_head run_queue;

static const int nice_to_weight[40] = {
    88761, 71755, 56483, 46273, 36291, 29154, 23254, 18705, 14949, 11916,
    9548,  7620,  6100,  4904,  3906,  3121,  2501,  1991,  1586,  1277,
    1024,  820,   655,   526,   423,   335,   272,   215,   172,   137,
    110,   87,    70,    56,    45,    36,    29,    23,    18,    15
};

static int weight_from_nice(int nice) {
    int index = nice + 20;
    if (index < 0) index = 0;
    if (index > 39) index = 39;
    return nice_to_weight[index];
}

void init_run_queue() {
    INIT_LIST_HEAD(&run_queue);
}

void enqueue_task(struct task_struct *task) {
    if (task->weight == 0) {
        task->weight = weight_from_nice(task->nice);
    }
    list_add(&task->tasks, &run_queue);
}

struct task_struct* pick_next_task() {
    struct list_head *pos;
    struct task_struct *best = NULL;
    unsigned long min_vruntime = ULONG_MAX;

    list_for_each(pos, &run_queue) {
        struct task_struct *t = container_of(pos, struct task_struct, tasks);
        if (t->vruntime < min_vruntime) {
            min_vruntime = t->vruntime;
            best = t;
        }
    }
    return best;
}

void update_vruntime(struct task_struct *task, unsigned long delta_exec) {
    if (task->weight == 0) {
        task->weight = weight_from_nice(task->nice);
    }
    // Increase vruntime proportionally inverse to the task weight
    task->vruntime += (delta_exec * 1024) / task->weight;
}
