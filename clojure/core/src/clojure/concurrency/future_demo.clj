;;;; ==========================
;;;; Clojure Concurrency Future Demo
;;;; ==========================

(ns clojure.concurrency.future-demo)

;; A simple example of using `future` for concurrency
;; Futures allow you to run tasks asynchronously in Clojure.
;; You can create a future using the `future` macro, which will run the given expression in a separate thread.
;; Define a function that simulates a long-running task
;; This function will simulate a task that takes some time to complete
;; and returns a result after a delay.

(defn slow-task [msg delay-ms]
  (Thread/sleep delay-ms)
  (str "Finished: " msg))

;; Run two tasks concurrently
(def result1 (future (slow-task "Task 1" 2000)))
(def result2 (future (slow-task "Task 2" 3000)))

(println "Tasks started... Doing other work in the meantime.")

;; Use `deref` or `@` to wait for and get the result
(println "Result 1:" @result1)
(println "Result 2:" @result2)

(System/exit 0)
