(ns euler-clojure.problems.problem-025
  (:use [euler-clojure.core :only [defproblem]]
        euler-clojure.util.fibonacci))

(defproblem []
  (inc
   (count
    (take-while #(< (count (str %)) 1000)
                (fibonacci [0N 1N])))))
                 