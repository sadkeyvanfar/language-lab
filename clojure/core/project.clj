(defproject core "0.1.0-SNAPSHOT"
  :description "A simple Clojure project"
  :dependencies [[org.clojure/clojure "1.11.1"]]
  :main ^:skip-aot clojure.hello-world
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
