(ns euler-clojure.problems.problem-025
  (:use [euler-clojure.core :only [defproblem]]))

(defn fibonacci []
  (map last
       (iterate
        (fn [vals]
          (list (last vals)
                (+ (first vals)
                   (last vals))))
        '(0N 1N))))

(defproblem []
  (inc
   (count
    (take-while #(< (count (str %)) 1000)
                (fibonacci)))))
                 