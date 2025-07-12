#ifndef LIST_H
#define LIST_H

#include <stddef.h>  // for size_t

/* simulated list_head structure */

struct list_head {
    struct list_head *next, *prev;
};

#define container_of(ptr, type, member) \
    ((type *)((char *)(ptr) - (size_t)&((type *)0)->member))

#define INIT_LIST_HEAD(ptr) \
    do { (ptr)->next = (ptr); (ptr)->prev = (ptr); } while (0)

#define list_for_each(pos, head) \
    for (pos = (head)->next; pos != (head); pos = pos->next)

void list_add(struct list_head *new, struct list_head *head);
void list_del(struct list_head *entry);

#endif // LIST_H
