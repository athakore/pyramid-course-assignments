package pyramid_course_assignments.section2;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.while_loop_test;

class WhileLoopTest {

    @Test
    void loopdyLoop() {
        PersistentVector result = (PersistentVector) while_loop_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));

    }
}
