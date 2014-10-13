package List;

import java.util.HashSet;
import java.util.Set;

/*
 * Created by khuang on 10/12/14.
 */
public class RemoveDuplicatesFromSortedList2 {

    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) return head;

        Set<Integer> delete = new HashSet<>();

        // find all nodes that are duplicated
        ListNode temp = head;
        while (temp != null) {
            if (!delete.contains(temp.val)) {
                if (temp.next != null && temp.next.val == temp.val) {
                    delete.add(temp.val);
                }
            }

            temp = temp.next;
        }

        // delete all duplicated nodes
        temp = head;
        // first find the first non-repeat and make it head
        while (temp != null && delete.contains(temp.val)) {
            temp = temp.next;
        }

        head = temp;
        // continue the rest of the way
        while (temp != null) {
            if (temp.next != null) {
                ListNode next = temp.next;
                while (next != null && delete.contains(next.val)) {
                    next = next.next;
                }
                temp.next = next;
                temp = temp.next;
            } else {
                temp = temp.next;
            }
        }

        return head;
    }

    public static void main(String args[]) {
        ListNode root = new ListNode(1);

        ListNode temp = root;
        for (int i = 2; i < 13; i++) {
            if (i % 2 == 1) {
                temp.next = new ListNode(i);
                temp = temp.next;
            }
            temp.next = new ListNode(i);
            temp = temp.next;
        }

        root.print();
        new RemoveDuplicatesFromSortedList2().deleteDuplicates(root).print();
    }
}
