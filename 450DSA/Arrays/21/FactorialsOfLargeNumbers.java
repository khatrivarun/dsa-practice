import java.math.BigInteger;
import java.util.ArrayList;

public class FactorialsOfLargeNumbers {
    public static BigInteger calculateFactorial(int n) {
        if (n == 0 || n == 1)
            return BigInteger.ONE;

        return BigInteger.valueOf(n).multiply(calculateFactorial(n - 1));
    }

    public static ArrayList<Integer> factorial(int n) {
        BigInteger factorial = calculateFactorial(n);
        ArrayList<Integer> result = new ArrayList<>();

        for (char integer : factorial.toString().toCharArray())
            result.add(integer - '0');

        return result;
    }
}
