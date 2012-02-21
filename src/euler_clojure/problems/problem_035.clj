(ns euler-clojure.problems.problem-035
  (:use euler-clojure.util.primes
        euler-clojure.util.digits))

(defn- rotate [coll]
  (flatten (list (rest coll)
                 (first coll))))

(defn- rotations [coll]  
  (map collapse-digits         
       (take (count coll)
             (iterate rotate coll))))

(defn- circular-prime? [coll]
  (and (or (= 1 (count coll))
           (not (some #{0 2 4 5 6 8} coll)))
       (every? prime? (rotations coll))))
       
(defn- circular-primes [max-value]
  (map collapse-digits
       (filter circular-prime?
               (map digits
                    (take-while #(< % max-value)
                                (primes))))))

(defn problem-035 []
  (count (circular-primes 1000000)))

