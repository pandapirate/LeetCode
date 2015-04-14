package TrieTree;

import java.util.ArrayList;

public class TrieTree {

  private static ArrayList<TrieNode> baseNodes;

  public TrieTree() {
    baseNodes = new ArrayList<TrieNode>();
  }

  public void add(String s) {
    if (s.length() == 0)
      return;

    TrieNode base = findBaseNode(s.charAt(0));
    if (base == null) {
      base = new TrieNode(""+s.charAt(0), s.charAt(0), 1);
      baseNodes.add(base);
    }

    if (s.length() == 1)
      return;

    for (int i = 1; i < s.length(); i++) {
      TrieNode temp = base.findInChild(s.charAt(i));
      if (temp == null) {
        temp = new TrieNode(s.substring(0, i), s.charAt(i), 1);
        base.addChild(temp);
        base = temp;
      } else {
        temp.incrementValue();
        base = temp;
      }
    }
  }

  public TrieNode getNodeForString (String s) {
    TrieNode base = findBaseNode(s.charAt(0));

    if (base == null)
      return null;

    if (s.length() == 1)
      return base;

    for (int i = 1; i < s.length()-1; i++) {
      base = base.findInChild(s.charAt(i));
      if (base == null)
        return null;
    }

    return base;
  }

  public boolean search (String s) {
    TrieNode base = findBaseNode(s.charAt(0));

    if (base == null)
      return false;

    if (s.length() == 1)
      return true;

    for (int i = 1; i < s.length()-1; i++) {
      base = base.findInChild(s.charAt(i));
      if (base == null)
        return false;
    }

    return true;
  }

  private TrieNode findBaseNode(char c) {
    for (TrieNode node : baseNodes) {
      if (node.getKey() == c) {
        return node;
      }
    }
    return null;
  }
}
