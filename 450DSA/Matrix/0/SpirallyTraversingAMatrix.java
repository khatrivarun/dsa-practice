import java.util.ArrayList;

public class SpirallyTraversingAMatrix {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        ArrayList<Integer> solution = new ArrayList<>();
        int leftCounter = 0, rightCounter = mat[0].length - 1, topCounter = 0, bottomCounter = mat.length - 1;

        while (leftCounter <= rightCounter && topCounter <= bottomCounter) {
            // Left to right traversal
            for (int i = leftCounter; i <= rightCounter; i++)
                solution.add(mat[topCounter][i]);
            topCounter += 1;

            // Top to bottom traversal
            for (int i = topCounter; i <= bottomCounter; i++)
                solution.add(mat[i][rightCounter]);
            rightCounter -= 1;

            // Right to left traversal
            if (topCounter <= bottomCounter)
                for (int i = rightCounter; i >= leftCounter; i--)
                    solution.add(mat[bottomCounter][i]);
            bottomCounter -= 1;

            // Bottom to top traversal
            if (leftCounter <= rightCounter)
                for (int i = bottomCounter; i >= topCounter; i--)
                    solution.add(mat[i][leftCounter]);
            leftCounter += 1;
        }

        return solution;
    }
}
