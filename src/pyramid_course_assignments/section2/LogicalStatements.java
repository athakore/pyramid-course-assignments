package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        tripleShot() method tests whether all three booleans are true
        tripleShotAgain() method tests whether one of the three booleans are true

    Example
        tripleShot(true, true, false) => false
        tripleShotAgain(false, true, false) => true
*/

public class LogicalStatements {

    public static boolean tripleShot(boolean one, boolean two, boolean three){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(one == true && two == true && three == true) return true;
        else return false;
    }
    public static boolean tripleShotAgain(boolean one, boolean two, boolean three){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(one == true || two == true || three == true) return true;
        else return false;
    }
}
