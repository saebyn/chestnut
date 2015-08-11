(ns {{project-ns}}.core
  (:require [quiescent.core :as q]
            [quiescent.dom :as d]
            [kioo.core :as k])
  (:require-macros [kioo.core :refer [defsnippet deftemplate]]))

(enable-console-print!)

(def root-element-id "app")

(defonce app-state (atom {:text "Hello Chestnut!"}))


(deftemplate UI "index.html" [data]
  {[:#app :h1] (k/content (:text data))})


(defn render []
  (q/render (UI @app-state) (.getElementById js/document root-element-id))
  (.requestAnimationFrame js/window render))


(defn ^:export main []
  (render))
