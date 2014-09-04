package Set;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Kevin on 9/3/14
 */
public class Powerset {

    public Set<Set<Integer>> recursive(Set<Integer> base) {
        if (base.size() == 0) {
            Set<Set<Integer>> r = new HashSet<>();
            r.add(new HashSet<Integer>());
            return r;
        }

        int a = base.iterator().next();
        base.remove(a);
        Set<Set<Integer>> result = recursive(base);

        Set<Set<Integer>> addOn = new HashSet<>(result);
        for (Set<Integer> set : addOn) {
            Set<Integer> newItem = new HashSet<>(set);
            newItem.add(a);
            result.add(newItem);
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
