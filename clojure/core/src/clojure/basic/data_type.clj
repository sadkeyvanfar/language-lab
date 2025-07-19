(ns clojure.misc.data-types-demo)

;;;; ==========================
;;;; Clojure Data Types Sample
;;;; ==========================

;;; --- Numbers ---
(def int-val 42)               ; Integer
(def float-val 3.14)           ; Floating-point number
(def ratio-val 22/7)           ; Ratio
(def big-int 12345678901234567890N) ; BigInt (arbitrary precision)

(println "Integer:" int-val)
(println "Float:" float-val)
(println "Ratio:" ratio-val)
(println "BigInt:" big-int)

;;; --- Strings ---
(def message "Hello, Clojure!")
(println "String:" message)

;;; --- Characters ---
(def char-val \C)
(println "Character:" char-val)

;;; --- Booleans ---
(def bool-true true)
(def bool-false false)
(println "Boolean true:" bool-true)
(println "Boolean false:" bool-false)

;;; --- Nil (represents absence of value) ---
(def no-value nil)
(println "Nil value:" no-value)

;;; --- Keywords (used as identifiers or map keys) ---
(def k :my-key)
(println "Keyword:" k)

;;; --- Symbols (used for variable/function names) ---
(def s 'my-symbol)
(println "Symbol:" s)

;;; --- Lists (linked list, used for code and data) ---
(def my-list '(1 2 3 4))
(println "List:" my-list)

;;; --- Vectors (indexed, like arrays) ---
(def my-vector [1 2 3 4])
(println "Vector:" my-vector)

;;; --- Maps (key-value pairs) ---
(def my-map {:name "Alice" :age 30})
(println "Map:" my-map)
(println "Name from map:" (:name my-map)) ; keyword lookup

;;; --- Sets (unique values) ---
(def my-set #{1 2 3})
(println "Set (no duplicates):" my-set)
