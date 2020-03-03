package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        Return the greater of the two integers.

    Example
        max(3,6) => 6
        max(6,3) => 6
        max(6,6) => 6
*/

public class IfStatement {

    public static int max(int n, int m){
        if(n >= m) return n;
        else return m;
    }
}
