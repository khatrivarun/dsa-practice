public class KadanesAlgorithm {
    int maxSubarraySum(int[] arr) {
        // Initial subarray sum
        int result = arr[0];

        // Temporary sum
        int tempSum = arr[0];

        // Calculate the maximum sum possible
        for (int i = 1; i < arr.length; i++) {
            // Either we continue the subarray sum
            // or start with a new subarray
            tempSum = Math.max(tempSum + arr[i], arr[i]);
            result = Math.max(result, tempSum);
        }

        return result;
    }    
}
