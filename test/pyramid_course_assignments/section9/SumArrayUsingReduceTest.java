package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.sum_array_using_reduce_test;

class SumArrayUsingReduceTest {
    @Test
    void sumArrayUsingReduceTest() {
        PersistentVector result = (PersistentVector) sum_array_using_reduce_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
