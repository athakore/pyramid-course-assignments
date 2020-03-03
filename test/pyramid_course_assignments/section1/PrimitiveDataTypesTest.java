package pyramid_course_assignments.section1;

import clojure.lang.LazySeq;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicReference;

import static pyramid_course_assignments.LoadTestFile.primitive_datatypes_test;

class PrimitiveDataTypesTest {
    @Test
    void primitiveDataTypesTest() {

        boolean result = false;
        try{
            result = (Boolean) primitive_datatypes_test.invoke();
            Assertions.assertTrue(result);
        } catch (Exception e){
            LazySeq seq = (LazySeq) primitive_datatypes_test.invoke();
            AtomicReference<String> failString = new AtomicReference<>("\n");
            seq.forEach(i -> failString.updateAndGet(v -> v + i));
            System.out.println(failString.get());
            Assertions.assertTrue(result, failString.get());
        }
    }
}
