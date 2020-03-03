package pyramid_course_assignments;

public class FormatTestCode {
    public static String testFileFormatter(String s){
        return String.format("""
                package pyramid_course_assignments;

                 import clojure.lang.RT;
                 import clojure.lang.Var;

                 import java.io.IOException;

                 public class LoadTestFile {
                     static {
                         try {
                             RT.loadResourceScript("core.clj");
                         } catch (IOException e) {
                             e.printStackTrace();
                         }
                     }
                     public static Var hello_world_test = RT.var("core", "hello-world-test");
                     public static Var primitive_datatypes_test = RT.var("core", "primitive-datatypes-test");
                     public static Var variable_assignment_test = RT.var("core", "variable-assignment-test");
                     public static Var increment_test = RT.var("core", "increment-test");
                     public static Var string_manipulation_test = RT.var("core", "string-manipulation-test");
                     public static Var user_input_assignment_test = RT.var("core", "user-input-test");
                     public static Var if_statement_test = RT.var("core", "if-statement-test");
                     public static Var if_else_test = RT.var("core", "if-else-test");
                     public static Var logical_statements_test = RT.var("core", "logical-statements-test");
                     public static Var switch_it_up_test = RT.var("core", "switch-it-up-test");
                     public static Var while_loop_test = RT.var("core", "while-loop-test");
                %s
                 }
                 """, s);
    }
    public static String assignmentFormatter(String sectionName, String className, String methodName){
        return String.format(
                """
                package pyramid_course_assignments.%s;
                public class %s {
                    public static void %s() {

                    }
                }
                """, sectionName,className, methodName);
    }
    public static String testFormatter(String sectionName, String testMethodName, String testVariableName){
        return String.format("""
                package pyramid_course_assignments.%s;

                import clojure.lang.PersistentVector;
                import org.junit.jupiter.api.Assertions;
                import org.junit.jupiter.api.Test;

                import static pyramid_course_assignments.LoadTestFile.%s;

                class %s {
                    @Test
                    void %s() {
                        PersistentVector result = (PersistentVector) %s.invoke();
                        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
                    }
                }
                """, sectionName,
                     testVariableName,
                     String.valueOf(testVariableName.charAt(0)).toUpperCase() + testMethodName.substring(1),
                     testMethodName,
                     testVariableName);
    }
}
