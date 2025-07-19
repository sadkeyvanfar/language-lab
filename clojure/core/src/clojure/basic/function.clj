;;;; ==========================
;;;; Clojure Function Sample
;;;; ==========================

(ns clojure.basic.function)

;;; --- Functions ---
;; Functions are first-class citizens in Clojure, meaning they can be passed as arguments,
;; returned from other functions, and stored in data structures and can be created dynamically

;; You can define a function using the defn macro.
(defn addition-function [x y]
  (+ x y))

(println "Addition function result (3 + 5):" (addition-function 3 5))

;; You can also define anonymous functions using the fn special form or the #() reader macro.
(def multiply-function (fn [x y] (* x y)))
(println "Multiply function result (4 * 6):" (multiply-function 4 6))

(def divide-function #(/ %1 %2)) ; Using the #() reader macro for an anonymous function
(println "Divide function result (8 / 2):" (divide-function 8 2))

;; Functions can take variable number of arguments using the & symbol.
(defn variable-args-function [& args]
  (reduce + args)) ; Summing all arguments
(println "Variable args function result (1 2 3 4):" (variable-args-function 1 2 3 4))

;; using let to bind variables within a function
(defn let-function [x y]
  (let [sum (+ x y)
        product (* x y)]
    (println "Sum:" sum)
    (println "Product:" product)
    sum)) ; Returning the sum
(println "Let function result (5, 10):" (let-function 5 10))

;; You can use higher-order functions to create functions that return other functions.
(defn make-adder [x]
  (fn [y] (+ x y))) ; Returns a function that adds x to its argument
(def add-five (make-adder 5)) ; Creating a function that adds 5
(println "Add five function result (10):" (add-five 10))

;; apply function to call a function with a list of arguments
(defn apply-function [f args]
  (apply f args)) ; Using apply to call the function with the list of arguments
(println "Apply function result (addition-function, [2 3]):" (apply-function addition-function [2 3]))
