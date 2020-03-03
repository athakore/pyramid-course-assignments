package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.find_max_and_min_in_array_test;

class FindMaxAndMinInArrayTest {

    @Test
    void findMaxAndMinInArray() {
        PersistentVector result = (PersistentVector) find_max_and_min_in_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}