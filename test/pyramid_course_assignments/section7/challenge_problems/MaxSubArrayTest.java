package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.max_sub_array_test;

class MaxSubArrayTest {
    @Test
    void maxSubArrayTest() {
        PersistentVector result = (PersistentVector) max_sub_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
