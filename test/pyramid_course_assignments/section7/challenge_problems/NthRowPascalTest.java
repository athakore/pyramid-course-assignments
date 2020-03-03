package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.nth_row_pascal_test;

class NthRowPascalTest {
    @Test
    void nthRowPascalTest() {
        PersistentVector result = (PersistentVector) nth_row_pascal_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
