(ns app.core)

(require 'app.players)

; the main function starts the program 
(defn -main
  "Just for test fun!" 
  [& args]
  (println "My players:")
  (println my-players)
  (println "Is Rocco home?")
  (println (find-player-by-name "Rocco"))
  (println "And the top players:")
  (println (get-players-above my-average)))
