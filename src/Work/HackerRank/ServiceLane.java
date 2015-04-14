package HackerRank;

import java.util.Scanner;

public class ServiceLane {

    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(System.in);

        String[] line1 = in.nextLine().split(" ");
        int n = Integer.parseInt(line1[1]);

        String[] line2 = in.nextLine().split(" ");
        int[] sizes = new int[Integer.parseInt(line1[0])];
        for (int i = 0; i < sizes.length; i++) {
            sizes[i] = Integer.parseInt(line2[i]);
        }

        for (int i = 0; i < n; i++) {
            String[] x = in.nextLine().split(" ");
            int a = Integer.parseInt(x[0]);
            int b = Integer.parseInt(x[1]);

            int min = sizes[a];
            for (int j = a + 1; j < b; j++) {
                if (sizes[j] < min) {
                    min = sizes[j];
                }
            }

            System.out.println(min);
        }

    }
}
