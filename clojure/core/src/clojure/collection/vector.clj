;;;; ==========================
;;;; Clojure vector Sample
;;;; ==========================

(ns clojure.collection.vector)

;;; --- Vectors (indexed, like arrays) ---
;; Vectors are a fundamental data structure in Clojure, providing efficient access to elements by index.
;; They are immutable, meaning that any operation that modifies a vector returns a new vector.
;; To create a vector, use square brackets or the vector function.
(def my-vector [1 2 3 4])
(println "Vector:" my-vector)

;;; --- Accessing elements in a vector ---
;; You can access elements in a vector using the get function or by index.
(println "Element at index 2:" (get my-vector 2)) ; Accessing element at index 2
(println "2ed element in vector:" (nth my-vector 1)) ; nth is zero-based index
(println "First element:" (first my-vector)) ; Accessing the first element
(println "Rest of the vector:" (rest my-vector)) ; Accessing the rest of the vector
(println "Last element:" (last my-vector)) ; Accessing the last element


;;; --- Adding elements to a vector ---
;; You can add elements to a vector using the conj function, which adds an element to the end of the vector.
(def new-vector (conj my-vector 5)) ; Adding an element to the end
(println "Vector after adding 5 at the end:" new-vector)

;;; --- Removing elements from a vector ---
;; You can remove elements from a vector using the filter function or the remove function.
(def filtered-vector (filter #(not= % 2) my-vector)) ; Removing element
(println "Vector after removing 2:" filtered-vector)
