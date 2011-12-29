(ns euler-clojure.problems.problem-007
  (:use euler-clojure.util.primes))

(defn problem-007 []
 (nth (primes) 10001))
