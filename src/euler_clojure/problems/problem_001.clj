(ns euler-clojure.problems.problem-001
  (:use [euler-clojure.core :only [defproblem]]
        [euler-clojure.util.primes :only [evenly-divisible?]]))

(defmacro evenly-divisible-by-any-of? [numerators]
  `(fn [~'denom]
     (or ~@(for [num# numerators]
             `(evenly-divisible? ~'denom ~num#)))))

(defn sum [coll]
  (if (or (seq? coll)
          (vector? coll))
    (reduce + coll)
    coll))

(defproblem []
  (sum
   (filter
    (evenly-divisible-by-any-of? [3 5])
    (range 1 1000))))

