(ns euler-clojure.problems.problem-037
  (:use euler-clojure.util.digits
        euler-clojure.util.primes
        [euler-clojure.core :only [defproblem]]))

(defn truncate-with [f]
  (fn [^Integer val]
    (let [truncated-digits (f (digits val))]
      (if (empty? truncated-digits)
        0
        (Integer. (apply str truncated-digits))))))

(defn truncatable-with? [f ^Integer val]
  ;; this is a bit confusing... if none of the values are not prime
  ;; then that means that they all must be prime, hence truncatable.
  (not-any? (complement prime?)
            ;; reversing the array is an optimization: it's cheaper
            ;; to determine if a single digit is prime versus a
            ;; larger number.           
            (reverse 
             (take-while (complement zero?)
                         (iterate (truncate-with f) val)))))
    
(defn truncatable? [^Integer val]
  ;; according the problem description, 2, 3, 5, and 7 are not truncatable
  (and (< 10 val) 
       (truncatable-with? rest val)
       (truncatable-with? butlast val)))

(defproblem []
  (reduce +
          (take 11 ;; problem description states there are 11 such primes
                (filter truncatable? (primes)))))


