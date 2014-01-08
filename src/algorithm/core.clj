(ns algorithm.core
  (:gen-class)
  (:require [algorithm.sort :refer :all])
  (:use criterium.core))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  ;; work around dangerous default behaviour in Clojure
  (alter-var-root #'*read-eval* (constantly false))
  (println "Hello, World!"))

(with-progress-reporting (bench (merge-sort [3 2 1]) :verbose))
