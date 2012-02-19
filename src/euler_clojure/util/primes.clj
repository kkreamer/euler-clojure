(ns euler-clojure.util.primes)

(defn sqrt-int [val]
  (Math/round (Math/sqrt val)))

(defn evenly-divisible? [val divisor]
  (zero? (mod val divisor)))

(defn factors
  ([val] (factors val (range 1 (inc val))))
  ([val possible-factors]
     (filter #(evenly-divisible? val %) possible-factors)))

(declare primes)

(defn prime?
  ([val] (prime? val (primes)))
  ([val previous-primes]
     (let [max-factor (inc (sqrt-int val))]
       (and (> val 1)
            (empty? (factors val
                             (take-while #(< % max-factor)
                                         previous-primes)))))))

(defn- next-prime [memory]
  (let [last-prime (first memory)
        previous-primes (second memory)
        prime (first (filter #(prime? % previous-primes)
                             (range (inc last-prime)
                                    Double/POSITIVE_INFINITY)))]
    (vector prime
            (conj previous-primes prime))))

(defn primes []
  (map first (iterate next-prime [2 [2]])))