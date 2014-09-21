package CustomDataStructure;

import java.util.Map;

/**
 * Created by khuang on 9/21/14.
 */
public class CustomClassTester {

    public static void main(String args[]) {
        Map<Integer, String> pandaHashMap = new PandaHashMap<>();

        for (int i = 0; i < 20; i++) {
            pandaHashMap.put(i, "1 " + i);
        }

        System.out.println(pandaHashMap.toString());
    }
}
