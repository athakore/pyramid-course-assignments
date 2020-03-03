package pyramid_course_assignments.section3;
/*
    PROBLEM STATEMENT
        Reverse an integer using arrays.

    Example
        reverseIntegerUsingArrays(486) => 684
        reverseIntegerUsingArrays(-123) => -321
*/

public class ReverseIntegerUsingArrays {

    public static int reverseIntegerUsingArrays(int myInt) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(myInt < 10 && myInt > -10) return myInt;
        boolean isNegative = myInt < 0 ? true : false;
        if(isNegative) myInt *= -1;
        String[] arr = reverseArray(Integer.toString(myInt).split(""));
        return isNegative ? -concatArray(arr) : concatArray(arr);
    }
    public static String[] reverseArray (String[] myArray) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        String[] result = new String[myArray.length];
        for(int i = 0, j = myArray.length - 1; i < myArray.length; i++, j--){
            result[i] = myArray[j];
        }
        return result;
    }
    public static int concatArray (String[] arr) {
        String result = "";
        for(int k = 0; k < arr.length; k++){
            result += arr[k];
        }
        return Integer.parseInt(result);
    }
}
