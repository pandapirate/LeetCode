package List;

/**
 * Created by Kevin on 10/7/2014
 */
public class RotateList {
    /*
        Given a list, rotate the list to the right by k places, where k is non-negative.

        For example:
        Given 1->2->3->4->5->NULL and k = 2,
        return 4->5->1->2->3->NULL.
    */
    public ListNode rotateRight(ListNode head, int n) {
        if (head == null || head.next == null || n == 0) return head;
        ListNode temp = head;
        //find size
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }

        int rotate = n % counter;
        if (rotate == 0)
            return head;

        //create new head with rotate left
        int left = counter - rotate -1;
        temp = head;
        while (left > 0) {
            left--;
            temp = temp.next;
        }
        ListNode newHead = temp.next;
        temp.next = null;

        temp = newHead;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;

        return newHead;
    }

    public static void main(String args[]) {
        ListNode base = new ListNode(1);
        ListNode temp = base;
        for (int i = 2; i < 4; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        base.print();
        ListNode result = new RotateList().rotateRight(base, 5);
        result.print();
    }
}
