(ns euler-clojure.problems.problem-024
  (:use euler-clojure.util.factorial
        [euler-clojure.core :only [defproblem]]))

(defn nth-permutation [n]
  (loop [permutations-left (dec n)
         acc ""
         digits (range 0 10)]
     (if (empty? digits)
      acc
      (let [permutations (factorial (dec (count digits)))
            this-digit (nth digits
                          (quot permutations-left
                                permutations))]
        (recur (rem permutations-left
                    permutations)
               (str acc this-digit)
               (filter #(not= % this-digit) digits))))))

(defproblem []
  (nth-permutation 1000000))

