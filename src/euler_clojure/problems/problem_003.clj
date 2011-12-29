(ns euler-clojure.problems.problem-003
  (:use euler-clojure.util.primes))

(defn largest-prime-factor [val]
  (first
   (filter prime?
           (maybe-prime-factors-descending val))))

(defn problem-003 []
  (largest-prime-factor 600851475143))

