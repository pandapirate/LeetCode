package HackerRank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class DecentNumber {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackerRank/TestData/decentNumber"));

        int n = Integer.parseInt(in.nextLine());

        for(int i = 0; i < n; i++) {
            int s = Integer.parseInt(in.nextLine());

            int num5 = s;
            int num3 = 0;

            while (true) {
                if (num5 < 0) {
                    System.out.println(-1);
                    break;
                }

                if (num5 % 3 == 0 && num3 % 5 == 0) {
                    for (int j = 0; j < num5; j++) {
                        System.out.print(5);
                    }
                    for (int j = 0; j < num3; j++) {
                        System.out.print(3);
                    }
                    System.out.println();
                    break;
                } else {
                    num5 --;
                    num3 ++;
                }
            }
        }
    }
}
