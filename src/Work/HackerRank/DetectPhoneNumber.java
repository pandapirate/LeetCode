package HackerRank;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DetectPhoneNumber {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);

    int n = Integer.parseInt(in.nextLine());
    int counter = 0;

    for(int i = 0; i < n; i++) {
      String s = in.nextLine().toLowerCase();
      String regex = "[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})";

      Pattern p = Pattern.compile(regex);
      Matcher m = p.matcher(s);
      if (m.find());
        counter++;
    }

    System.out.println(counter);
  }
}
