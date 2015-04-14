package HackerRank;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Random;

public class Solution3 {

    public static int lastX = -1, lastY = -1, captured = 0;
    public static char[][] board = new char[10][10];

    public static void main(String args[] ) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("E:\\Temp\\src\\text2"));//new InputStreamReader(System.in));
        boolean firstTime = true;

        // skip first line
        br.readLine();


        for (int i = 0; i < 10; i++) {
            String line = br.readLine();
            for (int j = 0; j < 10; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'h' || board[i][j] == 'd') captured++;
            }
        }

        makeMove();
    }

    public static void makeMove() {
        int y = -1, x = -1;

        ArrayList<Location> hitLocations = new ArrayList<Location>();

        for (y = 0; y < 10; y++) {
            boolean end = false;
            for (x = 0; x < 10; x++) {
                if (board[y][x] == 'h') {
                    hitLocations.add(new Location(x, y));
                    break;
                }
            }
        }

        boolean done = false;
        for (Location ii : hitLocations) {
            boolean set = false;
            y = ii.y;
            x = ii.x;

            if (y - 1 > 0 && board[y-1][x] == '-') {lastY = y-1; lastX = x; set = true;}
            else if (y + 1 < 10 && board[y+1][x] == '-') {lastY = y+1; lastX = x; set = true;}
            else if (x - 1 > 0 && board[y][x-1] == '-') {lastY = y; lastX = x-1; set = true;}
            else if (x + 1 < 10 && board[y][x+1] == '-') {lastY = y; lastX = x+1; set = true;}

            if (set) {
                done = true;
                System.out.println(lastY + " " + lastX);
                break;
            }
        }

        if (!done) {
            // can't find any
            Random rand = new Random();
            while (true) {
                x = rand.nextInt(10);
                y = rand.nextInt(10);

                if (board[y][x] == '-')
                    break;
            }
            System.out.println(y + " " + x);
        }
    }

    public static class Location {

        public int x;
        public int y;

        public Location(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

