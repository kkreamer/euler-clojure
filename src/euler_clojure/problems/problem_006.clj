(ns euler-clojure.problems.problem-006
    (:use [euler-clojure.core :only [defproblem]]))

(defn difference-sum-and-squares [my-range]
 (-
  (int
   (Math/pow
    (reduce + my-range)
    2))
  (reduce +
          (map
           #(int (Math/pow % 2))
           my-range))))
         

(defproblem []
 (difference-sum-and-squares (range 1 101)))
