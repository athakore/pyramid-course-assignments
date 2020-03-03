package pyramid_course_assignments.section8;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.first_record_of_texts_last_record_of_calls_test;

class FirstRecordOfTextsLastRecordOfCallsTest {
    @Test
    void firstRecordOfTextsLastRecordOfCallsTest() {
        PersistentVector result = (PersistentVector) first_record_of_texts_last_record_of_calls_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}
