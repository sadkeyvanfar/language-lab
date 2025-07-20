;;;; ==========================
;;;; Clojure Concurrency vars Demo
;;;; ==========================

(ns clojure.concurrency.stm.vars-demo)

;; This example shows how Clojure Vars behave
;; Vars are used to hold values that can change over time.
;; They are thread-local and can be rebound dynamically.
;; Define a Var with an initial value


;; Define a global var for a counter
(def counter 0)

;; A function that updates the var (not thread-safe!)
(defn increment-counter []
  (def counter (+ counter 1))
  (println "Counter is now:" counter))

;; Call the function multiple times
(increment-counter) ;; Counter is now: 1
(increment-counter) ;; Counter is now: 2
