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
; Average Theta(n log(n)), worst case Theta(n^2). The worst case happens when the sequence is already sorted or reverse-sorted.
; Quick sort is a very good sorting algorithm, which works also nice with caching.
; However it requires some tuings, e.g. selecting random pivots and applying another sorting algorithms when sub-devided sequence is shorter than 5 elements.
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

(defn quick-sort [s]
  (if (empty? s) 
    s
    (let [mid (first s)
          [left right]
          (vals (group-by (partial >= mid) (rest s)))]
      (concat (quick-sort left) [mid] (quick-sort right)))))

; TODOs
; Below two are both linear time Theta(n) with some assumptions.
;
; Couting sort (Good for substantially small ks)
; Pseudo code
; for i <- 1 to k
;   do C[i] <- 0
;   for i <- 1 to n
;     do C[A[j]] <- C[A[j]] + 1
;   for i 1 <- 1 to k
;     do C[i] <- C[i] + C[i + 1]
;   for j <- n downto 1
;     do B[c[A[i]]] <- A[j]
;        C[A[j]] <- C[A[j]] - 1
;
; Redix sort
;
; More advanced sort algorithm can achieve expected time O(n sqrt(lg lg n)) and worst case O(n lg lg n)
