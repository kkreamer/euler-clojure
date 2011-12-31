(ns euler-clojure.util.factorial)

(defn partial-factorial [^Integer from ^Integer to]
  (reduce *
          (range (bigint from)
                 (bigint (inc to)))))

(defn factorial [^Integer n]
  (partial-factorial 1 n))
