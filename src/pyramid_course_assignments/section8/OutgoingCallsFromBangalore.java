package pyramid_course_assignments.section8;

/*
    PROBLEM:
        Find all of the area codes and mobile prefixes called by people in Bangalore.
            - Fixed lines start with an area code enclosed in parenthesis. The area
              codes vary in length but always begin with 0.
            - Mobile numbers have no parentheses, but have a space in the middle
              of the number to help readability. The prefix of a mobile number
              is its first four digits, and they always start with 7, 8 or 9.
            - Telemarketers' numbers have no parentheses or space, but they start
              with the area code 140.
        The return string for outgoingCallsFromBangalore should be all the area codes in
        lexicographic order with no duplicates.

    EXAMPLE:
        outgoingCallsFromBangalore() => "080 110 5538"
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

public class OutgoingCallsFromBangalore {
    public static String outgoingCallsFromBangalore() throws IOException {
        String result = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/calls.csv")).stream().filter(call -> {
            String[] temp = call.split(",");
            return temp[0].substring(0, 5).equals("(080)");
        }).map(call -> {
            String[] temp = call.split(",");
            return temp[1].charAt(0) == '(' ? temp[1].substring(1, 4) : temp[1].substring(0, 4);
        }).distinct().sorted().reduce("", (acc, next) -> acc + next + " ").trim();
        System.out.println("\"" + result + "\"");
        return result;
    }
}
