import java.util.LinkedList;
import java.util.Collections;

public class SortedMatrix {
    int[][] sortedMatrix(int N, int Mat[][]) {
        LinkedList<Integer> sorted = new LinkedList<>();

        // Step 1: Add all elements in a list
        for (int i = 0; i < Mat.length; i++)
            for (int j = 0; j < Mat[i].length; j++)
                sorted.add(Mat[i][j]);

        // Step 2: Sort the list
        Collections.sort(sorted);

        // Step 3: Replace the matrix with
        // sorted elements
        int counter = 0;
        for (int i = 0; i < Mat.length; i++)
            for (int j = 0; j < Mat[i].length; j++) {
                Mat[i][j] = sorted.get(counter);
                counter += 1;
            }

        return Mat;
    }    
}
