package pyramid_course_assignments.section2;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.switch_it_up_test;

class SwitchStatementsTest {

    @Test
    void switchItUp() {
        PersistentVector result = (PersistentVector) switch_it_up_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
