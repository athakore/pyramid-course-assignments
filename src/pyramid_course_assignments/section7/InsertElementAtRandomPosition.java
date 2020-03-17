package pyramid_course_assignments.section7;

import javax.swing.table.AbstractTableModel;
import java.lang.reflect.Array;
import java.util.ArrayList;

/*
    PROBLEM STATEMENT
        Insert a random element at a random index into a random ArrayList. If the index
        exceeds the size of the ArrayList return the ArrayList unmodified.

    EXAMPLE:
        insertElementAtRandomPosition([1 2], 1, 500) => [1, 500, 2]
        insertElementAtRandomPosition([1 2], 2, 500) => [1, 2, 500]
        insertElementAtRandomPosition([1 2], 3, 500) => [1, 2]
*/

public class InsertElementAtRandomPosition {
    public static ArrayList<Integer> insertElementAtRandomPosition(ArrayList<Integer> nums, int index, int element) {
        // ↓↓↓↓ your code goes here ↓↓↓↓
        ArrayList<Integer> result = nums;
        if(index <= nums.size())result.add(index,element);
        return result;
    }
}
