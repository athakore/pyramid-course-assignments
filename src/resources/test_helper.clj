(ns test-helper
  (:require [clojure.test.check :as tc]
            [clojure.test.check.properties :as prop])
  (:import (pyramid_course_assignments FormatTestCode)))

(def function-links (atom {}))
(def dev-mode? false)
(def user-dir (System/getProperty "user.dir"))
(def test-file-location (str user-dir "/test/pyramid_course_assignments/LoadTestFile.java"))
(def assignments-location (str user-dir "/src/pyramid_course_assignments/"))
(def tests-for-assignments-location (str user-dir "/test/pyramid_course_assignments/"))


(defmacro docstring [symbol]
  `(:doc (meta (var ~symbol))))

(defn divide-symbol-by-hyphen
  [sym]
  (clojure.string/split (str sym) #"-"))

(defn javafy-clojure-sym-to-method-name
  "(fn 'hi-there) => \"hiThere\""
  [name]
  (let [[f & rest] (divide-symbol-by-hyphen name)]
    (apply str (conj (map #(clojure.string/capitalize %) rest) f))))

(defn javafy-clojure-sym-to-class-name
  "(fn 'hi-there) => \"HiThere\""
  [name]
  (apply str (map #(clojure.string/capitalize %) (divide-symbol-by-hyphen name))))

(defn javafy-clojure-sym-java-file-name
  "(fn 'hi-there) => \"HiThere.java\""
  [name]
  (str (javafy-clojure-sym-to-class-name name) ".java"))

(defn javafy-clojure-sym-java-var-name
  "(fn 'hi-there) => \"hi_there\""
  [name]
  (apply str
         (map (fn [x] (if (= x \-)
                        \_
                        x))
              (str name))))

(defn append-test
  "(fn 'hi-there) => hi-there-test"
  [name]
  (symbol (str name "-test")))



(defn find-java-files
  [section test?]
  (for [file (file-seq (clojure.java.io/file (str (or (when test?
                                                            tests-for-assignments-location)
                                                      assignments-location)
                                                  (symbol section))))
        :when (re-find #".java" (.getName file))]
    (.getName file)))
; TODO should does-file-exist?
(defn does-file-exist?
  [sym section test?]
  (some #(= % (or (when test?
                        (javafy-clojure-sym-java-file-name (append-test sym)))
                  (javafy-clojure-sym-java-file-name sym)))
        (find-java-files section test?)))

(defn inject-clojure-tests
  []
  (spit test-file-location
        (FormatTestCode/testFileFormatter
          (apply str
                 (map (fn [[_ val]] (str val "\n"))
                      @function-links)))))


(defn create-java-variable-test-links!
  [name]
  (let [java-code-name (symbol (apply str
                                      (map (fn [x] (if (= x \-)
                                                     \_
                                                     x))
                                           (str name))))
        clojure-code-name (str name)]
    (when dev-mode?
      (swap! function-links
             assoc
             (keyword name)
             (str "     public static Var "
                  java-code-name
                  " = RT.var(\"core\", \""
                  clojure-code-name
                  "\");"))
      (inject-clojure-tests))))

(defn create-template-code-in-java!
  [name section [{omit-java-class? :omit-java-class?}]]
  (let [test-file-exist? (does-file-exist? name section true)
        assignment-file-exist? (does-file-exist? name section false)
        section (str (symbol section))
        test-name (append-test name)]
    (if dev-mode?
      (create-java-variable-test-links! test-name))
    (when (and (not test-file-exist?) dev-mode?)
      (spit (str tests-for-assignments-location section
                 "/"
                 (javafy-clojure-sym-java-file-name test-name))
            (FormatTestCode/testFormatter section
                                          (javafy-clojure-sym-to-method-name test-name)
                                          (javafy-clojure-sym-java-var-name (str name "-test")))))
    (when (and (not assignment-file-exist?)
               dev-mode?
               (not omit-java-class?))
      (spit (str assignments-location section "/" (javafy-clojure-sym-java-file-name name))
            (FormatTestCode/assignmentFormatter section
                                                (javafy-clojure-sym-to-class-name name)
                                                (javafy-clojure-sym-to-method-name name))))))


(defmacro def-test
  [name section code & options]
  (create-template-code-in-java! name section options)
  `(defn ~(append-test name) [] ~code))

(defmacro def-prop-test
  [name section num-tests prop user test & options]
  (create-template-code-in-java! name section options)
  `(defn ~(append-test name)
     []
     (let [user# (atom nil)
           test# (atom nil)
           result# (tc/quick-check ~num-tests
                                   (prop/for-all ~prop
                                                 (do (reset! user# ~user)
                                                     (reset! test# ~test)
                                                     (= (deref user#)
                                                        (deref test#))))
                                   :reporter-fn (fn [m#]
                                                  (when (= :failure (:type m#))
                                                    (if (instance? java.lang.Exception (:result m#))
                                                        (.printStackTrace (:result m#))
                                                        (println (str ~(second (re-find #"\/([a-zA-Z]+)" (apply str test)))
                                                                      " was given "
                                                                      (first (:fail m#))
                                                                      ",\nExpected output was: "
                                                                      (deref user#)
                                                                      ",\nHowever, output was: "
                                                                      (deref test#)))))))]
       (if-not (:pass? result#)
         (if (instance? java.lang.Exception (:result result#))
             [false (.getMessage (:result result#))]
             [false (str "╳╳╳ TEST FAILED ╳╳╳")])
         [true ""]))))

