(defn iter [vals]
  (list (last vals) 
        (+ (first vals)
           (last vals))))

(println
 (reduce +
         (filter even?
                 (take-while
                  (fn [item]              
                      (< item 4000000))
                  (map last
                       (iterate iter '(0 1)))))))
