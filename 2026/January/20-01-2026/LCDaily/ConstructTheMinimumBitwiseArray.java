package LCDaily;

import java.util.List;

public class ConstructTheMinimumBitwiseArray {
    public int[] minBitwiseArray(List<Integer> nums) {
        int[] result = new int[nums.size()];

        for (int i = 0; i < nums.size(); i++) {
            int number = nums.get(i);
            int minimumNumber = -1;

            for (int j = 0; j <= number; j++) {
                if ((j | j + 1) == number) {
                    minimumNumber = j;
                    break;
                }
            }

            result[i] = minimumNumber;
        }
        
        return result;
    }    
}
