(ns euler-clojure.problems.problem-030
  (:use euler-clojure.util.digits
        [euler-clojure.core :only [defproblem]]))

(defn sum-of-powers? [^Integer sum ^Integer power]
  (= sum
     (int
      (reduce +
              (map
               #(bigint (Math/pow % power))
               (digits sum))))))

;;
;; 354294 = 6 * 9^5, so that's the max that
;; can possibly be an answer.
;;
(defproblem []
  (reduce +
          (filter
           (fn [n]
             (sum-of-powers? n 5))
           (range 2 354294))))
