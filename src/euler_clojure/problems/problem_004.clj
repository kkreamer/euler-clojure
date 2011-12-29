(ns euler-clojure.problems.problem-004)

(defn palindrome? [val]
  (= 
   (str val)
   (apply str
          (reverse 
           (str val)))))

(defn x-digit-numbers-descending [digits]
  (range 
   (-
    (Math/round    
     (Math/pow 10 digits))
    1)
   (-
    (Math/round
     (Math/pow 10
               (- digits 1)))
    1)
   -1))

(defn largest-palindrome [digits]
  (apply max
   (filter
    palindrome?
    (for
     [a (x-digit-numbers-descending digits) 
      b (x-digit-numbers-descending digits)]
      (* a b)))))

(defn problem-004 []
  (largest-palindrome 3))
