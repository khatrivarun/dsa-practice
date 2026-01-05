public class MaxSumSubarrayOfSizeK {
    public int maxSubarraySum(int[] arr, int k) {
        int subArraySum = 0;

        // First Window sum calculation
        for (int i = 0; i < k; i++) {
            subArraySum += arr[i];
        }

        int maxSum = subArraySum;

        // Check all window sums and find
        // the largest sum amongst all
        for (int i = k; i < arr.length; i++) {
            subArraySum += arr[i] - arr[i - k];
            maxSum = Math.max(maxSum, subArraySum);
        }

        return maxSum;
    }    
}
