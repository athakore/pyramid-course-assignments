package pyramid_course_assignments.section3;

/*
    PROBLEM STATEMENT
        The method below is given an array of integers and an integer.
        Check to see if that integer appears in the array.

    Example
        checkToSeeIFArrayContainsANumber([1,2,3,4,5], 6) => false
        checkToSeeIFArrayContainsANumber([1,2,3,4,5], 5) => true
*/

public class CheckToSeeIfArrayContainsANumber {

    public static boolean checkToSeeIFArrayContainsANumber(int[] myArray, int theInt) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        for (int i: myArray) {
            if(i == theInt) return true;
        }
        return false;
    }
}
