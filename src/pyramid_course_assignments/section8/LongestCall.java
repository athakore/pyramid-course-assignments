package pyramid_course_assignments.section8;

/*
    PROBLEM:
        What number spent the longest time on the phone? Return the correct number as a string.

    EXAMPLE:
        longestCall() => 100
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongestCall {
    public static void main(String[] args) throws IOException {
    }

    public static String longestCall() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<String> input = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/calls.csv"));
        Map<String, Integer> countMap = new HashMap<>();
        for (String call : input) {
            String[] temp = call.split(",");
            if(countMap.containsKey(temp[0])) {
                Integer countTemp = countMap.get(temp[0]) + Integer.parseInt(temp[3]);
                countMap.put(temp[0], countTemp);
            }
            else countMap.put(temp[0], Integer.parseInt(temp[3]));
            if(countMap.containsKey(temp[1])) {
                Integer countTemp = countMap.get(temp[1]) + Integer.parseInt(temp[3]);
                countMap.put(temp[1], countTemp);
            }
            else countMap.put(temp[1], Integer.parseInt(temp[3]));
        }
        String result = "";
        Integer longestCount = 0;
        for (Map.Entry<String, Integer> entry : countMap.entrySet()) {
            if(result.equals("")) {
                result = entry.getKey();
                longestCount = entry.getValue();
            }
            else if(longestCount < entry.getValue()) {
                result = entry.getKey();
                longestCount = entry.getValue();
            }
        }
        return result;
    }
}
