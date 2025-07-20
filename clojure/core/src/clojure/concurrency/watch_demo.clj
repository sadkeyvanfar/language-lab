;;;; ==========================
;;;; Clojure watch Demo
;;;; ==========================

(ns clojure.concurrency.watch-demo)

;; Watches notify you when a reference type (like an atom) changes
;; Watches are a way to observe changes to Clojure's reference types (like atoms, refs, etc.).
;; You can add a watch to an atom, ref, or var to get notified when its
;; value changes. This is useful for debugging or for triggering side effects
;; when the value changes.

;; Define an atom to hold some state
(def my-counter (atom 0))

;; Define a watch function that logs changes
(defn log-change [key reference old-state new-state]
  (println "WATCH triggered by:" key)
  (println "Old value:" old-state)
  (println "New value:" new-state))

;; Add the watch to the atom
(add-watch my-counter :logger log-change)

;; Update the atom
(swap! my-counter inc)  ;; Triggers watch
(swap! my-counter #(+ % 5))  ;; Triggers watch again

;; You can remove the watch if needed
(remove-watch my-counter :logger)

;; Further changes will not trigger the watch
(swap! my-counter inc)
