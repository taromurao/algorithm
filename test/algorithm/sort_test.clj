(ns algorithm.sort-test
  (:require [clojure.test :refer :all]
            [algorithm.sort :refer :all])
  (:use [clojure.string :as str]))

(deftest numerical-vector
  (is (= [1 2 3] (merge-sort [2 3 1]))))

(deftest keyword-vector
  (is (= [:a :b :c] (merge-sort [:a :b :c]))))

(deftest string-vector
  (is (=
       ["Lorem" "amet" "dolor" "ipsum" "sit"]
       (merge-sort (str/split "Lorem ipsum dolor sit amet" #" ")))))
