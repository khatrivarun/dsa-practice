import java.util.ArrayList;

public class MinimumPairRemovalToSortArray {
    public int minimumPairRemoval(int[] nums) {
        ArrayList<Integer> array = new ArrayList<>();
        int result = 0;

        for (Integer integer : nums) array.add(integer);

        while (!checkAscendingOrder(array)) {
            int pointer = 0;
            int minPairSum = array.get(0) + array.get(1);

            for (int i = 1; i < array.size() - 1; i++) {
                int currentPairSum = array.get(i) + array.get(i + 1);

                if (currentPairSum < minPairSum) {
                    minPairSum = currentPairSum;
                    pointer = i;
                }
            }

            array.set(pointer, minPairSum);
            array.remove(pointer + 1);

            ++result;
        }

        return result;
    }

    private boolean checkAscendingOrder(ArrayList<Integer> array) {
        for (int i = 1; i < array.size(); i++)
            if (array.get(i) < array.get(i - 1)) return false;
        return true;
    } 
}
