(ns algorithm.sort)

(defn ^:private sm [s1 s2]
  (if (some empty? [s1 s2])
    (if (empty? s1) s2 s1)
    (let [[xs1 xs2] (if (<= (compare (first s1) (first s2)) 0) [s1 s2] [s2 s1])]
      (cons (first xs1) (sm (rest xs1) xs2)))))

; Theta (n*lg(n))
(defn merge-sort [s]
  (if (<= (count s) 1)
    s
    (let [mid (int (/ (count s) 2))
          left (take mid s)
          right (drop mid s)]
      (sm (merge-sort left) (merge-sort right)))))

(merge-sort [3 2 4 1])
(merge-sort `(3 2 4 1))
(merge-sort [:c :b :a])
(merge-sort ["hello" "Dolly"])
