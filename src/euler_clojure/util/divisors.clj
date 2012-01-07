(ns euler-clojure.util.divisors
  (:use [euler-clojure.util.primes :only [sqrt-int]]))

(defn- divisor-groups [n]
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

(defn non-self-divisors [n]
  (filter #(not= n %)
          (divisors n)))
