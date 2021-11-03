(ns lessons.01)

;; Primitives
(+ 1 2)
(+ "1" "2")
(str "1" "2")
(+ 2 5.1)
(= "hello" "hello")
(= :hello :hello)

;; Collections
(def stmt '(println "hello"))
(def x '(1 2 3 4))
(first x)
(rest x)
(get x 1)

(def y [1 2 3 4])
(get y 0)

(def z #{1 2 3 4})
(get z 0)
(get z 1)

(def m {:one 1 :two 2})
(get m 1)
(get m :one)
