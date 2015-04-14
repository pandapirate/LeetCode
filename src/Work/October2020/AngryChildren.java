package October2020;


import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class AngryChildren {

  public static void main(String[] args) throws Exception {
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("src/October2020/TestData/AngryChildren"));

    int n = in.nextInt();
    int k = in.nextInt();

    ArrayList<Integer> set = new ArrayList<Integer>();

    for (int i = 0; i < n; i++) {
      set.add(in.nextInt());
    }



  }
}
