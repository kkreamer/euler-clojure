(ns euler-clojure.test.problems.problem-021
  (:use euler-clojure.problems.problem-021
        clojure.test))

(deftest test-amicable-number?
  (is (amicable-number? 220))
  (is (amicable-number? 284))
  (is (not (amicable-number? 31))))
