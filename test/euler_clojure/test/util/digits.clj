(ns euler-clojure.test.util.digits
  (:use euler-clojure.util.digits
        clojure.test))

(deftest test-digits
  (is (= (digits 1) '(1)))
  (is (= (digits 16804500) '(1 6 8 0 4 5 0 0))))

(deftest test-sum-of-digits
  (is (= (sum-of-digits 1) 1))
  (is (= (sum-of-digits 13579) 25)))

