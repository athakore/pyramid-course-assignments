package pyramid_course_assignments.section3;
/*
    PROBLEM STATEMENT
        Return an array containing the largest and smallest integer in an array.
        If the array is empty, return the largest and smallest as 0.

    Example
        findMaxAndMinInArray([1,2,3,4,5]) => [1,5]
*/

public class FindMaxAndMinInArray {

    public static int[] findMaxAndMinInArray(int[] myInt) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int[] result = new int[]{0, 0};
        if(myInt.length > 0){
            result = new int[]{myInt[0], myInt[0]};
            for(int i = 1; i < myInt.length; i++){
                if(myInt[i] < result[0]) result[0] = myInt[i];
                if(myInt[i] > result[1]) result[1] = myInt[i];
            }
        }
        return result;
    }
}
