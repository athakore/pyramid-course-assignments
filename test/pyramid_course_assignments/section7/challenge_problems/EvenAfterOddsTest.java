package pyramid_course_assignments.section7.challenge_problems;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.even_after_odds_test;

class EvenAfterOddsTest {
    @Test
    void evenAfterOddsTest() {
        PersistentVector result = (PersistentVector) even_after_odds_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
