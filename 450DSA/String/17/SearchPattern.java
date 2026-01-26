import java.util.ArrayList;

public class SearchPattern {

    public final static int numberOfCharacters = 256;
    public final static int oddNumberModulo = 1_000_000_007;
    
    ArrayList<Integer> search(String pattern, String mainString) {
        ArrayList<Integer> result = new ArrayList<>();

        int patternLength = pattern.length();
        int mainStringLength = mainString.length();

        if (patternLength > mainStringLength) return result;

        long patternHash = 0;
        long mainStringHash = 0;
        long multiplier = 1;

        for (int i = 0; i < patternLength - 1; i++) multiplier = (multiplier * numberOfCharacters) % oddNumberModulo;

        for (int i = 0; i < patternLength; i++) {
            patternHash = (numberOfCharacters * patternHash + pattern.charAt(i)) % oddNumberModulo;
            mainStringHash = (numberOfCharacters * mainStringHash + mainString.charAt(i)) % oddNumberModulo;
        }

        for (int i = 0; i <= mainStringLength - patternLength ; i++) {
            if (patternHash == mainStringHash) {
                boolean matchFound = true;
                for (int j = 0; j < patternLength; j++) {
                    if (mainString.charAt(i + j) != pattern.charAt(j)) {
                        matchFound = false;
                        break;
                    }
                }

                if (matchFound) result.add(i);
            }

            if (i < mainStringLength - patternLength) {
                mainStringHash = (numberOfCharacters * (mainStringHash - mainString.charAt(i) * multiplier) + mainString.charAt(i + patternLength)) % oddNumberModulo;

                if (mainStringHash < 0) mainStringHash = (mainStringHash + oddNumberModulo);
            }
        }

        return result;
    }    
}
