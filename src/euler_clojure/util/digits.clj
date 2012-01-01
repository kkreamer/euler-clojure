(ns euler-clojure.util.digits)

(defn digits [n]
  (let [radix 10]
    (reverse
     (map
      #(int (rem % radix))
      (take-while (complement zero?)
                  (iterate #(quot % radix)
                           n))))))

(defn sum-of-digits [n]
  (reduce +
          (digits n)))
