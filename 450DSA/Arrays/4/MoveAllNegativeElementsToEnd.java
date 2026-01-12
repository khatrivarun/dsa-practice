public class MoveAllNegativeElementsToEnd {
    public void segregateElements(int[] arr) {

        int counter = 0;
        int[] segregatedArray = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= 0) {
                segregatedArray[counter] = arr[i];
                counter += 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                segregatedArray[counter] = arr[i];
                counter += 1;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            arr[i] = segregatedArray[i];
        }
    }
}
