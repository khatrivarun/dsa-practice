public class MaximumDifferenceBetweenPairInAMatrix {
    public static int findMaxValue(int n, int[][] mat) {
        int[][] maximumMatrix = new int[n][n];
        int maxValue = Integer.MIN_VALUE;

        // Initial Value to build the maximum matrix       
        maximumMatrix[n - 1][n - 1] = mat[n - 1][n - 1];

        // Build up the last row of all possible
        // maximum elements
        int maxElement = maximumMatrix[n - 1][n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxElement = Math.max(mat[n - 1][i], maxElement);
            maximumMatrix[n - 1][i] = maxElement;
        }
        
        // Build up the last column of all possible
        // maximum elements
        maxElement = maximumMatrix[n - 1][n - 1];
        for (int i = n - 1; i >= 0; i--) {
            maxElement = Math.max(mat[i][n - 1], maxElement);
            maximumMatrix[i][n - 1] = maxElement;
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = n - 2; j >= 0; j--) {
                // Now we calculate the max possible difference
                // since we are subtracting mat[i][j] from
                // maximumMatrix[i + 1][j + 1], we are preserving
                // c > a and d > b condition required
                maxValue = Math.max(maxValue, maximumMatrix[i + 1][j + 1] - mat[i][j]);

                // Now we need to calculate the maximumMatrix[i][j]
                // for the next iteration, and it can be either to
                // the right or the bottom of the max matrix or can
                // be the original mat[i][j] as well
                maximumMatrix[i][j] = Math.max(mat[i][j], Math.max(maximumMatrix[i][j + 1], maximumMatrix[i + 1][j]));
            }
        }

        return maxValue;
    }    
}
