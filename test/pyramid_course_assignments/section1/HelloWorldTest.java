package pyramid_course_assignments.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.hello_world_test;

public class HelloWorldTest {
    @Test
    void mainTest() {
        Object result = hello_world_test.invoke();
        Assertions.assertTrue((Boolean) result);
    }
}
