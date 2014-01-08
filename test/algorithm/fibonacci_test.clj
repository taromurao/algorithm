(ns algorithm.fibonacci-test
  (:require [clojure.test :refer :all]
            [algorithm.fibonacci :refer :all]))

(defn check-fib [f]
  (is (= 8 (f 5))))

(deftest fn-fib
  (check-fib fib))

