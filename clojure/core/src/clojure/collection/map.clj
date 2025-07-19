;;;; ==========================
;;;; Clojure map Sample
;;;; ==========================

(ns clojure.collection.map)

;;; --- Maps (key-value pairs) ---
;; Maps are collections of key-value pairs, where each key is unique.
;; You can create a map using the hash-map function or the literal syntax.
(def my-map {:name "Alice" :age 30 :city "Wonderland"})
(println "Map:" my-map)

;; You can also create a map using the hash-map function.
(def another-map (hash-map :a 1 :b 2 :c 3)) ; Creating a map using hash-map
(println "Another map:" another-map)

;;; --- Accessing values in a map ---
;; You can access values in a map using the get function or by keyword.
(println "Name from map:" (:name my-map)) ; Accessing value by keyword
(println "Age from map:" (get my-map :age)) ; Accessing value using get function

;;; --- Adding key-value pairs to a map ---
;; You can add key-value pairs to a map using the assoc function.
(def updated-map (assoc my-map :country "Fantasyland")) ; Adding a new key-value pair
(println "Updated map with country:" updated-map)

;;; --- Removing key-value pairs from a map ---
;; You can remove key-value pairs from a map using the dissoc function.
(def reduced-map (dissoc my-map :city)) ; Removing the city key-value pair
(println "Map after removing city:" reduced-map)

;;; --- Transforming a map ---
;; You can transform a map using the map function.
(def transformed-map (into {} (map (fn [[k v]] [k (str v " (transformed)")]) my-map))) ; Appending "(transformed)" to each value
(println "Transformed map:" transformed-map)

;;; --- Merging maps ---
;; You can merge two maps using the merge function.
(def another-map {:country "Wonderland" :language "English"})
(def merged-map (merge my-map another-map)) ; Merging two maps
(println "Merged map:" merged-map)

;;; --- Map operations ---
;; Clojure provides many functions to operate on maps, such as keys, vals, and
;; seq.
(println "Keys in map:" (keys my-map)) ; Getting keys from the map
(println "Values in map:" (vals my-map)) ; Getting values from the map
(println "Map as sequence:" (seq my-map)) ; Converting map to a sequence

;;; --- Map destructuring ---
;; You can destructure maps to bind variables to their keys.
(let [{:keys [name age]} my-map]
  (println "Destructured name:" name)
  (println "Destructured age:" age))
(println "Rest of the map after destructuring:" (dissoc my-map :name :age))

;;; --- Higher-Order Functions ---
;; Clojure supports higher-order functions, allowing you to pass functions as arguments or return them
;; Example: Using map to transform values in a map.
(def incremented-age-map (into {} (map (fn [[k v]] [k (if (= k :age) (inc v) v)]) my-map))) ; Incrementing age by 1
(println "Map with incremented age:" incremented-age-map)

;;; --- Map as a sequence ---
;; Maps in Clojure are also sequences, allowing for lazy evaluation and operations on collections.
(def my-seq (seq my-map))
(println "Sequence from map:" my-seq)
