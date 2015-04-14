package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

/**
 *
 3
 abc
 abcba
 abcd
 */
public class LoveLetter {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
//        in = new Scanner(new FileReader("src/HackerRank/TestData/median"));

        int N = Integer.parseInt(in.nextLine());

        for (int i = 0; i < N; i++) {
            String s = in.nextLine();
            int total = 0;
            for (int j = 0; j < s.length()/2 ; j++) {
                int begin = Character.getNumericValue(s.charAt(j));
                int end = Character.getNumericValue(s.charAt(s.length()-1-j));
                if (begin == end) {
                    continue;
                } else if (begin < end) {
                    total += end-begin;
                } else {
                    total += begin-end;
                }
            }
            System.out.println(total);
        }
    }
}
