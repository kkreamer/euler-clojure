(ns euler-clojure.problems.problem-048
  (:use clojure.math.numeric-tower))

(defn problem-048 []
  (mod
   (reduce +
           (map #(expt %1 %1)
                (range 1 (inc 1000))))
   (expt 10 10)))