package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        The ifElse method takes a string, if the string is "goblin" then it returns "attack the goblin!"
        If the string is "human" then it returns "you are one of us".

    Example
        ifElse("human"); => "you are one of us!"
*/

public class IfElse {

    public static String ifElse(String humanoid){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        if(humanoid.equals("human")) return "you are one of us!";
        else return "attack the goblin!";
    }
}
