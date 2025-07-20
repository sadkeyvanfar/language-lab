;;;; ==========================
;;;; Clojure Concurrency STM Ref Demo
;;;; ==========================

(ns clojure.concurrency.stm.ref-demo)

;;; --- Software Transactional Memory (STM) ---
;; Clojure's STM allows for safe concurrent programming by providing a way to manage shared state
;; without the need for locks. It uses references (Refs) to manage mutable state in a
;; transactional manner.
;; Refs are mutable references that can be changed within a transaction.
;; You can create a Ref using the `ref` function, which initializes it with a value.

;; Define a shared reference (Ref) to the account balance
(def balance (ref 100))

;; Deposit function using STM
(defn deposit [amount]
  (dosync
   (println "Depositing" amount)
   (alter balance + amount)
   (println "Balance after deposit:" @balance)))

;; Withdraw function using STM
(defn withdraw [amount]
  (dosync
   (println "Withdrawing" amount)
   (alter balance - amount)
   (println "Balance after withdrawal:" @balance)))

;; Print initial balance
(println "Initial balance:" @balance)

;; Simulate concurrent access
(future (deposit 50))
(future (withdraw 30))

;; Wait to ensure both threads finish
(Thread/sleep 1000)

(println "Final balance:" @balance)

;; Exit the program
(System/exit 0)
