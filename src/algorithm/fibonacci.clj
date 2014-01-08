(ns algorithm.fibonacci)

(defn fib [n]
  (condp = n
    0 1
    1 1
    (+ (fib (- n 1)) (fib (- n 2)))))

