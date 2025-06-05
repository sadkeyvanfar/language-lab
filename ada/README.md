# Ada – language-lab

This directory contains a simple Ada project set up using [Alire](https://alire.ada.dev), the Ada language package and build manager.

## structure
- `src/`: Contains the Ada source files.
- `alire.toml`: alr.toml defines metadata and dependencies
- `core.gpr`: The GNAT project file that defines the build configuration for the Ada project.
## Prerequisites
- [Alire](https://alire.ada.dev) (recommended)
- Or alternatively: GNAT compiler (if not using `alr`)

## Build
```bash
alr build
```

## Run
```bash
alr run
```
## Clean
```bash
alr clean
```
