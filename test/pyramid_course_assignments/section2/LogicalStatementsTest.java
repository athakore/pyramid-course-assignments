package pyramid_course_assignments.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.logical_statements_test;

class LogicalStatementsTest {

    @Test
    void tripleShotTests() {
        boolean result = false;
        try{
            result = (Boolean) logical_statements_test.invoke();
            Assertions.assertTrue(result);
        } catch (Exception e){
            String failResult = (String) logical_statements_test.invoke();
            Assertions.assertTrue(result, failResult);
        }
    }
}
