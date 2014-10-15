package String;

/**
 * Created by Kevin on 10/14/2014.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;

        String[] token = s.split(" ");

        return token.length > 0 ? token[token.length-1].length() : 0;
    }

    public static void main(String[] args) {
        String str = "Hello World";
        System.out.println(new LengthOfLastWord().lengthOfLastWord(str));
    }
}
