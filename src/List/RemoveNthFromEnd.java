package List;

/**
 * Created by khuang on 10/12/14.
 */
public class RemoveNthFromEnd {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;

        int size = 0;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

        int skip = size - n;

        if (skip == 0) {
            return head.next;
        }

        temp = head;
        while (skip > 1) {
            temp = temp.next;
            skip--;
        }

        ListNode newTemp = temp.next;
        temp.next = newTemp.next;
        return head;
    }

    public static void main(String args[]) {
        ListNode root = new ListNode(1);

        ListNode temp = root;
        for (int i = 2; i < 11; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        root.print();
        new RemoveNthFromEnd().removeNthFromEnd(root, 1).print();
    }
}
