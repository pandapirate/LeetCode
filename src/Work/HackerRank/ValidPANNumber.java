package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class ValidPANNumber {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\PANNumber"));

    int n = Integer.parseInt(in.nextLine());
    String regex = "[A-Z][A-Z][A-Z][A-Z][A-Z]\\d\\d\\d\\d[A-Z]";

    for(int i = 0; i < n; i++) {
      String s = in.nextLine();
      if (s.matches(regex))
        System.out.println("YES");
      else
        System.out.println("NO");
    }
  }
}
