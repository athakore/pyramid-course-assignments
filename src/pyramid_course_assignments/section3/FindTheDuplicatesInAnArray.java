package pyramid_course_assignments.section3;

/*
    PROBLEM STATEMENT
        Given an input array of integers, return an array of all of the integers that appeared more than once.

    Example
        findTheDuplicatesInAnArray([1,2,2,3,3,3,4]) => [2,3]
*/

import java.util.ArrayList;
import java.util.List;

public class FindTheDuplicatesInAnArray {

    public static int[] findTheDuplicatesInAnArray(int[] myArray) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<Integer> resultList = new ArrayList<Integer>();
        if(myArray.length <= 1)return new int[]{};
        for(int i = 0; i < myArray.length; i++){
            for(int j = i + 1; j < myArray.length; j++){
                if(myArray[i] == myArray[j] && !resultList.contains(myArray[i])) resultList.add(myArray[i]);
            }
        }
        int[] result = new int[resultList.size()];
        for(int k = 0; k < result.length; k++){
            result[k] = resultList.get(k).intValue();
        }
        return result;
    }

}
