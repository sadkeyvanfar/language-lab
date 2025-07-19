;;;; ==========================
;;;; Clojure list collection sample
;;;; ==========================

(ns clojure.collection.list)

;;; --- Lists (linked list, used for code and data) ---
;; Note: Lists are typically used for code in Clojure, but can also be used
;; as data structures.
;; To create a list, use the quote syntax or the list function.
;; ' is used to prevent evaluation.
;; Example: (def my-list '(1 2 3 4)) or (def my-list (list 1 2 3 4))
(def my-list '(1 2 3 4))
(println "List:" my-list)

;;; --- Accessing elements in a list ---
;; You can access elements in a list using the first, rest, and nth functions.
(println "First element:" (first my-list)) ; Accessing the first element
(println "Rest of the list:" (rest my-list)) ; Accessing the rest of the list
(println "Element at index 2:" (nth my-list 2)) ; Accessing element at index 2

;;; --- Adding elements to a list ---
;; You can add elements to a list using the cons function or the conj function.
(def new-list (cons 0 my-list)) ; Adding an element to the front
(println "List after adding 0 at the front:" new-list)
(def another-list (conj my-list 5)) ; Adding an element to the end
(println "List after adding 5 at the end:" another-list)

;;; --- Removing elements from a list ---
;; You can remove elements from a list using the filter function or the remove function.
(def filtered-list (filter #(not= % 2) my-list)) ; Removing element 2
(println "List after removing 2:" filtered-list)

;;; --- Transforming a list ---
;; You can transform a list using the map function.
(def transformed-list (map #(* 2 %) my-list)) ; Doubling each element
(println "Transformed list (doubled):" transformed-list)

;;; --- List operations ---
;; Clojure provides many functions to operate on lists, such as map, filter, and reduce.
;; Example: Using reduce to sum elements in a list.
(def sum-of-list (reduce + 0 my-list)) ; Summing elements in the list
(println "Sum of elements in the list:" sum-of-list)
;;; --- Higher-Order Functions ---
;; Clojure supports higher-order functions, allowing you to pass functions as arguments or return them
;; Example: Using filter to get even numbers from a list.
(def even-numbers (filter even? my-list))
(println "Even numbers from list:" even-numbers)

;;; --- List as a sequence ---
;; Lists in Clojure are also sequences, allowing for lazy evaluation and operations on collections.
(def my-seq (seq my-list))
(println "Sequence from list:" my-seq)

;;; --- List destructuring ---
;; You can destructure lists to bind variables to their elements.
(let [[first second & rest] my-list]
  (println "Destructured first element:" first)
  (println "Destructured second element:" second)
  (println "Rest of the list after destructuring:" rest))

;;; --- List comparison ---
;; You can compare lists for equality.
(def another-list '(1 2 3 4))
(println "Are the two lists equal?" (= my-list another-list))

;;; --- List length ---
;; You can get the length of a list using the count function.
(println "Length of the list:" (count my-list))

;;; --- List reversal ---
;; You can reverse a list using the reverse function.
(def reversed-list (reverse my-list))
(println "Reversed list:" reversed-list)

;;; --- List conversion ---
;; You can convert a list to other collection types, such as vectors or sets.
(def my-vector (vec my-list)) ; Convert list to vector
(println "List converted to vector:" my-vector)

(def my-set (set my-list)) ; Convert list to set
(println "List converted to set:" my-set)

;;; --- List concatenation ---
;; You can concatenate lists using the concat function.
(def another-list '(5 6 7))
(def concatenated-list (concat my-list another-list)) ; Concatenating two lists
(println "Concatenated list:" concatenated-list)
