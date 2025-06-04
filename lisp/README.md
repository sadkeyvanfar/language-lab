# Lisp / Common Lisp

This is a Common Lisp project using SBCL, Quicklisp, and ASDF.

## Structure

- `src/` – Library source (`mylib.lisp`)
- `test/` – Simple test script
- `mylab.asd` – ASDF system file
- `Makefile` – Run / REPL helpers

## Usage

```bash
make run    # Runs test
make repl   # Starts REPL with Quicklisp
```
## Dependencies
- [SBCL](http://www.sbcl.org/) – Common Lisp implementation
- [Quicklisp](https://www.quicklisp.org/beta/) – Library manager
