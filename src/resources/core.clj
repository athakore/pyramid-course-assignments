(ns core
  (:require [clojure.reflect :as r]
            [clojure.test.check.generators :as gen]
            [clojure.test.check.properties :as prop]
            [clojure.test.check :as tc]
            [test-helper :as th]
            [clojure.data.csv :as csv]
            [clojure.java.io :as io])
  (:use [com.rpl.specter])
  (:import (java.io ByteArrayOutputStream PrintStream)
           (pyramid_course_assignments.section1 HelloWorld
                                                IncrementDecrement
                                                PrimitiveDataTypes
                                                VariableAssignment
                                                StringManipulation
                                                UserInputAssignment)
           (pyramid_course_assignments.section2 IfStatement
                                                IfElse
                                                LogicalStatements
                                                SwitchStatements
                                                WhileLoop
                                                ForLoop
                                                DoWhile)
           (pyramid_course_assignments.section3 SumArray
                                                ReverseArray
                                                FindTheMissingInteger
                                                FindTheDuplicatesInAnArray
                                                CheckToSeeIfArrayContainsANumber
                                                FindMaxAndMinInArray
                                                RemoveDuplicatesFromArray
                                                ReverseIntegerUsingArrays)
           (pyramid_course_assignments.section4 Animal AccessModifiers Objects Constructors)
           (pyramid_course_assignments.section8 FirstRecordOfTextsLastRecordOfCalls
                                                TotalNumberOfCalls
                                                LongestCall
                                                OutgoingCallsFromBangalore
                                                PotentialTelemarketers)
           (pyramid_course_assignments.section9 CreatingAStreamFromAnArray
                                                SquaringAnArray
                                                RemoveOddsFromArray
                                                SumArrayUsingReduce
                                                ReverseAStringReduce)
           (java.util ArrayList HashMap)
           (pyramid_course_assignments.section7 InsertElementAtRandomPosition
                                                RemoveDuplicatesWithASet
                                                CountDuplicatesWithHashmap)
           (pyramid_course_assignments.section7.challenge_problems EvenAfterOdds
                                                                   NthRowPascal
                                                                   MaxSubArray
                                                                   StepsToTake
                                                                   NumberOfBinarySearchTrees
                                                                   AddOneToArrayList
                                                                   LastIndexFound
                                                                   FindKeypadCombos
                                                                   FastStairClimber)))


(defn hello-world-test
  []
  (let [out (ByteArrayOutputStream.)]
    (System/setOut (PrintStream. out))
    (HelloWorld/main (into-array String ""))
    (or (= (.toString out) "Hello World\r\n")
        (= (.toString out) "Hello World\n"))))

(defn increment-test
  []
  (if (not (re-find #"\+\+"
                    (slurp "src/pyramid_course_assignments/section1/IncrementDecrement.java")))
    false
    (if (= (IncrementDecrement/increment) 2)
      true
      false)))

(defn decrement-test
  []
  (if (not (re-find #"\-\-"
                    (slurp "src/pyramid_course_assignments/section1/IncrementDecrement.java")))
    false
    (if (= (IncrementDecrement/decrement) 0)
      true
      false)))

