public class CountSubarrayWithKOdds {
    public int countSubarrays(int[] arr, int k) {
        // Exactly K = At Most K - At Most K - 1
        return countAtMost(arr, k) - countAtMost(arr, k - 1);
    }

    public int countAtMost(int arr[], int k) {
        int numberOfOdds = 0;
        int result = 0;
        int subArrayStart = 0;

        // The idea is to find the count of subarrays
        // with atmost k odd elements
        for (int i = 0; i < arr.length; i++) {

            // If the current element is odd
            // increment the number of odds
            if(arr[i] % 2 != 0) numberOfOdds += 1;

            // if we have exceeded number of
            // odds required, lets shorten
            // down the subarray to arrive at
            // most k odd elements
            while (numberOfOdds > k) {
                if (arr[subArrayStart] % 2 != 0) numberOfOdds -= 1;
                subArrayStart += 1;
            }

            // Counting the number of possible
            // subarrays here at i
            result += i - subArrayStart + 1;
        }

        return result;
    }    
}
