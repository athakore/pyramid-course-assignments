package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.steps_to_take_test;

class StepsToTakeTest {
    @Test
    void stepsToTakeTest() {
        PersistentVector result = (PersistentVector) steps_to_take_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
