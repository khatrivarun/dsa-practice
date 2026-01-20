public class SplitTheBinaryStringIntoSubstringsWithEqualNumberOf0SAnd1S {
    public static int maxSubStr(String str) {
        int countZero = 0, countOne = 0, result = 0;

        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') countOne += 1;
            else countZero += 1;

            if (countOne == countZero) {
                countZero = 0;
                countOne = 0;

                result += 1;
            }
        }

        return (result == 0 || countZero != countOne) ? -1 : result;
    }    
}
