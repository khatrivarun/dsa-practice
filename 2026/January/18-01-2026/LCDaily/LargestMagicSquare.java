public class LargestMagicSquare {
    private int[][] rowPrefixSums;
    private int[][] columnPrefixSums;
    
    private boolean checkMagicSquare(int[][] matrix, int topRow, int leftColumn, int bottomRow, int rightColumn) {
        int targetSum = rowPrefixSums[topRow + 1][rightColumn + 1] - rowPrefixSums[topRow + 1][leftColumn];

        for (int row = topRow + 1; row <= bottomRow; row++) {
            int rowSum = rowPrefixSums[row + 1][rightColumn + 1] - rowPrefixSums[row + 1][leftColumn];
            if (rowSum != targetSum) return false;
        }

        for (int column = leftColumn; column <= rightColumn; column++) {
            int columnSum = columnPrefixSums[bottomRow + 1][column + 1] - columnPrefixSums[topRow][column + 1];
            if (columnSum != targetSum) return false;
        }

        int diagonalSum = 0;
        for (int i = topRow, j = leftColumn; i <= bottomRow; i++, j++) {
            diagonalSum += matrix[i][j];
        }
        if (diagonalSum != targetSum) return false;
        
        int antiDiagonalSum = 0;
        for (int i = topRow, j = rightColumn; i <= bottomRow; i++, j--) {
            antiDiagonalSum += matrix[i][j];
        }
        if (antiDiagonalSum != targetSum) return false;

        return true;
    }
    
    public int largestMagicSquare(int[][] grid) {
        int rows = grid.length, columns = grid[0].length;

        rowPrefixSums = new int[rows + 1][columns + 1];
        columnPrefixSums = new int[rows + 1][columns + 1];

        for (int i = 1; i <= rows; i++)
            for (int j = 1; j <= columns; j++) {
                rowPrefixSums[i][j] = rowPrefixSums[i][j - 1] + grid[i - 1][j - 1];
                columnPrefixSums[i][j] = columnPrefixSums[i - 1][j] + grid[i - 1][j - 1];
            }

        for (int size = Math.min(rows, columns); size > 1; size--) {
            for (int topRow = 0; topRow + size - 1 < rows; topRow++) {
                for (int leftColumn = 0; leftColumn + size - 1 < columns; leftColumn++) {
                    int bottomRow = topRow + size - 1;
                    int rightColumn = leftColumn + size - 1;

                    if (checkMagicSquare(grid, topRow, leftColumn, bottomRow, rightColumn)) return size;
                }
            }
        }

        return 1;

    }    
}
