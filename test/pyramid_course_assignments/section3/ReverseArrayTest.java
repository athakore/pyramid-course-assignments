package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.reverse_array_test;

class ReverseArrayTest {

    @Test
    void reverseArray() {
        PersistentVector result = (PersistentVector) reverse_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
