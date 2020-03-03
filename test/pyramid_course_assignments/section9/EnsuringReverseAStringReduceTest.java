package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.ensuring_reverse_a_string_reduce_test;

class EnsuringReverseAStringReduceTest {
    @Test
    void ensuringReverseAStringReduceTest() {
        PersistentVector result = (PersistentVector) ensuring_reverse_a_string_reduce_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
