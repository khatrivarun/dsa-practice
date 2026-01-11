public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;
        int[][] dynamicProgramming = new int[rows][columns];
        int result = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                // If there is a 0, limit
                // of the rectangle reached
                if (matrix[i][j] == '0') continue;

                // Compute width of 1's at (i, j)
                // Start with 1 if we are the
                // starting edge else contineu from
                // before
                dynamicProgramming[i][j] = j == 0 ? 1 : dynamicProgramming[i][j - 1] + 1;

                // Take the current width
                int width = dynamicProgramming[i][j];

                // Traverse upwards row by row,
                // update minimum width and calculate area.
                for (int k = i; k >= 0; k--) {

                    // Take the minimum possible width
                    // to construct a proper rectangle
                    width = Math.min(width, dynamicProgramming[k][j]);

                    // Calculate the area
                    int area = width * (i - k + 1);

                    // And make sure the max possible
                    // is saved
                    result = Math.max(result, area);
                }
            }
        }

        return result;
    }    
}
