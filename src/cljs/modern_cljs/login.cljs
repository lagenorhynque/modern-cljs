(ns modern-cljs.login
  (:require [domina.core :refer [by-id value]]
            [domina.events :refer [listen!]]))

(defn validate-form []
  (if (and (> (count (value (by-id "email"))) 0)
           (> (count (value (by-id "password"))) 0))
    true
    (do (js/alert "Please complete the form!")
        false)))

(defn ^:export init []
  (if (and js/document
           (aget js/document "getElementById"))
    (listen! (by-id "submit")
             :click
             validate-form)))
