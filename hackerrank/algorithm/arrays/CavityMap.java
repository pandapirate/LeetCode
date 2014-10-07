package algorithm.arrays;

import java.util.*;

/**
 * Created by khuang on 10/5/14.
 */
public class CavityMap {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int x = Integer.parseInt(in.nextLine());
        int[][] map = new int[x][x];

        for (int i = 0; i < x; i++) {
            String line = in.nextLine();
            for (int j = 0; j < x; j++) {
                map[i][j] = Integer.parseInt(line.charAt(j) + "");
            }
        }

        Queue<Integer> queue = new LinkedList<Integer>();
        for (int i = 1; i < x-1; i++) {
            for (int j = 1; j < x-1; j++) {
                int n = map[i][j];
                if (map[i-1][j] >= n || map[i+1][j] >= n || map[i][j+1] >= n || map[i][j-1] >= n)
                    continue;
                else {
                    queue.add(i);
                    queue.add(j);
                }
            }
        }

        int a = -1, b = -1;
        if (queue.size() > 0) {
            a = queue.remove();
            b = queue.remove();
        }
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                if (a == i && b == j) {
                    System.out.print("X");
                    if (queue.size() > 0) {
                        a = queue.remove();
                        b = queue.remove();
                    }
                } else
                    System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }
}
