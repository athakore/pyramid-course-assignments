package pyramid_course_assignments.section9;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.squaring_an_array_ensuring_map_is_used_test;

class SquaringAnArrayEnsuringMapIsUsedTest {
    @Test
    void squaringAnArrayEnsuringMapIsUsedTest() {
        PersistentVector result = (PersistentVector) squaring_an_array_ensuring_map_is_used_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
