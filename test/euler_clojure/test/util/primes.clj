(ns euler-clojure.test.util.primes
  (:use euler-clojure.util.primes
        clojure.test))

(deftest test-evenly-divisible?
  (is (evenly-divisible? 8 4))
  (is (not (evenly-divisible? 8 5)))
  (is (evenly-divisible? 7 1)))

(deftest test-prime?
  (is (prime? 17))
  (is (not (prime? 9))))

(deftest test-primes
  (is (= (take 8 (primes)) '(1 2 3 5 7 11 13 17)))
  (is (= (take 3 (take-nth 1000 (primes))) '(1 7919 17389))))
