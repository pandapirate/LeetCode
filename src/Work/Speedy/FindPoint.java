package Speedy;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class FindPoint {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);
//        in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\FindAWord"));

        int n = Integer.parseInt(in.nextLine());

        for (int i = 0; i < n; i++) {
            String[] points = in.nextLine().split(" ");

            int ax = Integer.parseInt(points[0]);
            int ay = Integer.parseInt(points[1]);
            int bx = Integer.parseInt(points[2]);
            int by = Integer.parseInt(points[3]);

            int cx = bx-ax + bx;
            int cy = by-ay + by;

            System.out.println(cx + " " + cy);
        }
    }
}
