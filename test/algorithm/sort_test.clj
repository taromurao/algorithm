(ns algorithm.sort-test
  (:require [clojure.test :refer :all]
            [algorithm.sort :refer :all])
  (:use [clojure.string :as str]))

(deftest numerical-vector
  (is (= [1 1 2 3] (merge-sort [2 1 3 1]))))

