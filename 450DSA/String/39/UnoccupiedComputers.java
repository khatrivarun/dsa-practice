import java.util.HashMap;

public class UnoccupiedComputers {
    public static int solve(int n, String s) {
        HashMap<String, Boolean> cache = new HashMap<>();
        int allowed = n, result = 0;

        for (int i = 0; i < s.length(); i++) {
            String person = s.substring(i, i + 1);

            if (cache.containsKey(person)) {
                if (cache.remove(person))
                    allowed += 1;
                else
                    result += 1;
            } else {
                cache.put(person, allowed > 0);
                if (allowed > 0)
                    allowed -= 1;
            }
        }

        return result;
    }
}
