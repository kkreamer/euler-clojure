(ns euler-clojure.problems.problem-016
  (:use [clojure.math.numeric-tower :only [expt]]
        euler-clojure.util.digits))

(defn problem-016 []
  (sum-of-digits
   (expt 2 1000)))
   