package pyramid_course_assignments.section7;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.insert_element_at_random_position_test;

class InsertElementAtRandomPositionTest {
    @Test
    void insertElementAtRandomPositionTest() {
        PersistentVector result = (PersistentVector) insert_element_at_random_position_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
