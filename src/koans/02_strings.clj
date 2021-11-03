(ns koans.02-strings
  (:require [koan-engine.core :refer :all]
            [clojure.string :as string]))

(meditations
  "A string is nothing more than text surrounded by double quotes"
  (= __ "hello")

  "But double quotes are just magic on top of something deeper"
  (= __ (str 'world))

  "You can do more than create strings, you can put them together"
  (= "Cool right?" (str __ __))

  "You can even get certain characters"
  (= \C (get "Characters" __))

  "Or even count the characters"
  (= __ (count "Hello World"))

  "But strings and characters are not the same"
  (= __ (= \c "c"))

  "What if you only wanted to get part of a string?"
  (= "World" (subs "Hello World" __ __))

  "How about joining together elements in a list?"
  (= __ (string/join '(1 2 3)))

 )
