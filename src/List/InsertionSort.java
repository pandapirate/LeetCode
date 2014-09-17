package List;

/**
 * Created by khuang on 8/30/14.
 */
public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode first = head;
        ListNode tracker = head.next;
        head.next = null;

        while (tracker != null) {
            if (tracker.val < first.val) {
                // tracker becomes first
                ListNode next = tracker.next;
                tracker.next = first;
                first = tracker;
                tracker = next;
            } else {
                //iterate through the list and insert in the correct position
                ListNode temp = first;
                while (temp != null) {
                    if (temp.next == null || temp.next.val > tracker.val) {
                        // insert to the middle or end
                        ListNode next = tracker.next;
                        tracker.next = temp.next;
                        temp.next = tracker;
                        tracker = next;
                        break;
                    }
                    temp = temp.next;
                }
            }
        }

        return first;
    }

    public ListNode insertionSortListSlow(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode pivot = head;
        ListNode temp = head.next;
        ListNode tracker = head;

        while (temp != null) {
            if (tracker.next == null) {
                tracker.next = pivot;
                pivot.next = null;
            } else if (tracker.next.val < pivot.val) {
                tracker = tracker.next;
                continue;
            } else {
                ListNode next = tracker.next;
                tracker.next = pivot;
                pivot.next = next;
            }
            temp.print();
            tracker = head;
            pivot = temp;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String args[]) {
        ListNode root = new ListNode(10);

        ListNode temp = root;
        for (int i = 9; i >= 0; i -- ) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        root.print();
        ListNode result = new InsertionSort().insertionSortList(root);
        result.print();
    }
}
