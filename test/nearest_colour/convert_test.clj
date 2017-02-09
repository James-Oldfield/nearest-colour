(ns nearest-colour.convert-test
  (:require [clojure.test :refer :all]
            [nearest-colour.convert :refer :all]))

(deftest test-rgb_to_XYZ
  (testing "RGB to XYZ mapping"
    (is (= 79.9102738014409 (map_rgb_channel 231))))
  (testing "RGB -> XYZ conversion"
    (is (= [0.0 0.0 0.0] (RGB_to_XYZ [0 0 0])))
    (is (= [46.83917101461927 30.638612719415054 9.406382243260119] (RGB_to_XYZ [255 99 71]))))
  (testing "XYZ -> LAB conversion"
    (is (= [62.20136881808274 57.861325307863645 46.41666460154521] (XYZ_to_LAB [46.83917101461927 30.638612719415054 9.406382243260119]))))
  (testing "RGB -> LAB conversion"
    (is (= [62.20136881808274 57.861325307863645 46.41666460154521] (RGB_to_LAB [255 99 71])))))
