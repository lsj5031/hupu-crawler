(ns hupu.core
  (:gen-class)
  (:require [clj-http.client :as http]
            [clojure.java.io :as io]))

(defn make-file-name [post-id page-number]
  (str post-id "-" page-number ".html"))

(defn download-page [post-id page-number]
  (let [filename (make-file-name post-id page-number)]
    (if-not (.exists (io/file filename))
      (http/get (str "https://m.hupu.com/bbs/" post-id "-" page-number ".html") {:async? true}
                (fn [response] (spit filename (:body response)))
                (fn [exception] (println "Error while downloading page " page-number  ": " (.getMessage exception)))))))

(defn find-total-page-number [htmlbody]
  (Integer. (last (re-find #"HPM\.pageCount = \"(\d+)" htmlbody))))

(defn download-post [post-id]
  (http/get (str "https://m.hupu.com/bbs/" post-id ".html") {:async? true}
            (fn [response]
              (let [body (:body response)
                    total-page-number (find-total-page-number body)]
                (if total-page-number
                  (doall (map (partial download-page post-id) (range 1 (inc total-page-number))))
                  (println "Error while getting total page number in post " post-id))))
            (fn [exception] (println "Error while downloading post " post-id ": " (.getMessage exception)))))

(defn -main
  [& args]
  (http/with-connection-pool {:timeout 5 :threads 4 :insecure? false :default-per-route 10}
    (doall
     (map download-post args))))