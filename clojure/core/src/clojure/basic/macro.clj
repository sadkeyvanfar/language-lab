;;;; ==========================
;;;; Clojure Macro Sample
;;;; ==========================

(ns clojure.basic.macro)

;;; --- Macros ---
;; Macros in Clojure allow you to manipulate code before it is evaluated.
;; They are used to create new syntactic constructs or to perform code transformations.
;; Macros are defined using the defmacro special form.
(defmacro unless [condition body]
  "Executes body unless condition is true."
  `(if (not ~condition)
     ~body))
;; Example usage of the unless macro
(println "Unless macro example:")
(unless true
        (println "This will not be printed.")) ; This will not execute because condition is true
(unless false
        (println "This will be printed.")) ; This will execute because condition is false

;;; --- Using macros for code generation ---
;; Macros can be used to generate code dynamically.
(defmacro repeat-n [n body]
  "Repeats body n times."
  `(do
     ~@(repeat n body))) ; Generates a sequence of body repeated n times
;; Example usage of the repeat-n macro
(println "Repeat-n macro example:")
(repeat-n 3
          (println "This will be printed 3 times.")) ; This will print the message 3 times

;;; --- Macros for control flow ---
;; You can create macros that control the flow of execution.
(defmacro while-true [body]
  "Executes body in an infinite loop."
  `(loop []
     ~body
     (recur))) ; Recursively calls itself to create an infinite loop
;; Example usage of the while-true macro
(println "While-true macro example:")
;; Uncomment the next line to see the infinite loop in action
;; (while-true
;;   (println "This will print indefinitely.")) ; This will create an infinite loop
