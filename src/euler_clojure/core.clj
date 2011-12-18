(ns euler-clojure.core
  (:use [clojopts.core :only [clojopts with-arg]]
        euler-clojure.problems))

(defn parse-options [args]
  (clojopts "euler-clojure"
            args
            (with-arg problem p "Problem number")))

(defn resolve-problem [args]
  (str "euler-"
       (get (parse-options args) :problem)))

(defn run-problem [^String fn-name & args]
  (let [fun (ns-resolve 'euler-clojure.problems (symbol fn-name))]
    (if (nil? fun)
      (str "ERROR: Could not find " fn-name)
      (apply fun args))))
  
(defn run [args]
  (run-problem (resolve-problem args)))

(defn -main [& args]
  (println
   (run args)))

