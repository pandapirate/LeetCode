package MathSolver;

import java.util.ArrayList;

public class MathSolver {

  private static MathSolver INSTANCE;

  public static MathSolver getInstance () {
    if (INSTANCE == null) {
      INSTANCE = new MathSolver();
    }

    return INSTANCE;
  }

  public double solve(String equation) {
    ArrayList<String> eq = parseEquation(equation);
    return solve(eq);
  }

  public double solve(ArrayList<String> eq) {

    while (eq.size() > 1) {
      int[] p = getIndexForParenthesis(eq);
      if (p[0] != -1) {
        ArrayList<String> sub = new ArrayList<String>(eq.subList(p[0]+1, p[1]));
        double r = solve(sub);
        replace(eq, p[0], p[1], r);
      }
      else {
        int i = getIndexForOp(eq);
        while (i != -1) {
          String op = eq.get(i);
          double a = Double.parseDouble(eq.get(i-1));
          double b = Double.parseDouble(eq.get(i+1));

          double result = 0.0;

          if (op.equals("+")) {
            result = a + b;
          } else if (op.equals("-")) {
            result = a - b;
          } else if (op.equals("*")) {
            result = a * b;
          } else if (op.equals("/")) {
            result = a / b;
          } else if (op.equals("^")) {
            result = Math.pow(a, b);
          }

          replace(eq, i-1, i+1, result);
          i = getIndexForOp(eq);
        }
      }
    }
    return Double.parseDouble(eq.get(0));
  }

  private ArrayList<String> parseEquation (String equation) {
    ArrayList<String> eq = new ArrayList<String>();

    int i = 0;
    int eqIndex = 0;

    while (i < equation.length()) {
      char c = equation.charAt(i++);
      if (Character.isDigit(c)) {
        if (eqIndex >= eq.size()) {
          eq.add(c+"");
        } else
          eq.set(eqIndex, eq.get(eqIndex) + c);
      } else {
        eq.add(c+"");
        eqIndex += 2;
      }
    }

    for (String s : eq) {
      System.out.print(s + " ");
    }
    System.out.println("");

    return eq;
  }

  private int[] getIndexForParenthesis(ArrayList<String> eq) {
    int[] index = new int[2];
    index[0] = -1;
    index[1] = -1;
    int lastP = -1;

    for (int i = 0; i < eq.size(); i++) {
      String s = eq.get(i);

      if (s.equals("(")) {
        lastP = i;
      } else if (s.equals(")")) {
        index[0] = lastP;
        index[1] = i;
        break;
      }
    }

    return index;
  }

  private int getIndexForOp(ArrayList<String> eq) {
    for (int i = 0; i < eq.size(); i++) {
      if (eq.get(i).equals("^")) {
        return i;
      }
    }

    for (int i = 0; i < eq.size(); i++) {
      if (eq.get(i).equals("*") || eq.get(i).equals("/")) {
        return i;
      }
    }

    for (int i = 0; i < eq.size(); i++) {
      if (eq.get(i).equals("+") || eq.get(i).equals("-")) {
        return i;
      }
    }

    return -1;
  }

  private void replace(ArrayList<String> eq, int start, int end, double value) {
    for (int i = end; i > start; i--) {
      eq.remove(i);
    }
    eq.set(start, value+"");
  }
}