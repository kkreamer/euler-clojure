(ns euler-clojure.problems)

(defn append 
  ([] (lazy-seq nil))
  ([x] (lazy-seq x))
  ([x & ys]
     (concat x ys)))

(defn next-step-fn [^Integer width ^Integer height]
  (fn [route]
    (let [stop (last route)]
      (cond 
       (and (< (first stop) width)
            (< (last stop) height))
       (list
        (append route
                (list (inc (first stop))
                      (last stop)))
        (append route
                (list (first stop)
                      (inc (last stop)))))
       
       (< (first stop) width)
       (list
        (append route
                (list (inc (first stop))
                      (last stop))))
        
       (< (last stop) height)
       (list
        (append route
                (list (first stop)
                      (inc (last stop)))))))))

(defn all-routes [^Integer width ^Integer height]
  (let [route-fn (next-step-fn width height)]
    (loop [routes (route-fn '((0 0)))]
      (if (= (last (first routes))
             (list width height))
        routes
        (recur (mapcat route-fn routes))))))
      
(defn problem-015 []
  (count (all-routes 2 2)))
