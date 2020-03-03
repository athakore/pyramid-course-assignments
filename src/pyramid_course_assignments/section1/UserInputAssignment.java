package pyramid_course_assignments.section1;

/*
    PROBLEM STATEMENT
        Get some input from the user using a scanner.
        The scanner should take two numbers and add them together,
        printing the result to the console.

    Example
        Input:
        2
        4
        Output:
        6
*/

import java.util.Scanner;

public class UserInputAssignment {

    public static int convertAndAddNums(String n, String m){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        int sum = Integer.parseInt(n) + Integer.parseInt(m);
        return sum;
    }
    public static void main(String [] args){
        // ↓↓↓↓ your code goes here ↓↓↓↓
        Scanner input = new Scanner(System.in);
        String i = input.next();
        String j = input.next();
        System.out.println(convertAndAddNums(i, j));

    }
}
