(ns euler-clojure.util.primes)

(defn sqrt-int [val]
  (Math/round 
   (Math/sqrt val)))

(defn evenly-divisible? [val divisor]
  (= 0 (mod val divisor)))

(defn maybe-prime-factors-descending [val]
  (filter
   #(evenly-divisible? val %)
   (range (sqrt-int val) 0 -1)))

(defn prime? [val]
  (= 1
     (first
      (maybe-prime-factors-descending val))))

(defn primes []
  (filter prime? (range)))
