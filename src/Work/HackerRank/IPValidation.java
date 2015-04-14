package HackerRank;

import java.io.FileReader;
import java.util.Scanner;

public class IPValidation {

  static String ipv4 = "";
  static String ipv6 = "";

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\IPValidation"));

    int n = Integer.parseInt(in.nextLine());

    String v4 = "([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-5][0-5])";
    ipv4 = v4 + "." + v4 + "." + v4 + "." + v4;

    String v6 = "([a-f0-9]|[a-f0-9][a-f0-9]|[a-f0-9][a-f0-9][a-f0-9]|[a-f0-9][a-f0-9][a-f0-9][a-f0-9])";
    for (int i = 0; i < 7; i++) {
      ipv6 = ipv6 + v6 + ":";
    }
    ipv6 = ipv6 + v6;

    for(int i = 0; i < n; i++) {
      String s = in.nextLine().replaceAll("\\s+$", "");
      processLine(s);
    }
  }

  public static void processLine(String str) {
    if (str.matches(ipv4))
      System.out.println("IPv4");
    else if (str.matches(ipv6))
      System.out.println("IPv6");
    else
      System.out.println("Neither");
  }
}
