(ns nearest-colour.core
  (:require [clojure.math.numeric-tower :as math])
  (:gen-class))

(defn compute_3d_dist
  [[x1 y1 z1]
   [x2 y2 z2]]
  (math/sqrt (+ (math/expt (- x1 x2) 2)
                (math/expt (- y1 y2) 2)
                (math/expt (- z1 z2) 2))))
(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))
