(ns euler-clojure.problems.problem-003
  (:use euler-clojure.util.primes
        [euler-clojure.core :only [defproblem]]))

(defn largest-prime-factor [val]
  (first
   (filter
    (fn [n]
      (and (evenly-divisible? val n)
           (prime? n)))
    (range (sqrt-int val) 2 -1))))

(defproblem []
  (largest-prime-factor 600851475143))

