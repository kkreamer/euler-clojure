(ns euler-clojure.test.util.binomial-coefficient
  (:use euler-clojure.util.binomial-coefficient
        clojure.test))

(deftest test-binomial-coefficient
  (is (= 5 (binomial-coefficient 5 4)))
  (is (= 10 (binomial-coefficient 5 2))))

