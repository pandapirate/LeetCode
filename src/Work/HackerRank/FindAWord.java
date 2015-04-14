package HackerRank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FindAWord {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\FindAWord"));

    int n = Integer.parseInt(in.nextLine());
    ArrayList<String> strings = new ArrayList<String>();


    for(int i = 0; i < n; i++) {
      String[] split = in.nextLine().split(" ");
      for (String s : split) {
        strings.add(s);
      }
    }

    n = Integer.parseInt(in.nextLine());

    for(int i = 0; i < n; i++) {
      String word = in.nextLine().toLowerCase();

      int counter = 0;

      String regex = "([^a-z0-9_]*|^)" + word + "([^a-z0-9_]*|$)";
      Pattern p = Pattern.compile(regex);

      for (String s : strings) {
        Matcher m = p.matcher(s);
        while(m.find()) {
          counter++;
        }
      }

      System.out.println(counter);
    }
  }
}
