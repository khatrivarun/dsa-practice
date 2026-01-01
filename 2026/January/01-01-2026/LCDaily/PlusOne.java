import java.util.Arrays;

public class PlusOne {

    /*
     * Method used for the solution of the problem
     */
    public int[] plusOne(int[] digits) {

        int length = digits.length;

        // We start with a carry of 1 because
        // the goal is to add 1 to the number
        int carryOver = 1;

        // Loop backwards: start from the last
        // digit (the ones place) and move left
        for (int i = length - 1; i >= 0; i--) {

            // Add the carry to the current digit
            digits[i] += carryOver;

            // Calculate if there is a new carry
            // If digits[i] is 10, carryOver becomes 1
            // If it's < 10, carryOver becomes 0
            carryOver = digits[i] / 10;

            // If the digit became 10 (or more),
            // we need to set it to the remainder
            if (digits[i] >= 10) {
                digits[i] %= 10;
            }
        }

        // After the loop finishes, check if we still have a carry left
        // No leftover carry means the number fit inside the original array size
        if (carryOver == 0) return digits;

        // If carryOver is 1, it means we ran out of space
        else {
            int[] newDigits = new int[length + 1];
            newDigits[0] = carryOver;

            // Copy the rest of the digits from
            // the source
            for (int i = 0; i < length; i++) {
                newDigits[i + 1] = digits[i];
            }

            return newDigits;
        }

    }

    public static void main(String[] args) {
        PlusOne solution = new PlusOne();

        // Test cases
        System.out.println(Arrays.toString(solution.plusOne(new int[]{1,2,3})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{4,3,2,1})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9})));
        System.out.println(Arrays.toString(solution.plusOne(new int[]{9,9,9})));
    }

}
