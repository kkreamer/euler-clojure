(ns euler-clojure.util.fibonacci)

(defn- next-fibonacci [[a b]]
  (vector b (+ a b)))

(defn fibonacci
  ([]
     (fibonacci [1 1]))
  ([starting-vals]
     (map last
          (iterate next-fibonacci starting-vals))))
  

