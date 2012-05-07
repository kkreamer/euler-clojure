(ns euler-clojure.core
  (:use [clojopts.core :only [clojopts with-arg]]))

(def problem-fn-name 'answer)

(defn fatal-error
  ([] (System/exit -1))
  ([^String msg]
     (binding [*out* *err*]
       (println msg))
     (fatal-error)))

(defn parse-options [args]
  (try
    (clojopts "euler-clojure"
              args
              (with-arg problem p "Problem number"))
    (catch IllegalArgumentException ex
      (fatal-error)))) ; clojopts prints its own error messages

(defn problem-fn [^Integer number]
  (try 
    (let [ns-name (str "euler-clojure.problems.problem-" (format "%03d" number))
          fn-name (symbol (str ns-name "/" problem-fn-name))
          _ (require (symbol ns-name))
          fun (resolve fn-name)]
      (if (nil? fun)
        (fatal-error (str "ERROR: Could not find answer for problem " number)))
      fun)
    (catch java.io.FileNotFoundException ex
      (fatal-error (str "ERROR: Could not resolve answer for problem " number)))))      

(defn run [{number :problem args :clojopts/more}]
  (apply (problem-fn number) args))

(defmacro defproblem [& body]
  `(defn ~problem-fn-name [& args#]
     (time
      (println
       (apply (fn ~@body) args#)))))
                
(defn -main [& args]
  (-> args parse-options run))

