import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TwoSumPairsWith0Sum {
    public static ArrayList<ArrayList<Integer>> getPairs(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        HashMap<Integer, Integer> cache = new HashMap<>();

        Arrays.sort(arr);

        for (int i = 0; i < arr.length; i++) {
            int number = arr[i];
            int toSearch = 0 - number;

            int index = Arrays.binarySearch(arr, toSearch);

            if (index >= 0 && i != index) {
                int min = Math.min(arr[index], number);
                int max = Math.max(arr[index], number);

                if (!cache.containsKey(min)) {
                    ArrayList<Integer> element = new ArrayList<>();

                    element.add(min);
                    element.add(max);

                    result.add(element);

                    cache.put(min, max);
                }
            }
        }

        return result;
    }    
}
