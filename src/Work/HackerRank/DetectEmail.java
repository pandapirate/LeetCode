package HackerRank;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectEmail {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\DetectEmail"));

    int n = Integer.parseInt(in.nextLine());

    ArrayList<String> email = new ArrayList<String>();

    for(int i = 0; i < n; i++) {
      String[] s = in.nextLine().split(" ");
      String regex = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";
      Pattern p = Pattern.compile(regex);

      for (String ss : s) {
        Matcher m = p.matcher(ss);
        if (m.find()) {
          if (!email.contains(ss))
            email.add(ss.substring(m.start(), m.end()));
        }
      }
    }

    String delim = "";
    Collections.sort(email);
    for (String s : email) {
      System.out.print(delim + s);
      delim = ";";
    }
  }
}
