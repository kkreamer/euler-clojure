(ns euler-clojure.problems.problem-016
  (:use [clojure.math.numeric-tower :only [expt]]
        euler-clojure.util.digits
        [euler-clojure.core :only [defproblem]]))

(defproblem []
  (sum-of-digits
   (expt 2 1000)))
   