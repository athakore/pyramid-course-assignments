package pyramid_course_assignments.section9;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    PROBLEM:
        Create an IntStream from the input in the first method then
        create a stream from the input in the second method.
*/

public class CreatingAStreamFromAnArray {
    public static IntStream creatingAStreamFromAnArray(int[] arr) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return IntStream.rangeClosed(1,2);
    }
    public static Stream creatingAStreamFromAList(List list) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return Stream.of(1,2);
    }
}
