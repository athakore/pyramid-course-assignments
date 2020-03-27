package pyramid_course_assignments.section9;

/*
    PROBLEM:
        Remove the odd numbers from an array using the filter stream method.
    EXAMPLE:
        removeOddsFromArray([1 1 2 3 4]) => [2 4]
        removeOddsFromArray([2 4 6]) => [2 4 6]
        removeOddsFromArray([1 3]) => []
        removeOddsFromArray([]) => []
*/

import java.util.Arrays;
import java.util.stream.Stream;

public class RemoveOddsFromArray {
    public static int[] removeOddsFromArray(int[] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Arrays.stream(nums).filter(num -> num % 2 == 1).toArray();
    }
}
