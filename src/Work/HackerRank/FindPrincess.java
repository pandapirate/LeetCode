package HackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class FindPrincess {
  /* Head ends here */
  static void displayPathtoPrincess(int n, String [] grid){
    int bx=0, by=0;
    int px=0, py=0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < grid.length; j++) {
        if (grid[i].charAt(j)=='m'){
          bx = j;
          by = i;
          continue;
        } else if (grid[i].charAt(j) == 'p') {
          px = j;
          py = i;
        }
      }
    }

    int dx = Math.abs(bx-px);
    int dy = Math.abs(by-py);

    for (int i = 0; i < dx; i++) {
      System.out.println(bx > px ? "LEFT" : "RIGHT");
    }

    for (int i = 0; i < dy; i++) {
      System.out.println(by > py ? "UP" : "DOWN");
    }

  }
  /* Tail starts here */
  public static void main(String[] args) throws Exception{
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\TestData\\FindPrincess"));
    int m;
    m = in.nextInt();
    String grid[] = new String[m];
    for(int i = 0; i < m; i++) {
      grid[i] = in.next();
    }

    displayPathtoPrincess(m,grid);
  }
}