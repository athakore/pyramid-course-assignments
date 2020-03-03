package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.find_the_duplicates_in_an_array_test;

class FindTheDuplicatesInAnArrayTest {

    @Test
    void findTheDuplicatesInAnArray() {
        PersistentVector result = (PersistentVector) find_the_duplicates_in_an_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}