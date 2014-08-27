package List;

/**
 * Created by khuang on 8/26/14.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null)
            return;

        ListNode temp = head;

        //size
        int counter = 0;
        while (temp != null) {
            counter++;
            temp = temp.next;
        }

        counter /= 2;
        temp = head;
        while (counter-- > 0) {
            ListNode t = temp;
            temp = temp.next;
            if (counter == 0) {
                t.next = null;
            }
        }

        // reverse node
        ListNode reverseHead = null;
        while (temp != null) {
            ListNode tempNext = temp.next;
            temp.next = reverseHead;
            reverseHead = temp;
            temp = tempNext;
        }
        temp = head;

        while (temp != null && reverseHead != null) {
            ListNode tempFront = temp.next;
            ListNode tempBack = reverseHead.next;
            temp.next = reverseHead;
            reverseHead.next = tempFront;

            if (tempFront == null && tempBack != null) {
                reverseHead.next = tempBack;
                break;
            }

            temp = tempFront;
            reverseHead = tempBack;
        }
    }

    public static void main(String args[]) {
        ListNode head = new ListNode(1);

        ListNode temp = head;
        for (int i = 2; i < 6; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        ReorderList rl = new ReorderList();
        rl.reorderList(head);
        head.print();
    }
}
