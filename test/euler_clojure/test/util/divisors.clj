(ns euler-clojure.test.util.divisors
  (:use euler-clojure.util.divisors
        clojure.test))

(deftest test-divisors
  (is (= (divisors 6) '(1 2 3 6)))
  (is (= (divisors 1) '(1)))
  (is (= (divisors 13) '(1 13))))

