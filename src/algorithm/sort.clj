(ns algorithm.sort)

(defn ^:private sm [s1 s2]
  (if (some empty? [s1 s2])
    (if (empty? s1) s2 s1)
    (let [[xs1 xs2] (if (<= (first s1) (first s2)) [s1 s2] [s2 s1])]
      (cons (first xs1) (sm (rest xs1) xs2)))))

(defn ^:private halves [s]
   (let [mid (int (/ (count s) 2))]
     (split-at mid s)))


; Source: http://academicearth.org/courses/introduction-to-algorithms/
; Theta(n*lg(n))
;
; Execution time mean : 8.345478 ms
;     Execution time std-deviation : 238.976425 µs
;    Execution time lower quantile : 7.865005 ms ( 2.5%)
;    Execution time upper quantile : 8.796605 ms (97.5%)
;                    Overhead used : 2.919222 ns
; 
; Found 1 outliers in 60 samples (1.6667 %)

(defn merge-sort [s]
  (if (<= (count s) 1)
    s
    (let [[left right] (halves s)]
      (sm (merge-sort left) (merge-sort right)))))

; Source: http://academicearth.org/courses/introduction-to-algorithms/
; Theta(log(n))
; Though binary-sort itself is log(n), group-by function is probably slower than that.
;
;              Execution time mean : 3.905761 ms
;     Execution time std-deviation : 205.126521 µs
;    Execution time lower quantile : 3.760365 ms ( 2.5%)
;    Execution time upper quantile : 4.539937 ms (97.5%)
;                    Overhead used : 3.038231 ns
; 
; Found 5 outliers in 60 samples (8.3333 %)
; 	low-severe	 5 (8.3333 %)
;  Variance from outliers : 38.4894 % Variance is moderately inflated by outliers

(defn binary-sort [s]
  (if (empty? s) 
    s
    (let [mid (first s)
          [left right]
          (vals (group-by (partial >= mid) (rest s)))]
      (concat (binary-sort left) [mid] (binary-sort right)))))

