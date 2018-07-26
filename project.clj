(defproject hupu "0.1.0"
  :description "This is a tool to download given hupu post as backup"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [clj-http "3.7.0"]]
  :main ^:skip-aot hupu.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
