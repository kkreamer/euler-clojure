(ns euler-clojure.problems.problem-012
  (:use euler-clojure.util.divisors))

(defn triangle-number [n]
  (/ (* n (inc n)) 2))

(defn count-of-divisors [n]
  (count
   (divisors n)))

(defn problem-012 []
 (first
  (filter
   #(> (count-of-divisors %) 500)
   (map triangle-number (range 1 Double/POSITIVE_INFINITY)))))

  