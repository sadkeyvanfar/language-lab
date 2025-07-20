;;;; ==========================
;;;; Clojure Concurrency STM Agent Demo
;;;; ==========================

(ns clojure.concurrency.stm.agent-demo)

;; An agent is used for asynchronous updates to shared state
;; Agents are a way to manage shared state in Clojure, allowing for asynchronous updates.
;; They are useful for tasks that can be performed independently and do not require immediate
;; synchronization with other threads.
;; You can create an agent using the `agent` function, which initializes it with a value.

;; Define an agent with an initial balance of 100
(def balance (agent 100))

;; A function that simulates depositing money
(defn deposit [current amount]
  (println "Depositing" amount)
  (+ current amount))

;; A function that simulates withdrawing money
(defn withdraw [current amount]
  (println "Withdrawing" amount)
  (- current amount))

;; Send tasks to the agent (asynchronously)
(send balance deposit 50)     ; Add 50 to balance
(send balance withdraw 30)    ; Subtract 30 from balance

;; Wait for all agent actions to finish
(await balance)

;; Print final balance
(println "Final balance is:" @balance)

(System/exit 0)
