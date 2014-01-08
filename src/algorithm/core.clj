(ns algorithm.core
  (:gen-class)
  (:require [algorithm.sort :refer :all]
            [algorithm.sample-data :as data]
            [algorithm.fibonacci :refer :all])
  (:use criterium.core))

(defn -main []
  ;(with-progress-reporting (bench (merge-sort data/int-vector))))
  ;(with-progress-reporting (bench (binary-sort data/int-vector))))
  ;(with-progress-reporting (bench (fib 20))))
  (with-progress-reporting (bench (fib-memo 20))))
