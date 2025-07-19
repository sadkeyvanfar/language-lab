;;;; ============================================================
;;;; Sample demonstrating different types of comments in Clojure
;;;; ============================================================

;;; --- Namespace Declaration ---
(ns clojure.basic.comment)

;; A simple function that adds two numbers
(defn add [a b]
  (+ a b)) ; returns the sum of a and b

;;; --- Main Execution ---

(println "Sum of 3 and 4 is:" (add 3 4)) ; prints 7

;; You can use a comment macro to temporarily disable blocks of code:
(comment
  ;; This code will not be evaluated
  (println "This won't run")
  (defn subtract [a b]
    (- a b))
  (subtract 10 5))

;;; --- Utilities ---

;; This function returns the square of a number
(defn square [x]
  (* x x)) ; square using multiplication

(println "Square of 5 is:" (square 5))

;;;; End of File
