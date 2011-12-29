(ns euler-clojure.test.problems.problem-004
  (:use euler-clojure.problems.problem-004
        clojure.test))

(deftest test-palindrome?
  (is (palindrome? 14341))
  (is (not (palindrome? 123)))
  (is (palindrome? 4)))