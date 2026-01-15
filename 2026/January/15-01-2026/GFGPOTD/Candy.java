import java.util.Arrays;

public class Candy {
    public int minCandy(int arr[]) {
        // Logic here is that we will do a 2 pass, from left and right
        // on the ratings value and increment the number
        // of chocolates by 1 if the current student was better
        // than the previous and then we calculate the max chocolates
        // as the max for both passes for the same kid
        int[] leftPass = new int[arr.length];
        int[] rightPass = new int[arr.length];
        int result = 0;

        // By default everyone gets 1
        Arrays.fill(leftPass, 1);
        Arrays.fill(rightPass, 1);

        // Left passing and calculating chocolates
        for (int i = 1; i < arr.length; i++)
            if (arr[i] > arr[i - 1]) leftPass[i] = leftPass[i - 1] + 1;
        
        // Right passing and calculating chocolates
        for (int i = arr.length - 2; i >= 0; i--)
            if (arr[i] > arr[i + 1]) rightPass[i] = rightPass[i + 1] + 1;

        // Calculate the max chocolates for each kid
        for (int i = 0; i < rightPass.length; i++) result += Math.max(leftPass[i], rightPass[i]);

        return result;
    }    
}
