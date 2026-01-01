public class ReverseAnArray {
    public void reverseArray(int arr[]) {
        int length = arr.length;

        // Loop only through the first half of the array
        for (int i = 0; i < arr.length / 2; i++) {

            // Swap ith and length - i - 1th element
            int swap = arr[i];
            arr[i] = arr[length - i - 1];
            arr[length - i - 1] = swap;
        }
    }
}
