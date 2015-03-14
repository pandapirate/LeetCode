package Array;

import java.util.*;

/**
 * Created by Kevin on 3/7/2015.
 */
public class RandomFromIterator {

    public static Map<Integer, Integer> results;
    public static final int ROUNDS = 1000000;
    public static final int SIZE = 10;
    public static Random rand = new Random();

    public static void main(String[] args) {
        results = new HashMap<>();

        List<Integer> baseSet = new ArrayList<>();
        for (int i = 1; i <= 25; i++) {
            baseSet.add(i);
        }

        for (int i = 0; i < ROUNDS; i++) {
            List<Integer> copy = new ArrayList<>(baseSet);
            addToResults(calculateRandom(copy.iterator()));
        }

        printResults();
    }

    public static List<Integer> calculateRandom(Iterator<Integer> iter) {
        List<Integer> result = new ArrayList<>();

        int count = 0;
        while (iter.hasNext()) {
            count++;
            int x = iter.next();
            if (count <= SIZE) {
                result.add(x);
            } else {
                int index = rand.nextInt(count);
                if (index < SIZE) {
                    result.set(index, x);
                }
            }
        }

        return result;
    }

    public static void addToResults(List<Integer> result) {
        for (int i : result) {
            Integer num = results.get(i);
            if (num == null) {
                num = 0;
            }
            num++;
            results.put(i, num);
        }
    }

    public static void printResults() {
        List<Integer> keys = new ArrayList<>(results.keySet());
        Collections.sort(keys);

        for (int i : keys) {
            int x = results.get(i);
            double percent = x * 100.0 / (SIZE * ROUNDS);
            System.out.println(i + " - " + results.get(i) + " - " + percent + "%");
        }
    }
}
