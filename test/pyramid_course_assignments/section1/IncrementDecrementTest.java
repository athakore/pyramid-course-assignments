package pyramid_course_assignments.section1;

import clojure.lang.RT;
import clojure.lang.Var;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.increment_test;

class IncrementDecrementTest {
    @Test
    void increment() {
        Object result = increment_test.invoke();
        Assertions.assertTrue((Boolean) result,
                """

                           Expected return value is 2, either return is wrong
                           or you did not use the increment operator
                       """);
    }
    @Test
    void decrement() {
        Var decrement_test = RT.var("core", "decrement-test");
        Object result = decrement_test.invoke();
        Assertions.assertTrue((Boolean) result,
                """

                           Expected return value is 0, either return is wrong
                           or you did not use the decrement operator
                       """);
    }
}
