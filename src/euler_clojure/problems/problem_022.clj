(ns euler-clojure.problems.problem-022
  (:use [clojure.string :only [lower-case replace split] :rename {replace replace-str}]))

(defn- first-names [filename]
  (sort
   (map #(replace-str % "\"" "")
        (split (slurp filename)
               #","))))

(defn- name-value [name]
  (reduce +
          (map #(- (int %) (dec (int \a)))
               (seq (lower-case name)))))

(defn problem-022 [filename]
  (reduce +
          (map-indexed
           (fn [index item]
             (* (inc index) (name-value item)))
           (first-names filename))))
