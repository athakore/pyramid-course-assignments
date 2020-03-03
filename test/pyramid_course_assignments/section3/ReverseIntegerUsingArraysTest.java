package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.reverse_integer_using_arrays_test;

class ReverseIntegerUsingArraysTest {
    @Test
    void reverseIntegerUsingArraysTest() {
        PersistentVector result = (PersistentVector) reverse_integer_using_arrays_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
