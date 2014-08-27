package Other;

/**
 * Created by khuang on 8/27/14.
 */
public class ReversePolishNotation {

    private int lastOpIndex;

    public int evalRPN(String[] tokens) {
        if (tokens.length == 1)
            return Integer.parseInt(tokens[0]);

        lastOpIndex = 0;
        int result = 0;

        while (hasOp(tokens)) {
            String op = tokens[lastOpIndex];
            int bIndex = findNums(tokens, lastOpIndex);
            int aIndex = findNums(tokens, bIndex);

            int b = Integer.parseInt(tokens[bIndex]);
            int a = Integer.parseInt(tokens[aIndex]);

            if (op.equals("+")) {
                result = a + b;
            } else if (op.equals("-")) {
                result = a - b;
            } else if (op.equals("*")) {
                result = a * b;
            } else if (op.equals("/")) {
                result = a / b;
            }

            tokens[lastOpIndex] = "";
            tokens[aIndex] = "";
            tokens[bIndex] = result + "";
        }

        return result;
    }

    private int findNums(String[] tokens, int start) {
        for (int i = start-1; i >= 0; i--) {
            if (tokens[i].length() > 0) {
               return i;
            }
        }
        return -1;
    }

    private boolean hasOp(String[] tokens) {
        for (int i = lastOpIndex; i < tokens.length; i++) {
            if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
                lastOpIndex = i;
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]) {
        /*
        ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
         */

        System.out.println(new ReversePolishNotation().evalRPN(new String[] {"2", "1", "+", "3", "*"}));
        System.out.println(new ReversePolishNotation().evalRPN(new String[] {"4", "13", "5", "/", "+"}));
    }
}
