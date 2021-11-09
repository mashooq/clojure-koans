[
 ["15_destructuring" {"__" [":bar:foo"
                         (format (str "An Oxford comma list of %s, "
                                      "%s, "
                                      "and %s.")
                                 a b c)
                         (apply str
                                (interpose " "
                                           (apply list
                                                  first-name
                                                  last-name
                                                  (interleave (repeat "aka") aliases))))
                         {:original-parts full-name
                          :named-parts {:first first-name :last last-name}}
                         (str street-address ", " city ", " state)
                         city state
                         (str street-address ", " city ", " state)]
                   "___" [(fn [[fname lname]
                              {:keys [street-address city state]}]
                            (str fname " " lname ", "
                                 street-address ", " city ", " state))
                          ]}]

 ["16_refs" {"__" ["hello"
                "hello"
                "better"
                "better!!!"
                (dosync (ref-set the-world 0))
                (map :jerry [@the-world @bizarro-world])
                ]
          "___" [(fn [x] (+ 20 x))]}]

 ["17_atoms" {"__" [0
                 1
                 (swap! atomic-clock (partial + 4))
                 20
                 20
                 atomic-clock 20 :fin
                 ]}]

 ["18_quote" {"__" ['(1 2 3 4 5)
                    (1 2 3 4 5)
                    'age
                    quote
                    '(+ 2 3)
                    1 2 3
                    1 5]}]

 ["19_datatypes" {"__" [(print
                      (str "You're really the "
                           (.category this)
                           ", " recipient "... sorry."))
                     "peace"
                     "literature"
                     "physics"
                     nil
                     [true false]
                     (str "Congratulations on your Best Picture Oscar, "
                          "Evil Alien Conquerors!")]}]

 ["20_java_interop" {"__" [java.lang.String
                        "SELECT * FROM"
                        10
                        1024
                        ]
                  "___" [#(.toUpperCase %)
                         ]}]

 ["21_partition" {"__" [partition
                        [:a :b :c]
                        '((0 1 2) (3 4))
                        5
                        :hello
                        (6 :these :are)
                        ]}]

 ["22_group_by" {"__" [odd?
                       {5 ["hello" "world"] 3 ["foo" "bar"]}
                       {1 [{:name "Bob" :id 1}
                           {:last-name "Smith" :id 1}]
                        2 [{:name "Jennifer" :id 2}]}
                       nil
                       {:naughty-list [{:name "Jimmy" :bad true}
                                       {:name "Joe" :bad true}]
                        :nice-list [{:name "Jane" :bad false}]}]}]

 ["23_meta" {"__" [{:league "National League"}
                   {:division "West"}
                   "This doesn't implement the IObj interface"
                   {:foo :bar}
                   nil
                   \C
                   inc
                   :park "AT&T Park"
                   'Giants
                   "Giants"]}]

 ["24_macros" {"__" [~(first form)
                     ~(nth form 2)
                     form
                     (drop 2 form)
                     "Hello, Macros!"
                     10
                     '(+ 9 1)]}]

 ["25_threading_macros" {"__" [{:a 1}
                               "Hello world, and moon, and stars"
                               "String with a trailing space"
                               6
                               1
                               [2 3 4]
                               12
                               [1 2 3]]}]

 ["26_transducers" {"__" ['(2 3 4)
                          [2 4]
                          [2 4]
                          [2 4]
                          6]}]

 ["27_multimethods" {"__" ["Hello, World!"
                           "Hello there"
                           1
                           6]}]
]
