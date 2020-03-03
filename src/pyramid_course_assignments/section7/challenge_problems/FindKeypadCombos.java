package pyramid_course_assignments.section7.challenge_problems;

import java.util.ArrayList;

/*
    PROBLEM STATEMENT:

        A keypad on a cellphone has alphabets for all numbers between 2 and 9.
        You can make different combinations of alphabets by pressing the numbers.
        For example, if you press 23, the following combinations are possible:
            ad, ae, af, bd, be, bf, cd, ce, cf
        Note that because 2 is pressed before 3, the first letter is always an alphabet on the number 2.
        Likewise, if the user types 32, the order would be:
            da, db, dc, ea, eb, ec, fa, fb, fc
        Given an integer num, find out all the possible strings that can be made using digits of input num.
        Return these strings in a list. The order of strings in the list does not matter. However, as stated
        earlier, the order of the letters in a particular string matters.
*/

public class FindKeypadCombos {
    //Use this helper method to solve the problem
    static String getCharacters(int num){
        return switch (num) {
            case 2 -> "abc";
            case 3 -> "def";
            case 4 -> "ghi";
            case 5 -> "jkl";
            case 6 -> "mno";
            case 7 -> "pqrs";
            case 8 -> "tuv";
            case 9 -> "wxyz";
            default -> "";
        };
    }


    public static ArrayList<String> findKeypadCombos(int n) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        return new ArrayList<>();
    }
}
