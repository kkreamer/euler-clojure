(ns euler-clojure.problems.problem-003
  (:use euler-clojure.util.primes))

(defn largest-prime-factor [val]
  (first
   (filter
    (fn [n]
      (and (evenly-divisible? val n)
           (prime? n)))
    (range (sqrt-int val) 2 -1))))

(defn problem-003 []
  (largest-prime-factor 600851475143))

