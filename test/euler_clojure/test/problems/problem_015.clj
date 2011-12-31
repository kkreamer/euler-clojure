(ns euler-clojure.test.problems.problem-015
  (:use euler-clojure.problems.problem-015
        clojure.test))

(deftest test-routes
  (is (= 2 (routes 1)))
  (is (= 6 (routes 2)))
  (is (= 20 (routes 3)))
  (is (= 70 (routes 4)))
  (is (= 252 (routes 5)))
  (is (= 924 (routes 6)))
  (is (= 184756 (routes 10))))