(ns demo-2-solutions)

; ======================
; Introducción a Clojure
; ======================

; Referencia
; ------------------------------------------------------------------
; Ejemplo tomado de la platica, Clojure in a nutshell by James Trunk
; https://www.youtube.com/watch?v=C-kF25fWTO8&


(defn deaccent [str]
  ;; http://www.matt-reid.co.uk/blog_post.php?id=69
  (-> str
      (java.text.Normalizer/normalize java.text.Normalizer$Form/NFD)
      (clojure.string/replace #"\p{InCombiningDiacriticalMarks}+" "")))

(def book (slurp "https://www.gutenberg.org/files/58221/58221-0.txt"))
(def words (re-seq #"\w+" (deaccent book)))


; Encontrar las 20 palabras mas frequentes
; ----------------------------------------

(def common-words #{"de" "la" "que" "el" "en" "y" "a" "los" "se" "del" "las" "un" "por" "con" "no" "una" "su" "para"
                    "es" "al" "lo" "como" "más" "o" "pero" "sus" "le" "ha" "me" "si" "sin" "sobre" "este" "ya" "entre"
                    "cuando" "todo" "esta" "ser" "son" "dos" "también" "fue" "había" "era" "muy" "años" "hasta" "desde"
                    "está" "mi" "porque" "qué" "sólo" "han" "yo" "hay" "vez" "puede" "todos" "así" "nos" "ni" "parte"
                    "tiene" "él" "uno" "donde" "bien" "tiempo" "mismo" "ese" "ahora" "cada" "e" "vida" "otro" "después"
                    "te" "otros" "aunque" "esa" "eso" "hace" "otra" "gobierno" "tan" "durante" "siempre" "día" "tanto"
                    "ella" "tres" "sí" "dijo" "sido" "gran" "país" "según" "menos" "les" "tu" "l" "n" "m" "tel" "s" "j"
                    "c" "h" "asi" "pues" "mas"})
(->> words
     (map clojure.string/lower-case)
     (remove common-words)
     (frequencies)
     (sort-by val)
     (take-last 20))

; Encontrar las 20 palabras más largas
; ------------------------------------

(->> words
     (distinct)
     (sort-by count)
     (take-last 20))


; El palindrome más largo
; ----------------------

(defn palindrome? [coll]
  (= (seq coll) (reverse coll)))

(palindrome? [1 2 3 2 1])
(palindrome? "solos")

(defn longest-palindrome [words]
  (->> words
       (distinct)
       (filter palindrome?)
       (sort-by count)
       (last)))

(longest-palindrome words)
