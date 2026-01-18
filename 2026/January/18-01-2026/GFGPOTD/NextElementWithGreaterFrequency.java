import java.util.ArrayList;
import java.util.HashMap;
import java.util.Stack;

public class NextElementWithGreaterFrequency {
    public ArrayList<Integer> nextFreqGreater(int[] arr) {
        ArrayList<Integer> result = new ArrayList<>();
        HashMap<Integer, Integer> frequencies = new HashMap<>();
        Stack<Integer> stack = new Stack<>();

        for (Integer number : arr) {
            frequencies.put(number, frequencies.getOrDefault(number, 0) + 1);
            result.add(-1);
        }

        for (int i = 0; i < arr.length; i++) {
            while (!stack.isEmpty() && frequencies.get(arr[i]) > frequencies.get(arr[stack.peek()]))
                result.set(stack.pop(), arr[i]);

            stack.push(i);
        }

        return result;
    }    
}
