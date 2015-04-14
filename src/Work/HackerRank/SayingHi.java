package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class SayingHi {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());
    String regex = "[hH][iI]\\s[^dD]";

    for(int i = 0; i < n; i++) {
      String s = in.nextLine();
      if (s.substring(0, 4).matches(regex))
        System.out.println(s);
    }
  }
}
