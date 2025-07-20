;;;; ==========================
;;;; Clojure Concurrency STM Atom Demo
;;;; ==========================

(ns clojure.concurrency.stm.atom-demo)

;; Atoms provide synchronous, thread-safe state changes
;; Atoms are a way to manage shared state in Clojure, allowing for synchronous updates.
;; They are useful for cases where you want to manage state that can change over time,
;; but you want to ensure that changes are made atomically.

;; Define an atom to hold a balance, initially 100
(def balance (atom 100))

;; A function to deposit money
(defn deposit [amount]
  (println "Depositing" amount)
  (swap! balance + amount))

;; A function to withdraw money
(defn withdraw [amount]
  (println "Withdrawing" amount)
  (swap! balance - amount))

;; Perform operations
(deposit 50)    ;; balance becomes 150
(withdraw 30)   ;; balance becomes 120

;; Print final balance
(println "Final balance is:" @balance)

(System/exit 0)
