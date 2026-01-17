import java.util.Arrays;

public class NextPermutation {
    private void reverseArray(int[] arr) {
        for (int i = 0; i < arr.length / 2; i++) swap(arr, i, arr.length - i - 1);
    }

    private void swap(int[] arr, int indexOne, int indexTwo) {
        int swap = arr[indexOne];
        arr[indexOne] = arr[indexTwo];
        arr[indexTwo] = swap;
    }
    
    public void nextPermutation(int[] arr) {
        int marker = -1;
        for (int i = arr.length - 1; i > 0; i--)
            if (arr[i - 1] < arr[i]) {
                marker = i - 1;
                break;
            }

        if (marker == -1){
            reverseArray(arr);
            return;
        }

        int nextMinimumMarker = marker + 1;
        int nextMinimumDifference = arr[marker + 1] - arr[marker];

        for (int i = marker + 2; i < arr.length; i++) {
            if (arr[i] > arr[marker])
                if (arr[i] - arr[marker] < nextMinimumDifference) {
                    nextMinimumMarker = i;
                    nextMinimumDifference = arr[i] - arr[marker];
                }
        }

        swap(arr, marker, nextMinimumMarker);

        Arrays.sort(arr, marker + 1, arr.length);
    }    
}
