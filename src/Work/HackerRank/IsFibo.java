package HackerRank;

import java.io.FileReader;
import java.util.HashSet;
import java.util.Scanner;

public class IsFibo {

    public static HashSet<Long> values = new HashSet<Long>();

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackerRank/TestData/isFibo"));

        int n = Integer.parseInt(in.nextLine());

        fib(90);

        for (int i = 0; i < n; i++) {
            long value = Long.parseLong(in.nextLine());
            if (values.contains(value)) {
                System.out.println("IsFibo");
            } else {
                System.out.println("IsNotFibo");
            }
        }
    }

    public static long fib(int n) {
        return n == 0 ? 0 : fib2(n, 0, 1);
    }

    public static long fib2(int n, long p0, long p1) {
        values.add(p1);
        return n == 1 ? p1 : fib2(n-1, p1, p1+p0);
    }
}
