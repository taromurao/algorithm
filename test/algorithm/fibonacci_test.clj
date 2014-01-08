(ns algorithm.fibonacci-test
  (:require [clojure.test :refer :all]
            [algorithm.fibonacci :refer :all]))

(defn check-fib [f]
  (is (= 8 (f 5))))

(deftest fn-fib
  (check-fib fib))

(deftest fn-fib-memoize
  (check-fib fib-memoize))

(deftest fn-fib-tco
  (check-fib fib-tco))

