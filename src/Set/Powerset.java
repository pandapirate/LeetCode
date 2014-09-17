package Set;

import Other.IntegerToRoman;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kevin on 9/3/14
 */
public class Powerset {
    public Set<Set<Integer>> recursive(Set<Integer> base) {
        Set<Set<Integer>> result = new HashSet<>();
        result.add(base);

        for (Integer x : base) {
            Set<Integer> newBase = new HashSet<>(base);
            newBase.remove(x);
            result.addAll(recursive(newBase));
        }

        return result;
    }

    public Set<Set<Integer>> iterative(Set<Integer> base) {
        Set<Set<Integer>> collection = new HashSet<>();
        collection.add(new HashSet<Integer>());
        for (int a : base) {
            Set<Set<Integer>> newSets = new HashSet<>(collection);
            for (Set<Integer> set : collection) {
                Set<Integer> newSet = new HashSet<>(set);
                set.add(a);
                newSets.add(newSet);
            }
            collection = newSets;
        }

        return collection;
    }

    public static void main(String args[]) {
        // start with {1, 2, 3} create all possible sets recursively and iteratively {}{1}{2}{3}{1,2}{1,3}{2,3}{1,2,3}

        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);

        System.out.println(new Powerset().recursive(set));

        set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(3);
        System.out.println(new Powerset().iterative(set));
    }
}
