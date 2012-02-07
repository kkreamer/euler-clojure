(ns euler-clojure.problems.problem-033)

(defn problem-033 []
  (denominator
   (reduce *
           (for [a (range 1 10)
                 b (range 1 10)
                 c (range 1 10)
                 :let [frac (/
                             (+ (* 10 a) b)
                             (+ (* 10 b) c))]
                 :when (and
                        (< frac 1)
                        (= frac
                           (/ a c)))]
             frac))))
