(ns nearest-colour.convert-test
  (:require [clojure.test :refer :all]
            [nearest-colour.convert :refer :all]
            [nearest-colour.valid_colour :refer :all]))

(deftest test-is_colour_valid?
  (testing "Is the colour input vec valid?"
    (is (= true (is_colour_valid? [0 255 100])))
    (is (= false (is_colour_valid? 2 24 0)))
    (is (= false (is_colour_valid? "2 24 0")))
    (is (= false (is_colour_valid? "bob")))
    (is (= false (is_colour_valid? [0 255 -100])))
    (is (= false (is_colour_valid? [0])))))

(deftest test-rgb_to_XYZ
  (testing "RGB -> XYZ conversion"
    (is (= [0 0 0] (rgb_to_XYZ [0 0 0])))
    (is (= [46.83917101461927 30.63861271941505 9.406382243260119] (rgb_to_XYZ [255 99 71])))))
