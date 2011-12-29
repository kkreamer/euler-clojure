(ns euler-clojure.problems.problem-009)

(defn pythagorean-triplet? [a b c]
  (= (double c)     
     (Math/sqrt
      (+ (* a a)
         (* b b)))))

(defn answer? [a b c total]
  (and (pythagorean-triplet? a b c)
       (= total
          (+ a b c))))

(defn problem-009 []
 (for [c (range 1001)
       b (range
          (- 1001
             c))
       a (range
          (- 1001
             (+ b c)))
       :when (and
              (> c b)
              (> b a)
              (answer? a b c 1000))]
   (* a b c)))
