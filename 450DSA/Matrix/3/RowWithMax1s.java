
public class RowWithMax1s {

    // HELPER: Standard Binary Search to find the first occurrence of a target
    // Returns the index of the first '1'. If not found, returns -1
    private int binarySearchFirstOccurrence(int[] arr, int search) {
        int index = -1;

        int low = 0, high = arr.length - 1;

        while(low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == search) {
                index = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return index;
    }

    public int rowWithMax1s(int arr[][]) {
        int result = -1;
        int maxOnes = -1;
        int columns = arr[0].length;

        for (int i = 0; i < arr.length; i++) {

            // Step 1: Find where the 1s start in this specific row
            int firstOne = binarySearchFirstOccurrence(arr[i], 1);

            // Step 2: Calculate count of 1s based on the index
            if (firstOne != -1) {

                // Since rows are sorted, all elements after firstOneIndex are also 1.
                // Count = Total Length - Index of First 1
                int numberOfOnes = columns - firstOne;

                // Step 3: Check if this row beats our current record
                if (numberOfOnes > maxOnes) {
                    maxOnes = numberOfOnes;
                    result = i;
                }
            }
        }

        return result;
    }
    
}
