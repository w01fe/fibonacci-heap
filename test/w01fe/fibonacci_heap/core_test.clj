(ns w01fe.fibonacci-heap.core-test
  (:refer-clojure :exclude [empty?])
  (:use clojure.test w01fe.fibonacci-heap.core))

(deftest heap-test
  (let [h (fibonacci-heap)
        n1 (add! h [50] "foo")
        n2 (add! h [50] "bar")
        n3 (add! h [75] "baz")]
    (is (node? n1))
    (is (not (empty? h)))
    (is (= (node-key n1) [50]))
    (is (= (node-val n1) "foo"))
    (is (= (node->entry n1) [[50] "foo"]))    
    (is (= (count h) 3))
    (is (= (set (peek-seq h))
           #{ [[50] "foo"]
              [[50] "bar"]
              [[75] "baz"]}))
    (remove! h n2)
    (is (= (count h) 2))
    (is (= (set (peek-seq h))
           #{ [[50] "foo"]
              [[75] "baz"]}))
    (doseq [i (shuffle (range 100))]
      (add! h [i] i))
    (is (= (count h) 102))
    (dotimes [i 50]
      (is (= (peek-min h) [[i] i]))
      (is (= (remove-min! h) [[i] i])))
    (remove! h n1)
    (remove! h n3)
    (dotimes [i 50]
      (let [i (+ 50 i)]
        (is (= (peek-min h) [[i] i]))
        (is (= (remove-min! h) [[i] i]))))
    (is (= (count h) 0))
    (is (empty? h))))


