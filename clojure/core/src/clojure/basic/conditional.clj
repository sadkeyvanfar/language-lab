;;;; ==========================
;;;; Clojure Conditional Sample
;;;; ==========================

(ns clojure.basic.conditional)

;;; --- Conditional Statements ---
;; Clojure provides several ways to perform conditional logic, including if, when, and cond.

;;; --- if statement ---
;; The if statement evaluates a condition and executes one of two branches based on the result.
(defn check-even-odd [n]
  (if (even? n)
    (println n "is even")
    (println n "is odd")))
(check-even-odd 10) ; Example usage of if statement

;;; --- when statement ---
;; The when statement is used for executing a block of code only if a condition is true.
(defn greet-if-true [condition]
  (when condition
    (println "Condition is true!")))
(greet-if-true true) ; Example usage of when statement

;;; --- cond statement ---
;; The cond statement allows you to evaluate multiple conditions and execute the corresponding branch.
(defn grade-message [score]
  (cond
    (< score 60) (println "You failed.")
    (< score 80) (println "You passed.")
    :else (println "You did great!")))
(grade-message 75) ; Example usage of cond statement

;;; --- case statement ---
;; The case statement is used for comparing a value against multiple constants.
(defn day-message [day]
  (case day
    :monday (println "Start of the week!")
    :friday (println "Almost weekend!")
    :sunday (println "Rest day!")
    (println "Just another day!")))
(day-message :friday) ; Example usage of case statement

;;; --- condp statement ---
;; The condp statement is similar to cond but allows you to specify a predicate function.
(defn compare-numbers [x y]
  (condp > x
    y (println x "is greater than" y)
    (println x "is not greater than" y)))
(compare-numbers 5 3) ; Example usage of condp statement

;;; --- if-let statement ---
;; The if-let statement allows you to bind a value to a name if it is not nil.
(defn check-name [name]
  (if-let [n name]
    (println "Hello," n)
    (println "No name provided.")))
(check-name "Alice") ; Example usage of if-let statement

;;; --- when-let statement ---
;; The when-let statement is similar to if-let but executes a block only if the value is not nil.
(defn greet-name [name]
  (when-let [n name]
    (println "Welcome," n)))
(greet-name "Bob") ; Example usage of when-let statement

;;; --- some? and every? ---
;; The some? function checks if a value is not nil, while every? checks if all elements in a collection satisfy a predicate.
(defn check-values [values]
  (if (some? values)
    (println "Values provided:" values)
    (println "No values provided.")))
(check-values [1 2 3]) ; Example usage of some?

(defn all-even? [numbers]
  (if (every? even? numbers)
    (println "All numbers are even.")
    (println "Not all numbers are even.")))
(all-even? [2 4 6]) ; Example usage of every?

;;; --- cond-> and cond->> ---
;; The cond-> and cond->> macros allow you to conditionally thread a value through a series of forms.
(defn conditional-threading [x]
  (cond-> x
    (even? x) (inc) ; Increment if x is even
    (odd? x) (dec))) ; Decrement if x is odd
(println "Conditional threading result:" (conditional-threading 4)) ; Example usage of cond
