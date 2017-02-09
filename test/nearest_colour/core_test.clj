(ns nearest-colour.core-test
  (:require [clojure.test :refer :all]
            [nearest-colour.core :refer :all]))

(deftest test-core
  (testing "That the 3D euclidean distance compute returns correctly"
    (is (= 86.60254037844386 (compute_3d_dist [100 100 100] [50 50 50])))))
