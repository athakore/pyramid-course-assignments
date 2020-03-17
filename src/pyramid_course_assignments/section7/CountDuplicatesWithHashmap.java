package pyramid_course_assignments.section7;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/*
    PROBLEM STATEMENT
        Count the amount of duplicates in a hashmap. This method should return an ArrayList
        filled with strings that should be in a format that would easily be printable.
        The exact format should appear as the return in the example below.

    EXAMPLE:
        countDuplicatesWithHashmap([1, 1, 2, 4, 4, 3, 4, 4]) => ["There are: " "2 1s\n" "1 2s\n" "4 4s\n" "1 3s\n"]
*/

public class CountDuplicatesWithHashmap {
    public static ArrayList<String> countDuplicatesWithHashmap(ArrayList<Long> nums) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(nums.size() == 1) return new ArrayList<>(){{
            add("There are: ");
            add(String.format("1 %ss\n", nums.get(0)));
        }};
        ArrayList<String> result = new ArrayList<>();
        Map<Integer, Long> map = new HashMap<>();
        for (int i = 0; i < nums.size(); i++) {
            map.put(i, nums.get(i));
        }
        result.add("There are: ");
        for(int j = 0; j < nums.size(); j++) {
            if(map.get(j) != null){
                int count = 0;
                for(int k = j + 1; k < nums.size(); k++) {
                    if(map.get(j) == map.get(k)){
                        count ++;
                        map.remove(k);
                    }
                }
                count++;
                result.add(String.format("%s %ss\n", count, map.get(j)));
                map.remove(j);
            }
        }
        return result;
    }
}
