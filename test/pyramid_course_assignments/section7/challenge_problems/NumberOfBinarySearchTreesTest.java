package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.number_of_binary_search_trees_test;

class NumberOfBinarySearchTreesTest {
    @Test
    void numberOfBinarySearchTreesTest() {
        PersistentVector result = (PersistentVector) number_of_binary_search_trees_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
