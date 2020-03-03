package pyramid_course_assignments.section1;

/*
    PROBLEM STATEMENT
        Concat:
            Use string concatenation to prepend the cat string
            with cats so that the method concat returns "cats are bad"
        Interpolation:
            Use string interpolation to insert weather into "the %s is good"
            the method should return "the weather is good"

    Example
        concat();
        output: cats are bad

        interpolation();
        output: the weather is good
*/



public class StringManipulation {

    public static String concat(){
        String cats = "are bad";
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return "cats " + cats;
    }
    public static String interpolation() {
        String interpolateMe = "the %s is good";
        // ↓↓↓↓ your code goes here ↓↓↓↓
        interpolateMe = String.format(interpolateMe, "weather");
        return interpolateMe;
    }
}
