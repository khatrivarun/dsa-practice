public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < strs[0].length(); i++) {
            char compareCharacter = strs[0].charAt(i);
            int j = 1;
            
            for (;j < strs.length; j++) {
                if (strs[j].length() <= i || strs[j].charAt(i) != compareCharacter) break;
            }

            if (j != strs.length) {
                break;
            } else {
                result.append(compareCharacter);
            }
        }

        return result.toString();
    }
}
