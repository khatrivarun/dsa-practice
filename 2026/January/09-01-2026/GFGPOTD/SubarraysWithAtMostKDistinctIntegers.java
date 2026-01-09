package GFGPOTD;

import java.util.HashMap;

public class SubarraysWithAtMostKDistinctIntegers {
    public int countAtMostK(int arr[], int k) {
        int result = 0, left = 0, right = 0, countDistinct = 0;
        HashMap<Integer, Integer> distinctElements = new HashMap<>();

        // The idea is to find the count of subarrays
        // with atmost k distinct elements
        while (right < arr.length) {
            distinctElements.put(arr[right], distinctElements.getOrDefault(arr[right], 0) + 1);

            // If the current element is distinct
            // increment the number of distinct elements
            if (distinctElements.get(arr[right]) == 1) countDistinct += 1;

            // if we have exceeded number of
            // distinct required, lets shorten
            // down the subarray to arrive at
            // most k distinct elements
            while (countDistinct > k) {
                distinctElements.put(arr[left], distinctElements.get(arr[left]) - 1);
                if (distinctElements.get(arr[left]) == 0) countDistinct -= 1;
                left += 1;
            }

            // Counting the number of possible
            // subarrays here at right
            result += right - left + 1;
            right += 1;
        }

        return result;
    }    
}
