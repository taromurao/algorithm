(ns algorithm.sort-test
  (:require [clojure.test :refer :all]
            [algorithm.sort :refer :all])
  (:use [clojure.string :as str]))

(deftest numerical-vector
  (is (= [1 1 2 3] (merge-sort [2 1 3 1]))))

(deftest keyword-vector
  (is (= [:a :a :b :c] (merge-sort [:b :a :c :a]))))

(deftest string-vector
  (is (=
       ["Lorem" "amet" "dolor" "ipsum" "sit"]
       (merge-sort (str/split "Lorem ipsum dolor sit amet" #" ")))))
