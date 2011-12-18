(ns euler-clojure.problems)

(defn sqrt-int [val]
  (Math/round 
   (Math/sqrt val)))

(defn evenly-divisible [val divisor]
  (= 0 (mod val divisor)))

(defn maybe-prime-factors-descending [val]
  (filter
   #(evenly-divisible val %)
   (range (sqrt-int val) 0 -1)))

(defn prime? [val]
  (= 1
     (first
      (maybe-prime-factors-descending val))))

(defn largest-prime-factor [val]
  (first
   (filter prime?
           (maybe-prime-factors-descending val))))

(defn euler-3 []
 (largest-prime-factor 600851475143))

;; (println
;;  (largest-prime-factor 13195)) 
