(ns clojure.hello-world-test
  (:require [clojure.test :refer :all]
            [clojure.hello-world :refer :all]))

(deftest test-main
  (is (= 1 1)))
