(ns euler-clojure.problems.problem-036
  (:use [euler-clojure.core :only [defproblem]]))

(defn palindrome? [^String val]
  (= val
     (apply str (reverse val))))

(defproblem []
  (reduce +
          (filter
           (fn [n]
             (and (palindrome? (Integer/toString n 2))
                  (palindrome? (Integer/toString n 10))))
           (range 1 (inc 1000000)))))