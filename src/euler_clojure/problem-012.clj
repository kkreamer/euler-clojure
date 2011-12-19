(ns euler-clojure.problems
  (:use euler-clojure.util.primes))

(defn triangle-number [n]
  (/ (* n (inc n)) 2))

(defn divisor-groups [n]
  (filter
   #(integer? (last %))
   (map
    #(list % (/ n %))
    (range 1
           (inc (sqrt-int n))))))
  
(defn divisors [n]
  (distinct
   (sort
    (flatten
     (divisor-groups n)))))

(defn count-of-divisors [n]
  (count
   (divisors n)))

(defn problem-012 []
 (first
  (filter
   #(> (count-of-divisors %) 500)
   (map triangle-number (range 1 Double/POSITIVE_INFINITY)))))

  