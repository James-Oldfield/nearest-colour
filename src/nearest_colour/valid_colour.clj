(ns nearest-colour.valid_colour)

(defn validate_colour
  "Return a boolean of whether or not input colour is valid"
  ([r g b]
    (validate_colour '(r g b)))
  ([c]
    (if (and (seq c)
                (= 3 (count (seq c)))
                (every? #(true? (and (number? %)
                                     (> % -1)
                                     (< % 256))) (seq c)))
      c
      [])))
