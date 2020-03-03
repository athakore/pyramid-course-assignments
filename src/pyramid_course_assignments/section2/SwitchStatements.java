package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        The method switchItUp takes an integer between 1 and 5. Using a switch statement, return a string
        equivalent for the integer input. If none of the inputs match return "none matched".

    Example
        switchItUp(4) => "four"
*/

public class SwitchStatements {

    public static String switchItUp(int n){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        switch (n) {
            case 1:
                return "one";
            case 2:
                return "two";
            case 3:
                return "three";
            case 4:
                return "four";
            case 5:
                return "five";
            default:
                return "none matched";
        }
    }
}
