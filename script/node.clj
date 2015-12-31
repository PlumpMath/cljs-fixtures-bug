(require 'cljs.build.api)

(cljs.build.api/watch "src"
  {:main 'fixtures.core-test
   :output-to "out/testable.js"
   :target :nodejs})
