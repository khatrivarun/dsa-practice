public class LongestPalindromeInAString {
    static String longestPalindrome(String s) {
        int maxLength = 1, start = 0;

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= 1; j++) {
                int low = i;
                int high = i + j;

                while (low >= 0 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                    int currentLength = high - low + 1;
                   if (currentLength > maxLength) {
                       maxLength = currentLength;
                       start = low;
                   }

                   low -= 1;
                   high += 1; 
                }
            }
        }

        return s.substring(start, start + maxLength);
    }
}
