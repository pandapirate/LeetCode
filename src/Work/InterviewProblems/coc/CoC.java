package InterviewProblems.coc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class CoC {
  interface Iterator<E> {
    /**
     * @return the next element in the collection
     * @throws java.util.NoSuchElementException if there are no more elements
     */
    E next();

    /**
     * @return true if there is at least one more element in the collection
     */
    boolean hasNext();

    /**
     * @throws IllegalStateException if next has not yet been called or remove
     *         has already been called since the last call to next.
     * @throws UnsupportedOperationException if this Iterator does not support
     *         the remove operation.
     */
    void remove();
  }

  public class CustomIterator<E> implements Iterator<E> {

    public CustomIterator(Collection<E> collection) {

    }

    @Override
    public E next() {
      return null;
    }

    @Override
    public boolean hasNext() {
      return false;
    }

    @Override
    public void remove() {

    }
  }

  interface Iterable<E> {
    Iterator<E> iterator();
  }

  public class CustomIterable<E> implements Iterable<E> {

    Collection<E> collection;

    public CustomIterable(Collection<E> collection) {
      this.collection = collection;
    }

    @Override
    public Iterator<E> iterator() {
      return new CustomIterator<E>(this.collection);
    }
  }

  public static <E> Iterator<E> createFlattenedIterator(Iterable<? extends Iterable<E>> iterableOfIterables) {
// implement

    return null;
  }

  public static void main(String[] args) {
    List<List<Integer>> listOfList = new ArrayList<>();
    listOfList.add(Arrays.asList(24, 42, 1));
    listOfList.add(Arrays.asList(1));
    listOfList.add(Arrays.asList(54, 12));

    System.out.println(listOfList);

//    Iterator<Integer> iter = createFlattenedIterator(listOfList);
//    iter.next() -> 24
//    iter.next() -> 42
//    iter.next() -> 1
//    iter.next() -> 1
//    iter.hasNext() -> true
//    iter.next() -> 54
//    iter.next() -> 12
//    iter.hasNext() -> false
  }

/*
listOfLists = {
  {24, 42, 1},
  {1}
  {54, 12}
}
iter = createFlattenedIterator(listOfLists)
iter.next() -> 24
iter.next() -> 42
iter.next() -> 1
iter.next() -> 1
iter.hasNext() -> true
iter.next() -> 54
iter.next() -> 12
iter.hasNext() -> false
*/
}
