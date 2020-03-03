package pyramid_course_assignments.section2;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.if_else_test;

class IfElseTest {

    @Test
    void ifElse() {
        PersistentVector result = (PersistentVector) if_else_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));

    }
}
