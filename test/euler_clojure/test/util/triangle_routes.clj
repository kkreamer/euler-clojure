(ns euler-clojure.test.util.triangle-routes
  (:use euler-clojure.util.triangle-routes
        clojure.test))

(deftest test-triangle-maximum-total
  (is (= 23 (triangle-maximum-total
             [[3]
              [7 4]
              [2 4 6]
              [8 5 9 3]]))))
