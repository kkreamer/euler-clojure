(ns euler-clojure.problems.problem-021
  (:use euler-clojure.util.divisors
        [euler-clojure.core :only [defproblem]]))

(defn sum-of-divisors [n]
  (reduce +
          (rest
           (reverse
            (divisors n)))))

(defn amicable-number? [n]
  (let [b (sum-of-divisors n)
        a (sum-of-divisors b)]
    (and (not= a b)
         (= n a))))

(defproblem []
  (reduce +
          (filter amicable-number?
                  (range 1 10000))))

