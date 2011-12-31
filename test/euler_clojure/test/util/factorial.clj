(ns euler-clojure.test.util.factorial
  (:use euler-clojure.util.factorial
        clojure.test))

(deftest test-partial-factorial
  (is (= 20160 (partial-factorial 3 8)))
  (is (= 1 (partial-factorial 1 1))))

(deftest test-factorial
  (is (= (factorial 0) 1))
  (is (= (factorial 1) 1))
  (is (= (factorial 3) 6))
  (is (= (factorial 4) 24))
  (is (= (factorial 10) 3628800))
  (is (= (factorial 50)
         30414093201713378043612608166064768844377641568960512000000000000N)))
