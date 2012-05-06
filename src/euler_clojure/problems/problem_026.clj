(ns euler-clojure.problems.problem-026
  (:use [euler-clojure.core :only [defproblem]]))

(defn remainders-fn [^Integer divisor]
  (fn [dividends]
    (let [dividend (last dividends)]
      (conj dividends
            (rem (* 10 dividend) divisor)))))

(defn repeating-remainders [^Integer divisor]
  (first
   (filter seq
           (map
            (fn [coll]
              (let [repeating-val (last coll)]
                (if (zero? repeating-val)
                  (list 0)
                  (drop-while #(not= % repeating-val)
                              (drop-last coll)))))
            (iterate (remainders-fn divisor) [1])))))

(defn count-repeating-remainders [^Integer divisor]
  (let [remainders (repeating-remainders divisor)]
    (if (= '(0) remainders)
      0
      (count remainders))))

(defproblem []
  (first
   (reduce
    (fn [a b]
      (if (> (last a) (last b)) a b))
    (map
     (fn [n]
       (list n (count-repeating-remainders n)))
     (range 1 1001)))))