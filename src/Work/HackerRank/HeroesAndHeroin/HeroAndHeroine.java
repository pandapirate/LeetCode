package HackerRank.HeroesAndHeroin;


import java.io.InputStream;
import java.util.Scanner;


public class HeroAndHeroine {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    InputStream input = HeroAndHeroine.class.getResourceAsStream("/HackerRank/HeroesAndHeroin/corpus.txt");
    in = new Scanner(input);

    int n = Integer.parseInt(in.nextLine());
    for(int i = 0; i < n; i++) {
      String s = in.nextLine().toLowerCase();

    }

  }
}
