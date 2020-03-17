package pyramid_course_assignments.section4;

/*
    PROBLEM STATEMENT
        The CreatingMethods class should have three fields, a name of Jack, a parkName of (And Around We Go), and
        a lapsWalked of 10. There should also be two methods. the returnLapsWalked method should set the lapsWalked to
        five, and return the field lapsWalked. There should also be a method takeAWalk which returns a string that is the
        concatenation of the name and parkName variables, the string should look like the one in the example below.

    Example
        CreatingMethods obj = new CreatingMethods();
        obj.lapsWalked => 10
        obj.takeAWalk() => "Jack you walked 5 laps at (And Around We Go) today!"
*/

public class CreatingMethods {
    // ↓↓↓↓ your code goes here ↓↓↓↓
    public String name = "Jack";
    public String parkName = "(And Around We Go)";
    public int lapsWalked = 10;

    public int returnLapsWalked() {
        lapsWalked = 5;
        return lapsWalked;
    }

    public String takeAWalk() {
        return String.format("%s you walked %s laps at %s today!", name, returnLapsWalked(), parkName);
    }
}
