(ns euler-clojure.problems.problem-007
  (:use [euler-clojure.core :only [defproblem]]
        euler-clojure.util.primes))

(defproblem []
 (nth (primes) 10001))
