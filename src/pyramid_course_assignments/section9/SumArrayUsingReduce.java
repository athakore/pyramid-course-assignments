package pyramid_course_assignments.section9;

/*
    PROBLEM:
        Sum an array using the stream method reduce.
    EXAMPLE:
        sumArrayUsingReduce([1 2 3]) => 6
*/

import java.util.Arrays;

public class SumArrayUsingReduce {
    public static int sumArrayUsingReduce(int [] nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Arrays.stream(nums).reduce(0, (acc, next) -> acc + next);
    }
}
