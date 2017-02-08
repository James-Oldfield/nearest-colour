(ns nearest-colour.valid_colour)

(defn is_colour_valid?
  "Return a boolean of whether or not input colour is valid"
  ([r g b]
    (is_colour_valid? '(r g b)))
  ([c]
    (true? (and (seq c)
                (= 3 (count (seq c)))
                (every? #(true? (and (number? %)
                                     (> % -1)
                                     (< % 256))) (seq c))))))
