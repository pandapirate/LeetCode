package Other;

/**
 * Created by Kevin on 3/8/2015.
 */
public class FibonacciEvenPound {

    static int curVal = 0;

    public static void main (String[] args) {
        int x = printFib(10);
        System.out.println(" " + x);
    }

    public static int printFib (int n) {
        if (n == 0) {
            if (0 > curVal) {
                System.out.print(0 + " ");
            }
            return 0;
        } else if (n == 1) {
            if (1 > curVal) {
                System.out.print(1 + " ");
                curVal = 1;
            }
            return 1;
        } else {
            int result = printFib(n-1) + printFib(n-2);
            if (result >= curVal) {
                System.out.print((result % 2 == 0 ? "#" : result) + " ");
                curVal = result;
            }
            return result;
        }
    }
}
