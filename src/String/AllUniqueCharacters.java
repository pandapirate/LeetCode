package String;

import java.util.HashSet;

public class AllUniqueCharacters {

  public static void main (String[] args) {

    String notUnique = "akiuyfdghalsuhdrgfkaiwuyfrkoaisud";
    String unique = "abcdqwertyuioplkjhgfsznxmv";

    System.out.println(allUnique(notUnique));
    System.out.println(allUnique(unique));
  }

  public static boolean allUnique(String str) {
    HashSet<Character> chars = new HashSet<Character>();
    for (int i = 0; i < str.length(); i++) {
      if (chars.contains(str.charAt(i)))
        return false;
      else
        chars.add(str.charAt(i));
    }
    return true;
  }

  public static boolean allUniqueNoDatastructure(String str) {
    return true;
  }
}
