package pyramid_course_assignments.section7.challenge_problems;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;

/*
    Problem Statement
        You are given a non-negative number in the form of list elements.
        For example, the number 123 would be provided as [1, 2, 3].
        Add one to the number and return the output in the form of a new list.
    Example 1:
        •	input = [1, 2, 3]
        •	output = [1, 2, 4]
    Example 2:
        •	input = [9, 9, 9]
        •	output = [1, 0, 0, 0]
    Challenge:
        One way to solve this problem is to convert the input array into a number and then add one to it.
        For example, if we have input = [1, 2, 3], you could solve this problem by creating the number 123 and then
        separating the digits of the output number 124.
    But can you solve it in some other way?

*/


public class AddOneToArrayList {
    public static ArrayList<Long> addOneToArrayList(ArrayList<Long> ints) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Long> result = ints;
        if(ints.size() == 0){
            result.add(Long.valueOf(1));
            return result;
        }
        while(result.get(0) == Long.valueOf(0)) {
            result.remove(0);
        }
        for(int i = result.size() - 1; i >= 0; i--) {
            if(result.get(i) == 9 && i == 0) {
                result.add(0,Long.valueOf(1));
                break;
            }
            else if (result.get(i) == 9 && i != 0) {
                result.set(i, Long. valueOf(0));
            }
            else {
                Long temp = result.get(i) + 1;
                result.set(i, temp);
                break;
            }
        }
        return result;
    }
}
