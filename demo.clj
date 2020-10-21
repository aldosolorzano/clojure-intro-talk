(ns demo) ;; Namespace -> equivalente a una clase en Java

;; Obtener valores de un mapa/map

(def item {:product "Bocinas" :price 800.22})

(get item :price)

(:price item)

;;;;;;; Ejercicios ;;;;;;;;

(def cart [{:product "Bocinas" :price 800.20}
           {:product "Teclado" :price 300}
           {:product "Audifonos" :price 560.99}])

;; 1. Crea una función names donde se produzca una lista con el nombre de los productos en el carrito

(names cart)

;; 2. Crea una función prices donde produzcas una lista con el precio los productos en el carrito

(prices cart)

;; 3. Crea dos funciónes, prices-str y prices-str-comp donde produzcas una lista con el precio de los productos en el carrito como STRING
;;    prices-str-comp deberá usar la función comp

(prices-str cart)

(prices-str-comp cart)

;; 4. Crea una función times-4 donde produzcas una copia de cart con los precios multiplicados por 4

(times-4 cart)

;; 5. Crea una función total donde produzcas el la suma de los precios del carrito

(total cart)
