import java.util.Arrays;

public class MergeWithoutExtraSpace {

    public void swap(int firstArray[], int secondArray[], int firstArrayCounter, int secondArrayCounter) {

        int swap = firstArray[firstArrayCounter];
        firstArray[firstArrayCounter] = secondArray[secondArrayCounter];
        secondArray[secondArrayCounter] = swap;

    }

    public void mergeArrays(int a[], int b[]) {

        int firstArrayLimit = 0;
        int secondArrayLimit = b.length;

        int firstArrayCounter = a.length - 1;
        int secondArrayCounter = 0;

        // Loop over the 2 arrays, in reverse order for the first array and in straight
        // order for the second array and compare the elements and swap to make them fit
        // the narrative.
        while (firstArrayCounter >= firstArrayLimit && secondArrayCounter < secondArrayLimit) {

            if (a[firstArrayCounter] > b[secondArrayCounter]) {
                swap(a, b, firstArrayCounter, secondArrayCounter);
                firstArrayCounter -= 1;
                secondArrayCounter += 1;
            } else {
                break;
            }

        }

        // Sort the arrays again after swap so they're in proper format
        Arrays.sort(a);
        Arrays.sort(b);
    }
}
