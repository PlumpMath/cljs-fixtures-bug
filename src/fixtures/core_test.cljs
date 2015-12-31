(ns fixtures.core-test
  (:require [cljs.nodejs :as nodejs]
            [cljs.test :refer-macros [async deftest is testing
                                      use-fixtures run-tests]]
            [schema.core :as s]
            [schema.test]
            ;; [doo.runner :refer-macros [doo-tests]]
            ))

(nodejs/enable-util-print!)

(use-fixtures :once schema.test/validate-schemas)

(deftest other-test
  (is true))

(s/defn square :- s/Int
  [x :- s/Int]
  (* x x))

(deftest schema-test
  (is (= 4 (square "A"))))
