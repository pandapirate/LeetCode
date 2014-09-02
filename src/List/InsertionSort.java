package List;

/**
 * Created by khuang on 8/30/14.
 */
public class InsertionSort {
    public ListNode insertionSortList(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode temp = head;
        ListNode tracker = head;

        while (tracker != null) {

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
