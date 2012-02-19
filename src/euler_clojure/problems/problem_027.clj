(ns euler-clojure.problems.problem-027
  (:use euler-clojure.util.primes))

(defn- quadratic-result [^Integer a ^Integer b ^Integer n]
  (+ (* n n) (* a n) b))
  
(defn- prime-coefficients [^Integer a ^Integer b]
  (count
   (take-while (comp prime? #(Math/abs %))
               (map (partial quadratic-result a b) (range)))))

(defn- max-primes [^Integer max-coefficient]
  (let [pr (take-while #(< % max-coefficient)
                       (primes))]
    (reduce
     (fn [x y]
       (if (> (get x :primes) (get y :primes)) x y))            
     (for [a (range (inc (* -1 max-coefficient)) max-coefficient)
           b pr]
       {:a a
        :b b
        :primes (prime-coefficients a b)}))))
  
(defn problem-027 []
  (max-primes 1000))