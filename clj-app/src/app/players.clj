
; the players 
(def my-players [
    {:name "Peter" :points 4} 
    {:name "Rocco" :points 3} 
    {:name "Randy" :points 3} 
    {:name "Nicholas" :points 1} 
    {:name "Ron" :points 5}])

; map 
(def my-names (map (fn [x] (get x :name)) my-players))
; reduce 
(def my-average (/ (reduce (fn [a b] (+ a (get b :points)) ) 0 my-players) (count my-players)))

; filter 
(defn get-players-above 
    [avg] 
    (filter (fn [x] (> (get x :points) avg)) my-players))

(defn find-player-by-name 
    [name] 
    (filter (fn [x] (= (get x :name) name)) my-players))
