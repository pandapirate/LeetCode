package List;

/**
 * Created by khuang on 8/27/14.
 */
public class MergeSortList {

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode slow = head;
        ListNode fast = head;
        ListNode temp = slow;

        while (slow != null && fast != null && fast.next != null) {
            temp = slow;
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
        }

        //break into two halves
        temp.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(slow);

        return mergeTwoLists(left, right);
    }

    private ListNode mergeTwoLists(ListNode l1, ListNode l2) {
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
        ListNode root = new ListNode(10);

        ListNode temp = root;
        for (int i = 9; i >= 0; i -- ) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        root.print();
        ListNode result = new MergeSortList().sortList(root);
        result.print();
    }
}
