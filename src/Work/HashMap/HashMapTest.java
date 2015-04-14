package HashMap;

public class HashMapTest {

    public static void main (String[] args) throws Exception {
        NewHashMap<String, Integer> list = new NewHashMap<String, Integer>();

        for (int i = 0; i < 200; i++) {
            list.put("A"+i, i);
        }


        System.out.println("Size: " + list.size());

        for (int i = 0; i < 200; i+= 3) {
            list.remove("A"+i);
        }

        System.out.println("Size: " + list.size());

        list.put("A2", 300);
        System.out.println(list.getValueForKey("A0"));
        System.out.println(list.getValueForKey("A1"));
        System.out.println(list.getValueForKey("A2"));
    }

}
