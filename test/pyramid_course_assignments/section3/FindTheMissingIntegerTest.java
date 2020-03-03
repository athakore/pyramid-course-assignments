package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.find_the_missing_integer_test;

class FindTheMissingIntegerTest {

    @Test
    void findTheMissingInteger() {
        PersistentVector result = (PersistentVector) find_the_missing_integer_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
