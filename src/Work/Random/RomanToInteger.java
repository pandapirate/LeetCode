package Random;

public class RomanToInteger {

  public int romanToInt(String s) {
    int[] nums = new int[] {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    String[] rom = new String[] {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    int num = 0;
    while (s.length() > 0) {
      for (int i = 0; i < rom.length; i++) {
        if (s.startsWith(rom[i])) {
          num += nums[i];
          s = s.substring(rom[i].length());
          break;
        }
      }
    }

    return num;
  }

  public static void main (String[] args) {
    String roman = "XIV";
    System.out.println(new RomanToInteger().romanToInt(roman));
  }
}
