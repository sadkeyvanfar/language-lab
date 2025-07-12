#ifndef LIST_H
#define LIST_H

/* simulated list_head structure */

struct list_head {
    struct list_head *next, *prev;
};

#define container_of(ptr, type, member) \
    ((type *)((char *)(ptr) - (size_t)&((type *)0)->member))

#define INIT_LIST_HEAD(ptr) \
    do { (ptr)->next = (ptr); (ptr)->prev = (ptr); } while (0)

void list_add(struct list_head *new, struct list_head *head);
void list_del(struct list_head *entry);

#endif // LIST_H
