#include <stdio.h>
#include "task_struct.h"
#include "list_head.h"

struct list_head task_list;

int main() {
    INIT_LIST_HEAD(&task_list);

    struct task_struct *init = create_task(1, "init", NULL, TASK_RUNNING, 0);
    struct task_struct *bash = create_task(2, "bash", init, TASK_INTERRUPTIBLE, 100);
    struct task_struct *sshd = create_task(3, "sshd", init, TASK_RUNNING, 200);
    struct task_struct *nginx = create_task(4, "nginx", init, TASK_RUNNING, 150);
    struct task_struct *worker1 = create_task(5, "nginx-worker1", nginx, TASK_UNINTERRUPTIBLE, 250);
    struct task_struct *worker2 = create_task(6, "nginx-worker2", nginx, TASK_RUNNING, 300);

    printf("\nProcess Tree:\n");
    print_task(init, 0);

    return 0;
}
