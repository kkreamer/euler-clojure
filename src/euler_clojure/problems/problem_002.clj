(ns euler-clojure.problems.problem-002
  (:use [euler-clojure.core :only [defproblem]]
        euler-clojure.util.sum))

(defn next-fibonacci [[a b]]
  (vector b (+ a b)))

(defn fibonacci []
  (map last
       (iterate next-fibonacci [1 1])))

(defn while-below [limit coll]
  (take-while #(< % limit) coll))

(defproblem []
  (sum (filter even? (while-below 4000000 (fibonacci)))))

