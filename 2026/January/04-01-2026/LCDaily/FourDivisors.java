package LCDaily;

public class FourDivisors {
    public int sumFourDivisors(int[] nums) {
        int result = 0;

        // Intermediate calculations here
        int countDivisors = 0;
        int intermediateSum = 0;

        for (Integer number : nums) {

            // Skip the lower numbers
            if (number < 6) continue;

            // Counting divisors here
            // Loop till square root by also
            // counting the otherside quotient too
            // and skip counting perfect squares
            // twice
            for (int i = 1; i * i <= number; i++) {
                if (number % i == 0) {
                    countDivisors += 1;
                    intermediateSum += i;

                    if (i * i != number) {
                        countDivisors += 1;
                        intermediateSum += (number / i);
                    }
                }

                if (countDivisors > 4) break;
            }

            // Check if the number of divisors encountered
            // is exactly 4 or not
            if (countDivisors == 4) {
                result += intermediateSum;
            }

            // Reset the intermediate variables
            countDivisors = 0;
            intermediateSum = 0;
        }

        return result;
    }

    public static void main(String[] args) {
        FourDivisors solution = new FourDivisors();

        System.out.println(solution.sumFourDivisors(new int[]{21,4,7}));
        System.out.println(solution.sumFourDivisors(new int[]{21,21}));
        System.out.println(solution.sumFourDivisors(new int[]{1,2,3,4,5}));
    }    
}
