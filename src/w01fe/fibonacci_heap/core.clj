(ns w01fe.fibonacci-heap.core
  (:refer-clojure :exclude [empty?])
  (:import [w01fe.fibonacci_heap FibonacciHeap FibonacciHeap$Node]))

(set! *warn-on-reflection* true)

(defn fibonacci-heap []
  (FibonacciHeap.))

(defn node? [n]
  (instance? FibonacciHeap$Node n))

(defn node-key [^FibonacciHeap$Node n]
  (.getKey n))

(defn node-val [^FibonacciHeap$Node n]
  (.getData n))

(defn node->entry [^FibonacciHeap$Node n]
  [(.getKey n) (.getData n)])


(defn empty? [^FibonacciHeap heap]
  (.isEmpty heap))

(defn add!
  "Add an entry to the heap, returning the added node."
  [^FibonacciHeap heap ^Comparable k v]
  (.insert heap v k))

(defn peek-min [^FibonacciHeap heap]
  (node->entry (.min heap)))

(defn peek-seq
  "Return an eager seq of key-value pairs, in no particular order."
  [^FibonacciHeap heap]
  (map node->entry (.nodeList heap)))

(defn remove-min! [^FibonacciHeap heap]
  (let [^FibonacciHeap$Node n (.min heap)]
    [(.getKey n) (.removeMin heap)]))

(defn remove!
  "Remove a specific node returned by add!."
  [^FibonacciHeap heap ^FibonacciHeap$Node n]
  (.delete heap n))








