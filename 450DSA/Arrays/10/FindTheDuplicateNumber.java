public class FindTheDuplicateNumber {
    public int findDuplicate(int[] nums) {
        int slowPointer = nums[0];
        int fastPointer = nums[0];

        // Floyd’s Cycle Finding Algorithm
        do {
            slowPointer = nums[slowPointer];
            fastPointer = nums[nums[fastPointer]];
        } while(slowPointer != fastPointer);

        slowPointer = nums[0];

        while(slowPointer != fastPointer) {
            slowPointer = nums[slowPointer];
            fastPointer = nums[fastPointer];
        }

        return slowPointer;
    }    
}
