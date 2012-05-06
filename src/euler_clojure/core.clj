(ns euler-clojure.core
  (:use [clojopts.core :only [clojopts with-arg]]))

(def PROBLEM-FN 'answer)

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

(defn problem-ns [^Integer number]
  (symbol (str "euler-clojure.problems.problem-" (format "%03d" number))))

(defn resolve-problem-fn [^Integer number]
  (do
    (try
      (use (problem-ns number))
      (catch java.io.FileNotFoundException ex
        (fatal-error (str "ERROR: Could not find namespace for problem " number))))
    (resolve PROBLEM-FN)))

(defn problem-fn [^Integer number]
  (let [fun (resolve-problem-fn number)]
    (if (nil? fun)
      (fatal-error (str "ERROR: Could not find answer for problem " number)))
    fun))  

(defn run [{number :problem args :clojopts/more}]
  (apply (problem-fn number) args))

(defmacro defproblem [& body]
  `(defn ~PROBLEM-FN [& args#]
     (time
      (println
       (apply (fn ~@body) args#)))))
                
(defn -main [& args]
  (-> args parse-options run))

