package pyramid_course_assignments.section8;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.potential_telemarketers_test;

class PotentialTelemarketersTest {
    @Test
    void potentialTelemarketersTest() {
        PersistentVector result = (PersistentVector) potential_telemarketers_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
