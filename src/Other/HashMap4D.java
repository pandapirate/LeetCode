package Other;

import java.util.HashMap;

/**
 * Created by khuang on 9/14/14.
 */
public class HashMap4D {

    public HashMap<String, Integer> boringHashMap = new HashMap<>();
    public HashMap<Integer, HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>>> epicMap = new HashMap<>();

    public void createBoringMap (int elements) {
        for (int i = 0; i < elements; i++) {
            for (int j = 0; j < elements; j++) {
                for (int k = 0; k < elements; k++) {
                    for (int l = 0; l < elements; l++) {
                        String str = i + " " + j + " " + k + " " + l;
                        boringHashMap.put(str, 1);
                    }
                }
            }
        }
    }

    public void createEpicMap (int elements) {
        for (int i = 0; i < elements; i++) {
            HashMap<Integer, HashMap<Integer, HashMap<Integer, Integer>>> mapA = new HashMap<>();
            for (int j = 0; j < elements; j++) {
                HashMap<Integer, HashMap<Integer, Integer>> mapB = new HashMap<>();
                for (int k = 0; k < elements; k++) {
                    HashMap<Integer, Integer> mapC = new HashMap<>();
                    for (int l = 0; l < elements; l++) {
                        mapC.put(l, 1);
                    }
                    mapB.put(k, mapC);
                }
                mapA.put(j, mapB);
            }
            epicMap.put(i, mapA);
        }
    }

    public int findInBoringMap(String key) {
        return boringHashMap.get(key);
    }

    public int findInEpicMap(int a, int b, int c, int d) {
        return epicMap.get(a).get(b).get(c).get(d);
    }

    public static void main(String args[]) {
        HashMap4D mapper = new HashMap4D();
        long time = System.currentTimeMillis();
//        System.out.println(time);
        mapper.createBoringMap(50);
        System.out.println(mapper.findInBoringMap("15 15 15 15"));
        System.out.println(System.currentTimeMillis() - time);
//        System.out.println(mapper.boringHashMap);

        time = System.currentTimeMillis();
        mapper.createEpicMap(50);
        System.out.println(mapper.findInEpicMap(15, 15, 15, 15));
        System.out.println(System.currentTimeMillis() - time);
//        System.out.println(mapper.epicMap);
    }
}
