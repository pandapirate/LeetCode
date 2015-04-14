package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class SquareWords {
    public static void main(String args[]) throws Exception {
        Scanner in = new Scanner(System.in);
        in = new Scanner(new FileReader("src/HackerRank/TestData/squarewords"));

        String word = in.nextLine().replaceAll(" ", "");

        int length = word.length();

        int lo = (int) Math.floor(Math.sqrt(1.0*length));
        int hi = (int) Math.ceil(Math.sqrt(1.0*length));

        int size = hi * hi;
        int templo = lo;
        int temphi = hi;

        for (int i = lo; i <= hi; i++) {
            for (int j = i; j <= hi; j++) {
                if (i*j <= size && i*j >= length) {
                    size = i*j;
                    templo = i;
                    temphi = j;
                }
            }
        }
        lo = templo;
        hi = temphi;

        char[][] map = new char[lo][hi];

        for (int i = 0; i < lo; i++) {
            for (int j = 0; j < hi; j++) {
                if ((i*hi + j) >= length)
                    break;
                map[i][j] = word.charAt(i*hi + j);
//                System.out.print(map[i][j]);
            }
//            System.out.println();
        }

        for (int i = 0; i < hi; i++) {
            String s = "";
            for (int j = 0; j < lo; j++) {
                if (map[j][i] != 0)
                    s += map[j][i];
            }
            if (i == 0)
                System.out.print(s);
            else
                System.out.print(" " + s);
        }
    }
}
