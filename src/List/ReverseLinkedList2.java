package List;

/**
 * Created by khuang on 8/26/14.
 */
public class ReverseLinkedList2 {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (m == n)
            return head;

        ListNode temp = head;
        ListNode tempMid = null;
        for (int i = 1; i < m; i++) {
            if (i == m-1)
                tempMid = temp;
            temp = temp.next;
        }

        ListNode reverse = reverseNode(temp, n-m);
        if (m == 1)
            head = reverse;
        else
            tempMid.next = reverse;
        return head;
    }

    public ListNode reverseNode(ListNode node, int depth) {
        ListNode tempHead = null;
        ListNode newTail = null;
        while (depth >= 0) {
            depth--;
            ListNode temp = node;
            node = node.next;
            temp.next = tempHead;
            if (newTail == null)
                newTail = tempHead;

            tempHead = temp;
        }
        if (newTail != null)
            newTail.next = node;

        return tempHead;
    }

    public static void main(String args[]) {

    }
}
