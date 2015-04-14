package HackerRank.PacMan;

import java.io.*;
import java.util.*;

public class PacManDFS {

  static String[] grid;
  static int r, c;
  static ArrayList<Position> children = new ArrayList<Position>();

  public static void main(String[] args) throws Exception{
    Scanner in = new Scanner(System.in);
    in = new Scanner(new FileReader("E:\\Temp\\src\\HackerRank\\PacMan\\Test"));

    int pacman_r = in.nextInt();
    int pacman_c = in.nextInt();

    int food_r = in.nextInt();
    int food_c = in.nextInt();

    r = in.nextInt();
    c = in.nextInt();

    grid = new String[r];

    for(int i = 0; i < r; i++) {
      grid[i] = in.next();
    }

    dfs(pacman_r, pacman_c, food_r, food_c);
  }

  static void dfs(int pacman_r, int pacman_c, int food_r, int food_c){
    Position head = new Position(pacman_r, pacman_c, null);
    addChildren(head);

    ArrayList<Position> stack = new ArrayList<Position>();
    stack.add(head);

    Position temp = head;
    while (!stack.isEmpty()) {
      temp = stack.get(stack.size()-1);

      if (temp.isFood) {
        break;
      } else {
        for (Position p : temp.children) {
          stack.add(p);
        }
      }
    }

    ArrayList<Position> printList = new ArrayList<Position>();

    while (temp.parent != null) {
      printList.add(temp);
      temp = temp.parent;
    }

    System.out.println(printList.size() + 1);
    System.out.println(pacman_r + " " + pacman_c);
    for (Position p : printList) {
      System.out.println(p.row + " " + p.col);
    }
  }

  private static Position alreadyExist (Position p) {
    for (Position pp : children) {
      if (p.row == pp.row && p.col == pp.col)
        return pp;
    }
    return null;
  }

  private static void addChildren(Position p) {
    System.out.println(p.row + " " + p.col);
    if (grid[p.row].charAt(p.col) == '.')
      p.isFood = true;

    // UP
    if (p.row - 1 >= 0) {
      if (p.parent != null && p.parent.row == p.row-1 && p.parent.col == p.col) {
        // do nothing
      } else if (grid[p.row-1].charAt(p.col) == '-' || grid[p.row-1].charAt(p.col) == '.') {
        Position pp = new Position(p.row-1, p.col, p);
        Position ppp = alreadyExist(pp);

        if (ppp != null)
          pp = ppp;
        else
          children.add(pp);

        p.addChild(pp);
        addChildren(pp);
      }
    }

    // LEFT
    if (p.col - 1 >= 0) {
      if (p.parent != null && p.parent.row == p.row && p.parent.col == p.col-1) {
        // do nothing
      } else if (grid[p.row].charAt(p.col-1) == '-' || grid[p.row].charAt(p.col-1) == '.') {
        Position pp = new Position(p.row, p.col-1, p);

        Position ppp = alreadyExist(pp);

        if (ppp != null)
          pp = ppp;
        else
          children.add(pp);

        p.addChild(pp);
        addChildren(pp);
      }
    }

    // RIGHT
    if (p.col + 1 < c) {
      if (p.parent != null && p.parent.row == p.row && p.parent.col == p.col+1) {
        // do nothing
      } else if (grid[p.row].charAt(p.col + 1) == '-' || grid[p.row].charAt(p.col + 1) == '.') {
        Position pp = new Position(p.row, p.col+1, p);

        Position ppp = alreadyExist(pp);

        if (ppp != null)
          pp = ppp;
        else
          children.add(pp);

        p.addChild(pp);
        addChildren(pp);
      }
    }

    // DOWN
    if (p.row + 1 < r) {
      if (p.parent != null && p.parent.row == p.row+1 && p.parent.col == p.col) {
        // do nothing
      } else if (grid[p.row+1].charAt(p.col) == '-' || grid[p.row+1].charAt(p.col) == '.') {
        Position pp = new Position(p.row+1, p.col, p);

        Position ppp = alreadyExist(pp);

        if (ppp != null)
          pp = ppp;
        else
          children.add(pp);

        p.addChild(pp);
        addChildren(pp);
      }
    }
  }

  private static class Position {
    int row, col;
    Position parent;
    ArrayList<Position> children;
    boolean isFood = false;

    public Position(int r, int c, Position p) {
      row = r;
      col = c;
      parent = p;
      children = new ArrayList<Position>();
    }

    public void addChild(Position p) {

      children.add(p);
    }
  }
}