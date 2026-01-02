import java.util.Arrays;

public class MinimizeTheHeights {
    public int getMinDiff(int[] arr, int k) {
        int length = arr.length;

        // Edge case: If there is only 1 tower, the difference is 0
        if (length == 1)
            return 0;

        // Sort the array and get the maximum
        // possible difference before optimization
        Arrays.sort(arr);
        int minDifference = arr[length - 1] - arr[0];

        for (int i = 0; i < arr.length - 1; i++) {

            // Calculate the potential new minimum height of the entire array
            // It is the smaller of:
            //  a) The original smallest tower increased (arr[0] + k)
            //  b) The tower just after the split decreased (arr[i+1] - k)
            int minHeight = Math.min(arr[0] + k, arr[i + 1] - k);

            if (minHeight > 0) {
                // Calculate the potential new maximum height of the entire array
                // It is the larger of:
                //  a) The original tallest tower decreased (arr[length-1] - k)
                //  b) The tower just at the split increased (arr[i] + k)
                int maxHeight = Math.max(arr[length - 1] - k, arr[i] + k);
                minDifference = Math.min(minDifference, maxHeight - minHeight);
            }
        }

        // Return the min difference
        return minDifference;
    }
}
