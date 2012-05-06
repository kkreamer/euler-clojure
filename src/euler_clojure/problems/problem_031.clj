(ns euler-clojure.problems.problem-031
  (:use [euler-clojure.core :only [defproblem]]))

(defn coin-combos [^Integer total coins]
  (let [this-coin (first coins)]
    (if (= this-coin 1)
      (list total)
      (for [combo (range 0
                         (inc (int (/ total this-coin))))
            rest-combo (coin-combos (- total
                                       (* combo this-coin))
                                    (rest coins))]
        (flatten (list combo rest-combo))))))

(defproblem []
  (count
   (coin-combos 200
                '(200 100 50 20 10 5 2 1))))

