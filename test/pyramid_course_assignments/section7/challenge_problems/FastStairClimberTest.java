package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.fast_stair_climber_test;

class FastStairClimberTest {
    @Test
    void fastStairClimberTest() {
        PersistentVector result = (PersistentVector) fast_stair_climber_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
