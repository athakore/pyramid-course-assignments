package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pyramid_course_assignments.LoadTestFile.do_while_test;
import static pyramid_course_assignments.LoadTestFile.sum_array_test;

class SumArrayTest {

    @Test
    void sumArray() {
        PersistentVector result = (PersistentVector) sum_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}