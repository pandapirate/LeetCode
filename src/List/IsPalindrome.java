package List;

/**
 * Created by Kevin on 10/24/2014.
 */
public class IsPalindrome {
    //Implement bool isPalindrome(SingleLinkList *node) in constant Space.
    public boolean isPalindrome(ListNode head) {
        if (head == null) return false;
        if (head.next == null) return true;

        // find size
        int size = 0;
        ListNode temp = head;
        while (temp != null) {
            size++;
            temp = temp.next;
        }

//        System.out.println(size);
        boolean isOdd = size % 2 == 1;

        // start at the second half of the list
        temp = head;
        int half = size/2;
        while (half > 0) {
            half--;
            temp = temp.next;
        }

        // reverse
        ListNode newHead = temp.next;
        temp.next = null;
        temp = newHead;
        newHead = null;

        while (temp != null) {
            ListNode next = temp.next;
            temp.next = newHead;
            newHead = temp;
            temp = next;
        }

        temp = head;
        ListNode temp2 = newHead;

        while (temp != null && temp2 != null) {
            if (temp.val != temp2.val) {
                return false;
            }
            temp = temp.next;
            temp2 = temp2.next;
        }

        return true;
    }

    public static void main (String[] args) {
        ListNode head = new ListNode(1);
        ListNode temp = head;

        for (int i = 2; i < 5; i++) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }
        for (int i = 5; i >= 1; i--) {
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        head.print();

        System.out.println(new IsPalindrome().isPalindrome(head));
    }
}
