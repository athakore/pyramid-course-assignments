package pyramid_course_assignments.section7;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

/*
    PROBLEM STATEMENT
        Use a set to remove the duplicates from an ArrayList.

    EXAMPLES:
        removeDuplicatesWithASet([1, 1]) => [1]
        removeDuplicatesWithASet([1]) => [1]
        removeDuplicatesWithASet([]) => []
        removeDuplicatesWithASet([1, 1, 1, 2, 2]) => [1, 2]
*/

public class RemoveDuplicatesWithASet {

    /*public static ArrayList<Long> removeDuplicatesWithASet(ArrayList<Integer> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        HashSet<Long> temp = new HashSet<>();
        nums.forEach((i) -> temp.add(i.longValue()));
        return new ArrayList<Long>(temp);
    }*/

    public static ArrayList<Long> removeDuplicatesWithASet(ArrayList<Long> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        HashSet<Long> temp = new HashSet<>();
        nums.forEach((i) -> temp.add(i));
        return new ArrayList<Long>(temp);
    }
}
