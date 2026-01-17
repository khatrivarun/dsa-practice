import java.util.HashMap;

public class IsomorphicStrings {
    public boolean areIsomorphic(String s1, String s2) {
        if (s1.length() != s2.length()) return false;

        HashMap<String, Integer> s1IndicesMap = new HashMap<>();
        HashMap<String, Integer> s2IndicesMap = new HashMap<>();

        for (int i = 0; i < s1.length(); i++) {
            String s1SubString = s1.substring(i, i + 1);
            String s2SubString = s2.substring(i, i + 1);

            if (!s1IndicesMap.containsKey(s1SubString)) s1IndicesMap.put(s1SubString, i);
            if (!s2IndicesMap.containsKey(s2SubString)) s2IndicesMap.put(s2SubString, i);

            if (!s1IndicesMap.get(s1SubString).equals(s2IndicesMap.get(s2SubString))) return false;
        }
    
        return true;
    }    
}
