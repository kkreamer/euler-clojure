(ns euler-clojure.test.problems.problem-018
  (:use euler-clojure.problems.problem-018
        clojure.test))

(deftest test-triangle-maximum-total
  (is (= 23 (triangle-maximum-total
             [[3]
              [7 4]
              [2 4 6]
              [8 5 9 3]]))))
