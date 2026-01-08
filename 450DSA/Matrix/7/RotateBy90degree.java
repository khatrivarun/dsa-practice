public class RotateBy90degree {
    static void rotate(int mat[][]) {
        int n = mat.length;

        // Initialize the result matrix with zeros
        int[][] result = new int[n][n];

        // Flip the matrix clockwise using nested loops
        for (int i = 0; i < n; i++)
            for (int j = 0; j < n; j++)
                result[j][n - i - 1] = mat[i][j];

        // Copy result back to the matrix
        for (int i = 0; i < n; i++) {
            System.arraycopy(result[i], 0, mat[i], 0, n);
        }
    }
}
