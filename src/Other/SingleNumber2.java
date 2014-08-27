package Other;

import java.util.HashMap;

/**
 * Created by khuang on 8/26/14.
 */
public class SingleNumber2 {

    public int singleNumber(int[] A) {
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();

        for (int i : A) {
            if (map.containsKey(i)){
                map.put(i, map.get(i)+1);
            } else {
                map.put(i, 1);
            }
        }

        for (int i : map.keySet()) {
            if (map.get(i) < 3)
                return i;
        }
        return -1;
    }

    public static void main(String args[]) {

    }
}
