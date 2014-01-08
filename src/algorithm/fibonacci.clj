(ns algorithm.fibonacci)

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

(def fib-memo (memoize fib))

(defn fib-tco [n])

