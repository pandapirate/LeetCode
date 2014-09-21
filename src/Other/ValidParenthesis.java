package Other;

import java.util.Stack;

/**
 * Created by khuang on 9/19/14.
 */
public class ValidParenthesis {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.size() == 0)
                    return false;
                char pop = stack.pop();
                switch (pop) {
                    case '(': if (c != ')') return false; break;
                    case '[': if (c != ']') return false; break;
                    case '{': if (c != '}') return false; break;
                }
            }
        }
        if (stack.size() == 0) return true;
        return false;
    }

    public static void main(String args[]) {
        String[] tests = new String[]{"()", "()[]{}", "(]", "([)]"};
        for (String s : tests) {
            System.out.println(new ValidParenthesis().isValid(s));
        }
    }
}
