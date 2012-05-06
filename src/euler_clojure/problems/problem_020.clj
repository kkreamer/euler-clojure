(ns euler-clojure.problems.problem-020
  (:use euler-clojure.util.digits
        euler-clojure.util.factorial
        [euler-clojure.core :only [defproblem]]))

(defproblem []
  (sum-of-digits
   (factorial 100)))
  