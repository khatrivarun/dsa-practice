import java.util.Stack;

public class ParenthesisChecker {
    static boolean isBalanced(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);

            if (character == '{' || character == '(' || character == '[') stack.push(character);
            else {
                if (stack.isEmpty())
                    return false;

                Character poppedBracket = stack.pop();

                if (poppedBracket == '(') {
                    if (character != ')') {
                        return false;
                    }
                } else if (poppedBracket == '[') {
                    if (character != ']') {
                        return false;
                    }
                } else {
                    if (character != '}') {
                        return false;
                    }
                }
            }
        }

        return stack.isEmpty();
    }
}
