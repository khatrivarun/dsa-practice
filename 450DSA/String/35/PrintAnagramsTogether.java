import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class PrintAnagramsTogether {
    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        HashMap<String, ArrayList<String>> anagramGroups = new HashMap<>();

        for (String word : arr) {
            char[] characterArray = word.toCharArray();

            Arrays.sort(characterArray);
            String sortedString = String.valueOf(characterArray);

            ArrayList<String> group = anagramGroups.getOrDefault(sortedString, new ArrayList<String>());
            group.add(word);
            anagramGroups.put(sortedString, group);
        }

        ArrayList<ArrayList<String>> result = new ArrayList<>();

        for (String group : anagramGroups.keySet()) result.add(anagramGroups.get(group));
        
        return result;
    }
}
