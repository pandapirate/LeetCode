package String;

/**
 * Created by khuang on 8/26/14.
 */
public class ReverseString {

    public String reverseWords(String s) {
        String[] list = s.split(" ");
        StringBuilder builder = new StringBuilder();

        boolean skipSpace = true;
        for (int i = list.length-1; i >= 0; i--) {
            if (list[i].length() == 0) {
                continue;
            }
            if (!skipSpace) {
                builder.append(" ");
            } else {
                skipSpace = false;
            }

            builder.append(list[i].replaceAll(" ", ""));

        }
        return builder.toString();
    }

    public static void main(String args[]) {
        ReverseString rev = new ReverseString();
        System.out.println(rev.reverseWords(" 1 peter parker lane "));
    }
}
