package pyramid_course_assignments.section7;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.count_duplicates_with_hashmap_ensuring_hashmap_was_used_test;

class CountDuplicatesWithHashmapEnsuringHashmapWasUsedTest {
    @Test
    void countDuplicatesWithHashmapEnsuringHashmapWasUsedTest() {
        PersistentVector result = (PersistentVector) count_duplicates_with_hashmap_ensuring_hashmap_was_used_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
