import java.util.ArrayList;
import java.util.Collections;

public class MedianInARowWiseSortedMatrix {
    public int median(int[][] mat) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        // Step 1: add all elements of the
        // matrix in the array list
        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                arrayList.add(mat[i][j]);

        // Step 2: Sort the list
        Collections.sort(arrayList);

        // Step 3: Return the mid element
        return arrayList.get(arrayList.size() / 2);
    }
}
