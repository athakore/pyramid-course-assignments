package pyramid_course_assignments.section7.challenge_problems;

/*
    PROBLEM STATEMENT:
        A person can climb a set of stairs of length 'n' by either one, two, or three stairs at a time.
        Find the total number of combinations that a person can take to go up the set of stairs.

        ** Your fastStairClimber method needs to run in under 100 milliseconds **

    EXAMPLE:
        fastStairClimber(4) => 7

*/
public class FastStairClimber {

    public static void main(String[] args) {
        System.out.println(fastStairClimber(4));
    }
    public static int fastStairClimber(int n) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return (int) Math.pow(2, n) - n;
    }
}
