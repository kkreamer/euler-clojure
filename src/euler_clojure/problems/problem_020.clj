(ns euler-clojure.problems.problem-020
  (:use euler-clojure.util.digits
        euler-clojure.util.factorial))

(defn problem-020 []
  (sum-of-digits
   (factorial 100)))
  