import java.util.List;
import java.util.LinkedList;

public class CommonIn3SortedArrays {
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
            List<Integer> arr3) {

            // Result List
            List<Integer> result = new LinkedList<>();

            // Counters
            int arr1Counter = 0, arr2Counter = 0, arr3Counter = 0;

            // Size of the arrays
            int arr1Size = arr1.size(), arr2Size = arr2.size(), arr3Size = arr3.size();

            // Logic is to check across at all 3 pointers if they are equal
            // and increase the counters depending on how the counter elements
            // relate to each other in case of how big they are
            while (arr1Counter < arr1Size && arr2Counter < arr2Size && arr3Counter < arr3Size) {
                int arr1Element = arr1.get(arr1Counter);
                int arr2Element = arr2.get(arr2Counter);
                int arr3Element = arr3.get(arr3Counter);

                // Common element found, check if the list contains the
                // element and add it if it doesn't exist
                if (arr1Element == arr2Element && arr2Element == arr3Element) {
                    if (result.isEmpty() || !result.get(result.size() - 1).equals(arr1Element)) result.add(arr1Element);

                    arr1Counter += 1;
                    arr2Counter += 1;
                    arr3Counter += 1;
                }

                // Whatever element is smaller, increment
                // the counter for the same
                else if (arr1Element < arr2Element) arr1Counter += 1;
                else if (arr2Element < arr3Element) arr2Counter += 1;
                else arr3Counter += 1;
            }

            return result;
    }
}
