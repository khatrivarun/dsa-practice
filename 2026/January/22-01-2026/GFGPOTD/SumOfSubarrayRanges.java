import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayRanges {
    public int subarrayRanges(int[] nums) {
        int result = 0;
        int n = nums.length;

        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int currentVal = (i == n) ? Integer.MIN_VALUE : nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] > currentVal) {
                int mid = stack.pop();
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int rightBoundary = i;

                long count = (long) (mid - leftBoundary) * (rightBoundary - mid);
                result -= (long) nums[mid] * count;
            }
            stack.push(i);
        }

        stack.clear();
        
        for (int i = 0; i <= n; i++) {
            int currentVal = (i == n) ? Integer.MAX_VALUE : nums[i];

            while (!stack.isEmpty() && nums[stack.peek()] < currentVal) {
                int mid = stack.pop();
                int leftBoundary = stack.isEmpty() ? -1 : stack.peek();
                int rightBoundary = i;

                long count = (long) (mid - leftBoundary) * (rightBoundary - mid);
                result += (long) nums[mid] * count;
            }
            stack.push(i);
        }

        return result;
    }  
}
