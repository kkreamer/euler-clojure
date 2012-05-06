(ns euler-clojure.problems.problem-028
  (:use [euler-clojure.core :only [defproblem]]))

(defn square [^Integer n]
  (* n n))

(defproblem []
  (inc
   (reduce +
           (map
            (fn [n]
              (+
               (* 10 (dec n))
               (* 4 (square (- n 2)))))
            (filter odd?
                    (range 2 1002))))))