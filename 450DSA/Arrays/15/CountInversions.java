import java.util.ArrayList;

public class CountInversions {
    static int inversionCount(int arr[]) {

        return mergeSort(arr, 0, arr.length - 1);
    }

    static int mergeSort(int arr[], int low, int high) {
        int inversionCount = 0;
        if (low >= high) {
            return 0;
        }
        int mid = (low + high) / 2;
        inversionCount += mergeSort(arr, low, mid);
        inversionCount += mergeSort(arr, mid + 1, high);
        inversionCount += merge(arr, low, mid, high);

        return inversionCount;
    }

    static int merge(int arr[], int low, int mid, int high) {

        int inversionCount = 0;
        ArrayList<Integer> resultArray = new ArrayList<>();

        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                resultArray.add(arr[left]);

                left += 1;
            } else {
                resultArray.add(arr[right]);

                inversionCount += mid - left + 1;
                right += 1;
            }
        }

        while (left <= mid) {
            resultArray.add(arr[left]);

            left += 1;
        }

        while (right <= high) {
            resultArray.add(arr[right]);

            right += 1;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = resultArray.get(i - low);
        }

        return inversionCount;

    }
}
