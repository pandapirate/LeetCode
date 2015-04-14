package HackerRank;

import java.io.FileReader;
import java.util.*;

public class FindStrings {

  static HashSet<String> substrings = new HashSet<String>();

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\FindStrings"));

    int n = Integer.parseInt(in.nextLine());

    for(int i = 0; i < n; i++) {
      String s = in.nextLine();
      addSubStrings(s);
      addSubStrings(s);
    }

    ArrayList<String> list = new ArrayList<String>(substrings);
    Collections.sort(list);

    n = Integer.parseInt(in.nextLine());
    for (int i = 0; i < n; i++) {
      int val = in.nextInt()-1;
      if (val >= list.size())
        System.out.println("Invalid");
      else
        System.out.println(list.get(val));
    }
  }

  private static void addSubStrings(String s) {
    HashSet<String> temp = new HashSet<String>();

    for (int i = 0; i < s.length()-1; i++) {
      for (int j = i+1; j <= s.length(); j++) {
        temp.add(s.substring(i,j));
      }
    }

    temp.add(s.substring(s.length()-1));
    substrings.addAll(temp);
  }
}
