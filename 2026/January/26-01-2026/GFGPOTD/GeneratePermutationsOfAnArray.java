import java.util.ArrayList;

public class GeneratePermutationsOfAnArray {
    public static ArrayList<ArrayList<Integer>> permuteDist(int[] arr) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        generatePermutations(result, arr, 0);
        return result;
    }

    public static void generatePermutations(ArrayList<ArrayList<Integer>> result, int[] arr, int indexPointer) {
        if (indexPointer == arr.length) {
            ArrayList<Integer> element = new ArrayList<>();
            for (Integer integer : arr) element.add(integer);
            result.add(element);
        }

        for (int i = indexPointer; i < arr.length; i++) {
            int swap = arr[indexPointer];
            arr[indexPointer] = arr[i];
            arr[i] = swap;

            generatePermutations(result, arr, indexPointer + 1);
            
            swap = arr[indexPointer];
            arr[indexPointer] = arr[i];
            arr[i] = swap;
        }
    }
}
