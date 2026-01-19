public class MaximumSideLengthOfASquareWithSumLessThanOrEqualToThreshold {
    private int[][] prefixSums;
    private int rows;
    private int columns;
    private int threshold;

    public boolean checkIfSquareSumIsLessThanOrEqualToThreshold(int k) {
        for (int row = 0; row <= rows - k; row++) {
            for (int column = 0; column <= columns - k; column++) {
                int sum = prefixSums[row + k][column + k] - prefixSums[row + k][column] - prefixSums[row][column + k]
                        + prefixSums[row][column];

                if (sum <= threshold)
                    return true;
            }
        }

        return false;
    }

    public int maxSideLength(int[][] mat, int threshold) {
        rows = mat.length;
        columns = mat[0].length;
        this.threshold = threshold;

        prefixSums = new int[rows + 1][columns + 1];

        for (int row = 1; row <= rows; row++) {
            for (int column = 1; column <= columns; column++) {
                prefixSums[row][column] = prefixSums[row - 1][column] + prefixSums[row][column - 1]
                        - prefixSums[row - 1][column - 1] + mat[row - 1][column - 1];
            }
        }

        int lowSides = 1;
        int highSides = Math.min(rows, columns);
        int maxSide = 0;

        while (lowSides <= highSides) {
            int checkSide = lowSides + (highSides - lowSides) / 2;

            if (checkIfSquareSumIsLessThanOrEqualToThreshold(checkSide)) {
                maxSide = checkSide;
                lowSides = checkSide + 1;
            } else {
                highSides = checkSide - 1;
            }
        }

        return maxSide;
    }
}
