import java.util.Arrays;

public class TripletSumInArray {
    public boolean hasTripletSum(int arr[], int target) {
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 2; i++) {
            int newTarget = target - arr[i];

            int lowPointer = i + 1, highPointer = arr.length - 1;

            while (lowPointer < highPointer) {
                if (arr[lowPointer] + arr[highPointer] == newTarget) return true;
                else if (arr[lowPointer] + arr[highPointer] > newTarget) highPointer -= 1;
                else lowPointer += 1;
            }
        }
        return false;
    }    
}
