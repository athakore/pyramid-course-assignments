package pyramid_course_assignments.section9;

/*
    PROBLEM:
        Square all the numbers in the input array using the map stream method, producing a new array
        of integers that are the squares of the previous array
    EXAMPLE:
        squaringAnArray([1 2 3]) => [1 4 9]
*/

import java.util.Arrays;

public class SquaringAnArray {
    public static int[] squaringAnArray(int[] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Arrays.stream(nums).map(num -> num * num).toArray();
    }
}
