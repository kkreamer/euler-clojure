(ns euler-clojure.problems)

(defn partial-factorial [^Integer from ^Integer to]
  (reduce *
          (range (bigint from)
                 (bigint (inc to)))))

(defn factorial [^Integer n]
  (partial-factorial 1 n))

(defn binomial-coefficient [^Integer n ^Integer r]
  (/ (partial-factorial (- n (dec r)) n)
     (factorial r)))
             
(defn routes [^Integer size]
  (loop [acc 2
         loop-count 1]
    (if (= size loop-count)
      acc
      (let [r (dec size)
            n (+ r loop-count)]
        (recur (+ acc
                  (* 2 (binomial-coefficient n r)))
               (inc loop-count))))))

         
(defn problem-015 []
  (routes 20))
