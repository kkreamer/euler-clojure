(ns euler-clojure.problems.problem-010
  (:use euler-clojure.util.primes
        [euler-clojure.core :only [defproblem]]))

(defn sum-of-primes-below [ceiling]
 (reduce +
         (take-while
          #(< % ceiling)
          (primes))))

(defproblem []
 (sum-of-primes-below 2000000))

