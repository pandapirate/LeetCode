package TrieTree;

public class TrieTreeTester {

  public static void main (String[] args) throws Exception {
    TrieTree tree = new TrieTree();

    tree.add("Holla");
    tree.add("Hella");
    tree.add("Hello");

    System.out.println("Hella: " + tree.search("Hella"));
    System.out.println("Hell: " + tree.search("Hell"));
    System.out.println("Hellaaaa: " + tree.search("Hellaaaa"));
    System.out.println("He: " + tree.search("He"));
  }
}
