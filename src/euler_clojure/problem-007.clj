(ns euler-clojure.problems
  (:use euler-clojure.util.primes))

(defn euler-7 []
 (nth (primes) 10001))
