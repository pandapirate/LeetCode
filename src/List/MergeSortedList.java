package List;

/**
 * Created by khuang on 8/26/14.
 */
public class MergeSortedList {

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode t1 = l1;
        ListNode t2 = l2;

        if (t1 == null) {
            return t2;
        } else if (t2 == null) {
            return t1;
        }

        ListNode combined = null;

        if (t1.val < t2.val) {
            combined = t1;
            t1 = t1.next;
        } else {
            combined = t2;
            t2 = t2.next;
        }

        while (t1 != null && t2 != null) {
            if (t1.val < t2.val) {
                combined.next = t1;
                t1 = t1.next;
            } else {
                combined.next = t2;
                t2 = t2.next;
            }
            combined = combined.next;
        }

        if (t1 != null) {
            combined.next = t1;
        } else {
            combined.next = t2;
        }

        return l1.val < l2.val ? l1 : l2;
    }

    public static void main(String args[]) {

    }
}
