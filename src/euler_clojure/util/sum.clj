(ns euler-clojure.util.sum)

(defn sum [coll]
  (if (or (seq? coll)
          (vector? coll))
    (reduce + coll)
    coll))

