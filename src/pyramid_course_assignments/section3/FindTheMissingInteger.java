package pyramid_course_assignments.section3;

/*
    PROBLEM STATEMENT
        Given an array of integers starting from 1, return the integer missing in the incremental sequence.
        Return 0 if there is no missing integer in the sequence.

    Example
        findTheMissingInteger([1,2,3,5]) => 4
*/

public class FindTheMissingInteger {

    public static int findTheMissingInteger(int[] myArray) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(myArray.length != 0 && myArray[0] != 1) return 1;
        for(int i = 0; i < myArray.length; i++){
            if(i + myArray[0] != myArray[i]) return i + myArray[0];
        }
        return 0;
    }
}
