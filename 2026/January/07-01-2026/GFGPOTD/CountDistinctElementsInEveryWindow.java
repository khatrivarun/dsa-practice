package GFGPOTD;

import java.util.ArrayList;
import java.util.HashMap;

public class CountDistinctElementsInEveryWindow {
    /**
     * Solution method for counting distinct
     * elements in each window, strategy is
     * to use a hashmap and keep a track of
     * frequencies over there and the size
     * of the hashmap is the number of
     * distinct elements in the given window
     * @param arr: Array
     * @param k: Window size
     * @return array with number of distinct
     * elements in each window
     */
    ArrayList<Integer> countDistinct(int arr[], int k) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        HashMap<Integer, Integer> history = new HashMap<>();

        // First window calculation
        for (int i = 0; i < k; i++) history.put(arr[i], history.getOrDefault(arr[i], 0) + 1);
        arrayList.add(history.size());

        // Subsequent windows calculation
        for (int i = k; i < arr.length; i++) {
            // Add in the element in the window
            history.put(arr[i], history.getOrDefault(arr[i], 0) + 1);

            // Remove the elemment out of the window
            history.put(arr[i - k], history.get(arr[i - k]) - 1);

            // if the frequency is 0, remove it from the hashmap
            if (history.get(arr[i - k]) == 0) history.remove(arr[i - k]);

            // Number of distinct elements in this window
            arrayList.add(history.size());
        }

        return arrayList;
    }
}
