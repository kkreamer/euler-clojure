(ns euler-clojure.util.primes)

(defn sqrt-int [val]
  (Math/round 
   (Math/sqrt val)))

(defn evenly-divisible? [val divisor]
  (zero? (mod val divisor)))

(defn maybe-prime-factors-descending [val]
  (filter
   #(evenly-divisible? val %)
   (range (sqrt-int val) 0 -1)))

(defn prime? [val]
  (and (not= 1 val)
       (= 1
          (first
           (maybe-prime-factors-descending val)))))

(defn primes []
  (filter prime?
          (flatten
           (list 2
                 (range 3 Double/POSITIVE_INFINITY 2)))))
