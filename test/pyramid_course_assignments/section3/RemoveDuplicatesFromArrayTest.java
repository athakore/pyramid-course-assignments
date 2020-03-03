package pyramid_course_assignments.section3;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.remove_duplicates_from_array_test;

public class RemoveDuplicatesFromArrayTest {
    @Test
    void removeDuplicates() {
        PersistentVector result = (PersistentVector) remove_duplicates_from_array_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
