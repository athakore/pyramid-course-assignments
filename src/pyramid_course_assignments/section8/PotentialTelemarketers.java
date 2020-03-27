package pyramid_course_assignments.section8;

/*
    PROBLEM:
        The telephone company wants to identify numbers that might be involved in
        telephone marketing. Create a set of possible telemarketers:
        these are numbers that make outgoing calls but never send texts,
        receive texts or receive incoming calls.

        The return string for potentialTelemarketers should list the telemarketers in
        lexicographic order with no duplicates.

    EXAMPLE:
        outgoingCallsFromBangalore() => "98440 68457 (044)45416964 94497"
*/

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class PotentialTelemarketers {
    public static String potentialTelemarketers() throws IOException {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        List<String> callList = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/calls.csv"));
        List<String> textList = Files.readAllLines(Paths.get("./src/pyramid_course_assignments/section8/texts.csv"));
        Set<String> outgoingCallSet = new HashSet<>();
        Set<String> textAndIncomingSet = new HashSet<>();
        for (String call : callList) {
            String[] temp = call.split(",");
            outgoingCallSet.add(temp[0]);
            textAndIncomingSet.add(temp[1]);

        }
        for (String text : textList) {
            String[] temp = text.split(",");
            textAndIncomingSet.add(temp[0]);
            textAndIncomingSet.add(temp[1]);
        }
        outgoingCallSet.removeAll(textAndIncomingSet);
        List<String> telemarketerList = new ArrayList<>(outgoingCallSet);
        Collections.sort(telemarketerList);
        String result = "";
        for(int i = 0; i < telemarketerList.size(); i++) {
            if(i != telemarketerList.size() - 1)result += telemarketerList.get(i) + " ";
            else result += telemarketerList.get(i);
        }
        //System.out.println(result);
        return result;
    }
}
