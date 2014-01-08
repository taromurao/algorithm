(ns algorithm.core
  (:gen-class)
  (:require [algorithm.sort :refer :all]
            [algorithm.sample-data :as data])
  (:use criterium.core))

(defn -main []
  ;(with-progress-reporting (bench (merge-sort data/int-vector))))
  (with-progress-reporting (bench (binary-sort data/int-vector))))

