(defn euler6 [my-range]
 (-
  (int
   (Math/pow
    (reduce + my-range)
    2))
  (reduce +
          (map
           #(int (Math/pow % 2))
           my-range))))
         

(println
 (euler6 (range 1 101)))
