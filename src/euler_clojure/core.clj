(ns euler-clojure.core
  (:use [clojopts.core :only [clojopts with-arg]]
        euler-clojure.problems))

(defn parse-options [args]
  (clojopts "euler-clojure"
            args
            (with-arg problem p "Problem number")))

(defn problem-number [args]
  (get (parse-options args) :problem))

(defn resolve-problem [args]
  (str "problem-"
       (format "%03d" (problem-number args))))

(defn fatal-error [^String msg]
  (println msg)
  (System/exit -1))

(defn run-problem [^String fn-name & args]
  (let [fun (ns-resolve 'euler-clojure.problems (symbol fn-name))]
    (if (nil? fun)
      (fatal-error 
       (str "ERROR: Could not find " fn-name))
      (apply fun args))))
  
(defn run [args]
  (try
    (run-problem (resolve-problem args))
    (catch IllegalArgumentException ex
      (fatal-error "ERROR: Could not find requested problem"))))

(defn -main [& args]
  (println
   (run args)))

