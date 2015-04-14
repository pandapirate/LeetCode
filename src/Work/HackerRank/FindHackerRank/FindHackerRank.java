package HackerRank.FindHackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class FindHackerRank {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\FindHackerRank\\test"));

    int n = Integer.parseInt(in.nextLine());

    for(int i = 0; i < n; i++) {
      processLine(in.nextLine());
    }
  }

  public static void processLine(String str) {
    boolean start = str.startsWith("hackerrank");
    boolean end = str.endsWith("hackerrank");

    if (start && end)
      System.out.println(0);
    else if (start)
      System.out.println(1);
    else if (end)
      System.out.println(2);
    else
      System.out.println(-1);

  }
}
