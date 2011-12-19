(ns euler-clojure.problems
  (:use euler-clojure.util.primes))

(defn sum-of-primes-below [ceiling]
 (reduce +
         (take-while
          #(< % ceiling)
          (primes))))

(defn problem-010 []
 (sum-of-primes-below 2000000))

