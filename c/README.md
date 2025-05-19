# C Language Samples

This directory contains sample programs written in the C programming language.

## Structure

The code samples are organized into topic-based subdirectories:

- `basic/` – Core language syntax, types, loops, functions
- `io/` – Input and output operations
- `cuncurrency/` – multithreading examples
- `syscall/` – Simple system call usage
- ...

## Building

Each subdirectory may include a `Makefile` to compile the examples. To build all examples in a folder:

```bash
make
```
This will generate binaries in the build/ directory (if configured that way).

## Requirements

- C compiler (e.g., `gcc`, `clang`, or `clang` with LLVM)