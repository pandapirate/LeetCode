package InterviewProblems;

import java.util.HashSet;
import java.util.Set;

public class Powerset {

  public static void main(String[] args) {
    HashSet<String> test = new HashSet<String>();
    test.add("a");
    test.add("b");
    test.add("c");
    test.add("d");
    test.add("e");
    test.add("f");
    test.add("g");
    test.add("h");
    test.add("i");
    test.add("j");
    test.add("k");
    test.add("l");
    test.add("m");
    test.add("n");

    long time = System.currentTimeMillis();
    System.out.println(getPowerSet(test));
    System.out.println(System.currentTimeMillis() - time);

    time = System.currentTimeMillis();
    System.out.println(getPowerSet2(test));
    System.out.println(System.currentTimeMillis() - time);

  }

  public static Set<Set<String>> getPowerSet(Set<String> set) {
    Set<Set<String>> pset = new HashSet<Set<String>>();
    pset.add(new HashSet<String>());
    for (String s : set) {
      HashSet<HashSet<String>> tempSet = new HashSet<HashSet<String>>();
      for (Set<String> sset : pset) {
        HashSet<String> newSet = new HashSet<String>(sset);
        newSet.add(s);
        tempSet.add(newSet);
      }
      for (Set<String> sset : tempSet) {
        pset.add(sset);
      }
    }
    return pset;
  }

  public static Set<Set<String>> getPowerSet2(Set<String> set) {
    Set<Set<String>> result = new HashSet<Set<String>>();
    if (set.size() == 0) {
      result.add(new HashSet<String>());
      return result;
    }

    String s = set.iterator().next();
    set.remove(s);
    Set<Set<String>> pset = getPowerSet2(set);

    for (Set<String> ss : pset) {
      Set<String> newSet = new HashSet<>(ss);
      newSet.add(s);
      result.add(newSet);
    }
    result.addAll(pset);

    return result;
  }
}
