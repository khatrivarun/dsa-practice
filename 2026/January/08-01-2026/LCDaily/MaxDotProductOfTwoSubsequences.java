public class MaxDotProductOfTwoSubsequences {
    public int maxDotProduct(int[] nums1, int[] nums2) {
        // Recording all possible combinations of dot product
        // in the dynamic programming matrix with first row and
        // column being in the initial states and then carrying
        // forward
        int[][] maxMatrix = new int[nums1.length + 1][nums2.length + 1];

        // Initializing the matrix as the minimum
        // possible value
        for (int i = 0; i < maxMatrix.length; i++)
            for (int j = 0; j < maxMatrix[i].length; j++)
                maxMatrix[i][j] = Integer.MIN_VALUE;

        // We start with 1 since 0 is the empty state
        for (int i = 1; i <= nums1.length; i++)
            for (int j = 1; j <= nums2.length; j++) {
                // We are first checking current product of when
                // we start completely fresh from no history?
                int freshProduct = nums1[i - 1] * nums2[j - 1];

                // Then we check first if we can pickup
                // any values from previous iterations
                // i.e. what if I only considered
                // previous nums1 or nums2 and not the current?
                maxMatrix[i][j] = Math.max(maxMatrix[i][j - 1], maxMatrix[i - 1][j]);

                // Then we check if we can continue an existing
                // dot product or are we good to use the previous
                // iteration itself or is it good to start completely new
                maxMatrix[i][j] = Math.max(maxMatrix[i][j], Math.max(maxMatrix[i - 1][j - 1], 0) + freshProduct);
            }

        return maxMatrix[nums1.length][nums2.length];
    }
}
