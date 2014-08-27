package List;

/**
 * Created by khuang on 8/26/14.
 */
public class LinkedListCycle {

    public boolean hasCycle(ListNode head) {

        if (head == null)
            return false;

        ListNode turtle = head;
        ListNode hare = head;

        while (true) {
            turtle = turtle.next;

            if (hare != null && hare.next != null)
                hare = hare.next.next;
            else
                return false;

            if (turtle == null && hare == null)
                return false;

            if (turtle == hare)
                return true;
        }

    }

    public static void main(String args[]) {

    }
}
