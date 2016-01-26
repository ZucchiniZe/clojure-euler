(ns euler.solutions
  (:require [clojure.math.numeric-tower :as math]
            [euler.input :as input]))

;; Problem 1: find multiples of 1000 and add together

(defn get-multiples [under]
  (for [item (range 1 under)]
    (let [mul-3 (rem item 3)
          mul-5 (rem item 5)]
      (if (or (= 0 mul-3)
              (= 0 mul-5)) item))))

(defn multiples [under]
  (apply + (remove nil? (get-multiples under))))

(def multiple-solution (multiples 1000))
;; Solution: 23316

;; Problem 2: Find the sum of even number in fib sequence under 4mil

(def fib
  (->> [1 2]
       (iterate (fn [[a b]] [b (+ a b)]))
       (map first)))

(defn even-fib [num]
  (apply + (remove odd? (take num fib))))

;; Solution: 461373

(def fib-solution (even-fib 32))

;; Problem 3: largest prime factors of 600851475143


;; THIS PROBLEM IS UNFINISHED, WILL COME BACK LATER MAYBE

;; Problem 4: find the largest palindrome number made with 3 digit numbers

(defn palindrome? [input]
  (= (str input) (clojure.string/reverse (str input))))

(def pal-numbers
  (for [a (range 100 1000)
        b (range 100 1000)]
    (if (palindrome? (* a b)) (* a b))))

(def palindrome-solution
  (let [results (remove nil? pal-numbers)]
    (apply max results)))

;; Problem 5: find the smallest number that can be divided by each of the numbers in 1 to 20 without any remainder

;; this solution uses a library to find the least common multiple of 1 through 20

(def remainder-solution
  (reduce math/lcm (range 2 21)))

;; Problem 6: find the difference between the sum of squares and square of the sum for 1 - 10001

(defn square [n]
  (* n n))

(defn sum-square [n]
  (apply + (map #(square %) (range 1 (inc n)))))

(defn square-sum [n]
  (square (apply + (range 1 (inc n)))))

(defn difference-sum-square [n]
  (- (square-sum n) (sum-square n)))

(def difference-solution (difference-sum-square 1000))

;; Problem 7: find the 10001st prime number

(def prime-solution
  (last (take 10001 input/primes)))

;; Problem 8: Find the largest product in a series of numbers

(def split-numbers (map #(read-string %) (clojure.string/split (str input/series) #"")))

(defn split-by [n]
  (partition n 1 split-numbers))

(def largest-adjacent-solution
  (reduce max (map #(apply * %) (split-by 13))))

;; Problem 10: Find the sum of primes below number x

;; Number where primes reach over 2mil
(def nth-prime 148933)

(def prime-sums-solution
  (apply + (take nth-prime input/primes)))

;; Problem 13: Find the largest sum in 50 numbers

(def large-nums
  (map #(read-string %) (clojure.string/split-lines input/large-nums-string)))

(def large-sum (apply + large-nums))

(defn n-digits
  "Find n number of digits from input"
  [n input]
  (map #(read-string (str %)) (take n (str input))))

(def large-sum-solution
  (read-string (reduce str (n-digits 10 large-sum))))
