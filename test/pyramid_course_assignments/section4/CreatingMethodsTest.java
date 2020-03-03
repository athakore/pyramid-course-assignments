package pyramid_course_assignments.section4;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class CreatingMethodsTest {
    CreatingMethods test = new CreatingMethods();

    Method returnLapsWalked = CreatingMethods.class.getMethod("returnLapsWalked");
    Method takeAWalk = CreatingMethods.class.getMethod("takeAWalk");

    Field name = CreatingMethods.class.getField("name");
    Field parkName = CreatingMethods.class.getField("parkName");
    Field lapsWalked = CreatingMethods.class.getField("lapsWalked");

    CreatingMethodsTest() throws NoSuchMethodException, NoSuchFieldException {
    }

    @Test
    void takeAWalkMethodTest() throws InvocationTargetException, IllegalAccessException {
        Assertions.assertEquals("Jack you walked 5 laps at (And Around We Go) today!", takeAWalk.invoke(test), "takeAWalk() did not return the correct string.");
    }
    @Test
    void returnLapsWalkedTest() throws InvocationTargetException, IllegalAccessException {
        Assertions.assertEquals(5, returnLapsWalked.invoke(test), "returnLapsWalked() did not return the correct value.");
    }
    @Test
    void creatingMethodNameTest() throws IllegalAccessException {
        Assertions.assertEquals("Jack", name.get(test), "name was not the correct value.");
    }
    @Test
    void creatingMethodParkNameTest() throws IllegalAccessException {
        Assertions.assertEquals("(And Around We Go)", parkName.get(test), "parkName was not the correct value.");
    }
    @Test
    void creatingMethodLapsWalkedTest() throws IllegalAccessException {
        Assertions.assertEquals(10, lapsWalked.get(test), "lapsWalked was not the correct value. ");
    }
}
