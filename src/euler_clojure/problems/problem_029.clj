(ns euler-clojure.problems.problem-029)

(defn problem-029 []
  (count
   (distinct
    (for [a (range 2 101)
          b (range 2 101)]
      (Math/pow a b)))))
