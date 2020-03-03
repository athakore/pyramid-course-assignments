package pyramid_course_assignments.section1;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.string_manipulation_test;

class StringManipulationTest {

    @Test
    void stringManipulation() {
        PersistentVector result = (PersistentVector) string_manipulation_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
