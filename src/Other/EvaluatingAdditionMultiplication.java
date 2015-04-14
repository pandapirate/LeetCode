package Other;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 3/31/2015.
 */
public class EvaluatingAdditionMultiplication {

    public static void main(String[] args) {
        String eq = "3+4*5+3*2";

        System.out.println(new EvaluatingAdditionMultiplication().eval(eq));
    }

    public int eval(String eq) {
        List<Integer> eqNum = new ArrayList<Integer>();

        String tempEq = eq;
        while (tempEq.length() > 0) {
            // find operation
            int counter = 0;
            while (counter < tempEq.length()) {
                if (tempEq.charAt(counter) == '+' || tempEq.charAt(counter) == '*') {
                    break;
                }
                counter++;
            }

            String number = "";
            if (counter == tempEq.length()) {
                // no operation found
                eqNum.add(Integer.parseInt(tempEq));
                break;
            }

            char c = tempEq.charAt(counter);
            number = tempEq.substring(0, counter);
            if (c == '+') {
                // for addition, just add the previous number and keep going
                eqNum.add(Integer.parseInt(number));
            } else {
                // calculate multiply
                int nextCounter = counter+1;
                while (nextCounter < tempEq.length()) {
                    if (tempEq.charAt(nextCounter) == '+' || tempEq.charAt(nextCounter) == '*') {
                        break;
                    }
                    nextCounter++;
                }

                String nextNumber = "";
                if (nextCounter == tempEq.length()) {
                    // no next operation found
                    nextNumber = tempEq.substring(counter+1);
                } else {
                    nextNumber = tempEq.substring(counter+1, nextCounter);
                }

                // calculate the result of the multiplication and add it back into the equation
                int result = Integer.parseInt(number) * Integer.parseInt(nextNumber);
                if (nextCounter == tempEq.length()) {
                    tempEq = "" + result;
                } else {
                    tempEq = result + tempEq.substring(nextCounter);
                }
                continue;
            }
            tempEq = tempEq.substring(counter+1);
        }

        // everything in the list should be added together to form the final solution
        int sum = 0;
        for (int i : eqNum) {
            sum += i;
        }
        return sum;
    }
}
