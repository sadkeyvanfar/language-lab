#include "foo.h"
#include <stdio.h>

int main() {
    foo_t myfoo;

    if (foo_init(&myfoo, 42, "ExampleFoo") != 0) {
        printf("Failed to initialize foo\n");
        return 1;
    }

    printf("Foo state after init: %d\n", foo_get_state(&myfoo));

    if (foo_start(&myfoo) == 0) {
        printf("Foo started successfully\n");
    } else {
        printf("Foo failed to start\n");
    }

    printf("Foo state after start: %d\n", foo_get_state(&myfoo));

    foo_stop(&myfoo);
    printf("Foo state after stop: %d\n", foo_get_state(&myfoo));

    return 0;
}
