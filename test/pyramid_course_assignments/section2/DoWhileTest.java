package pyramid_course_assignments.section2;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.do_while_test;

class DoWhileTest {

    @Test
    void doWhile() {
        PersistentVector result = (PersistentVector) do_while_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
