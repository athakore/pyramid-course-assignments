package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.creating_a_stream_from_an_array_test;

class CreatingAStreamFromAnArrayTest {
    @Test
    void creatingAStreamFromAnArrayTest() {
        PersistentVector result = (PersistentVector) creating_a_stream_from_an_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
