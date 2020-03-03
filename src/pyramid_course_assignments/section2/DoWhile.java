package pyramid_course_assignments.section2;

/*
    PROBLEM STATEMENT
        Use a do while loop to reverse the string "abc".

    Example
        doWhile("abc") => "cba"
*/

public class DoWhile {

    public static String doWhile(String abc){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int count = abc.length();
        String result = "";
        if(abc.length() > 0) {
            do {
                result += abc.charAt(count - 1);
                count--;
            } while (count > 0);
        }
        return result;
    }
}


