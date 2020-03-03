package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        Complete the method loopdyLoop using a while loop to print numbers
        starting at the integer parameter from and ending at the integer parameter to.

    Example
        loopdyLoop(1,3);
        Output:
        1
        2
        3
*/

public class WhileLoop {

    public static void loopdyLoop(int from, int to){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int count = from;
        while(count <= to)
        {
            System.out.println(count);
            count++;
        }
    }
}
