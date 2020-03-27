package pyramid_course_assignments.section8;

/*
    PROBLEM:
        How many different telephone numbers are there in the records? Check both csv files for the
        total amount of numbers.

    EXAMPLE:
        totalNumberOfCalls() => 90000000
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TotalNumberOfCalls {
    public static int totalNumberOfCalls() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<String> callList = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/calls.csv"));
        List<String> textList = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/texts.csv"));
        Set<String> numberSet = new HashSet<>();
        for (String call : callList) {
            String[] temp = call.split(",");
            numberSet.add(temp[0]);
            numberSet.add(temp[1]);
        }
        for (String text : textList) {
            String[] temp = text.split(",");
            numberSet.add(temp[0]);
            numberSet.add(temp[1]);
        }
        return numberSet.size();
    }
}
