(ns euler-clojure.core
  (:use [clojopts.core :only [clojopts with-arg]]))

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
  (binding [*out* *err*]
    (println msg))
  (System/exit -1))

(defn use-problem-ns [^String fn-name]
  (try
    (use (symbol (str "euler-clojure.problems" "." fn-name)))
    (catch java.io.FileNotFoundException ex
      (fatal-error 
       (str "ERROR: Could not find namespace for " fn-name)))))

(defn run-problem [^String fn-name]
  (use-problem-ns fn-name)
  (let [fun (resolve (symbol fn-name))]
    (if (nil? fun)
      (fatal-error
       (str "ERROR: Could not find function named " fn-name))
      (apply fun '()))))

(defn run [args]
  (try
    (run-problem (resolve-problem args))
    (catch IllegalArgumentException ex
      (fatal-error
       (str "ERROR: Could not find requested problem: "
            (. ex getMessage))))))

(defn -main [& args]
  (println
   (run args)))

