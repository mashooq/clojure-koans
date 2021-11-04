(ns lessons.lesson-04)

;; Immutability
;; Same argument same Result
(def x 10)
(defn add-to-x [n] (+ x n))
(add-to-x 10)
(println x)

;; Don't throw exceptions
(defn divide [dividend divisor] (/ dividend divisor))
(divide 0 5)

;; don't mutate state
(defn add-to-x! [n] (def x (+ x n)) x)
(add-to-x! 10)
(println x)


(def balance 0)
(defn deposit [m] (def balance (+ balance m)))
(defn withdraw [m] (def balance (- balance m)))

(deposit 10)
(withdraw 1)
(println balance)


(defn deposit [balance m] (+ balance m))
(defn withdraw [balance m] (- balance m))
(withdraw (deposit 0 10) 1)

(-> 0
    (deposit 10)
    (withdraw 1))

;; move side-effects to the periphery
(defn log [level msg] (println (str level ": " msg)))
(log "INFO" "Hello")

(defn log-pure [level msg] [println (str level ": " msg)])
(let [[logger msg] (log-pure "INFO" "Hello")]
  (logger msg))


;; Exercise (Payment Service)
; 3 functions: make-payment |-> fraud check-api
;                           |-> payment gateway-api

(defn fraud-check-api [user-id]
  (println (str user-id ": fraud-checked"))
    {:result :passed})

(fraud-check-api "mash")

(defn make-payment-api [payment-details]
  (println (str "made-payment: " payment-details))
    {:result :payment-made :details payment-details})

(make-payment-api {:card 13232})

(defn make-payment [payment-details fraud-check-fn]
  (if (= :passed (:result (fraud-check-fn)))
    [make-payment-api payment-details]
    [(fn[x] x) {:result :failed-due-to-fraud-check}]))

(let [[fun opts] (make-payment {:dsf :sdf} (fn [] {:result :failed}))]
  (fun opts))
