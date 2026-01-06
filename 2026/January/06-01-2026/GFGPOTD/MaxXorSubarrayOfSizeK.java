public class MaxXorSubarrayOfSizeK {
    public int maxSubarraySum(int[] arr, int k) {
        int subArrayXor = 0;

        // First Window Xor calculation
        for (int i = 0; i < k; i++) {
            subArrayXor ^= arr[i];
        }

        int maxXor = subArrayXor;

        // Check all window xors and find
        // the largest xor amongst all
        for (int i = k; i < arr.length; i++) {
            subArrayXor ^= arr[i - k];
            subArrayXor ^= arr[i];
            maxXor = Math.max(maxXor, subArrayXor);
        }

        return maxXor;
    }    
}
