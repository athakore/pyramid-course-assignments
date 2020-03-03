package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        Use a for loop to calculate the range of two integers, inclusively.

    Example
        forLoop(2,6) => 5
*/

public class ForLoop {
    public static int forLoop(int from, int to){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(from == to) return 0;
        int range = 0;
        for (int i = from; i <= to; i++) {
            range++;
        }
        return range;
    }
}
