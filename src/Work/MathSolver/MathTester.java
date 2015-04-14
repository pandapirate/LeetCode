package MathSolver;

public class MathTester {

  public static void main (String[] args) throws Exception{

    String eq = "5^(2*2+4)*5/2";

    double result = MathSolver.getInstance().solve(eq);

    System.out.printf("%.2f", result);
  }
}
