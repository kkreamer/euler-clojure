(ns euler-clojure.problems.problem-017
  (:use [euler-clojure.core :only [defproblem]]))

;; Yes, this is ugly, but English is not regular.
(defn number-words [^Integer n]
  (cond
   (= n 0) "zero"
   (= n 1) "one"
   (= n 2) "two"
   (= n 3) "three"
   (= n 4) "four"
   (= n 5) "five"
   (= n 6) "six"
   (= n 7) "seven"
   (= n 8) "eight"
   (= n 9) "nine"
   (= n 10) "ten"
   (= n 11) "eleven"
   (= n 12) "twelve"
   (= n 13) "thirteen"
   (= n 15) "fifteen"
   (= n 18) "eighteen"
   (< n 20) (str (number-words (rem n 10)) "teen")   
   (= n 20) "twenty"
   (= n 30) "thirty"
   (= n 40) "forty"
   (= n 50) "fifty"
   (= n 80) "eighty"
   (< n 100) (if (zero? (rem n 10))
               (str (number-words (quot n 10)) "ty")
               (str (number-words (* 10 (quot n 10)))
                    "-"
                    (number-words (rem n 10)))) 
   (< n 1000) (if (zero? (rem n 100))
                (str (number-words (quot n 100)) " hundred")
                (str (number-words (* 100 (quot n 100)))
                     " and "
                     (number-words (rem n 100))))
   (= n 1000) "one thousand"
   :else (throw (IllegalArgumentException. (str "number-words not implemented for "
                                                n
                                                ". Allowable range is 1 to 1000.")))))
                 
(defproblem []
  (reduce +
          (map
           (fn [n]
             (count
              (re-seq #"[a-zA-Z]"
                      (number-words n))))
           (range 1 (inc 1000)))))

