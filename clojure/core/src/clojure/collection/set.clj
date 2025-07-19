;;;; ==========================
;;;; Clojure set Sample
;;;; ==========================

(ns clojure.collection.set)

;;; --- Sets (unique values) ---
;; Sets are collections of unique values, meaning no duplicates are allowed.
;; You can create a set using the hash-set function or the literal syntax.
(def my-set #{1 2 3 4})
(println "Set:" my-set)

;;; --- Accessing elements in a set ---
;; You can check if an element is in a set using the contains? function.
(println "Contains 2?" (contains? my-set 2)) ; Checking if 2 is in the set

;;; --- Adding elements to a set ---
;; You can add elements to a set using the conj function.
(def updated-set (conj my-set 5)) ; Adding an element to the set
(println "Set after adding 5:" updated-set)

;;; --- Removing elements from a set ---
;; You can remove elements from a set using the disj function.
(def reduced-set (disj my-set 3)) ; Removing the element 3 from the set
(println "Set after removing 3:" reduced-set)
