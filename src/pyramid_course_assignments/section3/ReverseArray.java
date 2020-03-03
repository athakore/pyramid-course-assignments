package pyramid_course_assignments.section3;
/*
    PROBLEM STATEMENT
        Return an array in the reverse order of the input array.

    Example
        reverseArray([1,2,3]) => [3,2,1]
*/

public class ReverseArray {

    public static int[] reverseArray (int[] myArray) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(myArray.length <= 1) return myArray;
        int[] result = new int[myArray.length];
        for(int i = 0, j = myArray.length - 1; i < myArray.length; i++, j--){
            result[i] = myArray[j];
        }
        return result;
    }
}
