(ns euler-clojure.problems.problem-001
  (:use [euler-clojure.core :only [defproblem]]))

(defproblem []
  (reduce +
          (filter
           (fn [item]
             (or (= (mod item 5) 0)
                 (= (mod item 3) 0)))
           (range 1000))))

