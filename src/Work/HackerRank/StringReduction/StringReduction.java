package HackerRank.StringReduction;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class StringReduction {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\StringReduction\\test"));

    int n = in.nextInt();

    for(int i = 0; i < n; i++) {
      processLine(in.nextLine());
    }
  }

  public static void processLine(String str) {



  }
}
