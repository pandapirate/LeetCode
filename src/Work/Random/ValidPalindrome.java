package Random;

public class ValidPalindrome {
  public boolean isPalindrome(String s) {
    if (s.length() <= 1) return true;
    else if (s.matches("\\s+")) return true;

    String str = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();

    int mid = str.length()/2;
    if (str.length()%2 == 0) {
      return isPalindrome(str, mid-1, mid);
    } else {
      return isPalindrome(str, mid, mid);
    }
  }

  private boolean isPalindrome(String s, int i, int j) {
    while (i >= 0 && j < s.length()) {
      if (s.charAt(i--) != s.charAt(j++))
        return false;
    }
    return true;
  }

  public static void main (String[] args) {
    String str = "A man, a plan, a canal: Panama";
    System.out.println(new ValidPalindrome().isPalindrome(str));
  }
}
