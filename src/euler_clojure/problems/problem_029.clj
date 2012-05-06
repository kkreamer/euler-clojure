(ns euler-clojure.problems.problem-029
  (:use [euler-clojure.core :only [defproblem]]))

(defproblem []
  (count
   (distinct
    (for [a (range 2 101)
          b (range 2 101)]
      (Math/pow a b)))))
