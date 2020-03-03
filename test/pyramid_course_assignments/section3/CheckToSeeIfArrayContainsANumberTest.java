package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pyramid_course_assignments.LoadTestFile.check_to_see_if_array_contains_a_number_test;

class CheckToSeeIfArrayContainsANumberTest {

    @Test
    void checkToSeeIFArrayContainsANumber() {
        PersistentVector result = (PersistentVector) check_to_see_if_array_contains_a_number_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}