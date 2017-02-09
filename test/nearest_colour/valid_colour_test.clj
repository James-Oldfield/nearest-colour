(ns nearest-colour.valid_colour-test
  (:require [clojure.test :refer :all]
            [nearest-colour.valid_colour :refer :all]))

(deftest test-validate_colour
  (testing "Is the colour input vec valid?"
    (is (= [0 255 100] (validate_colour [0 255 100])))
    (is (= [] (validate_colour 2 24 0)))
    (is (= [] (validate_colour "2 24 0")))
    (is (= [] (validate_colour "bob")))
    (is (= [] (validate_colour [0 255 -100])))
    (is (= [] (validate_colour [0])))))
