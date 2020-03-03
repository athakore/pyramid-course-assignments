package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.last_index_found_test;

class LastIndexFoundTest {
    @Test
    void lastIndexFoundTest() {
        PersistentVector result = (PersistentVector) last_index_found_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
