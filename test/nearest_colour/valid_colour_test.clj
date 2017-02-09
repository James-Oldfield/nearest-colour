(ns nearest-colour.valid_colour-test
  (:require [clojure.test :refer :all]
            [nearest-colour.valid_colour :refer :all]))

(deftest test-is_colour_valid?
  (testing "Is the colour input vec valid?"
    (is (= true (is_colour_valid? [0 255 100])))
    (is (= false (is_colour_valid? 2 24 0)))
    (is (= false (is_colour_valid? "2 24 0")))
    (is (= false (is_colour_valid? "bob")))
    (is (= false (is_colour_valid? [0 255 -100])))
    (is (= false (is_colour_valid? [0])))))
