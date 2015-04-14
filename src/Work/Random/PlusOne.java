package Random;

public class PlusOne {
  public int[] plusOne(int[] digits) {
    if (digits.length == 0) return digits;
    boolean increment = false;

    if (digits[digits.length-1] == 9) {
      int index = digits.length-1;
      while (index >= 0 && digits[index] == 9) {
        digits[index] = 0;
        index--;
      }
      if (index < 0)
        increment = true;
      else
        digits[index]++;
    } else {
      digits[digits.length-1]++;
      return digits;
    }

    if (increment) {
      int[] newList = new int[digits.length+1];
      newList[0] = 1;
      for (int i = 0; i < digits.length; i++) {
        newList[i+1] = digits[i];
      }
      return newList;
    }

    return digits;
  }

  public static void main(String[] args) {
    int[] results = new PlusOne().plusOne(new int[]{9,9});
    for (int i : results)
      System.out.print(i);
  }
}
