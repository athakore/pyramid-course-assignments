package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.removing_odds_ensuring_filter_is_used_test;

class RemovingOddsEnsuringFilterIsUsedTest {
    @Test
    void removingOddsEnsuringFilterIsUsedTest() {
        PersistentVector result = (PersistentVector) removing_odds_ensuring_filter_is_used_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
