package pyramid_course_assignments.section2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static pyramid_course_assignments.LoadTestFile.if_statement_test;
import static pyramid_course_assignments.LoadTestFile.user_input_assignment_test;

class IfStatementTest {

    @Test
    void max() {
        boolean result = false;
        try{
            result = (Boolean) if_statement_test.invoke();
            Assertions.assertTrue(result);
        } catch (Exception e){
            String failResult = (String) if_statement_test.invoke();
            Assertions.assertTrue(result, failResult);
        }
    }
}
