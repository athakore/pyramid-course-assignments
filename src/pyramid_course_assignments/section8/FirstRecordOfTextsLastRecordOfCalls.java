package pyramid_course_assignments.section8;

/*
    Problem:
        What is the first record of texts and what is the last record of calls? The method
        firstAndLastRecordOfTexts should return an array containing these two strings.
        "First record of texts, <incoming number> texts <answering number> at time <time>"
        "Last record of calls, <incoming number> calls <answering number> at time <time>, lasting <duration> seconds"
        The text in brackets is what you need to fill in.

    Example:
        firstAndLastRecordOfTexts() => [
            "First record of texts, 911 texts Mama Sue at time Inf",
            "Last record of calls, 411 calls 123456798 at time 0200, lasting 987654321 seconds"
        ]
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class FirstRecordOfTextsLastRecordOfCalls {
    public static String[] firstRecordOfTextsLastRecordOfCalls() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<String> callList = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/calls.csv"));
        List<String> textList = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/texts.csv"));
        String[] lastCall = callList.get(callList.size() - 1).split(",");
        String[] firstText = textList.get(0).split(",");
        String[] result = new String[2];
        result[0] = String.format("First record of texts, %s texts %s at time %s", firstText[0], firstText[1], firstText[2]);
        result[1] = String.format("Last record of calls, %s calls %s at time %s, lasting %s seconds", lastCall[0], lastCall[1], lastCall[2], lastCall[3]);
        return result;
    }
}
