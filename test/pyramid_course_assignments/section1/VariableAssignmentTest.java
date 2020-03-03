package pyramid_course_assignments.section1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.variable_assignment_test;

class VariableAssignmentTest {
    @Test
    void variableAssignmentTest() {
        boolean result = false;
        try{
            result = (Boolean) variable_assignment_test.invoke();
            Assertions.assertTrue(result);
        } catch (Exception e){
            String failResult = (String) variable_assignment_test.invoke();
            Assertions.assertTrue(result, failResult);
        }
    }
}
