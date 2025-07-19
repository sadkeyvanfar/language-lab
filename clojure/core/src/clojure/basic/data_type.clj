(ns clojure.basic.data-type)

;;;; ==========================
;;;; Clojure Data Types Sample
;;;; ==========================

;;; --- Numbers ---
(def int-val 42)               ; Integer
(def long-val 123) ; Long (64-bit integer)
(def float-val 3.14)           ; Floating-point number
(def double-val 2.71828)      ; Double-precision floating-point number
(def big-decimal 1.23456789012345678901234567890M) ; BigDecimal (arbitrary precision decimal)
(def ratio-val 22/7)           ; Ratio
(def big-int 12345678901234567890N) ; BigInt (arbitrary precision)

(println "Integer:" int-val)
(println "Long:" long-val)
(println "Float:" float-val)
(println "Double:" double-val)
(println "BigDecimal:" big-decimal)
(println "Ratio:" ratio-val)
(println "BigInt:" big-int)

;;; --- Strings ---
(def message "Hello, Clojure!")
(println "String:" message)

;;; --- Characters --- Characters are single Unicode characters in Clojure.
;; Characters are represented by a backslash followed by the character.
(def char-val \C)
(println "Character:" char-val)

;;; --- Booleans ---
(def bool-true true)
(def bool-false false)
(println "Boolean true:" bool-true)
(println "Boolean false:" bool-false)

;;; --- Nil (represents absence of value) ---
;; In Clojure, nil is used to represent the absence of a value. like null in other languages.
(def no-value nil)
(println "Nil value:" no-value)

;;; --- Keywords (used as identifiers or map keys) ---
(def k :my-key)
(println "Keyword:" k)

;;; --- Symbols (used for variable/function names) ---
(def s 'my-symbol)
(println "Symbol:" s)
