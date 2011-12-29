(ns euler-clojure.test.problems.problem-015
  (:use [euler-clojure.problems.problem-015])
  (:use [clojure.test]))

(deftest test-factorial
  (is (= 1 (factorial 0)))
  (is (= 6 (factorial 3)))
  (is (= 24 (factorial 4)))
  (is (= 3628800 (factorial 10))))

(deftest test-binomial-coefficient
  (is (= 5 (binomial-coefficient 5 4)))
  (is (= 10 (binomial-coefficient 5 2))))

(deftest test-routes
  (is (= 2 (routes 1)))
  (is (= 6 (routes 2)))
  (is (= 20 (routes 3)))
  (is (= 70 (routes 4)))
  (is (= 252 (routes 5)))
  (is (= 924 (routes 6)))
  (is (= 184756 (routes 10))))