import java.util.HashMap;

public class SubarrayWith0Sum {
    static boolean findsum(int arr[]) {
        HashMap<Integer, Integer> history = new HashMap<>();
        history.put(0, Integer.MIN_VALUE);
        int cumulativeSum = 0;

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) return true;

            cumulativeSum += arr[i];

            if (cumulativeSum == 0) return true;

            if (history.containsKey(cumulativeSum)) return true;

            history.put(cumulativeSum, cumulativeSum);
        }

        return false;
    }
}
