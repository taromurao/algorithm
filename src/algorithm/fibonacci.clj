(ns algorithm.fibonacci)

; Theta(fib(n))?
; Evaluation count : 49200 in 60 samples of 820 calls.
;              Execution time mean : 1.238113 ms
;     Execution time std-deviation : 50.578746 µs
;    Execution time lower quantile : 1.199161 ms ( 2.5%)
;    Execution time upper quantile : 1.318812 ms (97.5%)
;                    Overhead used : 2.873275 ns
; 
; Found 7 outliers in 60 samples (11.6667 %)
;   low-severe   5 (8.3333 %)
;   low-mild   2 (3.3333 %)
;  Variance from outliers : 27.0806 % Variance is moderately inflated by outliers

(defn fib [n]
  (condp = n
    0 1
    1 1
    (+ (fib (- n 1)) (fib (- n 2)))))

; Theta(n)
; Evaluation count : 956366520 in 60 samples of 15939442 calls.
;              Execution time mean : 59.562877 ns
;     Execution time std-deviation : 1.004405 ns
;    Execution time lower quantile : 57.875909 ns ( 2.5%)
;    Execution time upper quantile : 61.571465 ns (97.5%)
;                    Overhead used : 2.978417 ns

(def fib-memo (memoize fib))

; Christopher Grand's solution
; Evaluation count : 6217920 in 60 samples of 103632 calls.
;              Execution time mean : 9.543614 µs
;     Execution time std-deviation : 193.336986 ns
;    Execution time lower quantile : 9.318345 µs ( 2.5%)
;    Execution time upper quantile : 9.924526 µs (97.5%)
;                    Overhead used : 1.777802 ns
; 
; Found 2 outliers in 60 samples (3.3333 %)
;   low-severe   1 (1.6667 %)
;   low-mild   1 (1.6667 %)
;  Variance from outliers : 9.3655 % Variance is slightly inflated by outliers

(defn fib-chris [n]
  (let [fib-seq
        (map first (iterate (fn [[a b]] [b (+ a b)]) [1 1]))]
    (nth fib-seq n)))

; Theoretically Theta(n), but with tail call optimization ;-)
; Source "Joy of Clojure"
; This algorithm is blazing fast,
; but the n at the end of letfn function looks pretty much an optimization-artifact.
; Evaluation count : 88839240 in 60 samples of 1480654 calls.
;              Execution time mean : 666.023709 ns
;     Execution time std-deviation : 9.258185 ns
;    Execution time lower quantile : 650.920248 ns ( 2.5%)
;    Execution time upper quantile : 683.418877 ns (97.5%)
;                    Overhead used : 2.908973 ns
; 
; Found 1 outliers in 60 samples (1.6667 %)
;   low-severe   1 (1.6667 %)
;  Variance from outliers : 1.6389 % Variance is slightly inflated by outliers

(defn fib-tco [n]
  (letfn [(fib' [current next n]
            (if (zero? n)
              next
              (recur next (+ current next) (dec n))))]
    (fib' 0 1 n))) ; In order to support larger numbers, we should use bigints.

