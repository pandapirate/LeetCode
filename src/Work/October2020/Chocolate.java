package October2020;


import java.io.FileReader;
import java.util.Scanner;

public class Chocolate {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("src/October2020/TestData/Chocolate"));

    int n = in.nextInt();

    for(int i = 0; i < n; i++) {
      int money = in.nextInt();
      int cost = in.nextInt();
      int change = in.nextInt();

      int pieces = money/cost;
      int total = pieces;

      while (pieces/change >= 1) {
        int exchanged = pieces/change;
        int extra = pieces % change;
        total += exchanged;
        pieces = extra + exchanged;
      }

      System.out.println(total);
    }
  }
}
