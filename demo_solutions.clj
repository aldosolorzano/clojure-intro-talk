(ns demo-solutions)

;;;;;;; Ejercicios ;;;;;;;;

(def cart [{:product "Bocinas" :price 800.20}
           {:product "Teclado" :price 300}
           {:product "Audifonos" :price 560.99}])


;; 1. Crea una función names donde se produzca una lista con el nombre de los productos en el carrito

(defn names [cart-vec]
  (map :product cart-vec))

(names cart)

;; 2. Crea una función prices donde produzcas una lista con el precio los productos en el carrito

(defn prices [cart-vec]
  (map :price cart-vec))

(prices cart)

;; 3. Crea dos funciónes, prices-str y prices-str-comp donde produzcas una lista con el precio de los productos en el carrito como STRING
;;    prices-str-comp deberá usar la función comp

(defn prices-str [cart-vec]
  (map (fn [item] (str (:price item))) cart-vec))

(defn prices-str-comp [cart-vec]
  (map (comp str :price) cart-vec))

(prices-str cart)

(prices-str-comp cart)

;; 4. Crea una función times-4 donde produzcas una copia de cart con los precios multiplicados por 4

(defn times-4 [cart-vec]
  (map (fn [item] (update item :price * 4)) cart-vec))

(times-4 cart)

;; 5. Crea una función total donde produzcas el la suma de los precios del carrito

(defn total [cart-vec]
  (reduce + (prices cart-vec)))

(total cart)
