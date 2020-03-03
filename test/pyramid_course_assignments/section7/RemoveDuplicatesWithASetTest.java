package pyramid_course_assignments.section7;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.remove_duplicates_with_a_set_test;

class RemoveDuplicatesWithASetTest {
    @Test
    void removeDuplicatesWithASetTest() {
        PersistentVector result = (PersistentVector) remove_duplicates_with_a_set_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
