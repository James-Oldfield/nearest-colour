(ns nearest-colour.convert-test
  (:require [clojure.test :refer :all]
            [nearest-colour.convert :refer :all]))

(deftest test-rgb_to_XYZ
  (testing "RGB -> XYZ conversion"
    (is (= [0 0 0] (rgb_to_XYZ [0 0 0])))
    (is (= [46.83917101461927 30.63861271941505 9.406382243260119] (rgb_to_XYZ [255 99 71])))))
