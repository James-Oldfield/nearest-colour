(ns nearest-colour.convert
  (:require [clojure.math.numeric-tower :as math]))

(defn map_channel
  "Take a single colour channel and map
  it to a value so that it can be composed with
  other channels to create X, Y, and Z components."
  [channel]
  (let [norm_c (/ channel 255)]
    (if (> norm_c 0.04045)
      (* (math/expt (/ (+ norm_c 0.055) 1.055) 2.4) 100)
      (* (/ norm_c 12.92) 100))))

(defn compute_components
  "Take the mapped RGB vals and derive the X, Y, & Z vals."
  [[r g b]]
  [(+ (* r 0.4124) (* g 0.3576) (* b 0.1805))
   (+ (* r 0.2126) (* g 0.7152) (* b 0.0722))
   (+ (* r 0.0193) (* g 0.1192) (* b 0.9505))])

(defn rgb_to_XYZ
  [coll]
  (compute_components (map map_channel coll)))
