;;;; ==========================
;;;; Clojure Concurrency Promise Demo
;;;; ==========================

(ns clojure.concurrency.promise_demo)

;; Example of using a promise in Clojure
;; Promises are a way to create a placeholder for a value that will be provided later.
;; They are useful for asynchronous programming, allowing you to block until a value is available.
;; A promise is created using the `promise` function, which returns a promise object.
;; You can deliver a value to a promise using the `deliver` function, and you can dereference it
;; using `@` or `deref`, which will block until the value is available.

;; Create an empty promise
(def p (promise))

;; A task that will deliver the value later
(future
  (Thread/sleep 2000)  ;; Simulate delay
  (deliver p "The result is ready!"))

(println "Waiting for the promised result...")

;; Wait for the value — blocks until delivered
(println "Promise delivered:" @p)


(System/exit 0)
