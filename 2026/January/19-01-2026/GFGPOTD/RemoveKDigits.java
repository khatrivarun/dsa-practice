import java.util.Stack;

public class RemoveKDigits {
    public String removeKdig(String s, int k) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character currentDigit = s.charAt(i);

            while (!stack.isEmpty() && k > 0 && currentDigit < stack.peek()) {
                stack.pop();
                k -= 1;
            }

            if (!stack.isEmpty() || currentDigit != '0') stack.push(currentDigit);
        }

        while (!stack.isEmpty() && k > 0) {
            stack.pop();
            k -= 1;
        }

        if (stack.isEmpty()) return "0";

        StringBuilder stringBuilder = new StringBuilder();

        while(!stack.isEmpty()) stringBuilder.append(stack.pop());

        return stringBuilder.reverse().toString();
    }    
}
