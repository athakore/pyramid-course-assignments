package pyramid_course_assignments.section4;

import clojure.lang.PersistentVector;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static pyramid_course_assignments.LoadTestFile.animal_test;

class AnimalTest {

    @Test
    void animalTest() {
        PersistentVector result = (PersistentVector) animal_test.invoke();
        Assertions.assertTrue((boolean)result.get(0), (String)result.get(1));
    }
}