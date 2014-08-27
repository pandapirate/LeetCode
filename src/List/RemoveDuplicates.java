package List;

/**
 * Created by khuang on 8/26/14.
 */
public class RemoveDuplicates {

    public ListNode deleteDuplicates(ListNode head) {
        ListNode temp = head;

        while (temp != null) {
            ListNode next = temp.next;
            while (next != null && next.val == temp.val) {
                next = next.next;
            }
            temp.next = next;
            temp = temp.next;
        }

        return head;
    }

    public static void main(String args[]) {

    }
}
