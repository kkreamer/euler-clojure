(ns euler-clojure.util.triangle-routes)

(defn max-so-far [row index]
  (max
   (or (get row (dec index))
       0)
   (or (get row index)
       0)))

(defn by-row-summation [previous-row current-row]  
  (vec
   (map-indexed
    (fn [index item]
      (+ item
         (max-so-far previous-row index)))
    current-row)))

(defn triangle-maximum-total [triangle]
  (reduce max         
          (reduce by-row-summation triangle)))
