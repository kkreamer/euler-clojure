(defn next-fibonacci [vals]
  (list (last vals) 
        (+ (first vals)
           (last vals))))

(defn fibonacci-sum [func limit]
 (reduce +
         (filter func
                 (take-while
                  (fn [item]              
                      (< item limit))
                  (map last
                       (iterate next-fibonacci '(1 1)))))))

(println
 (fibonacci-sum even? 4000000))
