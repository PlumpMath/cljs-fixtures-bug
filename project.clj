(defproject fixtures "0.1.0-SNAPSHOT"
  :description "Reproduce bug"
  :url "https://github.com/bensu/cljs-fixtures-bug"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.145"]
                 [prismatic/schema "1.0.4"]]

  :plugins [[lein-doo "0.1.7-SNAPSHOT"]]

  :source-paths ["src"]

  :clean-targets ^{:protect false} [:target-path "out"]

  :jvm-opts ["-Xmx1g"]

  :cljsbuild
  {:builds {:test {:source-paths ["src"]
                   :compiler {:output-to "out/testable.js"
                              :main fixtures.core-test
                              :optimizations :none
                              :target :nodejs}}
            :doo {:source-paths ["src"]
                  :compiler {:output-to "out/testable.js"
                             :main fixtures.runner
                             :optimizations :none
                             :target :nodejs}}}})
