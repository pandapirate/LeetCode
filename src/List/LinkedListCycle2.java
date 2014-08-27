package List;

/**
 * Created by khuang on 8/26/14.
 */
public class LinkedListCycle2 {

    public ListNode detectCycle(ListNode head) {
        while (head != null) {
            int v = detectLoop(head);

            if (v == -1)
                return null;
            else if (v == 0)
                return head;

            head = head.next;
        }

        return null;
    }

    public int detectLoop(ListNode head) {
        if (head.next == null)
            return -1;

        ListNode slow = head;
        ListNode fast = head;

        while (slow != null || fast != null) {
            slow = slow.next;
            fast = fast.next;
            if (fast != null)
                fast = fast.next;
            else
                return -1;

            if (slow == head || fast == head) {
                return 0;
            }

            if (slow == null || fast == null)
                return -1;

            if (slow == fast)
                return 1;
        }

        return 1;
    }

    public static void main(String args[]) {

    }
}
