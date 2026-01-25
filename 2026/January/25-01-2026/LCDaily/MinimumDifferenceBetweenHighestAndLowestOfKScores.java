import java.util.Arrays;

public class MinimumDifferenceBetweenHighestAndLowestOfKScores {
    public int minimumDifference(int[] nums, int k) {
        Arrays.sort(nums);

        int result = Integer.MAX_VALUE;

        for (int i = 0; i <= nums.length - k; i++)
            result = Math.min(result, nums[i + k - 1] - nums[i]);

        return result;
    }
}
