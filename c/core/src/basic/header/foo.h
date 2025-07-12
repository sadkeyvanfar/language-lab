#ifndef FOO_H
#define FOO_H

/*
 * Sample header file for a C project
 * header files should contain declarations, macros, and type definitions
 * but not definitions of functions or variables.
 */

/* Include standard headers needed by declarations */
#include <stddef.h>   // for size_t
#include <stdint.h>   // for fixed-width integer types

/* Macro constants */
#define FOO_MAX_SIZE 100
#define FOO_MAGIC_NUMBER 0x1234ABCD

/* Macro functions or inline helpers */
#define FOO_MIN(a,b) ((a) < (b) ? (a) : (b))

/* Enumerations */
typedef enum {
    FOO_STATE_INIT = 0,
    FOO_STATE_RUNNING,
    FOO_STATE_STOPPED,
    FOO_STATE_ERROR
} foo_state_t;

/* Struct declarations with comments */
typedef struct {
    int id;
    char name[32];
    foo_state_t state;
    size_t size;
} foo_t;

/* Function-like macros (be careful with side effects) */
#define FOO_IS_RUNNING(foo_ptr) ((foo_ptr)->state == FOO_STATE_RUNNING)

/* Function prototypes */
#ifdef __cplusplus
extern "C" {
#endif

/**
 * Initializes the foo object.
 * @param foo Pointer to the foo object
 * @param id The ID to assign
 * @param name The name to assign
 * @return 0 on success, non-zero on error
 */
int foo_init(foo_t *foo, int id, const char *name);

/**
 * Starts foo.
 * @param foo Pointer to the foo object
 * @return 0 on success, non-zero on error
 */
int foo_start(foo_t *foo);

/**
 * Stops foo.
 * @param foo Pointer to the foo object
 */
void foo_stop(foo_t *foo);

/**
 * Returns the current state of foo.
 * @param foo Pointer to the foo object
 * @return current state enum value
 */
foo_state_t foo_get_state(const foo_t *foo);

#ifdef __cplusplus
}
#endif

#endif /* FOO_H */
