(ns euler-clojure.problems
  (:use [clojure.math.numeric-tower :only [expt floor]]))

(defn sum-of-digits [n]
  (loop [x n
         acc 0]
    (if (< x 10)
      (+ acc x)
      (recur (floor (/ x 10))
             (+ acc (mod x 10))))))

(defn problem-016 []
  (sum-of-digits
   (expt 2 1000)))
   