#include "foo.h"
#include <string.h>   // for strncpy
#include <stdio.h>    // for printf (optional, for demo)

int foo_init(foo_t *foo, int id, const char *name) {
    if (!foo || !name) return -1;
    foo->id = id;
    strncpy(foo->name, name, sizeof(foo->name));
    foo->name[sizeof(foo->name)-1] = '\0';  // Ensure null-termination
    foo->state = FOO_STATE_INIT;
    foo->size = 0;
    return 0;
}

int foo_start(foo_t *foo) {
    if (!foo) return -1;
    if (foo->state != FOO_STATE_INIT) return -2;
    foo->state = FOO_STATE_RUNNING;
    // Simulate starting something here...
    return 0;
}

void foo_stop(foo_t *foo) {
    if (!foo) return;
    if (foo->state == FOO_STATE_RUNNING) {
        foo->state = FOO_STATE_STOPPED;
    }
}

foo_state_t foo_get_state(const foo_t *foo) {
    if (!foo) return FOO_STATE_ERROR;
    return foo->state;
}
