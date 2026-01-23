public class ConvertASentenceIntoItsEquivalentMobileNumericKeypadSequence {
    String printSequence(String S) {
        StringBuilder result = new StringBuilder();

        String[] dictionary = { "2", "22", "222", "3", "33", "333", "4", "44", "444", "5", "55", "555", "6", "66", "666", "7", "77", "777", "7777", "8", "88", "888", "9", "99", "999", "9999" };

        for (int i = 0; i < S.length(); i++) {
            char letter = S.charAt(i);

            if (letter == ' ') result.append(0);
            else result.append(dictionary[letter - 'A']);
        }

        return result.toString();
    }    
}
