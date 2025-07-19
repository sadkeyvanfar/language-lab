;;;; ==========================
;;;; Clojure Metadata
;;;; ==========================

 ;; Clojure provides a way to attach metadata to various data structures, which can be useful for documentation, tooling, and other purposes.
 ;; Metadata can be attached to symbols, functions, and other data structures using the `^` syntax.
 (ns clojure.basic.metadata)

;;; --- Attaching Metadata ---

;; The `with-meta` function is used to attach metadata to a function.
(def my-data (with-meta [1 2 3] {:info "sample list"}))
(println (meta my-data)) ; Accessing metadata of my-list

;; You can also attach metadata directly to a symbol using the `^{}` macro
(def my-symbol ^{:doc "This is a sample symbol"} my-symbol)
(println (meta #'my-symbol)) ; Accessing metadata of my-symbol
