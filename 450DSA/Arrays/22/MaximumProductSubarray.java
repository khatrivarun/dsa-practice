public class MaximumProductSubarray {
    int maxProduct(int[] arr) {
        int maxProduct = arr[0], minCurrentProduct = arr[0], maxCurrentProduct = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < 0) {
                int swap = maxCurrentProduct;
                maxCurrentProduct = minCurrentProduct;
                minCurrentProduct = swap;
            }

            maxCurrentProduct = Math.max(arr[i], maxCurrentProduct * arr[i]);
            minCurrentProduct = Math.min(arr[i], minCurrentProduct * arr[i]);
            maxProduct = Math.max(maxProduct, maxCurrentProduct);
        }

        return maxProduct;
    }
}
