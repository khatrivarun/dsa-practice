import java.util.HashMap;

public class NRepeatedElementInSize2NArray {

    /*
     * Method used for the solution of the problem
     */
    public int repeatedNTimes(int[] nums) {
        HashMap<Integer, Integer> counters = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            counters.put(nums[i], counters.getOrDefault(nums[i], 0) + 1);
        }

        for (int num : counters.keySet()) {
            if (counters.get(num) == nums.length / 2) {
                return num;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        NRepeatedElementInSize2NArray solution = new NRepeatedElementInSize2NArray();

        // Test Case for the solution
        System.out.println(solution.repeatedNTimes(new int[]{5,1,5,2,5,3,5,4}));
    }
}
