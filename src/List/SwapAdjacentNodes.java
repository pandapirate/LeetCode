package List;

/**
 * Created by Kevin on 9/3/14
 */
public class SwapAdjacentNodes {

    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;

        ListNode tempHead = head.next;
        ListNode seeker = head;
        ListNode prev = null;

        while (seeker != null && seeker.next != null) {
            ListNode next = seeker.next;
            ListNode temp = next.next;

            next.next = seeker;
            seeker.next = temp;
            if (prev != null)
                prev.next = next;

            prev = seeker;
            seeker = temp;
        }

        return tempHead;
    }

    public static void main(String args[]) {
        ListNode root = new ListNode(1);

        ListNode temp = root;
        for (int i = 2; i <= 10; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        root.print();
        ListNode result = new SwapAdjacentNodes().swapPairs(root);
        result.print();
    }
}
