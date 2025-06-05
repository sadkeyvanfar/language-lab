.section __TEXT,__text
.globl _main

_main:
    mov x0, #1                            // stdout
    adrp x1, message@PAGE
    add  x1, x1, message@PAGEOFF          // pointer to message
    mov x2, #13                           // length of message
    mov x16, #4                           // syscall: write
    svc #0x80

    mov x0, #0                            // exit code
    mov x16, #1                           // syscall: exit
    svc #0x80

.section __TEXT,__cstring
message:
    .asciz "Hello, World!\n"
