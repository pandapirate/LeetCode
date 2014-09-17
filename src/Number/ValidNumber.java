package Number;

/**
 * Created by Kevin on 9/16/2014.
 */
public class ValidNumber {
    public boolean isNumber(String s) {
        return s.matches("\\s*[+-]?(\\.\\d+|(\\d+(\\.\\d*)?))((e|E)[+-]?\\d+)?\\s*");
    }

    public static void main(String[] args) {
        ValidNumber matcher = new ValidNumber();

        System.out.println(matcher.isNumber("0"));
        System.out.println(matcher.isNumber(" 0.1 "));
        System.out.println(matcher.isNumber("abc"));
        System.out.println(matcher.isNumber("1 a"));
        System.out.println(matcher.isNumber("2e10"));
        System.out.println(matcher.isNumber("-2E10"));
        System.out.println(matcher.isNumber("e"));
        System.out.println(matcher.isNumber("."));
        System.out.println(matcher.isNumber(" "));
    }
}
