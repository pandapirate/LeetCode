public class MainTestRunner {
  public static void main(String[] args) {

    System.out.println(test(5, 3));
//    System.out.println(test(5, 0));
  }

  public static int test(int a, int b) {

    try {
      int c = a/b;
      return c;
    } catch (ArithmeticException e) {
      System.out.println("ahhhhhh");
      return a;
    } finally {
      return b;
    }
  }
}
