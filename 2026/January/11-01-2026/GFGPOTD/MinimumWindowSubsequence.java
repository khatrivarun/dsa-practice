public class MinimumWindowSubsequence {
    public String minWindow(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();
        String ans = "";
        int minimumLength = Integer.MAX_VALUE;

        // Iterate through every possible starting position in s1
        for (int i = 0; i < n; i++) {

            // Only start checking if the current character matches the start of the pattern
            if (s1.charAt(i) == s2.charAt(0)) {

                int p1 = i; // Start scanning s1 from current index i
                int p2 = 0; // Start scanning s2 from the beginning

                // Find the end of the subsequence
                while (p1 < n && p2 < m) {
                    if (s1.charAt(p1) == s2.charAt(p2)) {
                        p2++; // Move to next char in pattern if we found a match
                    }
                    p1++; // Always move forward in source string
                }

                // If we successfully matched the full pattern
                if (p2 == m) {
                    // we calculate the length from our current
                    // start point (i) to where we finished (p1).
                    int currentLength = p1 - i;

                    if (currentLength < minimumLength) {
                        minimumLength = currentLength;
                        ans = s1.substring(i, p1);
                    }
                }
            }
        }
        return ans;
    }
}
