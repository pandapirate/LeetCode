package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Kevin on 3/8/2015.
 */
public class StringCombinations {

    public static List<String> results;

    public static void main(String[] args) {
        String test = "a?b?c?";

        results = new ArrayList<>();
        getCombinations(test);

        for (String str : results) {
            System.out.println(str);
        }
    }

    public static void getCombinations(String str) {
        int index = str.indexOf("?");
        if (index == -1) {
            results.add(str);
        } else {
            String a = str.substring(0, index) + "0" + str.substring(index+1);
            String b = str.substring(0, index) + "1" + str.substring(index+1);
            getCombinations(a);
            getCombinations(b);
        }
    }
}
