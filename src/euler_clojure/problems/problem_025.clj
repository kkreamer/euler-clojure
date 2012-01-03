(ns euler-clojure.problems.problem-025)

(defn fibonacci []
  (map last
       (iterate
        (fn [vals]
          (list (last vals)
                (+ (first vals)
                   (last vals))))
        '(0N 1N))))

(defn problem-025 []
  (inc
   (count
    (take-while #(< (count (str %)) 1000)
                (fibonacci)))))
                 