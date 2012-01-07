(ns euler-clojure.problems.problem-023
  (:use euler-clojure.util.divisors
        [clojure.set :only [difference]]))

(defn abundant? [n]
  (> (reduce +
             (non-self-divisors n))
     n))


(defn abundant-numbers [from to]
  (filter abundant?
          (range from (inc to))))

(defn sum-of-two-abundant-numbers []
  (let [numbers (abundant-numbers 12 28123)]
    (set
     (for [a numbers
           b numbers]
       (+ a b)))))

(defn not-sum-of-two-abundant-numbers []
  (difference (set
               (range 1
                      (inc 28123)))
              (sum-of-two-abundant-numbers)))
  
(defn problem-023 []
  (reduce +
          (not-sum-of-two-abundant-numbers)))

