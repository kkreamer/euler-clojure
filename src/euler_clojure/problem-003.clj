(ns euler-clojure.problems
  (:use euler-clojure.util.primes))

(defn largest-prime-factor [val]
  (first
   (filter prime?
           (maybe-prime-factors-descending val))))

(defn euler-3 []
  (largest-prime-factor 600851475143))

