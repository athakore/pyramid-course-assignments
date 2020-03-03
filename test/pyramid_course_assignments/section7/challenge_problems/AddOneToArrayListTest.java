package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.add_one_to_array_list_test;

class AddOneToArrayListTest {
    @Test
    void addOneToArrayListTest() {
        PersistentVector result = (PersistentVector) add_one_to_array_list_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
