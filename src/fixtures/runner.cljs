(ns fixtures.runner
  (:require [cljs.test :refer-macros [async deftest is testing
                                      use-fixtures run-tests]]
            [doo.runner :refer-macros [doo-tests]]
            [fixtures.core-test]))

(doo-tests 'fixtures.core-test)
