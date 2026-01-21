import java.util.ArrayList;
import java.util.Collections;
import java.util.Stack;

public class StockSpanProblem {
    public ArrayList<Integer> calculateSpan(int[] arr) {
        int length = arr.length;
        ArrayList<Integer> result = new ArrayList<>(Collections.nCopies(length, 0));
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && arr[i] >= arr[stack.peek()]) stack.pop();

            if (stack.isEmpty()) result.set(i, i + 1);
            else result.set(i, i - stack.peek());

            stack.push(i);
        }

        return result;
    }    
}
