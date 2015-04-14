package HackerRank;

import java.io.FileReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLLinks {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("src/HackerRank/TestData/HTMLLinks"));

    int n = Integer.parseInt(in.nextLine());

    String linkRegex = "(<\\s*a.*?>)(.+)(/\\s*a\\s*>)";
    String hrefRegex = "href=\"([^\"]+)\"";
    String titleRegex = ">.*<";

    Pattern linkP = Pattern.compile(linkRegex);
    Pattern hrefP = Pattern.compile(hrefRegex);
    Pattern titleP = Pattern.compile(titleRegex);

    for(int i = 0; i < n; i++) {
      String s = in.nextLine();
      Matcher m = linkP.matcher(s);
      while (m.find()) {
        String sub = s.substring(m.start(), m.end());
        //System.out.println(sub);

        Matcher h = hrefP.matcher(sub);
        while (h.find()) {
          System.out.print(sub.substring(h.start()+6, h.end()-1));
        }
        System.out.print(",");
        Matcher t = titleP.matcher(sub);
        while (t.find()) {
          System.out.print(sub.substring(t.start()+1, t.end()-1));
        }
        System.out.println("");
      }
    }
  }
}
