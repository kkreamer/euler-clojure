(ns euler-clojure.problems.problem-028)

(defn square [^Integer n]
  (* n n))

(defn problem-028 []
  (inc
   (reduce +
           (map
            (fn [n]
              (+
               (* 10 (dec n))
               (* 4 (square (- n 2)))))
            (filter odd?
                    (range 2 1002))))))