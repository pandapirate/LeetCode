package algorithm.strings;

import java.util.Scanner;

/**
 * Created by khuang on 3/11/15.
 */
public class PalindromeIndex {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);

        int index = Integer.parseInt(in.nextLine());

        for (int i = 0; i < index; i++) {
            String s = in.nextLine();
            if (isPalindrome(s)) {
                System.out.println(-1);
                return;
            } else {
                for (int j = 0; j < s.length(); j++) {
                    String sub = "";
                    if (j == 0) {
                        sub = s.substring(1);
                    } else if (j == s.length()-1) {
                        sub = s.substring(0, s.length()-1);
                    } else {
                        sub = s.substring(0, j) + s.substring(j+1);
                    }

                    if (isPalindrome(sub)) {
                        System.out.println(j);
                        break;
                    }
                }
            }
        }
    }

    public static boolean isPalindrome(String str) {
        int start = 0; int end = str.length()-1;
        while (start < end) {
            if (str.charAt(start++) != str.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
}
