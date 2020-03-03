package pyramid_course_assignments.section8;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.outgoing_calls_from_bangalore_test;

class OutgoingCallsFromBangaloreTest {
    @Test
    void outgoingCallsFromBangaloreTest() {
        PersistentVector result = (PersistentVector) outgoing_calls_from_bangalore_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
