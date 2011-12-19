(ns euler-clojure.problems
  (:use euler-clojure.util.primes))

(defn problem-007 []
 (nth (primes) 10001))
