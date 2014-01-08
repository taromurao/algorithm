(ns algorithm.sort)

(defn ^:private sm [s1 s2]
  (if (some empty? [s1 s2])
    (if (empty? s1) s2 s1)
    (let [[xs1 xs2] (if (<= (compare (first s1) (first s2)) 0) [s1 s2] [s2 s1])]
      (cons (first xs1) (sm (rest xs1) xs2)))))

(defn ^:private halves [s]
   (let [mid (int (/ (count s) 2))]
     (split-at mid s)))

; Source: http://academicearth.org/courses/introduction-to-algorithms/
; Theta(n*lg(n))
(defn merge-sort [s]
  (if (<= (count s) 1)
    s
    (let [[left right] (lazy-seq (halves s))]
      (sm (merge-sort left) (merge-sort right)))))

; Source: http://academicearth.org/courses/introduction-to-algorithms/
; Theta(log(n))
(defn binary-sort [s]
  (if (empty? s) 
    s
    (let [mid (first s)
          [left right]
          ((juxt filter remove) (partial >= mid) (rest s))]
      (concat (binary-sort left) [mid] (binary-sort right)))))

(time (merge-sort [3 2 1]))
