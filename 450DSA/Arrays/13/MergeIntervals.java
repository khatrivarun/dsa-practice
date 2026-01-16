import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] arr) {

        /*
         * Thinking process: Lets first sort the intervals
         * by their first intervals.
         */
        Arrays.sort(arr, (arrayOne, arrayTwo) -> arrayOne[0] - arrayTwo[0]);

        /*
         * Thinking process: We will place all our final
         * intervals in a separate array.
         */
        List<int[]> array = new LinkedList<>();

        // Reference to the first interval.
        int lowerLimitFlag = arr[0][0];
        int higherLimitFlag = arr[0][1];

        for (int i = 0; i < arr.length; i++) {

            /*
             * Thinking process: We will check if the
             * lower limit of the current interval is lesser
             * than the higher limit of the global interval.
             *
             * If it is, we will calculate the new higher limit
             * for the merge and continue till we reach the limit
             * add it to the result array.
             *
             * Else we will add the global interval to the result array
             * as it is and make the current interval as the new global
             * interval.
             */
            int lowerLimit = arr[i][0];
            int higherLimit = arr[i][1];

            if (lowerLimit <= higherLimitFlag) {
                higherLimitFlag = Math.max(higherLimitFlag, higherLimit);
            } else {

                array.add(new int[] { lowerLimitFlag, higherLimitFlag });

                lowerLimitFlag = arr[i][0];
                higherLimitFlag = arr[i][1];

            }

        }

        array.add(new int[] { lowerLimitFlag, higherLimitFlag });

        int[][] result = new int[array.size()][2];

        for (int i = 0; i < array.size(); i++)
            result[i] = array.get(i);

        return result;
    }
}
