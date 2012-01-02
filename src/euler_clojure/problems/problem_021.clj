(ns euler-clojure.problems.problem-021
  (:use euler-clojure.util.divisors))

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

(defn problem-021 []
  (reduce +
          (filter amicable-number?
                  (range 1 10000))))

