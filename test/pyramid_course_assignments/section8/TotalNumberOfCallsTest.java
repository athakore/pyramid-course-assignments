package pyramid_course_assignments.section8;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.total_number_of_calls_test;

class TotalNumberOfCallsTest {
    @Test
    void totalNumberOfCallsTest() {
        PersistentVector result = (PersistentVector) total_number_of_calls_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
