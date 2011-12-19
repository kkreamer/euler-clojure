(ns euler-clojure.problems)

(defn problem-001 []
  (reduce +
          (filter
           (fn [item]
             (or (= (mod item 5) 0)
                 (= (mod item 3) 0)))
           (range 1000))))