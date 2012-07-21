(ns euler-clojure.problems.problem-002
  (:use [euler-clojure.core :only [defproblem]]
        euler-clojure.util.sum
        euler-clojure.util.fibonacci))

(defn while-below [limit coll]
  (take-while #(< % limit) coll))

(defproblem []
  (sum (filter even? (while-below 4000000 (fibonacci)))))

