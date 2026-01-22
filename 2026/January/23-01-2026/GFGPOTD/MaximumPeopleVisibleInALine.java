import java.util.Arrays;
import java.util.Stack;

public class MaximumPeopleVisibleInALine {
    private int[] previousGreaterElements(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < length; i++) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }
    
    private int[] nextGreaterElements(int[] array) {
        int length = array.length;
        int[] result = new int[length];

        Arrays.fill(result, length);

        Stack<Integer> stack = new Stack<>();

        for (int i = length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && array[i] > array[stack.peek()]) stack.pop();
            if(!stack.isEmpty()) result[i] = stack.peek();
            stack.push(i);
        }

        return result;
    }

    public int maxPeople(int[] arr) {
        int[] nextGreaterElements = nextGreaterElements(arr);
        int[] previousGreaterElements = previousGreaterElements(arr);

        int maxPeople = 0;

        for (int i = 0; i < previousGreaterElements.length; i++) {
            int leftLimit = previousGreaterElements[i] == -1 ? 0 : previousGreaterElements[i] + 1;
            int rightLimit = nextGreaterElements[i] == arr.length ? arr.length - 1 : nextGreaterElements[i] - 1;

            maxPeople = Math.max(maxPeople, rightLimit - leftLimit + 1);
        }

        return maxPeople;
    }    
}
