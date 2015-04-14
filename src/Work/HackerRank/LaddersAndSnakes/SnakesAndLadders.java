package HackerRank.LaddersAndSnakes;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Random;

public class SnakesAndLadders {

  public static void main(String[] args) throws Exception{

    Scanner scan = new Scanner(System.in);
    scan = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\LaddersAndSnakes\\test.txt"));

    int number = Integer.parseInt(scan.nextLine());
    int[] dice = new int[100];
    int ladder, snake;

    String str ;
    for (int i = 0; i < number; i++) {

      int index = 0;
      String[] split = scan.nextLine().split(",");
      for (int j = 1; j <= 6; j++) {
        int x = (int) (Double.parseDouble(split[j-1]) * 100);
        for (int k = index; k < Math.min(index + x, 100); k++) {
          dice[k] = j;
        }
        index += x;
      }

      split = scan.nextLine().split(",");
      ladder = Integer.parseInt(split[0]);
      snake = Integer.parseInt(split[1]);

      ArrayList<Position> ladders = new ArrayList<Position>();
      ArrayList<Position> snakes = new ArrayList<Position>();

      split = scan.nextLine().split(" ");
      for (int j = 0; j < ladder; j++) {
        String[] ss = split[j].split(",");
        ladders.add(new Position(Integer.parseInt(ss[0]), Integer.parseInt(ss[1])));
      }

      split = scan.nextLine().split(" ");
      for (int j = 0; j < snake; j++) {
        String[] ss = split[j].split(",");
        snakes.add(new Position(Integer.parseInt(ss[0]), Integer.parseInt(ss[1])));
      }

      runProgram(dice, ladders, snakes);
    }
  }

  private static void runProgram(int[] dice, ArrayList<Position> ladders, ArrayList<Position> snakes) {
    int counter = 0;
    int total = 0;
    Random rand = new Random();

    for (int i = 0; i < 5000; i++) {
      int curPos = 1;
      while (true) {
        counter++;
        int move = rand.nextInt(100);
        curPos += dice[move];

        if (curPos >= 100) {
          total += counter;
          counter = 0;
          break;
        }

        for (Position p : ladders) {
          if (p.in == curPos) {
            curPos = p.out;
            break;
          }
        }

        for (Position p : snakes) {
          if (p.in == curPos) {
            curPos = p.out;
            break;
          }
        }
      }
    }

    System.out.println((int) total/5000);
  }

  private static class Position {
    public int in, out;

    public Position(int inAt, int outAt) {
      in = inAt;
      out = outAt;
    }
  }
}
