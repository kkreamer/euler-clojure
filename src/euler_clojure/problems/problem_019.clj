(ns euler-clojure.problems.problem-019
  (:use [clj-time.core :only [date-time day-of-week]]))

(defn problem-019 []
  (count
   (filter
    #(= 7 (day-of-week %))
    (for [year (range 1901 (inc 2000))
          month (range 1 (inc 12))]
      (date-time year month)))))
  