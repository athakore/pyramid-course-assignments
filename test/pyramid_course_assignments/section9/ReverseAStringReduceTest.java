package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.reverse_a_string_reduce_test;

class ReverseAStringReduceTest {
    @Test
    void reverseAStringReduceTest() {
        PersistentVector result = (PersistentVector) reverse_a_string_reduce_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
