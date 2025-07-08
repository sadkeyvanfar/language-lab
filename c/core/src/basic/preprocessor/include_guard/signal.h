// The include guard prevents multiple inclusions of this header file, which can lead to redefinition errors.
#ifndef _INCLUDE_GUARD_SIGNAL_H
#define _INCLUDE_GUARD_SIGNAL_H

struct signal_struct {
    int sig;                // Signal number
    unsigned int flags;      // Flags for signal handling options
};

void send_signal(int sig, struct signal_struct *act) {
    printf("Sending signal %d with flags %u\n", sig, act->flags);
}
