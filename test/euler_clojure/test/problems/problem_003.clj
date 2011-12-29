(ns euler-clojure.test.problems.problem-003
  (:use euler-clojure.problems.problem-003
        clojure.test))

(deftest test-largest-prime-factor
  (is (= 29 (largest-prime-factor 13195))))