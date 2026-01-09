public class RotateArraybyOne {
    public void rotate(int[] arr) {
        int memory = arr[arr.length - 1];

        for (int i = 0; i < arr.length; i++) {
            int history = arr[i];
            arr[i] = memory;
            memory = history;
        }
    }
}
