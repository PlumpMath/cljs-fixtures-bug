(ns fixtures.core-test
  (:require [cljs.nodejs :as nodejs]
            [cljs.test :refer-macros [async deftest is testing
                                      use-fixtures run-tests]]))

(nodejs/enable-util-print!)

(def counter (atom 0))

(defn inc-counter [f]
  (swap! counter inc)
  (f))

(use-fixtures :once inc-counter)

(deftest fixture
  (is (= 1 @counter)))

(deftest other-test
  (is true))

(set! *main-cli-fn* (fn [] (run-tests 'fixtures.core-test)))
