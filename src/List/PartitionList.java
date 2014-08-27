package List;

/**
 * Created by khuang on 8/26/14.
 */
public class PartitionList {

    public ListNode partition(ListNode head, int x) {
        ListNode tracker = head;
        ListNode less =  null;
        ListNode lessHead = null;

        ListNode greater = null;
        ListNode greaterHead = null;


        while (tracker != null) {
            if (tracker.val < x) {
                if (lessHead == null) {
                    lessHead = tracker;
                    less = tracker;
                } else {
                    less.next = tracker;
                    less = less.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = tracker;
                    greater = tracker;
                } else {
                    greater.next = tracker;
                    greater = greater.next;
                }
            }

            tracker = tracker.next;
        }

        if (less != null)
            less.next = greaterHead;
        else if (greaterHead != null) {
            lessHead = greaterHead;
        }

        if (greater != null)
            greater.next = null;

        return lessHead;
    }

    public static void main(String args[]) {

    }
}
