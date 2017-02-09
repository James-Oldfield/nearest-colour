(ns nearest-colour.core
  (:require [clojure.math.numeric-tower :as math])
  (:require [nearest-colour.convert :as convert])
  (:gen-class))

(defn compute_3d_dist
  "Compute the euclidean distance of two points in 3d space"
  [[x1 y1 z1]
   [x2 y2 z2]]
  (math/sqrt (+ (math/expt (- x1 x2) 2)
                (math/expt (- y1 y2) 2)
                (math/expt (- z1 z2) 2))))

; temp inputs, etc.
(def palette [[196 34 74]
              [98 231 42]
              [124 195 204]
              [0 0 13]
              [24 199 0]
              [255 0 255]])

(def colour [255 99 71])

(defn -main
  "Find most perceptually-similar colour in a palette to an input colour"
  [& args]
    (map (partial compute_3d_dist (convert/RGB_to_LAB colour))
         (map convert/RGB_to_LAB palette)))
