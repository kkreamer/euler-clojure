(ns euler-clojure.problems.problem-015
  (:use euler-clojure.util.binomial-coefficient
        [euler-clojure.core :only [defproblem]]))
             
(defn routes [^Integer size]
  (loop [acc 2
         loop-count 1]
    (if (= size loop-count)
      acc
      (let [r (dec size)
            n (+ r loop-count)]
        (recur (+ acc
                  (* 2 (binomial-coefficient n r)))
               (inc loop-count))))))

         
(defproblem []
  (routes 20))
