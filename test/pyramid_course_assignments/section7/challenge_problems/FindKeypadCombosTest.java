package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.find_keypad_combos_test;

class FindKeypadCombosTest {
    @Test
    void findKeypadCombosTest() {
        PersistentVector result = (PersistentVector) find_keypad_combos_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
