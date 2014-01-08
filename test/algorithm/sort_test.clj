(ns algorithm.sort-test
  (:require [clojure.test :refer :all]
            [algorithm.sort :refer :all]))

(defn check [f]
  (is (= [1 1 2 3] (f [2 1 3 1]))))

(deftest test-merge-sort
  (check merge-sort))

(deftest test-binary-sort
  (check binary-sort))

