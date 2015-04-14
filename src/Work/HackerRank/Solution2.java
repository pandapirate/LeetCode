package HackerRank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;

public class Solution2 {

    public static int lastX = -1, lastY = -1, captured = 0;
    public static char[][] board = new char[10][10];

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Temp\\src\\text2"));//new InputStreamReader(System.in));
        boolean firstTime = true;

        //while (true) {
            // skip first line
            br.readLine();

            if (firstTime) {
                for (int i = 0; i < 10; i++) {
                    String line = br.readLine();
                    for (int j = 0; j < 10; j++) {
                        board[i][j] = line.charAt(j);
                        if (board[i][j] == 'h') captured++;
                    }
                }
                firstTime = false;
            } else {
                for (int i = 0; i < 10; i++) {
                    String line = br.readLine();
                    if (i == lastY) {
                        board[i][lastX] = line.charAt(lastX);
                        if (board[lastY][lastX] == 'h') captured++;
                        break;
                    }
                }
            }

            if (makeMove()) {
                //end game
                return;
            }
        //}
    }

    public static boolean makeMove() {
        int y = -1, x = -1;
        for (y = 0; y < 10; y++) {
            boolean end = false;
            for (x = 0; x < 10; x++) {
                if (board[y][x] == 'h') {
                    end = true;
                    break;
                }
            }
            if (end) break;
        }

        if (y < 10 && x < 10) {
            if (y - 1 > 0 && board[y-1][x] == '-') {lastY = y-1; lastX = x;}
            else if (y + 1 < 10 && board[y+1][x] == '-') {lastY = y+1; lastX = x;}
            else if (x - 1 > 0 && board[y][x-1] == '-') {lastY = y; lastX = x-1;}
            else if (x + 1 < 10 && board[y][x+1] == '-') {lastY = y; lastX = x+1;}

            System.out.println(lastX + " " + lastY);
        } else {
            // can't find any
            for (y = 0; y < 10; y++) {
                boolean end = false;
                for (x = 0; x < 10; x++) {
                    if (board[y][x] == '-') {
                        end = true;
                        break;
                    }
                }
                if (end) break;
            }
            lastX = x;
            lastY = y;
            System.out.println(x + " " + y);
        }

        return captured == 18;
    }
}