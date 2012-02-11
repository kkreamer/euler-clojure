(ns euler-clojure.problems.problem-036)

(defn palindrome? [^String val]
  (= val
     (apply str (reverse val))))

(defn problem-036 []
  (reduce +
          (filter
           (fn [n]
             (and (palindrome? (Integer/toString n 2))
                  (palindrome? (Integer/toString n 10))))
           (range 1 (inc 1000000)))))