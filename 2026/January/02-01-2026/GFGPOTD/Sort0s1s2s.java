import java.util.Arrays;

public class Sort0s1s2s {
    
    /*
     * Method used for the solution of the problem
     */
    public void sort012(int[] arr) {
        int zeroPointer = 0;
        int onePointer = 0;

        // Pull all the 0s at the front
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                int swap = arr[i];
                arr[i] = arr[zeroPointer];
                arr[zeroPointer] = swap;

                zeroPointer += 1;
            }
        }

        // Pull all the 1s after the 0s
        // 2s are automatically sorted after this step
        onePointer = zeroPointer;
        for (int i = zeroPointer; i < arr.length; i++) {
            if (arr[i] == 1) {
                int swap = arr[i];
                arr[i] = arr[onePointer];
                arr[onePointer] = swap;

                onePointer += 1;
            }
        }
    }

    public static void main(String[] args) {
        Sort0s1s2s solution = new Sort0s1s2s();

        // Test Case for the solution
        int[] array = new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
        solution.sort012(array);
        System.out.println(Arrays.toString(array));
    }    
}