(def prim-datatypes
  {:smallInteger 'short
   :takeABite 'byte
   :largeInteger 'long
   :mediumInteger 'int
   :largeFloat 'double
   :thisIsTrue 'boolean
   :smallFloat 'float
   :iHaveCharacter 'char})

(defn extract-fields
  [obj]
  (for [{name :name t :type :as x} (:members (r/reflect obj))
        :when (= (type x) clojure.reflect.Field)]
       [(keyword name) t]))

(defn extract-fields-access-modifiers
  [obj]
  (for [{name :name
         t :type
         {:keys [protected private public]} :flags :as field} (:members (r/reflect obj))
        :when (= (type field) clojure.reflect.Field)]
    {:name name
     :type t
     :access (or protected private public :default)}))

(defn invoke-field [obj fn-name-string]
  (let [m (.. obj getClass (getDeclaredField (str (symbol fn-name-string))))]
    (. m (setAccessible true))
    (. m (get obj))))


(defn pop-out-primitive-data-types
  []
  (filter (comp not nil?)
          (map (fn [{type :type name :name}]
                 (if (= name 'pyramid_course_assignments.section1.PrimitiveDataTypes)
                   nil
                   [name type]))
               (:members (r/reflect PrimitiveDataTypes)))))

(defn check-primitives
  []
  (let [check (map (fn [[name val]]
                     (if (= val (prim-datatypes (keyword name)))
                       val
                       (str "wrong primitive data type for: " name "\n")))
                   (pop-out-primitive-data-types))]
    (if (empty? check)
      '("no primitives found!")
      check)))


(defn primitive-datatypes-test
  []
  (let [prims (check-primitives)
        passed? (empty? (filter true? (map string? prims)))]
    (if-not passed?
      (filter string? prims)
      true)))

(defn variable-assignment-test
  []
  (let [obj (new VariableAssignment)
        fields (extract-fields obj)
        field-types (sort (map (fn [[_ type]] type)
                               fields))
        field-names (sort (map (fn [[name _]] name)
                               fields))
        values (sort (map (fn [x] (str (invoke-field obj x))) field-names))]
    (if (= fields
           '(boolean float int))
      (str "Incorrect declared types: " field-types)
      (if (= values
             '("3" "3.14" "false"))
        true
        (str "\n Expected values from fields: 3, 3.14, false,\n however values received were: "
             (apply str
                    (interpose " "
                               (transform [ALL]
                                          read-string
                                          (into []
                                                values)))))))))


(defn nest-if-nots
  [code]
  (map (fn [x] (conj x 'if-not))
       (partition 2
                  code)))

(defn find-if-not
  [code]
  (let [found? (transient [false])]
    (clojure.walk/postwalk (fn [x]
                             (if (= x 'if-not)
                               (conj! found? true))
                             x)
                           code)
    (last (persistent! found?))))

(defn append-if-not
  [st val]
  (if-not (find-if-not (rest st))
    (concat st [val])
    (let [init (butlast st)
          last (last st)]
      (concat init [(append-if-not last val)]))))

(defmacro if-test
  [& code]
  (let [code (map-indexed (fn [i e] (if-not (zero? (mod i 2))
                                      [false e]
                                      e))
                          code)]
    `( ~@(append-if-not (reduce
                          (fn [acc next]
                            (append-if-not acc next))
                          (nest-if-nots code))
                        [true ""]))))

(defn string-manipulation-test
  []
  (let [one (StringManipulation/concat)
        two (StringManipulation/interpolation)]
    (if-test (= one "cats are bad")
             (str "Expected: cats are bad, but your result was: " one)
             (= two "the weather is good")
             (str "Expected: the weather is good, but your result was: " two))))


(defn user-input-test
  []
  (let [out (ByteArrayOutputStream.)
        user (UserInputAssignment/convertAndAddNums "1" "2")]
    (System/setOut (PrintStream. out))
    (.println System/out user)
    (let [check (.toString out)]
      (if-test (or (= check "3\n") (= check "3\r\n"))
               (str "Input was \"1\" and \"2\", output should have been: 3, however it was: " user)))))

(defn if-statement-test
  []
  (:pass? (tc/quick-check 100
                          (prop/for-all [[n m] (gen/tuple gen/nat gen/nat)]
                                        (if-not (or (nil? n) (nil? m))
                                          (= (IfStatement/max n m) (Math/max ^long n ^long m))
                                          true)))))

(defn if-else-test
  []
  (let [human-response (IfElse/ifElse "human")
        goblin-response (IfElse/ifElse "goblin")]
    (if-test (re-find #"else"
                      (slurp "src/pyramid_course_assignments/section2/IfElse.java"))
             "Else was not included in your solution"
             (= human-response "you are one of us!")
             (str "ifElse returned: " human-response " when given \"human\", instead of: you are one of us!")
             (= goblin-response "attack the goblin!")
             (str "ifElse returned: " goblin-response "when given \"goblin\", instead of: attack the goblin!"))))

(defn logical-statements-test
  []
  (let [result (tc/quick-check 100 (prop/for-all [[a b c] (gen/tuple gen/boolean
                                                                     gen/boolean
                                                                     gen/boolean)]
                                                 (and (= (LogicalStatements/tripleShot a b c)
                                                         (and a b c))
                                                      (= (LogicalStatements/tripleShotAgain a b c)
                                                         (or a b c)))))]
       (if-not (:pass? result)
         (str "logical statements did not pass with the given input: " (first (:fail result)))
         true)))

(defn switch-it-up-test
  []
  (let [one    (SwitchStatements/switchItUp 1)
        two    (SwitchStatements/switchItUp 2)
        three  (SwitchStatements/switchItUp 3)
        four   (SwitchStatements/switchItUp 4)
        five   (SwitchStatements/switchItUp 5)]
    (if-test (= one "one")
             (str "switchItUp was given 1 and returned \"" one "\" instead of: \"one\"")
             (= two "two")
             (str "switchItUp was given 2 and returned \"" two "\" instead of: \"two\"")
             (= three "three")
             (str "switchItUp was given 3 and returned \"" three "\" instead of: \"three\"")
             (= four "four")
             (str "switchItUp was given 4 and returned \"" four "\" instead of: \"four\"")
             (= five "five")
             (str "switchItUp was given 5 and returned \"" five "\" instead of: \"five\""))))

(defn while-loop-test
  []
  (let [out (ByteArrayOutputStream.)]
    (System/setOut (PrintStream. out))
    (WhileLoop/loopdyLoop 5 10)
    (let [output (.toString out)]
      (if-test (or (= output "5\n6\n7\n8\n9\n10\n")
                   (= output "5\r\n6\r\n7\r\n8\r\n9\r\n10\r\n"))
               (str "loopdyLoop was given 5 and 10 it should have printed 5,6,7,8,9,10, however it printed: \n" output)))))



(th/def-prop-test for-loop
                  :section2
                  100
                  [[a b] (gen/tuple gen/nat gen/nat)]
                  (if (= a b)
                    0
                    (count (range a (inc b))))
                  (ForLoop/forLoop a b))

(th/def-prop-test do-while
                  :section2
                  100
                  [s gen/string-alpha-numeric]
                  (reduce str "" (reverse s))
                  (DoWhile/doWhile s))

(th/def-prop-test sum-array
                  :section3
                  100
                  [s (gen/not-empty (gen/vector gen/int))]
                  (reduce + s)
                  (SumArray/sumArray (int-array ^int s)))

(th/def-prop-test reverse-array
                  :section3
                  100
                  [s (gen/vector gen/nat)]
                  (reverse s)
                  (into [] (ReverseArray/reverseArray (int-array s))))

(th/def-prop-test find-the-missing-integer
                  :section3
                  100
                  [s (gen/fmap (fn [x] (let [r (range 1 x)]
                                         (if-not (empty? r)
                                           (let [removal (rand-nth r)]
                                             (into [] (remove (fn [x] (= removal x)) r)))
                                           (into [] r))))
                               gen/nat)]
                  (let [num-count (if (last s) (last s) 0)]
                    (- (reduce + 0 (range 1 (inc num-count))) (reduce + 0 s)))
                  (FindTheMissingInteger/findTheMissingInteger (int-array s)))

(th/def-prop-test find-the-duplicates-in-an-array
                  :section3
                  100
                  [s (gen/vector gen/nat)]
                  (into []
                        (sort (for [[k v] (reduce (fn [acc next] (if (acc next)
                                                                   (update acc next inc)
                                                                   (assoc acc next 1)))
                                                  {}
                                                  s)
                                    :when (> v 1)]
                                   k)))
                  (into []
                        (sort (FindTheDuplicatesInAnArray/findTheDuplicatesInAnArray (int-array s)))))

(th/def-prop-test check-to-see-if-array-contains-a-number
                  :section3
                  100
                  [[arr num] (gen/tuple (gen/vector gen/nat) gen/nat)]
                  (if (some #(= num %) arr)
                    true
                    false)
                  (CheckToSeeIfArrayContainsANumber/checkToSeeIFArrayContainsANumber (int-array arr) num))

(th/def-prop-test find-max-and-min-in-array
                  :section3
                  100
                  [nums (gen/vector gen/int)]
                  (let [sort (sort nums)]
                    [(or (first sort) 0) (or (last sort) 0)])
                  (into [] (FindMaxAndMinInArray/findMaxAndMinInArray (int-array nums))))

(th/def-prop-test remove-duplicates-from-array
                  :section3
                  100
                  [nums (gen/vector gen/int)]
                  (into [] (sort (distinct nums)))
                  (into [] (sort (RemoveDuplicatesFromArray/removeDuplicatesFromArray (int-array nums)))))

(th/def-prop-test reverse-integer-using-arrays
                  :section3
                  100
                  [num gen/int]
                  (if (zero? num)
                      0
                      (let [negate? (if-not (pos? num)
                                      true
                                      false)
                            num (Math/abs ^int num)
                            num (Integer/parseInt (apply str
                                                         (drop-while (partial = \0)
                                                                     (reverse (str num)))))]
                           (if negate?
                             (- 0 num)
                             num)))
                  (ReverseIntegerUsingArrays/reverseIntegerUsingArrays num))

; classes and objects part 1 tests
(th/def-test animal
             :section4
             (let [field-vals '("Yellow" 4 "blue" "Male")
                   user-vals  (let [animal (Animal.)]
                                (for [x [:hair :legs :eyeColor :gender]]
                                  (invoke-field animal x)))]
               (if-test (= field-vals
                           user-vals)
                        (str "Expected field values to be: " field-vals ", However fields were: " user-vals))))

(def fields-for-access-modifiers #{{:name 'gasMillage, :type 'float, :access :public}
                                   {:name 'hairColor, :type 'java.lang.String, :access :public}
                                   {:name 'companyName, :type 'java.lang.String, :access :default}
                                   {:name 'age, :type 'int, :access :private}
                                   {:name 'height, :type 'double, :access :protected}
                                   {:name 'name, :type 'java.lang.String, :access :private}})

(def expected-access-modifiers-for-fields {:gasMillage :public
                                           :hairColor :public
                                           :companyName :default
                                           :age :private
                                           :height :protected
                                           :name :private})

(th/def-test access-modifiers
             :section4
             (let [correct-access (reduce (fn [acc {name :name access :access}]
                                            (if-not (= ((keyword name) expected-access-modifiers-for-fields)
                                                       access)
                                              (conj acc {name access})
                                              (conj acc nil)))
                                          []
                                          (extract-fields-access-modifiers (AccessModifiers.)))]
               (if-test (every? nil? correct-access)
                        (println (str "\nincorrect access modifiers for: \n"
                                      (apply str
                                             (map (fn [kv] (let [[key val] (first (seq kv))]
                                                             (str "    "
                                                                  (symbol val)
                                                                  " "
                                                                  key
                                                                  "\n")))
                                                  (filter map? correct-access)))))
                        (if (empty? correct-access) false true)
                        (println "no access modifiers found!")
                        (= (count correct-access) 6)
                        (println "Does not contain all of the required access modifiers!"))))

(th/def-test creating-methods
             :section4
             (if-test (re-find #"lapsWalked = 5;"
                               (slurp "src/pyramid_course_assignments/section4/CreatingMethods.java"))
                      (println "lapsWalked was not assigned the value of 5")))

(th/def-test constructors
             :section4
             (if-test (let [con (Constructors. "bob" 10 100.0)]
                        (and (= (invoke-field con :name) "bob")
                             (= (invoke-field con :age) 10)
                             (= (invoke-field con :weight) 100.0)))
                      (println "did not assign fields through the constructor correctly!")))

(th/def-test objects
             :section4
             (let [[[anim] & fields] (extract-fields (Objects.))]
               (if-test (not fields)
                        "Too many fields are declared in Objects"
                        (= :animal anim)
                        "animal field not found!"
                        (instance? Animal (invoke-field (Objects.) anim))
                        "Animal field is not of the type animal or is null")))

; Section 7 COLLECTIONS

(th/def-prop-test insert-element-at-random-position
                  :section7
                  100
                  [[nums idx elm] (gen/tuple (gen/vector gen/nat) gen/nat gen/nat)]
                  (if (>= (count nums) idx)
                    (setval (srange idx idx) [elm] nums)
                    nums)
                  (into [] (InsertElementAtRandomPosition/insertElementAtRandomPosition (ArrayList. ^ArrayList nums)
                                                                                        idx
                                                                                        elm)))

(th/def-prop-test remove-duplicates-with-a-set
                  :section7
                  100
                  [nums (gen/vector gen/nat)]
                  (into [] (sort (distinct nums)))
                  (into [] (sort (RemoveDuplicatesWithASet/removeDuplicatesWithASet (ArrayList. ^ArrayList nums)))))


(th/def-test count-duplicates-with-hashmap-ensuring-hashmap-was-used
             :section7
             (if-test (re-find #"HashMap<"
                               (slurp "src/pyramid_course_assignments/section7/CountDuplicatesWithHashmap.java"))
                      (println "did not find usage of Hashmap in CountDuplicatesWithHashmap.java"))
             {:omit-java-class? true})

(th/def-prop-test count-duplicates-with-hashmap
                  :section7
                  100
                  [nums (gen/vector gen/nat)]
                  (into []
                        (sort (conj (map (fn [[x y]] (str (count y) " " x "s\n"))
                                         (group-by identity nums)) "There are: ")))
                  (into []
                        (sort (CountDuplicatesWithHashmap/countDuplicatesWithHashmap (ArrayList. ^ArrayList nums)))))




; Section 7 COLLECTIONS END

; Section 7 COLLECTIONS CHALLENGE

(th/def-prop-test even-after-odds
                  :section7/challenge_problems
                  100
                  [nums (gen/vector gen/nat)]
                  (into [] (sort-by even? (apply concat (vals (group-by odd? nums)))))
                  (into [] (EvenAfterOdds/evenAfterOdds (ArrayList. ^ArrayList nums))))

(first (let [nums [1, 2, -5, -4, 1, 6]]
         (reduce (fn [[max current] next] (let [current (Math/max (+ current next) next)
                                                max (Math/max current max)]
                                            [max current]))

                 [(first nums) (first nums)]
                 (rest nums))))

(th/def-prop-test max-sub-array
                  :section7/challenge_problems
                  100
                  [nums (gen/vector gen/nat)]
                  (if (empty? nums)
                    []
                    (first (reduce (fn [[max current] next]
                                     (let [current (Math/max (+ current next) next)
                                           max (Math/max current max)]
                                       [max current]))
                                   [(first nums) (first nums)]
                                   (rest nums))))
                  (MaxSubArray/maxSubArray (ArrayList. ^ArrayList nums)))

(defn compute-next-row
  [row]
  (let [row-pat (loop [nums row
                       acc []]
                  (if (> (count nums) 1)
                    (recur (next nums) (conj acc (take 2 nums)))
                    acc))]
    (setval (srange 1 1) (map (partial apply +) row-pat) [1 1])))

(defn compute-pascal
  [nth]
  (let [[f s :as start] [[1] [1 1]]]
    (cond (zero? nth) []
          (= 1 nth)   f
          (= 2 nth)   s
          :else       (last (reduce (fn [acc _]
                                      (conj acc
                                            (compute-next-row (last acc)))) start
                                    (range (- nth 2)))))))

(defn steps-to-take
  [n m]
  (if (> n m)
    -1
    (let [min-steps (+ (mod n 2) (quot n 2))]
      (loop [final min-steps]
        (if (zero? (mod final m))
          final
          (recur (inc final)))))))

(th/def-prop-test steps-to-take
                  :section7/challenge_problems
                  100
                  [[n m] (gen/tuple gen/nat (gen/such-that #(not (zero? %)) gen/nat))]
                  (steps-to-take n m)
                  (StepsToTake/stepsToTake n m))



(th/def-prop-test nth-row-pascal
                  :section7/challenge_problems
                  10
                  [num gen/nat]
                  (compute-pascal num)
                  (NthRowPascal/nthRowPascal num))

(defn num-bsts
  [n]
  (if (or (zero? n) (= n 1))
    1
    (reduce + (for [x (range 1 (inc n))]
                (* (num-bsts (dec x))
                   (num-bsts (- n x)))))))

(th/def-prop-test number-of-binary-search-trees
                  :section7/challenge_problems
                  10
                  [num (gen/such-that pos? gen/nat)]
                  (num-bsts num)
                  (NumberOfBinarySearchTrees/numberOfBinarySearchTrees num))

(th/def-prop-test add-one-to-array-list
                  :section7/challenge_problems
                  10
                  [nums (gen/vector gen/nat)]
                  (if (empty? nums)
                    [1]
                    (mapv #(Integer/parseInt %)
                          (-> (apply str nums)
                              Integer/parseInt
                              inc
                              str
                              (clojure.string/split #""))))
                  (into []
                        (AddOneToArrayList/addOneToArrayList (ArrayList. ^ArrayList nums))))

(th/def-prop-test last-index-found
                  :section7/challenge_problems
                  10
                  [[nums idx] (gen/tuple (gen/vector gen/nat) gen/nat)]
                  (let [nums (reverse nums)
                        found (take-while #(not= idx %) nums)]
                    (dec (- (count nums) (count found))))
                  (LastIndexFound/lastIndexFound (ArrayList. ^ArrayList nums) idx))


(defn keypad
  [n]
  (if (or (< n 2) (> n 9))
    ""
    (case n
      2 "abc"
      3 "def"
      4 "ghi"
      5 "jkl"
      6 "mno"
      7 "pqrs"
      8 "tuv"
      9 "wxyz")))

(defn find-keypad-combos
  [n]
  (cond (<= n 1) (ArrayList.)
        (< n 9) (ArrayList. (clojure.string/split (keypad n) #""))
        :else (let [last-code (clojure.string/split (keypad (mod n 10)) #"")
                    but-last-code (find-keypad-combos (quot n 10))
                    ret (ArrayList.)]
                (doseq [but-last-code-letters but-last-code]
                  (doseq [last-code-letter last-code]
                    (.add ret (str but-last-code-letters last-code-letter))))
                ret)))

(th/def-prop-test find-keypad-combos
                  :section7/challenge_problems
                  10
                  [nums (gen/such-that not-empty (gen/vector (gen/such-that pos? gen/nat)))]
                  (into [] (sort (find-keypad-combos (Integer/parseInt (apply str nums)))))
                  (into [] (FindKeypadCombos/findKeypadCombos (Integer/parseInt (apply str nums)))))

(let [memo (HashMap.)]
  (defn fast-stairs
    [n]
    (cond (<= n 0) 1
          (= n 1)  1
          (= n 2)  2
          (= n 3)  4
          :else   (if (.containsKey memo n)
                    (.get memo n)
                    (do (.put memo n (+ (fast-stairs (- n 1))
                                        (fast-stairs (- n 2))
                                        (fast-stairs (- n 3))))
                        (.get memo n))))))


(th/def-test fast-stair-climber
             :section7/challenge_problems
             (let [right1 (fast-stairs 15)
                   wrong1 (FastStairClimber/fastStairClimber 15)
                   right2 (fast-stairs 72)
                   wrong2 (FastStairClimber/fastStairClimber 72)
                   time (Float/parseFloat (re-find #"[0-9]+\.[0-9]+" (with-out-str (time (FastStairClimber/fastStairClimber 72)))))]
               (println (= right1 wrong1))
               (if-test (= right1 wrong1)
                        (println "fastStairClimber returned the wrong number for input of 15")
                        (= right2 wrong2)
                        (println "fastStairClimber returned the wrong number for input of 15")
                        (> 0.1 time)
                        (println "fastStairClimber is too slow"))))

; Section 7 COLLECTIONS CHALLENGE END


; Section 8

(def calls
  (map (fn [[calling receiving start duration]]
         {:calling calling
          :receiving receiving
          :start start
          :duration duration})
       (with-open [reader (io/reader (str (System/getProperty "user.dir")
                                          "/src/pyramid_course_assignments/section8/calls.csv"))]
         (doall
           (csv/read-csv reader)))))

(def texts
  (map (fn [[sending receiving time]]
         {:sending sending
          :receiving receiving
          :time time})
    (with-open [reader (io/reader (str (System/getProperty "user.dir")
                                       "/src/pyramid_course_assignments/section8/texts.csv"))]
      (doall
        (csv/read-csv reader)))))


(th/def-test first-record-of-texts-last-record-of-calls
             :section8
             (let [{:keys [receiving sending time]} (first texts)
                   {:keys [calling start duration] receiving2 :receiving} (last calls)
                   first-text (str "First record of texts, " sending " texts " receiving " at time " time)
                   last-call (str "Last record of calls, "
                                  calling
                                  " calls "
                                  receiving2
                                  " at time "
                                  start
                                  ", lasting "
                                  duration
                                  " seconds")
                   java-return (FirstRecordOfTextsLastRecordOfCalls/firstRecordOfTextsLastRecordOfCalls)]
               (if-test (= (count java-return) 2)
                        (println "return from firstAndLastRecordOfTexts must contain exactly two elements")
                        (= first-text
                           (aget java-return 0))
                        (println "wrong return for first text!")
                        (= last-call
                           (aget java-return 1))
                        (println "wrong return for last call!"))))

(def total-numbers (-> (map (fn [{calling :calling receiving :receiving}
                                 {sending :sending receiving2 :receiving}]
                              [calling receiving sending receiving2])
                            calls
                            texts)
                       flatten
                       distinct
                       count))

(th/def-test total-number-of-calls
             :section8
             (if-test (= total-numbers (TotalNumberOfCalls/totalNumberOfCalls))
                      (println (str "The method totalNumberOfCalls did not return the correct amount which was: "
                                    (TotalNumberOfCalls/totalNumberOfCalls)))))

(def longest-call (first (first (sort-by val > (reduce (fn [acc
                                                            {calling :calling receiving :receiving duration :duration}]
                                                         (let [call (acc calling) rec (acc receiving) duration (Integer/parseInt duration)]
                                                           (assoc acc calling (if call
                                                                                (+ call duration)
                                                                                duration)
                                                                      receiving (if rec
                                                                                  (+ rec duration)
                                                                                  duration))))
                                                       {}
                                                       calls)))))

(th/def-test longest-call
             :section8
             (if-test (= (LongestCall/longestCall) longest-call)
                      (println "longestCall did not return the correct phone number")))

(def out-going-calls-ordered
  (apply str (interpose " " (sort (reduce (fn [acc {c :calling}]
                                            (let [fl (re-matches #"\((0[0-9]+)\)[0-9]+" c)
                                                  mn (re-matches #"([789][0-9]{3})[0-9]* [0-9]+" c)
                                                  t (re-matches #"(140)[0-9]*" c)]

                                              (cond fl (conj acc (last fl))
                                                    mn (conj acc (last mn))
                                                    t  (conj acc (last t))
                                                    :else acc)))
                                          #{}
                                          calls)))))

(th/def-test outgoing-calls-from-bangalore
             :section8
             (if-test (= out-going-calls-ordered (OutgoingCallsFromBangalore/outgoingCallsFromBangalore))
                      (println "did not return the correct area codes or did not return them in the correct order")))

(def numbers-that-receive-calls-negate-texting
  (clojure.set/union (reduce (fn [acc {r :receiving}] (conj acc r)) #{} calls)
                     (reduce (fn [acc {s :sending r :receiving}] (conj acc s r)) #{} texts)))
(def numbers-that-call (reduce (fn [acc {r :calling}] (conj acc r)) #{} calls))

(def potential-telemarketers
  (apply str
         (interpose " "
                    (sort (for [num numbers-that-call
                                :when (not (numbers-that-receive-calls-negate-texting num))]
                            num)))))

(th/def-test potential-telemarketers
             :section8
             (if-test (= potential-telemarketers (PotentialTelemarketers/potentialTelemarketers))
                      (println "potentialTelemarketers returned the wrong amount of telemarketer numbers
                                returned the wrong order of the telemarketers")))

; section 9 streams tests

(th/def-test creating-a-stream-from-an-array
             :section9
             (if-test (re-find #"Arrays\.stream\(arr\)"
                               (slurp "src/pyramid_course_assignments/section9/CreatingAStreamFromAnArray.java"))
                      (println "Did not find the proper conversion of arr to a stream!")
                      (instance? java.util.stream.IntStream
                          (CreatingAStreamFromAnArray/creatingAStreamFromAnArray (int-array [1 2 3])))
                      (println "creatingAStreamFromAnArray did not return a stream")
                      (re-find #"list\.stream\(\)"
                               (slurp "src/pyramid_course_assignments/section9/CreatingAStreamFromAnArray.java"))
                      (println "Did not find the proper conversion of list to a stream!")
                      (instance? java.util.stream.Stream
                                 (CreatingAStreamFromAnArray/creatingAStreamFromAList (ArrayList.)))
                      (println "creatingAStreamFromAList did not return a stream")))

(re-find #"\+\+"
         (slurp "src/pyramid_course_assignments/section1/IncrementDecrement.java"))

(th/def-test squaring-an-array-ensuring-map-is-used
             :section9
             (if-test (re-find #"Arrays\.stream\(nums\)\.map"
                               (slurp "src/pyramid_course_assignments/section9/SquaringAnArray.java"))
                      (println "did not find usage of streams or map in SquaringAnArray.java"))
             {:omit-java-class? true})

(th/def-prop-test squaring-an-array
                  :section9
                  100
                  [nums (gen/vector gen/nat)]
                  (into [] (map #(* % %) nums))
                  (into [] (SquaringAnArray/squaringAnArray (int-array nums))))

(th/def-test removing-odds-ensuring-filter-is-used
             :section9
             (if-test (re-find #"Arrays\.stream\(nums\)\.filter"
                               (slurp "src/pyramid_course_assignments/section9/RemoveOddsFromArray.java"))
                      (println "did not find usage of streams or filter in RemoveOddsFromArray.java"))
             {:omit-java-class? true})

(th/def-prop-test remove-odds-from-array
                  :section9
                  100
                  [nums (gen/vector gen/nat)]
                  (into [] (filter #(not= (mod % 2) 0) nums))
                  (into [] (RemoveOddsFromArray/removeOddsFromArray (int-array nums))))

(th/def-test ensuring-sum-array-using-reduce
             :section9
             (if-test (re-find #"Arrays\.stream.+?\.reduce"
                               (slurp "src/pyramid_course_assignments/section9/SumArrayUsingReduce.java"))
                      (println "did not find usage of streams or reduce in SumArrayUsingReduce.java"))
             {:omit-java-class? true})

(th/def-prop-test sum-array-using-reduce
                  :section9
                  100
                  [nums (gen/vector gen/nat)]
                  (reduce + nums)
                  (SumArrayUsingReduce/sumArrayUsingReduce (int-array nums)))

(th/def-test ensuring-reverse-a-string-reduce
             :section9
             (if-test (re-find #"Arrays\.stream.+?\.reduce"
                               (slurp "src/pyramid_course_assignments/section9/ReverseAStringReduce.java"))
                      (println "did not find usage of streams or reduce in ReverseAStringReduce.java"))
             {:omit-java-class? true})

(th/def-prop-test reverse-a-string-reduce
                  :section9
                  100
                  [letters gen/string-alphanumeric]
                  (apply str (reverse letters))
                  (ReverseAStringReduce/reverseAStringReduce letters))