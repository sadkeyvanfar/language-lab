;;;; ==========================
;;;; Clojure Interop Java Interop Sample
;;;; ==========================

(ns clojure.interop.java-interop)

;;; --- Java Interop ---
;; Clojure provides seamless interop with Java, allowing you to call Java methods and access
;; Java classes directly from Clojure code.
;; You can use the `import` form to bring Java classes into scope.
(import '[java.util Date])
;;; --- Calling Java Methods ---
;; You can create instances of Java classes and call their methods.
(defn current-date []
  "Returns the current date and time."
  (Date.)) ; Creates a new Date instance representing the current date and time

;;; --- Accessing Java Fields ---
;; You can access public fields of Java classes using the dot syntax.
(defn date-to-string [date]
  "Converts a Date object to a string representation."
  (.toString date)) ; Calls the toString method on the Date object

;;; --- Using Java Collections ---
;; Clojure can work with Java collections like ArrayList and HashMap.
(import '[java.util ArrayList HashMap])
(defn create-array-list []
  "Creates an ArrayList and adds some elements."
  (let [list (ArrayList.)] ; Creates a new ArrayList instance
    (.add list "Clojure") ; Adds an element to the ArrayList
    (.add list "Java")    ; Adds another element
    list))                ; Returns the ArrayList
