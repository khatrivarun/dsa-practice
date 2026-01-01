import java.utils.Arrays;

public class Searcha2DMatrix {

    /*
     * Method used for the solution of the problem
     */
    public boolean searchMatrix(int[][] matrix, int target) {

        // Get dimensions of the grid
        int rows = matrix.length;
        int columns = matrix[0].length;

        // Set up Binary Search pointers
        // We treat the matrix as one long sorted list from index 0 to (total_elements - 1)
        int low = 0;
        int high = (rows * columns) - 1;

        while (low <= high) {
            // Calculate the middle index of our "virtual" 1D array
            int mid = low + (high - low) / 2;

            // Get coordinates for our middle element
            int midRow = mid / columns;
            int midColumn = mid % columns;

            // Check if the element is our target
            // or else update Binary Search pointers
            // accordingly
            if (matrix[midRow][midColumn] == target)
                return true;
            else if (matrix[midRow][midColumn] > target)
                high = mid - 1;
            else
                low = mid + 1;
        }

        return false;

    }

}
