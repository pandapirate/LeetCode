package Random;

public class ListNodePartitionList {
    public static void main(String args[]) throws Exception {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(1);
        ListNode result = partition(head, 0);

        while (result != null) {
            System.out.println(result.val);
            result = result.next;
        }
    }

    public static ListNode partition(ListNode head, int x) {
        ListNode tracker = head;
        ListNode less =  null;
        ListNode lessHead = null;

        ListNode greater = null;
        ListNode greaterHead = null;


        while (tracker != null) {
            if (tracker.val < x) {
                if (lessHead == null) {
                    lessHead = tracker;
                    less = tracker;
                } else {
                    less.next = tracker;
                    less = less.next;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = tracker;
                    greater = tracker;
                } else {
                    greater.next = tracker;
                    greater = greater.next;
                }
            }

            tracker = tracker.next;
        }
        if (less != null)
            less.next = greaterHead;
        else if (greaterHead != null) {
            lessHead = greaterHead;
        }

        if (greater != null)
            greater.next = null;

        return lessHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
