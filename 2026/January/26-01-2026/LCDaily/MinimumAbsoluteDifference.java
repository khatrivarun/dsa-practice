import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinimumAbsoluteDifference {
    public List<List<Integer>> minimumAbsDifference(int[] arr) {
        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(arr);
        int minimumDifference = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int currentDifference = Math.abs(arr[i] - arr[i + 1]);

            if (currentDifference < minimumDifference) {
                minimumDifference = currentDifference;
                result.clear();

                result.add(Arrays.asList(arr[i], arr[i + 1]));
            } else if (currentDifference == minimumDifference) {
                result.add(Arrays.asList(arr[i], arr[i + 1]));
            }
        }

        return result;
    }
}
