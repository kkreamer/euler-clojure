(ns euler-clojure.problems.problem-034
  (:use euler-clojure.util.digits
        euler-clojure.util.factorial))

(defn problem-034 []
  (let [factorials (vec
                    (map
                     (comp int factorial)
                     (range 0 10)))]
    (reduce +
            (filter
             (fn [n]
               (= n
                  (reduce +
                          (map #(get factorials %)
                               (digits n)))))
             ;; This range starts at three since the problem says that 1 and 2
             ;; not candidates, and ends where it does because 7 is where
             ;; (n * 9!) < (9 * 10^n + 9 * 10^(n-1) + ...)
             (range 3 2540160)))))
