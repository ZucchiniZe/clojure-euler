(ns euler.core
  (:gen-class)
  (:require [euler.solutions :as solutions]))

;; List of solutions for easily printing out
;; [euler problem number, problem name, answer]
(def solutions
  [[1 "multiples solution" solutions/multiple-solution]
   [2 "fib solution" solutions/fib-solution]
   [4 "palindrome solution" solutions/palindrome-solution]
   [5 "remainder solution" solutions/remainder-solution]
   [6 "difference solution" solutions/difference-solution]
   [7 "prime solution" solutions/prime-solution]
   [8 "largest adjacent solution" solutions/largest-adjacent-solution]
   [10 "prime sums solution" solutions/prime-sums-solution]
   [13 "large sum solution" solutions/large-sum-solution]])

(defn -main [& args]
  (doseq [[num problem answer] solutions]
    (println (str "#" num " " problem ": " answer))))
