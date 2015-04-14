package Speedy;

import java.util.Scanner;

public class FindDigit {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String number = in.nextLine();
            long num = Long.parseLong(number);
            int total = 0;
            for (int j = 0; j < number.length(); j++) {
                int x = Character.getNumericValue(number.charAt(j));
                if (x == 0)
                    continue;

                if (num % x == 0)
                    total++;
            }
            System.out.println(total);
        }
    }
}
