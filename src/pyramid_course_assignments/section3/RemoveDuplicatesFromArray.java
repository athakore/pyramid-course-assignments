package pyramid_course_assignments.section3;
/*
    PROBLEM STATEMENT
        Given an array of integers, return an array with all duplicates removed.

    Example
        removeDuplicatesFromArray([2,3,3,6,6,7]) => [2,3,6,7]
*/

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicatesFromArray {

    public static int[] removeDuplicatesFromArray(int[] myArray) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(myArray.length <= 1) return myArray;
        Set<Integer> res = removeDuplicates(myArray);
        return setToArray(res);
    }

    public static Set<Integer> removeDuplicates(int[] arr) {
        Set<Integer> resultSet = new HashSet<Integer>();
        for (int i : arr)
        {
            resultSet.add(i);
        }
        return resultSet;
    }

    public static int[] setToArray(Set<Integer> res){
        Integer[] intResult = res.toArray(new Integer[0]);
        int[] result =  new int[intResult.length];
        for(int j = 0; j < result.length; j++){
            result[j] = intResult[j].intValue();
        }
        return result;
    }
}
