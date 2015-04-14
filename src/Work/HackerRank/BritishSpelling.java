package HackerRank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BritishSpelling {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\BritishSpelling"));

    int n = Integer.parseInt(in.nextLine());
    ArrayList<String> s = new ArrayList<String>();

    for(int i = 0; i < n; i++) {
      s.add(in.nextLine());
    }

    n = Integer.parseInt(in.nextLine());
    for (int i = 0; i < n; i++) {
      String word = in.nextLine();
      String regex = word.substring(0, word.length()-2) + "(ze|se)";
      Pattern p = Pattern.compile(regex);

      int count = 0;

      for (String ss : s) {
        Matcher matcher = p.matcher(ss);
        while(matcher.find()) {
          count++;
        }
      }

      System.out.println(count);
    }
  }
}
