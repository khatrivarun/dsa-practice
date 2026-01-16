package GFGPOTD;

import java.awt.MenuBar;
import java.util.ArrayList;

import org.w3c.dom.ranges.Range;

public class MinimumNumberOfWorkers {
    public int minMen(int arr[]) {
        ArrayList<int[]> workRanges = new ArrayList<>();

        for (int i = 0; i < arr.length; i++) {
            int minHours = Math.max(0, i - arr[i]);
            int maxHours = Math.min(i + arr[i], arr.length - 1);

            workRanges.add(new int[]{minHours, maxHours});
        }

        if (workRanges.isEmpty()) return -1;

        workRanges.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int result = 0, i = 0, pointer = -1;

        while (pointer < arr.length - 1) {
            if (i >= workRanges.size()) return -1;

            if (workRanges.get(i)[0] > pointer + 1) return -1;

            int best = pointer;

            while (i < workRanges.size() && workRanges.get(i)[0] <= pointer + 1) {
                best = Math.max(best, workRanges.get(i)[1]);
                i++;
            }

            result += 1;
            pointer = best;
        }

        return result;
    }
}
