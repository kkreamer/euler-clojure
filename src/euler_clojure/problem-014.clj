(defn collatz-chain [starting-value]
  (loop [n starting-value
         acc '()]
    (if (= 1 n)
      (reverse (conj acc n))
      (if (even? n)
        (recur (/ n 2) (conj acc n))
        (recur (+ 1 (* 3 n)) (conj acc n))))))

(println
 (reduce
  (fn [list-a list-b]
    (if (> (last list-a) (last list-b))
      list-a
      list-b))
  (map
   (fn [n]
     (list n (count (collatz-chain n))))
   (range 1 1000001))))