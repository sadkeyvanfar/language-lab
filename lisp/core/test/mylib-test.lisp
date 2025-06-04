(load "quicklisp.lisp") ; Loads Quicklisp if needed
(ql:quickload "mylab")

(in-package :cl)
(use-package :mylib)

(greet "Common Lisp")
