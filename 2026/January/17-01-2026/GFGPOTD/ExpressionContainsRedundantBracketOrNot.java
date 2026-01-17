package GFGPOTD;

import java.util.Stack;

public class ExpressionContainsRedundantBracketOrNot {
    public static boolean checkRedundancy(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            String characterString = s.substring(i, i + 1);

            if (characterString.equals(")")) {
                String poppedString = stack.pop();

                boolean result = true;

                while (!poppedString.equals("(")) {
                    if (poppedString.equals("+") || poppedString.equals("*") || poppedString.equals("-") || poppedString.equals("/"))
                        result = false;

                    poppedString = stack.pop();
                }

                if (result) return true;
            } else {
                stack.push(characterString);
            }
        }

        return false;
    }    
}
