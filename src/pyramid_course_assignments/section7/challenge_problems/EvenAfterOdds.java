package pyramid_course_assignments.section7.challenge_problems;

import java.util.ArrayList;

/*
    Problem Statement
        Given a an ArrayList of integers, arrange the elements in such a manner that
        all the elements of even numbers are placed after the odd numbers.
        The relative order of even and odd elements must not change.

    Example:

        evenAfterOdds([1 2 3 4 5 6]) => [1 3 5 2 4 6]

*/

public class EvenAfterOdds {
    public static ArrayList<Long> evenAfterOdds(ArrayList<Long> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Long> result = nums;
        for (int i = 0; i < nums.size(); i++) {
            for (int j = 0; j < nums.size() - i - 1; j++) {
                if( result.get(j) % 2 == 0 && result.get(j + 1) % 2 == 1) {
                    Long temp = result.get(j);
                    result.set(j, result.get(j + 1));
                    result.set(j + 1, temp);
                }
            }
        }
        return result;
    }
}