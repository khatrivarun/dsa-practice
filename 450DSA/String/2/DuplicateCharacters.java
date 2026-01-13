import java.util.HashMap;
import java.util.Map;

public class DuplicateCharacters {
    public static void printDuplicates(String s) {
        HashMap<Character, Integer> history = new HashMap<>();

        for (char character : s.toCharArray())
            history.put(character, history.getOrDefault(character, 0) + 1);

        for (Map.Entry<Character, Integer> mapElement : history.entrySet())
            if (mapElement.getValue() > 1) System.out.println(mapElement.getKey());
    }    
}
