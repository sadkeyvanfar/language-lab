#include <unistd.h>
#include <sys/syscall.h>
#include <stdio.h>

int main() {
    const char *msg = "Hello from syscall!\n";
    syscall(SYS_write, STDOUT_FILENO, msg, 21);
    return 0;
}
