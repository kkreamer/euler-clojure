(ns euler-clojure.problems.problem-005
  (:use [euler-clojure.core :only [defproblem]]
        euler-clojure.util.primes))

(defn next-factor [val]
  (first
   (filter
    #(evenly-divisible? val %)
    (concat 
     (range 2 
            (inc 
             (sqrt-int val))) 
     (list val)))))

(defn prime-factors [val]
  (loop 
   [my-val val
   factors '()]
   (if (= 1 my-val)
       factors
     (recur
      (/ my-val (next-factor my-val))
      (concat factors
              (list (next-factor my-val)))))))

(defn min-with-factors-in-range [start end]
 (reduce *
         (map
          (fn [map-entry]
              (int
               (Math/pow
                (key map-entry)
                (val map-entry))))
          (reduce
           #(merge-with max %1 %2)
           (map frequencies
                (map prime-factors
                     (range end start -1)))))))

(defproblem []
 (min-with-factors-in-range 1 20))

