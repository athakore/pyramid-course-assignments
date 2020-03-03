package pyramid_course_assignments.section1;

import clojure.core.Vec;
import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pyramid_course_assignments.LoadTestFile.string_manipulation_test;
import static pyramid_course_assignments.LoadTestFile.user_input_assignment_test;

class UserInputAssignmentTest {

    @Test
    void convertAndAddNums() {
        PersistentVector result = (PersistentVector) user_input_assignment_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
