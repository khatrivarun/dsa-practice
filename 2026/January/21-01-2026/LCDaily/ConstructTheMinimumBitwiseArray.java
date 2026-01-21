import java.util.List;

public class ConstructTheMinimumBitwiseArray {
    public int[] minBitwiseArray(List<Integer> nums) {
        int length = nums.size();
        int[] result = new int[length];

        for (int i = 0; i < length; i++) {
            int number = nums.get(i);

            if (number == 2) result[i] = -1;
            else {
                for (int bitPosition = 1; bitPosition < 32; bitPosition++) {
                    if ((number >> bitPosition & 1) == 0) {
                        result[i] = number ^ (1 << (bitPosition - 1));
                        break;
                    }
                }
            }
        }

        return result;
    }    
}
