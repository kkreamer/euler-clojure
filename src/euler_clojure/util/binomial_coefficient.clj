(ns euler-clojure.util.binomial-coefficient
  (:use euler-clojure.util.factorial))

(defn binomial-coefficient [^Integer n ^Integer r]
  (/ (partial-factorial (- n (dec r)) n)
     (factorial r)))
