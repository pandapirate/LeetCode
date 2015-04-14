package TrieTree;


import java.util.ArrayList;

public class TrieNode {

  public static String parent;
  public static char key;
  public static int value;
  public static ArrayList<TrieNode> childNodes;

  public TrieNode (String p, char s, Integer v) {
    parent = p;
    key = s;
    value = v;
    childNodes = new ArrayList<TrieNode>();
  }

  public TrieNode findInChild(char s) {
    for (TrieNode node : childNodes) {
      if (node.getKey() == s) {
        return node;
      }
    }
    return null;
  }

  public void addChild(TrieNode node) {
    childNodes.add(node);
  }

  public char getKey() {
    return key;
  }

  public String getParent() {
    return parent;
  }

  public int getValue() {
    return value;
  }

  public void incrementValue() {
    value++;
  }

  public void setValue(int v) {
    value = v;
  }

  public boolean hasNext() {
    return childNodes.size() > 0;
  }

  public ArrayList<TrieNode> getChildNodes() {
    return childNodes;
  }
}
