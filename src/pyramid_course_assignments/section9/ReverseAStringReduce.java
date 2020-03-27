package pyramid_course_assignments.section9;

/*
    PROBLEM:
        Reverse a string using the reduce stream method.
    EXAMPLE:
        reverseAStringReduce("abc") => "cba"
*/

import java.util.Arrays;

public class ReverseAStringReduce {
    public static String reverseAStringReduce(String letters) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Arrays.stream(letters.split("")).reduce("", (acc, next) -> next + acc);
    }
}
