(ns nearest-colour.convert
  (:require [nearest-colour.valid_colour :as valid])
  (:require [clojure.math.numeric-tower :as math]))

; RGB to XYZ

(defn map_rgb_channel
  "Take a single colour channel and map
  it to a value so that it can be composed with
  other channels to create X, Y, and Z components."
  [channel]
  (let [norm_c (/ channel 255)]
    (if (> norm_c 0.04045)
      (* (math/expt (/ (+ norm_c 0.055) 1.055) 2.4) 100)
      (* (/ norm_c 12.92) 100))))

(defn compute_xyz_components
  "Take the mapped RGB vals and derive the X, Y, & Z vals."
  [[r g b]]
  [(+ (* r 0.4124) (* g 0.3576) (* b 0.1805))
   (+ (* r 0.2126) (* g 0.7152) (* b 0.0722))
   (+ (* r 0.0193) (* g 0.1192) (* b 0.9505))])

(defn RGB_to_XYZ
  "Take a vec of RGB and return its XYZ mapping."
  [coll]
  (compute_xyz_components (map map_rgb_channel (valid/validate_colour coll))))

; XYZ to LAB

(defn map_xyz_channel
  "Take a single colour channel and map
  it to a value so that it can be composed with
  other channels to create LAB components."
  [channel]
  (if (> channel 0.008856)
    (math/expt channel 1/3)
    (+ (* 7.787 channel) (/ 16 116))))

(defn compute_lab_components
  "Take the mapped XYZ vals and derive the LAB vals."
  [[x y z]]
  [(- (* y 116) 16)
   (* (- x y) 500)
   (* (- y z) 200)])


(defn XYZ_to_LAB
  "Take a vec of XYZ and return its LAB mapping."
  [[_x _y _z]]
  (let [coll [
               (/ _x 95.0470)
               (/ _y 100.000)
               (/ _z 108.883)]] (compute_lab_components (map map_xyz_channel coll) )))

(defn RGB_to_LAB [coll]
  ((comp XYZ_to_LAB RGB_to_XYZ) coll))
