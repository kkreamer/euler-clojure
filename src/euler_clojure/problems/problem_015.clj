(ns euler-clojure.problems.problem-015
  (:use euler-clojure.util.binomial-coefficient))
             
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

         
(defn problem-015 []
  (routes 20))
