(ns euler-clojure.test.problems.problem-017
  (:use euler-clojure.problems.problem-017
        clojure.test))

(deftest test-number-words
  (is (= (number-words 0) "zero"))
  (is (= (number-words 7) "seven"))
  (is (= (number-words 13) "thirteen"))
  (is (= (number-words 17) "seventeen"))
  (is (= (number-words 21) "twenty-one"))
  (is (= (number-words 50) "fifty"))
  (is (= (number-words 60) "sixty"))
  (is (= (number-words 100) "one hundred"))
  (is (= (number-words 212) "two hundred and twelve"))
  (is (= (number-words 233) "two hundred and thirty-three"))
  (is (= (number-words 360) "three hundred and sixty"))
  (is (= (number-words 1000) "one thousand")))
