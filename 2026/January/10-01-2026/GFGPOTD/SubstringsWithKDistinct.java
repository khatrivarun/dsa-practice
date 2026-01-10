package GFGPOTD;

import java.util.HashMap;

public class SubstringsWithKDistinct {
    public int countSubstr(String s, int k) {
        // Atmost K and K - 1 should give me definitely K distinct chars
        return countAtMostSubstr(s, k) - countAtMostSubstr(s, k - 1);
    }

    private int countAtMostSubstr(String s, int k) {
        // History of all characters
        HashMap<Character, Integer> characterHistory = new HashMap<>();

        // Left pointer, distinct counter and result vars
        int countDistinct = 0, left = 0, result = 0;

        for (int right = 0; right < s.length(); right++) {

            // Record history of all characters encountered
            characterHistory.put(s.charAt(right), characterHistory.getOrDefault(s.charAt(right), 0) + 1);

            // If it was encountered for the first time, increment distinct counter
            if (characterHistory.get(s.charAt(right)) == 1) countDistinct += 1;

            // If we have more distincts than we require
            // lets shorten down the subarray by incrementing
            // the left pointer and reducing distincts
            while (countDistinct > k) {
                characterHistory.put(s.charAt(left), characterHistory.get(s.charAt(left)) - 1);
                if (characterHistory.get(s.charAt(left)) == 0) countDistinct -= 1;
                left += 1;
            }

            // Number of combinations possible
            // for the current subarray
            result += right - left + 1;
        }

        return result;
    }    
}
