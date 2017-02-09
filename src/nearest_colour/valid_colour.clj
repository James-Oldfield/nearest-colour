(ns nearest-colour.valid_colour)

(defn validate_colour
  "Return (identity vec) or empty coll as a function of
  input colour's validity"
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
