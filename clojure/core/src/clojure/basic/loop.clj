;;;; ==========================
;;;; Clojure Loop Sample
;;;; ==========================

(ns clojure.basic.loop)

;;; --- Looping Constructs ---
;; Clojure provides several constructs for looping, including loop/recur, doseq, and for.

;;; --- loop/recur ---
;; The loop/recur construct is used for creating recursive loops.
(defn factorial [n]
  (loop [i n
         result 1]
    (if (zero? i)
      result
      (recur (dec i) (* result i))))) ; Recursive call with updated values
(println "Factorial of 5:" (factorial 5)) ; Example usage of factorial function

;;; --- doseq ---
;; The doseq construct is used for side-effecting operations, such as printing or updating state.
(defn print-numbers [n]
  (doseq [i (range 1 (inc n))] ; Iterating over a range of numbers
    (println "Number:" i))) ; Printing each number
(print-numbers 5) ; Example usage of print-numbers function

;;; --- for ---
;; The for construct is used for generating sequences based on a collection.
(defn square-numbers [numbers]
  (for [n numbers] ; Iterating over a collection of numbers
    (* n n))) ; Returning the square of each number
(println "Squares of numbers [1 2 3 4 5]:" (square-numbers [1 2 3 4 5])) ; Example usage of square-numbers function

;;; --- Looping with conditionals ---
;; You can combine looping constructs with conditionals to create more complex logic.
(defn even-squares [numbers]
  (for [n numbers :when (even? n)] ; Filtering even numbers
    (* n n))) ; Returning the square of each even number
(println "Even squares of numbers [1 2 3 4 5]:" (even-squares [1 2 3 4 5])) ; Example usage of even-squares function
