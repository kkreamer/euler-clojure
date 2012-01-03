(ns euler-clojure.problems.problem-024
  (:use euler-clojure.util.factorial))

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

(defn problem-024 []
  (nth-permutation 1000000))

