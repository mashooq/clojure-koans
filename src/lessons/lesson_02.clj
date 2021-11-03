(ns lessons.01)

;; functions
(defn say-hello[] "hello world")
(say-hello)

(def say-ilc (fn [] "I love Clojure"))
(say-ilc)

(defn plus5 [num] (+ 5 num))
(plus5 6)

(defn plus5fun[] #(+ 5 %1))
((plus5fun) 5)

(defn plusfun[] +)
((plusfun) 5)

(defn applyfun-to-five [f] (f 5))
(applyfun-to-five inc)
(applyfun-to-five dec)
(applyfun-to-five even?)


;; Immutability
;; Same argument same Result
(def x 10)
(defn add-to-x[n] (def x (+ x n)) x)
(add-to-x 10)


(def x 10)
(defn add-to-x[y] (+ x y))
(add-to-x 10)
(defn add-to-x[x y] (+ x y))
(add-to-x 1 2)
(println x)


;; No side-effects
(defn hello[] (println "hello") "hello")
(hello)

;; Don't throw exceptions
(defn divide [dividend divisor] (/ dividend divisor))
(divide 0 5)

;; don't mutate state
(def balance 0)
(defn deposit[m] (def balance (+ balance m)))
(defn withdraw[m] (def balance (- balance m)))

(deposit 10)
(withdraw 1)
(println balance)


(defn deposit[balance m] (+ balance m))
(defn withdraw[balance m] (- balance m))
(withdraw (deposit 0 10) 1)

(-> 0
    (deposit 10)
    (withdraw 1))

;; move side-effects to the periphery
(defn log[level msg] (println (str level ": " msg)))
(log "INFO" "Hello")

(defn log-pure [level msg] [println (str level ": " msg)])
(let [[logger msg] (log-pure "INFO" "Hello")]
  (logger msg))


;; Exercise (Payment Service)
; 3 functions: make-payment |-> fraud check-api
;                           |-> payment gateway-api

(defn fraud-check-api [user-id]
  #((println "fraud-checked")
  {:result :passed}))

(defn make-payment-api [payment-details]
  #( (println "made-payment")
     {:result :payment-made}))

(defn fraud-check[user-id]
  [fraud-check-api user-id])

(defn make-payment [payment-details fraud-check-result]
  (if (= :passed (:result fraud-check-result))
    #(make-payment-api payment-details)
    #({:result :failed})))

((make-payment {:dsf :sdf} {:ressult :passed}))
