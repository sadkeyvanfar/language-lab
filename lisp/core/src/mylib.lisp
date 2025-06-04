(defpackage :mylib
  (:use :cl)
  (:export :greet))

(in-package :mylib)

(defun greet (name)
  (format t "Hello, ~A!~%" name))
