package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.remove_odds_from_array_test;

class RemoveOddsFromArrayTest {
    @Test
    void removeOddsFromArrayTest() {
        PersistentVector result = (PersistentVector) remove_odds_from_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
